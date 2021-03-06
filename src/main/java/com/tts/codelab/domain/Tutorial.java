package com.tts.codelab.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tutorials")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tutorial {

    private String title;

    @Id
    private String alias;

    private Category category;

    private List<TutorialStep> steps;
    
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<TutorialStep> getSteps() {
        return steps;
    }

    public void setSteps(List<TutorialStep> steps) {
        this.steps = steps;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
