package ru.home.test_app.model;

import com.opencsv.bean.CsvBindByPosition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    private Integer id;
    private String text;
    private String option1;
    private String option2;
    private String option3;
    private String rightAnswer;

    public List<String> getAllOptions() {
        return Arrays.asList(option1, option2, option3);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
