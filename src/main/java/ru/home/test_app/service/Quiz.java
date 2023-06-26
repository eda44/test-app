package ru.home.test_app.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.home.test_app.config.QuizProps;
import ru.home.test_app.model.Person;

import java.io.IOException;
import java.util.Locale;

@Component
public class Quiz {
    private final QuizService quiz;
    private final Locale locale;
    private final MessageSource messageSource;

    public Quiz(QuizService quiz, QuizProps quizProps, MessageSource messageSource) {
        this.quiz = quiz;
        this.locale = quizProps.getLocale();
        this.messageSource = messageSource;
    }

    public void startTest() {
        try {
            Person person = quiz.askName();
            int count = quiz.makeQuiz();
            if (quiz.getResult(count))
                System.out.println(
                        messageSource.getMessage(
                                "successMsg",
                                new String[]{person.getName(), person.getLastname(), String.valueOf(count)},
                                locale));
            else
                System.out.println(
                        messageSource.getMessage(
                                "failMsg",
                                new String[]{person.getName(), person.getLastname(), String.valueOf(count)},
                                locale));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
