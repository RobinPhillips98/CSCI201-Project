package edu.unca.csci201;

public class FillInTheBlankQuestion implements Question {

	private String prompt, correctAnswer;

	public FillInTheBlankQuestion(String prompt, String correctAnswer) {
		this.prompt = prompt;
		this.correctAnswer = correctAnswer;
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
		return new SingleWordAnswer(correctAnswer);
	}

	@Override
	public Answer convertResponseToAnswer(String userResponse) throws InvalidResponseException {

		if (userResponse == null)
			throw new InvalidResponseException();
		else
			return new SingleWordAnswer(userResponse);
	}
}
