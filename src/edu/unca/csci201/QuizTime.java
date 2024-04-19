package edu.unca.csci201;

public class QuizTime {
	
	//------------------------------------------------------------------------------------------
	// Presents a quiz to the user, records their answers, and prints their score.
	//-----------------------------------------------------------------------------------------

	public static void main(String[] args) throws QuizBaseException, InterruptedException {
		
		Quiz quiz = new Quiz();

		System.out.println("                  ULTIMATE STAR WARS QUIZ                      \n");
		
		System.out.println("        INSTRUCTIONS        ");
		System.out.println("For each question: Type in your answer with the keyboard then press enter.");
		System.out.println("For multiple choice questions: type only the letter 'A', 'B', 'C', or 'D'.");
		System.out.println("For true or false questions: type true or t for true, or false or f for false.");
		System.out.println("For fill-in-the blank questions: type your answer.");
		System.out.println("The quiz is not case-sensitive.");
		System.out.println();
		
		//"Improved" user experience
		System.out.println("Loading quiz...");
		Thread.sleep(1000);
		System.out.println("Loading quiz...");
		Thread.sleep(1000);
		System.out.println("Loading quiz...");
		Thread.sleep(1000);
		System.out.println();
		
		
		quiz.addQuestion(new TrueFalseQuestion("True or False: Darth Vader is Luke Skywalker's father", true));
		quiz.addQuestion(new FillInTheBlankQuestion("Mando's real name from The Mandalorian is ___ Djarin", "Din"));
		quiz.addQuestion(new MultipleChoiceQuestion("What is the name of Han Solo's Ship?\nA. Ebon Hawk\nB. Millenium Falcon\nC. Serenity\nD. Executor", 'B'));
		quiz.addQuestion(new FillInTheBlankQuestion("Han Solo was frozen in _________", "Carbonite"));
		quiz.addQuestion(new TrueFalseQuestion("True or False: Boba Fett survived the Sarlacc pit", true));
		quiz.addQuestion(new MultipleChoiceQuestion("Who created Star Wars?\nA. George Lucas\nB. Steven Spielberg\nC. Denis Villeneuve\nD. Robert Jordan", 'A'));
		quiz.addQuestion(new FillInTheBlankQuestion("\"Help me Obi-Wan Kenobi. You are my only hope\" was said by Princess ____", "Leia"));
		quiz.addQuestion(new MultipleChoiceQuestion("What is Darth Sidious's real name?\nA. Quintus Palpatine\nB. Valkorion\nC. Anakin Skywalker\nD. Sheev Palpatine", 'D'));
		quiz.addQuestion(new TrueFalseQuestion("True or false: The Death Star II was destroyed over Yavin IV by Luke Skywalker", false));
		quiz.addQuestion(new MultipleChoiceQuestion("Padme Amidala was queen of what planet?\nA. Korriban\nB. Naboo\nC. Aldeeran\nD. Coruscant", 'B'));
		
		System.out.println("QUIZ STARTING NOW... \n");
		Thread.sleep(500);
		
		
		double score = quiz.giveQuiz();
		
		System.out.println("\n\nQUIZ COMPLETE!\n");
		
		System.out.println("Grading quiz...");
		Thread.sleep(1000);
		System.out.println("Grading quiz...");
		Thread.sleep(1000);
		System.out.println("Grading quiz...");
		Thread.sleep(1000);
		System.out.println();
		
		
		final double TOLERANCE = 0.01;
		
		if (Math.abs(score - 100) <= TOLERANCE)
			System.out.println("You got a perfect score! Great job!");
		else {
			
			System.out.println("Your score is " + score + "%!");
			System.out.println();
			quiz.printIncorrectAnswers();
			
		}
		
		System.out.println("May the force be with you.");
		
	}

}