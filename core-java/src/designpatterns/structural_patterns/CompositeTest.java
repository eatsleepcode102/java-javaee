package designpatterns.structural_patterns;

import java.util.ArrayList;
import java.util.List;

public class CompositeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractPhase parent= new Phase("1");
		AbstractPhase subPhs1= new Phase("1.1");
		AbstractPhase subPhs2= new Phase("1.2");
		parent.add(subPhs1);
		parent.add(subPhs2);
		System.out.println(parent.seq_no);
		for (AbstractPhase phs : parent.subPhases) {
			System.out.println(phs.seq_no);
		}
	}

}


abstract class AbstractPhase {
	String seq_no;
	List<AbstractPhase> subPhases;
	
	protected abstract void add(AbstractPhase phs);
	protected abstract void remove(AbstractPhase phs);
	
}

class Phase extends AbstractPhase {

	public Phase(String seq_no) {
		super.seq_no = seq_no;
		this.subPhases = new ArrayList();
	}

	@Override
	public void add(AbstractPhase phs) {
		this.subPhases.add(phs);
	}

	@Override
	public void remove(AbstractPhase phs) {
		this.subPhases.remove(phs);
	}
}