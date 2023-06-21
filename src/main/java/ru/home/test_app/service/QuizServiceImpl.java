package ru.home.test_app.service;

import org.springframework.stereotype.Service;
import ru.home.test_app.config.QuizProps;
import ru.home.test_app.dao.QuestionReader;
import ru.home.test_app.model.Person;
import ru.home.test_app.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    private final QuestionReader questionReader;
    private final Integer rightAns;

    public QuizServiceImpl(QuestionReader questionReader, QuizProps quizProps) {
        this.questionReader = questionReader;
        this.rightAns = quizProps.getSuccessResult();
    }

    @Override
    public int makeQuiz() throws IOException{
        List<Question> questionList = questionReader.readQuestion();
        int counter = 0;
        for (Question question : questionList) {
            System.out.println(question.id() + " " + question.question());
            question.options().forEach(System.out::println);
            System.out.print("Your answer: ");
            String ans = new BufferedReader(new InputStreamReader(System.in)).readLine();
            if (ans.equals(question.answer()))
                counter++;
        }
        return counter;
    }

    @Override
    public boolean getResult(int count) {
        return rightAns <= count;
    }

    @Override
    public Person askName() throws IOException {
        Person person = new Person();
        System.out.print("Enter your name: ");
        person.setName(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.print("Enter your lastname: ");
        person.setLastname(new BufferedReader(new InputStreamReader(System.in)).readLine());
        return person;
    }
}
