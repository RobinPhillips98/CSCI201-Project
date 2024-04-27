package edu.unca.csci201;

import java.util.Scanner;

/** An object of class quiz represents a quiz, containing a list of questions
 *  that can be given to the user and used to calculate the user's score. */
public class Quiz {

	private Question[] quizQuestions = new Question[25];
	private Question[] incorrectQuestions = new Question[25];
	private int i = 0;

	/** Add question to the array of questions held by the quiz. */
	public void addQuestion(Question question) throws QuizFullException {

		if (i > 24)
			throw new QuizFullException();
		else {

			quizQuestions[i] = question;
			i++;
		}
	}

	/** Present each question in quiz to the user, record incorrect answers, and return
	 *  the user's score. */
	public double giveQuiz() throws QuizBaseException {

		int correctAnswers = 0;
		int questionsToGrade = 0;
		int j = 0; // Counter for incorrect questions array

		if (quizQuestions[0] == null)
			return 0.0;
		else {
			Scanner scan = new Scanner(System.in);

			/* Go through each question held in quiz, present them to the user,
			 * break the loop when out of questions. */
			for (Question currentQuestion : quizQuestions) {				
				if (currentQuestion == null)
					break;
				else {
					boolean isInvalid; // Controller boolean for invalid input loop

					System.out.println(currentQuestion.getTextPrompt());

					if (currentQuestion instanceof MultipleChoiceQuestion)
						for (Answer currentAnswer : currentQuestion.getPossibleAnswers())
							System.out.println(currentAnswer);
					do {
						isInvalid = false;

						try {
							Answer answer = currentQuestion.convertResponseToAnswer(scan.nextLine());
							if (answer.isSameAs(currentQuestion.getCorrectAnswer()))
								correctAnswers++;
							else {
								incorrectQuestions[j] = currentQuestion;
								j++;
							}
							questionsToGrade++;
						} 
						catch (InvalidResponseException e) {
							isInvalid = true;
							System.out.println("Response invalid. Please try again");
						} 
						catch (NoCorrectAnswerException e) {
							System.out.println("This question will be graded at a later date.");
						}
					}
					while (isInvalid == true); // Loop if user enters invalid input.
				}
			}
			scan.close();
		}
		if (questionsToGrade > 0)
			return (double) correctAnswers / questionsToGrade;
		else
			return 0;
	}

	/** Go through array of incorrect answers and print out each question and the correct answer. */
	public void printIncorrectAnswers() throws NoCorrectAnswerException {

		if (incorrectQuestions[0] != null) {
			System.out.println("Incorrect answers: ");
			System.out.println();

			for (Question currentQuestion : incorrectQuestions) {
				if (currentQuestion == null)
					break;
				else {
					System.out.println(currentQuestion.getTextPrompt());
					System.out.println("Correct Answer: " + currentQuestion.getCorrectAnswer());
					System.out.println();
				}
			}
		}
		else
			System.out.println("No incorrect answers!");
	}
}
