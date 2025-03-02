package com.akshay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.entity.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>
{

}