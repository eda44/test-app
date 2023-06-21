package ru.home.test_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.home.test_app.config.QuizProps;
import ru.home.test_app.service.Quiz;

@SpringBootApplication
@EnableConfigurationProperties(QuizProps.class)
public class TestAppApplication {
	private static final Logger log = LoggerFactory.getLogger(TestAppApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestAppApplication.class, args);
		Quiz quiz = context.getBean(Quiz.class);
		quiz.startTest();
	}

}