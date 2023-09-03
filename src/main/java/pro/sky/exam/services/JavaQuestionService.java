package pro.sky.exam.services;

import org.springframework.stereotype.Service;
import pro.sky.exam.exceptions.DuplicatedArgumentException;
import pro.sky.exam.exceptions.WrongArgumentException;
import pro.sky.exam.others.Question;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;

    private final Random random;
    public JavaQuestionService() {
        questions = new HashSet<>();
        this.random = new Random();

    }

    @Override
    public Question add(String question, String answer) {
        Question qest = new Question(question, answer);
        if (question.equals(answer) || checker(qest)) {
            throw new DuplicatedArgumentException();
        }

        questions.add(qest);
        return qest;
    }

    @Override
    public Question add(Question question) {
        if (checker(question)) {
            throw new DuplicatedArgumentException();
        }

        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!checker(question)) {
            throw new WrongArgumentException();
        }

        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        System.out.println(7);
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Question questio = new Question(null, null);
        int i = 0;
        int getRandomNum = random.nextInt(questions.size());
        System.out.println(1);
        for (Question question: questions) {
            System.out.println(i);
            System.out.println(getRandomNum);
            if (i == getRandomNum) {
                return question;
            }
            i++;
        }
        return questio;
    }
    private boolean checker(Question question) {
        for (Question quest: questions) {
            if(quest.getQuestion().equals(question.getQuestion())){
                return true;
            }
        }
        return false;
    }
}
