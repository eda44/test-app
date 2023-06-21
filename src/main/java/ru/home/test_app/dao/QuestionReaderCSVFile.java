package ru.home.test_app.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.home.test_app.config.QuizProps;
import ru.home.test_app.model.Question;

import java.io.*;
import java.util.*;

@PropertySource("application.yml")
@Component
public class QuestionReaderCSVFile implements QuestionReader{
    private final String path;

    public QuestionReaderCSVFile(QuizProps quizProps) {
        this.path = quizProps.getPath();
    }

    @Override
    public List<Question> readQuestion() {
        Optional<InputStream> streamQuestions = Optional.ofNullable(getClass().getResourceAsStream(path));
        if (streamQuestions.isPresent()) {
            try(CSVReader reader = new CSVReader(new InputStreamReader(streamQuestions.get()))) {
                return reader.readAll().stream()
                        .map(q -> new Question(Integer.valueOf(q[0]), q[1], List.of(q[2], q[3], q[4]), q[5]))
                        .toList();
            }catch (IOException | CsvException e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }
}
