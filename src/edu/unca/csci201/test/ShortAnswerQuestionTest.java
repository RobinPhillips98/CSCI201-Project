package edu.unca.csci201.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.unca.csci201.*;

public class ShortAnswerQuestionTest {

	ShortAnswerQuestion question;

	@BeforeEach
	public void setUp() throws QuizBaseException {
		question = new ShortAnswerQuestion("What is a question?");
	}

	@Test
	public void testGetTextPrompt() {
		assertEquals(question.getTextPrompt(), "What is a question?", "Text prompt not reqturned correctly.");
	}

	@Test
	public void testGetPossibleAnswers() {

		try {
			question.getPossibleAnswers();
		} catch (NoAnswersException e) {
			// Exception thrown successfully (short answer doesn't give a list of possible answers)
			return;
		}
		fail("Exception not thrown when fill-in-the-blank question asked for a list of possible answers");	
	}

	@Test
	public void testGetCorrectAnswer() {

		try {
			question.getCorrectAnswer();
		} catch (NoCorrectAnswerException e) {
			// Exception thrown successfully (fill-in-the-blank doesn't give a list of possible answers)
			return;
		}
		fail("Exception not thrown when fill-in-the-blank question asked for a list of possible answers");

	}

	@Test
	public void testConvertResponseToAnswer() throws InvalidResponseException {

		Answer ans = question.convertResponseToAnswer("Correct");
		ShortAnswer sAns = (ShortAnswer) ans;

		assertTrue(sAns.isSameAs(new ShortAnswer("Correct")), "Incorrect answer returned converting user response 'Correct'");

		try {
			ans = question.convertResponseToAnswer(null);
		} catch (InvalidResponseException e) {
			// Correct exception thrown in response to invalid input
			return;
		}
	}
}
