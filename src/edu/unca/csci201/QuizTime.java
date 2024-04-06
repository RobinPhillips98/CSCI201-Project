package edu.unca.csci201;

public class QuizTime {

	public static void main(String[] args) throws QuizBaseException {
		
		Quiz quiz = new Quiz();
		
		quiz.addQuestion(null);
		quiz.addQuestion(null);
		quiz.addQuestion(null);
		quiz.addQuestion(null);
		quiz.addQuestion(null);
		quiz.addQuestion(null);
		quiz.addQuestion(null);
		quiz.addQuestion(null);
		quiz.addQuestion(null);

		System.out.println("                  <PLACEHOLDER> QUIZ                      \n");
		
		System.out.println("        INSTRUCTIONS        ");
		System.out.println("For multiple choice questions: enter only the letter 'A', 'B', 'C', or 'D'");
		System.out.println("For true or false questions: enter 't' or 'f'");
		System.out.println("For fill-in-the blank questions: enter only the word that fills in the blank, no spaces");
		System.out.println();
		
		System.out.println("Loading quiz...");
		System.out.println("Loading quiz...");
		System.out.println("Loading quiz...");
		System.out.println("QUIZ STARTING NOW... \n");
		
		double score = quiz.giveQuiz();
		
		System.out.println("QUIZ COMPLETE!");
		
		System.out.println("Your score is: " + score + "%!");
		
	}

}
