package pro.sky.exam.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.exam.exceptions.QuestionNumberIllegalArgumentException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.exam.services.JavaQuestionTestConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
//    @Mock
    @Mock
    private QuestionService questionService;
//    @Spy
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestion() {
        when(questionService.getAll()).thenReturn(LIST);
        when(questionService.getRandomQuestion()).thenReturn(newQuestionAdd5);

        assertThrows(QuestionNumberIllegalArgumentException.class, () -> examinerService.getQuestion(5));

        assertEquals(List.of(newQuestionAdd5), examinerService.getQuestion(1));
    }
}

