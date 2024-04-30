package edu.unca.csci201.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.unca.csci201.MultipleChoiceAnswer;

public class MultipleChoiceAnswerTest {

	@SuppressWarnings("unused")
	@Test
	public void testCreateMultipleChoiceAnswer() {

		MultipleChoiceAnswer answer1 = new MultipleChoiceAnswer('A');
		MultipleChoiceAnswer answer2 = new MultipleChoiceAnswer('B');
		MultipleChoiceAnswer answer3 = new MultipleChoiceAnswer('C');
		MultipleChoiceAnswer answer4 = new MultipleChoiceAnswer('D');

	}

	@Test
	public void testIsSameAs() {

		MultipleChoiceAnswer answer1 = new MultipleChoiceAnswer('A');
		MultipleChoiceAnswer answer2 = new MultipleChoiceAnswer('B');
		MultipleChoiceAnswer answer3 = new MultipleChoiceAnswer('C');
		MultipleChoiceAnswer answer4 = new MultipleChoiceAnswer('D');
		MultipleChoiceAnswer correctAnswer = new MultipleChoiceAnswer('C');

		assertTrue(answer1.isSameAs(answer1), "IsSameAs() fails self-test for A");
		assertTrue(answer2.isSameAs(answer2), "IsSameAs() fails self-test for B");
		assertTrue(answer3.isSameAs(answer3), "IsSameAs() fails self-test for C");
		assertTrue(answer4.isSameAs(answer4), "IsSameAs() fails self-test for D");
		assertFalse(answer1.isSameAs(correctAnswer), "IsSameAs() fails for A");
		assertFalse(answer2.isSameAs(correctAnswer), "IsSameAs() fails for B");
		assertTrue(answer3.isSameAs(correctAnswer), "IsSameAs() fails for C");
		assertFalse(answer4.isSameAs(correctAnswer), "IsSameAs() fails for D");
	}

	@Test
	public void testsToString() {

		MultipleChoiceAnswer answer1 = new MultipleChoiceAnswer('A', "Answer A");
		MultipleChoiceAnswer answer2 = new MultipleChoiceAnswer('B', "Answer B");
		MultipleChoiceAnswer answer3 = new MultipleChoiceAnswer('C', "Answer C");
		MultipleChoiceAnswer answer4 = new MultipleChoiceAnswer('D', "Answer D");

		assertTrue(answer1.toString().equalsIgnoreCase("A. Answer A"), "toString() does not output A correctly");
		assertTrue(answer2.toString().equalsIgnoreCase("B. Answer B"), "toString() does not output B correctly");
		assertTrue(answer3.toString().equalsIgnoreCase("C. Answer C"), "toString() does not output C correctly");
		assertTrue(answer4.toString().equalsIgnoreCase("D. Answer D"), "toString() does not output D correctly");
	}
}
