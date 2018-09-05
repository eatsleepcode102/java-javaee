package corejava.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class RententionPolicy {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class c=RententionPolicy.class;
		Method m=c.getMethod("processOne");
		System.out.println(m.getName());
		MyMethodInfo anno=m.getAnnotation(MyMethodInfo.class);
		System.out.println(anno.author() +" "+anno.remarks());
	}
	@MyMethodInfo(author="Andrew", remarks="this is a test creating a anno with specifying retention policy")
	public static void processOne(){
		
	}
}

@Retention(RetentionPolicy.RUNTIME) //if the retention policy is SOURCE then the process in main method will be error
@interface MyMethodInfo {
	String author();
	String remarks();
}