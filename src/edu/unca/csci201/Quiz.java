 package edu.unca.csci201;

import java.util.Scanner;

public class Quiz {
	
	Question[] quizQuestions = new Question[25];
	Question[] incorrectQuestions = new Question[25];
	int i;

	public void addQuestion (Question question) throws QuizFullException {
		if (i > 24)
			throw new QuizFullException();
		else {
			quizQuestions[i] = question;
			i++;
		}
	}

	public double giveQuiz() throws QuizBaseException {
		
		int correctAnswers = 0;
		int j = 0; //Counter for incorrect questions array
		
		
		if (quizQuestions[0] == null)
			return 0.0;
		else {
			
			Scanner scan = new Scanner(System.in);
			
			for (Question currentQuestion: quizQuestions) {
				
				if (currentQuestion == null)
					break;
				else {
					
					boolean isInvalid;
					
					System.out.println(currentQuestion.getTextPrompt());
					
					if (currentQuestion instanceof MultipleChoiceQuestion) {
						for (Answer currentAnswer: currentQuestion.getPossibleAnswers()) {
							System.out.println(currentAnswer);
						}
					}
					
					do {
						isInvalid = false;
						try
						{
							Answer answer = currentQuestion.convertResponseToAnswer(scan.nextLine());
							if (answer.isSameAs(currentQuestion.getCorrectAnswer()))
								correctAnswers++;
							else {
								
								incorrectQuestions[j] = currentQuestion;
								j++;
								
							}
								
						}
						catch (InvalidResponseException e)
						{
							
							isInvalid=true;
							System.out.println("Response invalid. Please try again");
						
						}
					} while (isInvalid == true);
				}
					
						
				}
			
			scan.close();
			
		}
	
		
		
		if (i > 0)
			return (double) correctAnswers / i;
		else
			return 0;
		
	}
	
	public void printIncorrectAnswers() throws NoCorrectAnswerException {
		
		if (incorrectQuestions[0] != null) {
			
			System.out.println("Incorrect answers: ");
			System.out.println();
		
			for (Question currentQuestion : incorrectQuestions) {
				if (currentQuestion == null )
					break;
				else {
					System.out.println(currentQuestion.getTextPrompt());
					System.out.println("Correct Answer: " + currentQuestion.getCorrectAnswer());
					System.out.println();
				}
			}
		} else
			System.out.println("No incorrect answers!");
		
	}

}
 