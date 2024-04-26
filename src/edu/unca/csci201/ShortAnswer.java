package edu.unca.csci201;

public class ShortAnswer implements Answer {
	
	private String answer;

	public ShortAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public boolean isSameAs(Answer other) {

		ShortAnswer sAns = (ShortAnswer) other;
		return (sAns.answer.equalsIgnoreCase(this.answer));
		
	}
	
	public String toString() {
		return answer;
	}

}
