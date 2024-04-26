package edu.unca.csci201.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.unca.csci201.Answer;
import edu.unca.csci201.InvalidResponseException;
import edu.unca.csci201.MultipleChoiceAnswer;
import edu.unca.csci201.MultipleChoiceQuestion;
import edu.unca.csci201.NoAnswersException;
import edu.unca.csci201.NoCorrectAnswerException;

public class MultipleChoiceQuestionTest {
	
	MultipleChoiceQuestion question;

	@BeforeEach
	public void setUp() {
		question = new MultipleChoiceQuestion("The answer to this question is D.", new MultipleChoiceAnswer('D', "Incorrect"), new MultipleChoiceAnswer('A', "Incorrect"), new MultipleChoiceAnswer('B', "Incorrect"), new MultipleChoiceAnswer('C', "Incorrect"), new MultipleChoiceAnswer('D', "Incorrect"));
	}
	
	@Test
	public void testGetTextPrompt() {
		assertTrue(question.getTextPrompt().equals("The answer to this question is D."), "Text prompt not returned correctly.");
	}
	
	@Test
	public void testGetPossibleAnswers() throws NoAnswersException {
		
		MultipleChoiceAnswer[] possibleAnswers = {new MultipleChoiceAnswer('A'), new MultipleChoiceAnswer('B'), new MultipleChoiceAnswer('C'), new MultipleChoiceAnswer('D')};
		MultipleChoiceAnswer[] testAnswers = question.getPossibleAnswers();
		for (int i = 0; i < 3; i++)
			assertTrue(possibleAnswers[i].isSameAs(testAnswers[i]));
			
	}
	
	@Test
	public void testGetCorrectAnswer() throws NoCorrectAnswerException {
		
		Answer ans = question.getCorrectAnswer();
		
		MultipleChoiceAnswer mcAns = (MultipleChoiceAnswer) ans;
		
		assertTrue(mcAns.isSameAs(question.getCorrectAnswer()), "Incorrect answer returned for the multiple choice question");
		
	}
	
	@Test
	public void testConvertResponseToAnswer() throws InvalidResponseException {
		
		Answer ans = question.convertResponseToAnswer("A");
		
		MultipleChoiceAnswer mcAns = (MultipleChoiceAnswer) ans;
		
		assertTrue(mcAns.isSameAs(new MultipleChoiceAnswer('A')), "Incorrect answer returned converting user resposne 'A'");
		
		ans = question.convertResponseToAnswer("B");
		
		mcAns = (MultipleChoiceAnswer) ans;
		
		assertTrue(mcAns.isSameAs(new MultipleChoiceAnswer('B')), "Incorrect answer returned converting user resposne 'B'");
		
		ans = question.convertResponseToAnswer("C");
		
		mcAns = (MultipleChoiceAnswer) ans;
		
		assertTrue(mcAns.isSameAs(new MultipleChoiceAnswer('C')), "Incorrect answer returned converting user resposne 'C'");
		
		ans = question.convertResponseToAnswer("D");
		
		mcAns = (MultipleChoiceAnswer) ans;
		
		assertTrue(mcAns.isSameAs(new MultipleChoiceAnswer('D')), "Incorrect answer returned converting user resposne 'D'");
		
		try {
			ans = question.convertResponseToAnswer("this is not a valid response");
		} catch (InvalidResponseException e) {
			// Correct exception thrown in response to invalid input
			return;
		}
		
		fail("Converting user response did not throw an exception when invalid input is received");
	}

}
