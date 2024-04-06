package edu.unca.csci201;

public class MultipleChoiceAnswer implements Answer {
	
	private char answer;

	public MultipleChoiceAnswer(char answer) {
		this.answer = answer;
	}

	@Override
	public boolean isSameAs(Answer other) {
		return (other.toString().equals(this.toString()));
	}
	
	public String toString() {
		return String.valueOf(answer);
	}

}
