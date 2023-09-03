package pro.sky.exam.services;

import org.springframework.stereotype.Service;
import pro.sky.exam.exceptions.QuestionNumberIllegalArgumentException;
import pro.sky.exam.others.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        List<Question> questions = new ArrayList<>();
        System.out.println(2);
        if (questionService.getAll().size() < amount) {
            throw new QuestionNumberIllegalArgumentException();
        }
        for (int i = 0; i < amount; i++) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
