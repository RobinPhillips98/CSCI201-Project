package edu.unca.csci201.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.unca.csci201.SingleWordAnswer;

class SingleWordAnswerTest {

	@Test
	public void testCreateSingleWordAnswer() {
		
		SingleWordAnswer answer1 = new SingleWordAnswer("Correct");;
		SingleWordAnswer answer2 = new SingleWordAnswer("Incorrect");
	}
	
	@Test
	public void testIsSameAs() {
		
		SingleWordAnswer answer1 = new SingleWordAnswer("Correct");;
		SingleWordAnswer answer2 = new SingleWordAnswer("Incorrect");
		SingleWordAnswer correctAnswer = new SingleWordAnswer("Correct");;
		
		assertTrue(answer1.isSameAs(answer1), "IsSameAs() fails self-test for Correct");
		assertTrue(answer2.isSameAs(answer2), "IsSameAs() fails self-test for Incorrect");
		assertFalse(answer1.isSameAs(answer2), "IsSameAs() fails for incorrect");
		assertTrue(answer1.isSameAs(correctAnswer), "IsSameAs() fails for correct");
		
	}
	
	@Test
	public void testToString() {
		
		SingleWordAnswer answer1 = new SingleWordAnswer("Correct");;
		SingleWordAnswer answer2 = new SingleWordAnswer("Incorrect");
		
		assertTrue(answer1.toString().equals("Correct"), "toString() does not output 'Correct'");
		assertTrue(answer2.toString().equals("Incorrect"), "toString() does not output 'Inorrect'");
		
	}

}
