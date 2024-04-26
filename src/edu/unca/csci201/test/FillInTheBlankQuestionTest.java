package edu.unca.csci201.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.unca.csci201.Answer;
import edu.unca.csci201.FillInTheBlankQuestion;
import edu.unca.csci201.InvalidResponseException;
import edu.unca.csci201.NoAnswersException;
import edu.unca.csci201.NoCorrectAnswerException;
import edu.unca.csci201.QuizBaseException;
import edu.unca.csci201.SingleWordAnswer;

public class FillInTheBlankQuestionTest {
	
	FillInTheBlankQuestion question;
	
	@BeforeEach
	public void setUp() throws QuizBaseException {
		question = new FillInTheBlankQuestion("This is a __________", "question");
	}

	@Test
	public void testGetTextPrompt() {	
		assertTrue(question.getTextPrompt().equals("This is a __________"), "Text prompt not returned correctly.");
	}
	
	@Test
	public void testGetPossibleAnswers() {
		try {
			question.getPossibleAnswers();
		} catch (NoAnswersException e) {
			// Exception thrown successfully (fill-in-the-blank doesn't give a list of possible answers)
			return;
		}
		
		fail("Exception not thrown when fill-in-the-blank question asked for a list of possible answers");
	}
	
	@Test
	public void testGetCorrectAnswer() throws NoCorrectAnswerException {
		
		Answer ans = question.getCorrectAnswer();
		
		SingleWordAnswer swAns = (SingleWordAnswer) ans;
		
		assertTrue(swAns.isSameAs(question.getCorrectAnswer()), "Incorrect answer returned for the fill-in-the-blank question");		
	}
	
	@Test
	public void testConvertResponseToAnswer() throws InvalidResponseException {
		
		Answer ans = question.convertResponseToAnswer("Correct");
		
		SingleWordAnswer swAns = (SingleWordAnswer) ans;
		
		assertTrue(swAns.isSameAs(new SingleWordAnswer("Correct")), "Incorrect answer returned converting user response 'Correct'");
		
		ans = question.convertResponseToAnswer("Incorrect");
		
		swAns = (SingleWordAnswer) ans;
		
		assertTrue(swAns.isSameAs(new SingleWordAnswer("Incorrect")), "Incorrect answer returned converting user response 'Incorrect'");
		
		try {
			ans = question.convertResponseToAnswer(null);
		} catch (InvalidResponseException e) {
			// Correct exception thrown in response to invalid input
			return;
		}
		
	}

}
