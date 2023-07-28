package Survival.questions;


/**
 * The Question class represents a question with its category, question text, and answer.
 * @author Behrouz Gavari
 * @version 1.0
 */
public class Question
{
    private final String category;
    private final String question;
    private final String answer;

    /**
     * Constructs a new instance of the Question class with the specified category, question, and answer.
     * @param category The category of the question.
     * @param question The question text.
     * @param answer The correct answer to the question.
     */
    public Question(final String category,
                    final String question,
                    final String answer)
    {
        this.category = category;
        this.question = question;
        this.answer   = answer;
    }

    /**
     * Gets the category of the question.
     * @return The category of the question.
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * Gets the question text.
     * @return The question text.
     */
    public String getQuestion()
    {
        return question;
    }

    /**
     * Gets the correct answer to the question.
     * @return The correct answer to the question.
     */
    public String getAnswer()
    {
        return answer;
    }
}
