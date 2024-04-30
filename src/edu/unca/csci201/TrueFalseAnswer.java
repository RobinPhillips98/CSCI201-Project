package edu.unca.csci201;

public class TrueFalseAnswer implements Answer {

	private boolean answer;

	public TrueFalseAnswer(boolean answer) {
		this.answer = answer;
	}

	@Override
	public boolean isSameAs(Answer other) {

		TrueFalseAnswer tfAns = (TrueFalseAnswer) other;
		return (tfAns.answer == this.answer);
	}

	public String toString() {

		return String.valueOf(answer);
	}
}
