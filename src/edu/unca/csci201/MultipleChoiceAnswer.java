package edu.unca.csci201;

public class MultipleChoiceAnswer implements Answer {
	
	private char answer;
	private String prompt;

	public MultipleChoiceAnswer(char answer, String prompt) {
		this.answer = answer;
		this.prompt = prompt;
	}

	public MultipleChoiceAnswer(char answer) {
		this.answer = answer;
	}

	@Override
	public boolean isSameAs(Answer other) {
		
		MultipleChoiceAnswer mcAns = (MultipleChoiceAnswer) other;
		
		return (mcAns.answer == this.answer);
	}
	
	public String toString() {
		return String.valueOf(answer + ". " + prompt);
	}

}
