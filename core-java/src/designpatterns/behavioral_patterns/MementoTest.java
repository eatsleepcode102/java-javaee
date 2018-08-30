package designpatterns.behavioral_patterns;

public class MementoTest {

	public static void main(String[] args) {
		FileWriterCaretaker caretaker=new FileWriterCaretaker();
		FileWriterUtil fileWriter=new FileWriterUtil("data.txt");
		fileWriter.write("First set of data\n");
		System.out.println(fileWriter);
		caretaker.save(fileWriter);
		fileWriter.write("second set of data\n");
		System.out.println(fileWriter);
		caretaker.undo(fileWriter);
		System.out.println(fileWriter);
	}
}

class FileWriterUtil {
	String fileName;
	StringBuilder content;
	public FileWriterUtil(String file) {
		this.fileName=file;
		this.content = new StringBuilder();
	}
	
	public void write(String str){
		content.append(str);
	}
	
	public Memento save(){
		return new Memento(fileName, content);
	}
	
	public void undoToLastSave(Object obj){
		Memento memento=(Memento) obj;
		this.fileName=memento.fileName;
		this.content=memento.content;
	}
	
	@Override
	public String toString() {
		return this.content.toString();
	}
	
	
	private class Memento {
		String fileName;
		StringBuilder content;
		
		public Memento(String fileName, StringBuilder content) {
			this.fileName = fileName;
			this.content = new StringBuilder(content);
		}
	}
}

class FileWriterCaretaker {
	private Object obj;
	
	public void save(FileWriterUtil fileWriter){
		this.obj=fileWriter.save();
	}
	
	public void undo(FileWriterUtil fileWriter){
		fileWriter.undoToLastSave(obj);
	}
}