package vn.edu.ifi.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.ifi.bot.entity.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
	
}
