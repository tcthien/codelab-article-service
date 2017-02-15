package com.tts.codelab.service;

import java.util.List;

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
    public Tutorial createTutorial(Tutorial tutorial) {
        Tutorial tmp = repo.findOneByIdOrAllias(tutorial.getId(), tutorial.getAlias());
        Assert.isNull(tmp, "Tutorial's alias or id already exists: " + tutorial.getAlias() + ", " + tutorial.getId());
        repo.save(tmp);
        return tmp;
    }

    @Override
    public Tutorial updateTutorial(Tutorial tutorial) {
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
    public List<Tutorial> findByCategory(Category category) {
        return repo.findByCategory(category);
    }

    @Override
    public Tutorial findByTitle(String title) {
        return repo.findOneByTitle(title);
    }
}
