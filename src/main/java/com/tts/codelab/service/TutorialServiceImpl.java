package com.tts.codelab.service;

import java.util.List;

import com.tts.codelab.domain.TutorialStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tts.codelab.domain.Category;
import com.tts.codelab.domain.Tutorial;
import com.tts.codelab.repository.TutorialRepository;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    private TutorialRepository repo;

    @Override
    public Tutorial createTutorial(String author, Tutorial tutorial) {
        Tutorial tmp = repo.findOneByIdOrAllias(tutorial.getId(), tutorial.getAlias());
        Assert.isNull(tmp, "Tutorial's alias or id already exists: " + tutorial.getAlias() + ", " + tutorial.getId());
        tutorial.setAuthor(author);
        for (int i = 0; i < tutorial.getSteps().size(); i++) {
            tutorial.getSteps().get(i).setStepId(i);
        }
        repo.save(tmp);
        return tmp;
    }

    @Override
    public Tutorial updateTutorial(String author, Tutorial tutorial) {
        Tutorial db = repo.findOne(tutorial.getId());
        Assert.notNull(db, "Tutorial doesn't exist: " + tutorial.getId());
        db.setTitle(tutorial.getTitle());
        db.setAlias(tutorial.getAlias());
        db.setCategory(tutorial.getCategory());
        db.setSteps(tutorial.getSteps());
        repo.save(db);
        return db;
    }

    @Override
    public void deleteById(String author, Integer id) {
        repo.delete(id);
    }

    @Override
    public List<Tutorial> findByCategory(Category category) {
        return repo.findByCategory(category);
    }

    @Override
    public Tutorial findByTitle(String title) {
        return repo.findOneByTitle(title);
    }

    @Override
    public Tutorial findById(Integer id) {
        return repo.findOne(id);
    }

    @Override
    public Tutorial findByAlias(String alias) {
        return repo.findOneByAlias(alias);
    }

    @Override
    public TutorialStep findTutorialStep(Integer tutorialId, Integer stepId) {
        Tutorial tutorial = findById(tutorialId);
        return tutorial.getSteps().get(stepId);
    }

    @Override
    public TutorialStep updateTutorialStep(Integer tutorialId, Integer stepId, TutorialStep step) {
        Tutorial tutorial = findById(tutorialId);
        step.setStepId(stepId);
        tutorial.getSteps().set(stepId, step);
        return step;
    }
}
