package edu.unca.csci201;

public class TrueFalseAnswer implements Answer {
	
	private boolean answer;

	public TrueFalseAnswer(boolean answer) {
		this.answer = answer;
	}

	@Override
	public boolean isSameAs(Answer other) {
		return (other.toString().equals(this.toString()));
	}
	
	public String toString() {
		if (answer == true)
			return "True";
		else if (answer == false)
			return "False";
		else
			return null;
	}

}
