package debugs;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class NumberBean implements Serializable {
	
	private int number=1;

	public int getNumber() {
		return number;
	}
	
	public void increase(){
		number++;
	}
	
}
