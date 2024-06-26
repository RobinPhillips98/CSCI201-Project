package edu.unca.csci201.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.unca.csci201.Answer;
import edu.unca.csci201.InvalidResponseException;
import edu.unca.csci201.NoAnswersException;
import edu.unca.csci201.NoCorrectAnswerException;
import edu.unca.csci201.TrueFalseAnswer;
import edu.unca.csci201.TrueFalseQuestion;

public class TrueFalseQuestionTest {

	TrueFalseQuestion question;

	@BeforeEach
	public void setUp() throws Exception {
		question = new TrueFalseQuestion("The answer to this question is true", true);
	}

	@Test
	public void testGetTextPrompt() {
		assertTrue(question.getTextPrompt().equals("The answer to this question is true"), "Text prompt not returned correctly");
	}

	@Test
	public void testGetPossibleAnswers() {

		try {
			question.getPossibleAnswers();
		} catch (NoAnswersException e) {
			// Exception thrown successfully (true / false doesn't give a list of possible answers)
			return;
		}
		fail("Exception not thrown when true/false question asked for a list of possible answers");
	}

	@Test
	public void testGetCorrectAnswer() throws NoCorrectAnswerException {

		Answer ans = question.getCorrectAnswer();
		TrueFalseAnswer tfAns = (TrueFalseAnswer) ans;

		assertTrue(tfAns.isSameAs(new TrueFalseAnswer(true)), "Incorrect answer returned for the true/false question");
	}

	@Test
	public void testConvertResponseToAnswer() throws InvalidResponseException {

		Answer ans = question.convertResponseToAnswer("t");
		TrueFalseAnswer tfAns = (TrueFalseAnswer) ans;

		assertTrue(tfAns.isSameAs(new TrueFalseAnswer(true)), "Incorrect answer returned converting user response 't'");

		ans = question.convertResponseToAnswer("f");		
		tfAns = (TrueFalseAnswer) ans;

		assertTrue(tfAns.isSameAs(new TrueFalseAnswer(false)), "Incorrect answer returned converting user response 'f'");


		try {
			ans = question.convertResponseToAnswer("this is not a valid response");
		} catch (InvalidResponseException e) {
			// Correct exception thrown in response to invalid input
			return;
		}
		fail("Converting user response did not throw an exception when invalid input is received");
	}
}
