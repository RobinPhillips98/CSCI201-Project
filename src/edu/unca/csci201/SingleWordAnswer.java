package edu.unca.csci201;

public class SingleWordAnswer implements Answer {
	
	private String answer;
	
	public SingleWordAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public boolean isSameAs(Answer other) {
		return (other.toString().equals(this.toString()));
	}
	
	public String toString() {
		return answer;
	}

}
