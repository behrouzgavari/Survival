package Survival;

import Survival.questions.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The SurvivalGame class represents a game where players answer to a wide-range of questions from various categories.
 * Players gain points based on correct answers and the game continues until all questions have been answered or the player quits.
 * @author Behrouz Gavari
 * @version 1.0
 */
public class SurvivalGame
{
    private       int            score;
    private       boolean        running;
    private final List<Question> questions;
    private       Question       currentQuestion;

    /**
     * Constructs a new instance of the SurvivalGame class.
     * Initializes the score, running status, and populates the list of questions.
     */
    public SurvivalGame()
    {
        score     = 0;
        running   = true;
        questions = new ArrayList<>();
        initializeQuestions();
    }

    /**
     * Initializes the list of questions with predefined questions from various categories.
     * Categories include Science, History, Art, Technology, and Current News.
     */
    private void initializeQuestions()
    {
        // Science category
        questions.add(new Question("Science",      "What is the chemical symbol for gold?", "Au"));
        questions.add(new Question("Science",      "Who developed the theory of relativity?", "Albert Einstein"));
        questions.add(new Question("Science",      "What is the largest planet in our solar system?", "Jupiter"));
        questions.add(new Question("Science",      "What is the process by which plants convert light energy into chemical energy?", "Photosynthesis"));
        questions.add(new Question("Science",      "What is the unit of electric current?", "Ampere"));
        questions.add(new Question("Science",      "What is the largest organ in the human body?", "Skin"));
        questions.add(new Question("Science",      "What is the chemical formula for water?", "H2O"));
        questions.add(new Question("Science",      "Which gas makes up the majority of the Earth's atmosphere?", "Nitrogen"));
        questions.add(new Question("Science",      "What is the study of fossils called?", "Paleontology"));
        questions.add(new Question("Science",      "What is the formula for the area of a circle?", "πr^2"));

        // History category
        questions.add(new Question("History",      "Who was the first President of the United States?", "George Washington"));
        questions.add(new Question("History",      "In which year did World War II end?", "1945"));
        questions.add(new Question("History",      "What was the name of the ancient Roman currency?", "Denarius"));
        questions.add(new Question("History",      "Which famous speech begins with the phrase 'I have a dream'?", "Martin Luther King Jr.'s 'I Have a Dream' speech"));
        questions.add(new Question("History",      "What is the name of the ship that Charles Darwin sailed on during his scientific voyage?", "HMS Beagle"));
        questions.add(new Question("History",      "Which city hosted the ancient Olympic Games?", "Olympia"));
        questions.add(new Question("History",      "Who painted the Mona Lisa?", "Leonardo da Vinci"));
        questions.add(new Question("History",      "Who wrote the novel Romeo and Juliet?", "William Shakespeare"));
        questions.add(new Question("History",      "Which civilization built the Great Wall of China?", "The Qin Dynasty"));
        questions.add(new Question("History",      "What was the name of the first artificial satellite launched into space?", "Sputnik 1"));

        // Art category
        questions.add(new Question("Art",          "Who painted the famous artwork 'The Starry Night'?", "Vincent van Gogh"));
        questions.add(new Question("Art",          "Which sculptor created the statue of David?", "Michelangelo"));
        questions.add(new Question("Art",          "Who is the author of the novel 'Pride and Prejudice'?", "Jane Austen"));
        questions.add(new Question("Art",          "Which composer is famous for his symphony 'Ode to Joy'?", "Ludwig van Beethoven"));
        questions.add(new Question("Art",          "Which artist is associated with the Pop Art movement?", "Andy Warhol"));
        questions.add(new Question("Art",          "Who is the playwright of the tragedy 'Hamlet'?", "William Shakespeare"));
        questions.add(new Question("Art",          "Which country is renowned for its traditional origami art?", "Japan"));
        questions.add(new Question("Art",          "Who is the author of the famous novel '1984'?", "George Orwell"));
        questions.add(new Question("Art",          "Who composed the famous ballet 'The Nutcracker'?", "Pyotr Ilyich Tchaikovsky"));
        questions.add(new Question("Art",          "Which artist painted the ceiling of the Sistine Chapel?", "Michelangelo"));

        // Technology category
        questions.add(new Question("Technology",   "Who is the CEO of Tesla?", "Elon Musk"));
        questions.add(new Question("Technology",   "Which programming language is known as the 'mother of all languages'?", "C"));
        questions.add(new Question("Technology",   "What does CPU stand for?", "Central Processing Unit"));
        questions.add(new Question("Technology",   "Who co-founded Apple Inc. along with Steve Jobs?", "Steve Wozniak"));
        questions.add(new Question("Technology",   "What is the world's largest social media platform?", "Facebook"));
        questions.add(new Question("Technology",   "What is the full form of HTML?", "Hypertext Markup Language"));
        questions.add(new Question("Technology",   "Which company developed the first commercially successful computer mouse?", "Xerox"));
        questions.add(new Question("Technology",   "Which programming language is commonly used for creating Android applications?", "Java"));
        questions.add(new Question("Technology",   "What does Wi-Fi stand for?", "Wireless Fidelity"));
        questions.add(new Question("Technology",   "Who is credited with inventing the World Wide Web?", "Tim Berners-Lee"));

        // Current News category
        questions.add(new Question("Current News", "Which country recently faced a major environmental disaster due to an oil spill?", "Mauritius"));
        questions.add(new Question("Current News", "Who won the Academy Award for Best Picture in the 2021 from the Academy Award?", "Nomadland"));
        questions.add(new Question("Current News", "Which country hosted the 2022 FIFA World Cup?", "Qatar"));
        questions.add(new Question("Current News", "What is the capital city of Afghanistan?", "Kabul"));
        questions.add(new Question("Current News", "Which country hosted the 2023 Cricket World Cup?", "India"));
        questions.add(new Question("Current News", "Who is the current President of the United States?", "Joe Biden"));
        questions.add(new Question("Current News", "Which country announced the development of a COVID-19 vaccine?", "Russia"));
        questions.add(new Question("Current News", "Which global event was postponed due to the COVID-19 pandemic?", "Tokyo Olympics"));
        questions.add(new Question("Current News", "What is the name of the most recent variant of COVID-19 that was first identified in India?", "Omicron"));
        questions.add(new Question("Current News", "Which country recently faced a significant political protest movement called the 'Black Lives Matter' movement?", "United States"));
    }

    /**
     * Displays the next question to the player.
     */
    public void displayNextQuestion()
    {
        if(!questions.isEmpty())
        {
            Random            random;
            random          = new Random();
            int index       = random.nextInt(questions.size());
            currentQuestion = questions.remove(index);

            System.out.println("Category: " + currentQuestion.getCategory());
            System.out.println(currentQuestion.getQuestion());
        }
        else
        {
            running = false;
        }
    }

    /**
     * Checks the player's answer against the current question.
     * @param answer The player's answer to the current question.
     */
    public void checkAnswer(String answer)
    {
        if(answer.equalsIgnoreCase("quit"))
        {
            running = false;
        }
        else
        {
            if(currentQuestion != null)
            {
                String          correctAnswer;
                correctAnswer = currentQuestion.getAnswer();
                if(answer.equalsIgnoreCase(correctAnswer))
                {
                    score++;
                }
                currentQuestion = null;
            }
        }
    }

    /**
     * Returns the running status of the game.
     * @return true if the game is running, false otherwise.
     */
    public boolean isRunning()
    {
        return running;
    }

    /**
     * Returns the player's current score.
     * @return The player's score.
     */
    public int getScore()
    {
        return score;
    }
}
