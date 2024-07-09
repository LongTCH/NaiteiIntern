package bai5.Practice2;

interface Question {
    void displayQuestion();
}

abstract class AbstractQuestion implements Question {
    String questionText;
    public AbstractQuestion(String questionText) {
        this.questionText = questionText;
    }
    @Override
    public void displayQuestion() {
        System.out.println(questionText);
    }
}

class YesNoQuestion extends AbstractQuestion {
    public YesNoQuestion(String questionText) {
        super(questionText);
    }
    @Override
    public void displayQuestion() {
        super.displayQuestion();
        System.out.println("1. Yes\n2. No");
    }
}

class ChoiceQuestion extends AbstractQuestion {
    String[] choices;
    public ChoiceQuestion(String questionText, String[] choices) {
        super(questionText);
        this.choices = choices;
    }
    @Override
    public void displayQuestion() {
        super.displayQuestion();
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }
    }
}

class CheckCorrect {
    public void checkAnswer(Question question, int answer) {
        if (question instanceof YesNoQuestion) {
            System.out.println("Checking Yes/No question answer...");
        } else if (question instanceof ChoiceQuestion) {
            System.out.println("Checking Choice question answer...");
        }
    }
}

// Main class to test the questions
public class Main {
    public static void main(String[] args) {
        Question yesNoQuestion = new YesNoQuestion("Is Java an object-oriented programming language?");
        Question choiceQuestion = new ChoiceQuestion("What is the capital of France?", new String[]{"Paris", "Berlin", "Madrid"});

        CheckCorrect checker = new CheckCorrect();

        yesNoQuestion.displayQuestion();
        checker.checkAnswer(yesNoQuestion, 1);

        System.out.println();

        choiceQuestion.displayQuestion();
        checker.checkAnswer(choiceQuestion, 1);
    }
}

