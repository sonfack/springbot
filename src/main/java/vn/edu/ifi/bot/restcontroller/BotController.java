package vn.edu.ifi.bot.restcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.internal.filter.ValueNode.JsonNode;

import vn.edu.ifi.bot.entity.Response;
import vn.edu.ifi.bot.stringsimilarity.*;
import vn.edu.ifi.bot.repository.QuestionRepository;
import vn.edu.ifi.bot.repository.ResponseRepository;
import vn.edu.ifi.bot.service.QuestionService;

@RestController
@RequestMapping(value="/api/bot")
public class BotController {
	
	
	@Autowired
	QuestionRepository RepoQuestion ; 
	
	@Autowired 
	ResponseRepository RepoResponse ; 
	
	@RequestMapping(value="/question",method=RequestMethod.POST)
	public String answer(@RequestBody  String question){
		List listQuestion = new ArrayList<Object>();
		JaroWinkler testSimilarity  =  new JaroWinkler(); 
		String quest = "";
		String [] splitQuestion = question.split("&");
		String questionEqual = splitQuestion[1]; 
		quest = quest+questionEqual.split("=")[1];
		quest = quest.replace("+", " "); 
		quest = quest.trim(); 
		System.out.println("ici la question: "+quest);
		listQuestion = RepoQuestion.findByQuestionIgnoreCaseContaining(quest); 
		System.out.println("ici nombre de question similaires: "+listQuestion.size());
		if(listQuestion.size() >0) {
			double maxSimilarity = 0; 
			List<Long> index = new ArrayList<Long>(); 
			double similar ; 
			for(int i = 0 ; i< listQuestion.size(); i++) {
				String stringQuestion = listQuestion.get(i).toString(); 
				String[] tabQuestion = stringQuestion.split("#"); 
				similar = testSimilarity.similarity(quest, tabQuestion[2].trim()); 
				if(similar!= 0 & similar > maxSimilarity ) {
					maxSimilarity = similar;
					index.clear();
					index.add(Long.parseLong(tabQuestion[1])); 
				}
				if(similar!= 0 & similar == maxSimilarity ) {
					index.add(Long.parseLong(tabQuestion[1])); 
				}
			
			}
			if(index.size() > 0) {
				String stringResponse = RepoResponse.findById(index.get(index.size()-1)).toString();
				String[] tabResponse = stringResponse.split("#"); 
				quest = tabResponse[1]; 
			}else {
				quest="Plus d'information sur ifi.edu.vn";
			}
			
		}else {
			quest="Plus d'information sur ifi.edu.vn"; 
		}
		return quest;
	 
	}
	
	@RequestMapping(value="/api/bot/allquestions", method=RequestMethod.GET)
	public String questions() {
	
		return "les question"; 
	}
	
}
