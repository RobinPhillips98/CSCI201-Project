package edu.unca.csci201;

public class MultipleChoiceQuestion implements Question {
	
	private String prompt;
	private char correctAnswer;

	public MultipleChoiceQuestion(String prompt, char correctAnswer) {
		this.prompt = prompt;
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String getTextPrompt() {
		return prompt;
	}

	@Override
	public MultipleChoiceAnswer[] getPossibleAnswers() throws NoAnswersException {
		MultipleChoiceAnswer[] possibleAnswers = {new MultipleChoiceAnswer('A'), new MultipleChoiceAnswer('B'), new MultipleChoiceAnswer('C'), new MultipleChoiceAnswer('D')};
		return possibleAnswers;
	}

	@Override
	public Answer getCorrectAnswer() throws NoCorrectAnswerException {
		return new MultipleChoiceAnswer(correctAnswer);
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
