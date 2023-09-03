package pro.sky.exam.services;

import pro.sky.exam.others.Question;

import java.util.ArrayList;
import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
