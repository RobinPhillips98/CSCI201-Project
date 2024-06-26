package edu.unca.csci201.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.unca.csci201.Quiz;
import edu.unca.csci201.QuizBaseException;
import edu.unca.csci201.QuizFullException;

public class QuizTest {

	private Quiz myQuiz;

	@BeforeEach
	public void setupQuiz() {
		myQuiz = new Quiz();
	}

	@Test
	public void testAddQuestion() throws QuizFullException {
		myQuiz.addQuestion(new DummyQuestion(false, false, false, false));
	}

	@Test
	public void testAddTooManyQuestions() {

		try {
			for (int i = 0; i < 26; i ++)
				myQuiz.addQuestion(new DummyQuestion(false, false, false, false));	
		} catch (QuizFullException e) {
			// Correctly threw the exception
			return;
		}
		fail("Quiz did not throw an exception when more than 25 questions are added");	
	}

	@Test
	public void testEmptyQuiz() throws QuizBaseException {

		double score = myQuiz.giveQuiz();

		assertTrue( Math.abs(score) <= 0.000001, "Score should be zero");
	}

	@Test
	public void testCorrectQuestionResponse() throws QuizBaseException {

		String testString = "T\n";

		System.setIn(new ByteArrayInputStream(testString.getBytes()));

		myQuiz.addQuestion(new DummyQuestion(true, false, false, false));

		double score = myQuiz.giveQuiz();

		assertTrue( Math.abs(score) > 0.000001, "Score should be greater than zero");
	}

	@Test
	public void testIncorrectQuestionResponse() throws QuizBaseException {

		String testString = "T\n";

		System.setIn(new ByteArrayInputStream(testString.getBytes()));

		myQuiz.addQuestion(new DummyQuestion(false, false, false, false));

		double score = myQuiz.giveQuiz();

		assertTrue( Math.abs(score) <= 0.000001, "Score should be zero");
	}

	@Test
	public void testMultipleQuestions() throws QuizBaseException {

		String testString = "T\nF\n";

		System.setIn(new ByteArrayInputStream(testString.getBytes()));

		myQuiz.addQuestion(new DummyQuestion(true, false, false, false));
		myQuiz.addQuestion(new DummyQuestion(true, false, false, false));

		double score = myQuiz.giveQuiz();
		final double TOLERANCE = 0.0001;

		assertTrue(Math.abs(score - 1) <= TOLERANCE, "Score should be equal to one"); //Changed score to be from 0-1 in order to use percent format.
	}

	@Test
	public void testHandleExceptions() throws QuizBaseException {

		String testString = "T\nF\nF\n";

		System.setIn(new ByteArrayInputStream(testString.getBytes()));

		// Question without a list of answers

		myQuiz.addQuestion(new DummyQuestion(true, true, false, false));

		// Question user invalid response

		myQuiz.addQuestion(new DummyQuestion(true, false, false, true));

		try {
			myQuiz.giveQuiz();

		} catch (NoSuchElementException e) {
			// User input has run out (correctly) due to invalid responses
		}
	}

	@Test
	public void testHandleExtraCreditException() throws QuizBaseException {

		String testString = "T\n";

		System.setIn(new ByteArrayInputStream(testString.getBytes()));

		// Question without list of answers or right answer

		myQuiz.addQuestion(new DummyQuestion(true, true, true, false));

		double score = myQuiz.giveQuiz();

		assertTrue( Math.abs(score) <= 0.000001, "Score should be zero");
	}
}
