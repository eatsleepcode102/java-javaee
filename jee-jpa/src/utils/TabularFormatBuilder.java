package utils;

import java.util.Arrays;
import java.util.Collection;

public class TabularFormatBuilder {
	
	public static TabularFormatBuilder instance;
	
	public static TabularFormatBuilder instance(){
		if(instance==null){
			instance=new TabularFormatBuilder();
		}
		return instance;
	}
	
	private String columnLengths;
	private String[] columnNames;
	private Collection<Object[]> data;
	
	private TabularFormatBuilder(){
	}
	
	public TabularFormatBuilder setColumnLengths(Object...columnLengths){
		this.columnLengths=buildColumnLengths(columnLengths);
		return this;
	}
	
	public String buildColumnLengths(Object...objects){
		StringBuilder pattern=new StringBuilder();
		for(Object i: objects){
			pattern.append("%");
			pattern.append(i);
			pattern.append("s");
			pattern.append(" ");
		}
		return pattern.toString();
	}
	
	public TabularFormatBuilder setColumnNames(Object...objects){
		this.columnNames= buildColumnNames(objects);
		return this;
	}
	
	public String[] buildColumnNames(Object...objects){
		this.columnNames=new String[objects.length];
		for(int i=0;i< objects.length; i++){
			this.columnNames[i]=((String) objects[i]).toUpperCase();
		}
		return this.columnNames;
	}
	
	public TabularFormatBuilder setData(Collection c){
		this.data=c;
		return this;
	}
	
	public void build(){
		// Print the list objects in tabular format.
		System.out.println("[size:"+this.data.size()+"]");
	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
	    System.out.printf(columnLengths, columnNames);
	    System.out.println();
	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
	    data.forEach(r -> {
	        System.out.format(columnLengths,
	        		r);
	        System.out.println();
	    });
	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public static void main(String[] args) {
		System.out.println( new TabularFormatBuilder().buildColumnLengths(1,2,3,4,5));
		System.out.println(Arrays.toString(new TabularFormatBuilder().buildColumnNames(new String[] {"student ID", "EMAIL ID", "NAME", "AGE", "GRADE"})));
	}
}
