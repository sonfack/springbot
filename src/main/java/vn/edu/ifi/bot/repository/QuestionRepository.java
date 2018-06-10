package vn.edu.ifi.bot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.ifi.bot.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	List<Question> findByQuestionIgnoreCaseContaining(String questionPattern); 
}
