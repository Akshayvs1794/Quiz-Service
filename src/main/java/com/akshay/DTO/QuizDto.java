package com.akshay.DTO;

public class QuizDto
{
	private Integer numQuestions;
	private String CategoryName;
	private String title;
	
	public QuizDto() {
		super();
	}
	public Integer getNumQuestions() {
		return numQuestions;
	}
	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}
	
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "QuizDto [numQuestions=" + numQuestions + ", CategoryName=" + CategoryName + ", title=" + title + "]";
	}
}