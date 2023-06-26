package ru.home.test_app.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.home.test_app.config.QuizProps;
import ru.home.test_app.model.Question;

import java.io.*;
import java.util.*;

@PropertySource("application.properties")
@Component
public class QuestionReaderCSVFile implements QuestionReader{
    private final String path;

    public QuestionReaderCSVFile(QuizProps quizProps) {
        this.path = quizProps.getPath();
    }

    @Override
    public List<Question> readQuestions() {
        Optional<InputStream> streamQuestions = getQuestionsStream();
        if (streamQuestions.isPresent()) {
            try(Reader reader = new BufferedReader(new InputStreamReader(streamQuestions.get()))) {
                return new CsvToBeanBuilder<Question>(reader)
                        .withSeparator('|')
                        .withType(Question.class)
                        .withIgnoreEmptyLine(true)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build()
                        .parse();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    private Optional<InputStream> getQuestionsStream() {
        return Optional.ofNullable(getClass().getResourceAsStream(path));
    }
}
