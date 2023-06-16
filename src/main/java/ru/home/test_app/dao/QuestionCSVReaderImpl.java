package ru.home.test_app.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.home.test_app.App;
import ru.home.test_app.model.Question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@PropertySource("application.properties")
@Component
public class QuestionCSVReaderImpl implements QuestionReader{
    private final String path;

    public QuestionCSVReaderImpl(@Value("${pathCSV}") String path) {
        this.path = path;
    }

    @Override
    public List<Question> readQuestion() {
        List<String[]> list = null;

        try(CSVReader reader = new CSVReader(new InputStreamReader(
                        Objects.requireNonNull(App.class.getResourceAsStream(path))))) {
            list = reader.readAll();
        }catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        List<Question> questionList = new ArrayList<>();
        Objects.requireNonNull(list).forEach(q -> {
            Question question = new Question();
            question.setId(Integer.valueOf(q[0]));
            question.setText(q[1]);
            question.setAns(List.of(q[2], q[3], q[4]));
            question.setRightAns(q[5]);
            questionList.add(question);
        });
        return questionList;
    }
}
