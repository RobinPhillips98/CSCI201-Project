package edu.unca.csci201.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.unca.csci201.ShortAnswer;

public class ShortAnswerTest {

	@Test
	void testCreateShortAnswer() {
		ShortAnswer answer1 = new ShortAnswer("Correct");
		ShortAnswer answer2 = new ShortAnswer("Incorrect");
	}

	@Test
	public void testIsSameAs() {

		ShortAnswer answer1 = new ShortAnswer("Correct");
		ShortAnswer answer2 = new ShortAnswer("Incorrect");
		ShortAnswer testAnswer = new ShortAnswer("Correct");

		assertTrue(answer1.isSameAs(answer1), "IsSameAs() fails self-test for Correct");
		assertTrue(answer2.isSameAs(answer2), "IsSameAs() fails self-test for Incorrect");
		assertFalse(answer1.isSameAs(answer2), "IsSameAs() fails for incorrect");
		assertTrue(answer1.isSameAs(testAnswer), "IsSameAs() fails for correct");	
	}

	@Test
	public void testToString() {

		ShortAnswer answer1 = new ShortAnswer("Correct");
		ShortAnswer answer2 = new ShortAnswer("Incorrect");

		assertTrue(answer1.toString().equals("Correct"), "toString() does not output 'Correct'");
		assertTrue(answer2.toString().equals("Incorrect"), "toString() does not output 'Inorrect'");
	}
}
