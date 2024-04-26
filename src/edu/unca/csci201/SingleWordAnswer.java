package edu.unca.csci201;

public class SingleWordAnswer implements Answer {
	
	private String answer;
	
	public SingleWordAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public boolean isSameAs(Answer other) {
		
		SingleWordAnswer swAns = (SingleWordAnswer) other;
		return (swAns.answer.equalsIgnoreCase(this.answer));
		
	}
	
	public String toString() {
		return answer;
	}

}
