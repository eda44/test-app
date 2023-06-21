package ru.home.test_app.service;

import org.springframework.stereotype.Component;
import ru.home.test_app.model.Person;

import java.io.IOException;

@Component
public class Quiz {
    private final QuizService quiz;

    public Quiz(QuizService quiz) {
        this.quiz = quiz;
    }

    public void startTest() {
        try {
            Person person = quiz.askName();
            int count = quiz.makeQuiz();
            if (quiz.getResult(count))
                System.out.println(person.getName() + " " + person.getLastname() + " has passed the test.\n" +
                        count + " right answers");
            else
                System.out.println(person.getName() + " " + person.getLastname() + " has not passed the test.\n" +
                        count + " right answers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
