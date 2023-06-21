package ru.home.test_app.model;

import java.util.List;

public record Question(Integer id,
                       String question,
                       List<String> options,
                       String answer) {
}
