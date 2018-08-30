package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subjects")
public class Subjects {
	
	public Subjects() {
	}

	@EmbeddedId
	private Pk pk;
	
	public Pk getPk() {
		return pk;
	}

	public void setPk(Pk pk) {
		this.pk = pk;
	}

	
	public Subjects(Pk pk) {
		super();
		this.pk = pk;
	}

	private String subject_name;

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
	@Column(name="desciption")
	private String desciption;

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	
	@ManyToOne
	@JoinColumn(name="stu_id", nullable=false, insertable=false, updatable=false)
	private Student student;
	
	@Embeddable
	public static class Pk implements Serializable{
		
		public Pk() {
		}
		
		public Pk(int subject_id, int stu_id) {
			this.subject_id = subject_id;
			this.stu_id = stu_id;
		}

		@Column(name="subject_id")
		private int subject_id;

		public int getSubject_id() {
			return subject_id;
		}

		public void setSubject_id(int subject_id) {
			this.subject_id = subject_id;
		}
		
		@Column(name="stu_id")
		private int stu_id;

		public int getStu_id() {
			return stu_id;
		}

		public void setStu_id(int stu_id) {
			this.stu_id = stu_id;
		}
		
	}
}
