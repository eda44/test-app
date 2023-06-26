package ru.home.test_app.dao;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.home.test_app.config.QuizProps;
import ru.home.test_app.model.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class QuestionReaderCSVFileTest {

    Question question = new Question();
    QuestionReader questionReader;
    @Mock
    QuizProps quizProps;
    @BeforeAll
    void init() {
        question.setId(1);
        question.setText("Who is taller?");
        question.setOption1("a. Elephant");
        question.setOption2("b. Giraffe");
        question.setOption3("c. Koala");
        question.setRightAnswer("b");
    }

    @BeforeEach
    void setNewQuestionReaderCSVFile() {
        when(quizProps.getPath()).thenReturn("/question_list_en.csv");
        questionReader = new QuestionReaderCSVFile(quizProps);
    }

    @Test
    void shouldReturnQuestion() {
        List<Question> questions = questionReader.readQuestions();

        assertThat(questions).hasSize(5);
    }

}
