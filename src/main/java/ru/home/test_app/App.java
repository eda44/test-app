package ru.home.test_app;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.home.test_app.model.Person;
import ru.home.test_app.service.QuizService;
import ru.home.test_app.service.QuizServiceImpl;

import java.io.IOException;

@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        QuizService quiz = context.getBean("quizServiceImpl", QuizServiceImpl.class);
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
