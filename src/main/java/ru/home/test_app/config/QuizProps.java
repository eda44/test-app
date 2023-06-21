package ru.home.test_app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties("quiz")
@ConfigurationPropertiesScan
public class QuizProps {
    private String path;
    private Integer successResult;

    public String getPath() {
        return path;
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
}
