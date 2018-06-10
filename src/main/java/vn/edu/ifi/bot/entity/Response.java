package vn.edu.ifi.bot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Response {
	@Id
	@Column(name="answer_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long response_id ;
	
	@Column(name="answer")
	private String response ; 
	
	@Column(name="answer_status")
	private int response_status ; 
	
	@Override
	public String toString() {
		return response_id+"#"+response+"#"+response_status ; 
	}

}
