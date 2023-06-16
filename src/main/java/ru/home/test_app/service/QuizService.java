package ru.home.test_app.service;

import ru.home.test_app.model.Person;
import java.io.IOException;

public interface QuizService {

    Person askName() throws IOException;

    int makeQuiz() throws IOException;
    boolean getResult(int count);
}
