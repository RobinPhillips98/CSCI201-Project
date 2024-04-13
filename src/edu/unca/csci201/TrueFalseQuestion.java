package edu.unca.csci201;

public class TrueFalseQuestion implements Question {
	
	private String prompt;
	private boolean correctAnswer;

	public TrueFalseQuestion(String prompt, boolean correctAnswer) {
		this.prompt = prompt;
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String getTextPrompt()  {
		return prompt;
	}

	@Override
	public Answer[] getPossibleAnswers() throws NoAnswersException {
		
		throw new NoAnswersException();
		
	}

	@Override
	public Answer getCorrectAnswer() throws NoCorrectAnswerException {
		return new TrueFalseAnswer(correctAnswer);
	}

	@Override
	public Answer convertResponseToAnswer(String userResponse) throws InvalidResponseException {
		boolean answer;
		if (userResponse.equalsIgnoreCase("t"))
				answer = true;
		else if (userResponse.equalsIgnoreCase("f"))
			answer = false;
		else
			throw new InvalidResponseException();
		return new TrueFalseAnswer(answer);
	}

}