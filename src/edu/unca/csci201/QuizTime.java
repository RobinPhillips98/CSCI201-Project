package edu.unca.csci201;

public class QuizTime {

	public static void main(String[] args) throws QuizBaseException, InterruptedException {
		
		Quiz quiz = new Quiz();
		

		System.out.println("                  ULTIMATE STAR WARS QUIZ                      \n");
		
		System.out.println("        INSTRUCTIONS        ");
		System.out.println("For multiple choice questions: type only the letter 'A', 'B', 'C', or 'D'");
		System.out.println("For true or false questions: type only 'T' or 'F'");
		System.out.println("For fill-in-the blank questions: type your answer");
		System.out.println();
		
		//"Improved" user experience
		System.out.println("Loading quiz...");
		Thread.sleep(1000);
		System.out.println("Loading quiz...");
		Thread.sleep(1000);
		System.out.println("Loading quiz...");
		Thread.sleep(1000);
		
		quiz.addQuestion(new TrueFalseQuestion("True or False: Darth Vader is Luke Skywalker's father", true));
		quiz.addQuestion(new FillInTheBlankQuestion("What is Mando's real name from The Mandalorian?", "Din Djarin"));
		quiz.addQuestion(new MultipleChoiceQuestion("What is the name of Han Solo's Ship?\nA. Ebon Hawk\nB. Millenium Falcon\nC. Serenity\nD.Executor", 'B'));
		quiz.addQuestion(new FillInTheBlankQuestion("Han Solo was frozen in what?", "Carbonite"));
		quiz.addQuestion(new TrueFalseQuestion("True or False: Boba Fett survived the Sarlacc pit", true));
		quiz.addQuestion(new MultipleChoiceQuestion("Who created Star Wars?\nA. George Lucas\nB. Steven Spielberg\nC. Denis Villeneuve\nD. Robert Jordan", 'A'));
		quiz.addQuestion(new FillInTheBlankQuestion("Which character said, \"Help me Obi-Wan Kenobi. You are my only hope\"?", "Leia"));
		quiz.addQuestion(new MultipleChoiceQuestion("What is Darth Sidious's real name?\nA. Quintus Palpatine\nB. Valkorion\nC. Anakin Skywalker\nD. Sheev Palpatine", 'D'));
		quiz.addQuestion(new TrueFalseQuestion("True or false: The Death Star II was destroyed over Yavin IV by Luke Skywalker", false));
		quiz.addQuestion(new MultipleChoiceQuestion("Padme Amidala was queen of what planet?\nA. Korriban\nB. Naboo\nC. Aldeeran\nD. Coruscant", 'B'));
		
		System.out.println("QUIZ STARTING NOW... \n");
		Thread.sleep(500);
		
		
		double score = quiz.giveQuiz();
		
		System.out.println("\n\nQUIZ COMPLETE!\n");
		
		System.out.println("Your score is: " + score + "%!");
		
	}

}
