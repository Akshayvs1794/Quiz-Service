package com.akshay.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.entity.QuestionWrapper;
import com.akshay.entity.Response;

@FeignClient("MS-QUESTIONSERVICE")
public interface QuizInterface
{
	// generate quiz
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category, 
			@RequestParam Integer numQs); 
		
		
	// getQuestion(questionId)
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
		
		
	//getScore
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}