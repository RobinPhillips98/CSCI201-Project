package edu.unca.csci201.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.unca.csci201.TrueFalseAnswer;

public class TrueFalseAnswerTest {

	@Test
	public void testCreateTrueFalseAnswer() {
		
		TrueFalseAnswer answer1 = new TrueFalseAnswer(true);
		TrueFalseAnswer answer2 = new TrueFalseAnswer(false);
		
	}

	@Test
	public void testIsSameAs() {

		TrueFalseAnswer answer1 = new TrueFalseAnswer(true);
		TrueFalseAnswer answer2 = new TrueFalseAnswer(true);
		TrueFalseAnswer answer3 = new TrueFalseAnswer(false);
		
		assertTrue(answer1.isSameAs(answer1), "IsSameAs() fails self-test for true");
		assertTrue(answer2.isSameAs(answer2), "IsSameAs() fails self-test for false");
		assertTrue(answer1.isSameAs(answer2), "IsSameAs() fails for true");
		assertFalse(answer1.isSameAs(answer3), "IsSameAs() fails for false");
		
	}

	@Test
	public void testToString() {
		TrueFalseAnswer answer1 = new TrueFalseAnswer(true);
		TrueFalseAnswer answer2 = new TrueFalseAnswer(false);
		
		assertTrue(answer1.toString().equalsIgnoreCase("true"), "toString() does not output 'true'");
		assertTrue(answer2.toString().equalsIgnoreCase("false"), "toString() does not output 'false'");
		
	}

}
