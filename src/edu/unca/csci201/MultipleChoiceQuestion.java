package edu.unca.csci201;

public class MultipleChoiceQuestion implements Question {
	
	private String prompt;
	private MultipleChoiceAnswer correctAnswer;
	private MultipleChoiceAnswer[] possibleAnswers;

	public MultipleChoiceQuestion(String prompt, MultipleChoiceAnswer correctAnswer, MultipleChoiceAnswer ... possibleAnswers) {
		this.prompt = prompt;
		this.correctAnswer = correctAnswer;
		this.possibleAnswers = possibleAnswers;
	}

	@Override
	public String getTextPrompt() {
		return prompt;
	}

	@Override
	public MultipleChoiceAnswer[] getPossibleAnswers() throws NoAnswersException {
		return possibleAnswers;
	}

	@Override
	public Answer getCorrectAnswer() throws NoCorrectAnswerException {
		return correctAnswer;
	}

	@Override
	public Answer convertResponseToAnswer(String userResponse) throws InvalidResponseException {
		
		switch (userResponse.toUpperCase()) {
			case "A":
			return new MultipleChoiceAnswer('A');
		case "B":
			return new MultipleChoiceAnswer('B');
		case "C":
			return new MultipleChoiceAnswer('C');
		case "D":
			return new MultipleChoiceAnswer('D');
		default:
			throw new InvalidResponseException();
		}
	}
}
