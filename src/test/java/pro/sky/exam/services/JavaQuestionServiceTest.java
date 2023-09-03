package pro.sky.exam.services;

import org.junit.jupiter.api.Test;
import pro.sky.exam.exceptions.DuplicatedArgumentException;
import pro.sky.exam.exceptions.WrongArgumentException;
import pro.sky.exam.others.Question;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.exam.services.JavaQuestionTestConstants.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();
    @Test
    void add() {
        Question question = javaQuestionService.add(FIRST_QUESTION, FIRST_ANSWER);
        assertThrows(DuplicatedArgumentException.class,
                () -> javaQuestionService.add(newQuestionAdd1));
        assertThrows(DuplicatedArgumentException.class,
                () -> javaQuestionService.add(FIRST_QUESTION, FIFTH_QUESTION));
        Question question2 = javaQuestionService.add(newQuestionAdd5);

        assertEquals(question, newQuestionAdd1);
        assertEquals(question2, newQuestionAdd5);
    }

    @Test
    void remove() {
        Question question3 = javaQuestionService.add(newQuestionAdd3);
        Question question4 = javaQuestionService.remove(newQuestionAdd3);
        assertThrows(WrongArgumentException.class,
                () -> javaQuestionService.remove(newQuestionAdd3));

        assertEquals(question4, question3);

    }

    @Test
    void getAll() {
        Question question1 = javaQuestionService.add(newQuestionAdd2);
        Question question2 = javaQuestionService.add(newQuestionAdd3);
        Question question3 = javaQuestionService.add(newQuestionAdd5);
        assertIterableEquals(List.of(question1, question3, question2), javaQuestionService.getAll());
    }

    @Test
    void getRandomQuestion() {
        Question question1 = javaQuestionService.add(newQuestionAdd2);
        Question question2 = javaQuestionService.add(newQuestionAdd4);
        Question question3 = javaQuestionService.getRandomQuestion();
        assertTrue(question2.equals(question3) || question1.equals(question3));
    }
}