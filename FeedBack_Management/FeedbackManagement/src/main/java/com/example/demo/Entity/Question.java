package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question implements Comparable<Question>{
	@Id
	@Column(name="ques_id")
	private int ques_id;
	@Column(name="ques_name")
	private String ques_name;
	@Column(name="ques_type")
	private String type;
	@Column(name = "ques_usage")
	private String usage;

	public Question(int ques_id, String ques_name, String type, String usage) {
		this.ques_id = ques_id;
		this.ques_name = ques_name;
		this.type = type;
		this.usage = usage;
	}

	public int getQues_id() {
		return ques_id;
	}

	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}

	public String getQues_name() {
		return ques_name;
	}

	public void setQues_name(String ques_name) {
		this.ques_name = ques_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public Question(){
	}

	public int getQuesId() {
		return ques_id;
	}

	public void setQuesId(int ques_id) {
		this.ques_id = ques_id;
	}

	public String getQuesName() {
		return ques_name;
	}

	public void setQuesName(String ques_name) {
		this.ques_name = ques_name;
	}


	public Question(int ques_id, String ques_name, String type) {
		this.ques_id = ques_id;
		this.ques_name = ques_name;
		this.type = type;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ques_name == null) ? 0 : ques_name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Question [ques_id=" + ques_id + ", ques_name=" + ques_name +" type=" + type + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (ques_name == null) {
			if (other.ques_name != null)
				return false;
		} else if (!ques_name.equals(other.ques_name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Question o) {
		return this.ques_id-((Question)o).getQuesId();
	}
	
	
	
}
