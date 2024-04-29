package edu.unca.csci201;

import java.text.NumberFormat;

public class QuizTime {

	//----------------------------------------------------------------------------
	// Presents a quiz to the user, records their answers, and prints their score.
	//----------------------------------------------------------------------------

	public static void main(String[] args) throws QuizBaseException, InterruptedException {

		Quiz quiz = new Quiz();
		
		//This ASCII art can be found at https://asciiart.website/index.php?art=movies/star%20wars
		System.out.println("      ________________.  ___     .______\n"
				+ "     /                | /   \\    |   _  \\\n"
				+ "    |   (-----|  |----`/  ^  \\   |  |_)  |\n"
				+ "     \\   \\    |  |    /  /_\\  \\  |      /\n"
				+ ".-----)   |   |  |   /  _____  \\ |  |\\  \\-------.\n"
				+ "|________/    |__|  /__/     \\__\\| _| `.________|\n"
				+ " ____    __    ____  ___     .______    ________.\n"
				+ " \\   \\  /  \\  /   / /   \\    |   _  \\  /        |\n"
				+ "  \\   \\/    \\/   / /  ^  \\   |  |_)  ||   (-----`\n"
				+ "   \\            / /  /_\\  \\  |      /  \\   \\\n"
				+ "    \\    /\\    / /  _____  \\ |  |\\  \\---)   |\n"
				+ "     \\__/  \\__/ /__/     \\__\\|__| `._______/\n"
				+ "");

		// Announces quiz to user and gives them instructions.
		System.out.println("                  ULTIMATE STAR WARS QUIZ                      \n");
		System.out.println("        INSTRUCTIONS        ");
		System.out.println("For each question: Type in your answer with the keyboard then press enter.");
		System.out.println("For multiple choice questions: type only the letter 'A', 'B', 'C', or 'D'.");
		System.out.println("For true or false questions: type true or t for true, or false or f for false.");
		System.out.println("For fill-in-the blank and short answer questions: type your answer.");
		System.out.println("The quiz is not case-sensitive.");
		System.out.println();

		// "Improved" user experience
		System.out.println("Loading quiz...");
		Thread.sleep(1000);
		System.out.println("Loading quiz...");
		Thread.sleep(1000);
		System.out.println("Loading quiz...");
		Thread.sleep(1000);
		System.out.println();

		// Adds desired questions to quiz
		quiz.addQuestion(new TrueFalseQuestion("True or False: Darth Vader is Luke Skywalker's"
				+ " father", true));
		quiz.addQuestion(new FillInTheBlankQuestion("Mando's real name from The Mandalorian is "
				+ "___ Djarin", "Din"));
		quiz.addQuestion(new MultipleChoiceQuestion("What is the name of Han Solo's Ship?",
				new MultipleChoiceAnswer('B', "Millenium Falcon"), 
				new MultipleChoiceAnswer('A', "Ebon Hawk"),
				new MultipleChoiceAnswer('B', "Millenium Falcon"),
				new MultipleChoiceAnswer('C', "Serenity"),
				new MultipleChoiceAnswer('D', "Executor")));
		quiz.addQuestion(new FillInTheBlankQuestion("Han Solo was frozen in _________",
				"Carbonite"));
		quiz.addQuestion(new TrueFalseQuestion("True or False: Boba Fett survived the Sarlacc pit",
				true));
		quiz.addQuestion(new MultipleChoiceQuestion("Who created Star Wars?", 
				new MultipleChoiceAnswer('A', "George Lucas"),  
				new MultipleChoiceAnswer('A', "George Lucas"),
				new MultipleChoiceAnswer('B', "Steven Spielberg"),
				new MultipleChoiceAnswer('C', "Denis Villeneuve"),
				new MultipleChoiceAnswer('D', "Robert Jordan")));
		quiz.addQuestion(new FillInTheBlankQuestion("\"Help me Obi-Wan Kenobi. "
				+ "You are my only hope\" was said by Princess ____", "Leia"));
		quiz.addQuestion(new MultipleChoiceQuestion("What is Darth Sidious's real name?", 
				new MultipleChoiceAnswer('D', "Sheev Palpatine"), 
				new MultipleChoiceAnswer('A', "Quintus Palpatine"),
				new MultipleChoiceAnswer('B', "Valkorion"),
				new MultipleChoiceAnswer('C', "Anakin Skywalker"),
				new MultipleChoiceAnswer('D', "Sheev Palpatine")));
		quiz.addQuestion(new TrueFalseQuestion("True or false: The Death Star II was"
				+ " destroyed over Yavin IV by Luke Skywalker", false));
		quiz.addQuestion(new MultipleChoiceQuestion("Padme Amidala was queen of what planet?",
				new MultipleChoiceAnswer('B', "Naboo"),
				new MultipleChoiceAnswer('A', "Korriban"),
				new MultipleChoiceAnswer('B', "Naboo"),
				new MultipleChoiceAnswer('C', "Aldeeran"),
				new MultipleChoiceAnswer('D', "Coruscant")));
		quiz.addQuestion(new ShortAnswerQuestion("Do you believe that Revan was correct in"
				+ " his decision to defy the Jedi High Council and join the "
				+ "Mandalorian Wars? Why or why not?"));

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

		final double TOLERANCE = 0.0001;

		if (Math.abs(score - 1) <= TOLERANCE) {
			System.out.println("You got a perfect score! Great job!");
			System.out.println();
		}
		else {
			NumberFormat fmt = NumberFormat.getPercentInstance();
			System.out.println("Your score is " + fmt.format(score) + "!");
			quiz.printIncorrectAnswers();
			System.out.println();
		}
		System.out.println("May the force be with you.");
	}
}
