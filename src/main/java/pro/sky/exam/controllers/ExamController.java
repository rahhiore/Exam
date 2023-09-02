package pro.sky.exam.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exam.others.Question;
import pro.sky.exam.services.ExaminerService;
import pro.sky.exam.services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }
    @GetMapping
    public Collection<Question> getQuestions(@RequestParam("amount") int amount) {
        return service.getQuestion(amount);
    }
}
