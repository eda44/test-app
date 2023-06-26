package ru.home.test_app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.Locale;

@ConfigurationProperties("quiz")
@ConfigurationPropertiesScan
public class QuizProps {
    private String path;
    private Integer successResult;
    private Locale locale;

    public String getPath() {
        return path + "_"+ locale + ".csv";
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSuccessResult() {
        return successResult;
    }

    public void setSuccessResult(String successResult) {
        this.successResult = Integer.parseInt(successResult);
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
