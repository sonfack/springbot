package vn.edu.ifi.bot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	@Id
	@Column(name="question_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long question_id; 
	
	@Column(name="question")
	private String question ;
	
	@Column(name="question_status")
	private int question_status;
	
	@Column(name="answer_id",nullable=false)
	private Long answer_id; 
	
	public Long getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(Long answer_id) {
		this.answer_id = answer_id;
	}
	public Long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getQuestion_status() {
		return question_status;
	}
	public void setQuestion_status(int question_status) {
		this.question_status = question_status;
	}
	
	@Override
	public String toString() {
		return question_id+"#"+answer_id+"#"+question+"#"+question_status ; 
	}
	// many to one realtion 
	@ManyToOne()
	@JoinColumn(name="answer_id", nullable = false, referencedColumnName="answer_id", insertable = false, updatable = false)
	private Response response;
}
