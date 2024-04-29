Requirements for this project, given by Dr. Kenneth Bogert, were as follows:

The point of this project is to create a quiz system using Test Driven Development.  Clone and import the QuizTime repository to your machine.  To get you started, I've included a few JUnit test cases in the repository.  This assignment is NOT subject to peer review, revisions, or feedback and it will not receive any issues (other than the development one).
	1. Create 3 classes that implement Question:
		1. MultipleChoiceQuestion
		2. TrueFalseQuestion
		3. FillInTheBlankQuestion
	2. Create 3 classes that implement Answer, each one corresponds to one Question type above:
		1. MultipleChoiceAnswer	
		2. TrueFalseAnswer
		3. SingleWordAnswer
	3. Following good test driven development, create test cases for the above classes and begin implementing them.  See the comments in the interfaces for help on how these objects should behave.
	4. Create a class called Quiz.  This class manages up to 25 Question objects
	5. Define two methods in Quiz:
		1. public void addQuestion(Question q) - This accepts a question object and adds it to it's list of questions
		2. public double giveQuiz() - This presents each question, one by one, to the user and asks for their answer.  After each answer, it checks if the answer is correct and keeps track of the results.  Finally, it returns the score the user got.  It should handle the exceptions thrown by the questions in a way that lets the quiz complete correctly.
		3. For help, see the QuizTest JUnit class.  When your implementation is correct these test cases should pass.
		4. BIG IMPLEMENTATION NOTE: The unit test will only work if you do NOT have create a Scanner object as an instance variable of the Quiz class.  You should instead use only local variable Scanner's as you need them.
	6. Again, each question class MUST implement the Question interface, and answers the Answer interface.  Implement these methods appropriately for the question type.  DO NOT MODIFY THE INTERFACES IN ANY WAY.
	7. Create a new class called QuizTime, which only has a main() method.
		1. In this method, create all of your Question objects (at least 10, no more than 25) and a single Quiz object.
		2. Add all of your questions to the quiz, then call giveQuiz() and print out the results to the user.
	8. Follow ALL of our rules of encapsulation and proper project design
	9.For extra credit, after the quiz is over go through each of the wrongly answered questions and printout the question followed by the correct answer.
	10. For more extra credit, implement a ShortAnswerQuestion which does not have a correct answer.  It should throw the appropriate exception when asked for the correct answer, and when Quiz receives this exception it should inform the user that this question will be graded later and not count this question towards the grade.
