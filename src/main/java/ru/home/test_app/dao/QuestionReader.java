package ru.home.test_app.dao;



import ru.home.test_app.model.Question;

import java.util.List;

public interface QuestionReader {
    List<Question> readQuestions();
}
