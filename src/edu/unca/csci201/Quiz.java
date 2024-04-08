package edu.unca.csci201;

import java.util.Scanner;

public class Quiz {
	
	Question[] quizQuestions = new Question[25];
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
					do {
						isInvalid = false;
						try
						{
							Answer answer = currentQuestion.convertResponseToAnswer(scan.nextLine());
							if (answer.isSameAs(currentQuestion.getCorrectAnswer())) {
								correctAnswers++;
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
			return ((double) correctAnswers / i) * 100;
		else
			return 0;
		
	}

}
 