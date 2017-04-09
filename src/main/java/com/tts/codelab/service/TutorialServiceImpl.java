package com.tts.codelab.service;

import com.tts.codelab.domain.Category;
import com.tts.codelab.domain.Tutorial;
import com.tts.codelab.domain.TutorialStep;
import com.tts.codelab.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    private TutorialRepository repo;

    @Override
    public Tutorial createTutorial(String author, Tutorial tutorial) {
        Tutorial tmp = repo.findOneByAlias(tutorial.getAlias());
        Assert.isNull(tmp, "Tutorial's alias already exists: " + tutorial.getAlias());
        tutorial.setAuthor(author);
        for (int i = 0; i < tutorial.getSteps().size(); i++) {
            tutorial.getSteps().get(i).setStepId(i);
        }
        repo.save(tutorial);
        return tutorial;
    }

    @Override
    public Tutorial updateTutorial(String author, Tutorial tutorial) {
        Tutorial db = repo.findOneByAlias(tutorial.getAlias());
        Assert.notNull(db, "Tutorial doesn't exist: " + tutorial.getAlias());
        db.setTitle(tutorial.getTitle());
        db.setAlias(tutorial.getAlias());
        db.setCategory(tutorial.getCategory());
        db.setSteps(tutorial.getSteps());
        repo.save(db);
        return db;
    }

    @Override
    public void deleteByAlias(String author, String alias) {
        repo.delete(alias);
    }

    @Override
    public List<Tutorial> findByCategory(Category category) {
        return repo.findByCategory(category);
    }

    @Override
    public List<Tutorial> findAll() {
        return iterableToList(repo.findAll());
    }

    private List<Tutorial> iterableToList(Iterable<Tutorial> iter) {
        List<Tutorial> lst = new ArrayList<>();
        iter.forEach(tutorial -> {
            lst.add(tutorial);
        });
        return lst;
    }

    @Override
    public Tutorial findByTitle(String title) {
        return repo.findOneByTitle(title);
    }

    @Override
    public Tutorial findByAlias(String alias) {
        return repo.findOneByAlias(alias);
    }

    @Override
    public TutorialStep findTutorialStep(String tutorialAlias, Integer stepId) {
        Tutorial tutorial = findByAlias(tutorialAlias);
        return tutorial.getSteps().get(stepId);
    }

    @Override
    public TutorialStep updateTutorialStep(String tutorialAlias, Integer stepId, TutorialStep step) {
        Tutorial tutorial = findByAlias(tutorialAlias);
        step.setStepId(stepId);
        tutorial.getSteps().set(stepId, step);
        repo.save(tutorial);
        return step;
    }
}
