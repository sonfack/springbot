package vn.edu.ifi.bot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.ifi.bot.entity.Question;
import vn.edu.ifi.bot.repository.QuestionRepository;



@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository ;
	


}
