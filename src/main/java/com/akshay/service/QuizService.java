package com.akshay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akshay.dao.QuizDao;
import com.akshay.entity.QuestionWrapper;
import com.akshay.entity.Quiz;
import com.akshay.entity.Response;
import com.akshay.feign.QuizInterface;

@Service
public class QuizService
{
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int numQs, String title)
	{
		List<Integer> questions =  quizInterface.getQuestionForQuiz(category, numQs).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		
		quizDao.save(quiz);
		
		return new ResponseEntity<String>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id)
	{
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
		
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
		
		return questions;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses)
	{
		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		
		return score;
	}

	
}