package edu.unca.csci201;

public class ShortAnswerQuestion implements Question {
	
	private String prompt;
	
	public ShortAnswerQuestion(String prompt) {
		this.prompt = prompt;
	}

	@Override
	public String getTextPrompt() {
		return prompt;
	}

	@Override
	public Answer[] getPossibleAnswers() throws NoAnswersException {
		throw new NoAnswersException();
	}

	@Override
	public Answer getCorrectAnswer() throws NoCorrectAnswerException {
		throw new NoCorrectAnswerException();
	}

	@Override
	public Answer convertResponseToAnswer(String userResponse) throws InvalidResponseException {
		if (userResponse == null)
			throw new InvalidResponseException();
		else
			return new ShortAnswer(userResponse);
	}

}
