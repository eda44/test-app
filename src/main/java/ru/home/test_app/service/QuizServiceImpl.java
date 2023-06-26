package ru.home.test_app.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.home.test_app.config.QuizProps;
import ru.home.test_app.dao.QuestionReader;
import ru.home.test_app.model.Person;
import ru.home.test_app.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

@Service
public class QuizServiceImpl implements QuizService{

    private final QuestionReader questionReader;
    private final MessageSource messageSource;
    private final Locale locale;
    private final int successResult;
    public QuizServiceImpl(QuestionReader questionReader, QuizProps quizProps, MessageSource messageSource) {
        this.questionReader = questionReader;
        this.locale = quizProps.getLocale();
        this.successResult=quizProps.getSuccessResult();
        this.messageSource = messageSource;
    }

    @Override
    public int makeQuiz() throws IOException {
        List<Question> questionList = questionReader.readQuestions();
        int counter = 0;
        for (Question question : questionList) {
            System.out.println(question.getId() + " " + question.getText());
            question.getAllOptions().forEach(System.out::println);
            System.out.print(messageSource.getMessage("yourAnswer", null, locale));
            String ans = new BufferedReader(new InputStreamReader(System.in)).readLine();
            if (ans.equals(question.getRightAnswer()))
                counter++;
        }
        return counter;
    }

    @Override
    public boolean getResult(int count) {
        return successResult <= count;
    }

    @Override
    public Person askName() throws IOException {
        var person = new Person();
        System.out.println(messageSource.getMessage("greeting", null, locale));
        System.out.print(messageSource.getMessage("askName", null, locale));
        person.setName(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.print(messageSource.getMessage("askLastname", null, locale));
        person.setLastname(new BufferedReader(new InputStreamReader(System.in)).readLine());
        return person;
    }
}
