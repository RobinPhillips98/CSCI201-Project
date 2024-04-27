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
		
		char answer;
		
		switch (userResponse.toUpperCase()) {
			case "A":
				answer = 'A';
				break;
			case "B":
				answer = 'B';
				break;
			case "C":
				answer = 'C';
				break;
			case "D":
				answer = 'D';
				break;
			default:
				throw new InvalidResponseException();
		}
		return new MultipleChoiceAnswer(answer);
	}
}
