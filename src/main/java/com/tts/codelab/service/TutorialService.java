package com.tts.codelab.service;

import com.tts.codelab.domain.Category;
import com.tts.codelab.domain.Tutorial;
import com.tts.codelab.domain.TutorialStep;

import java.util.List;

public interface TutorialService {

    Tutorial createTutorial(String author, Tutorial tutorial);
    
    Tutorial updateTutorial(String author, Tutorial tutorial);
    
    List<Tutorial> findByCategory(Category category);
    
    Tutorial findByTitle(String title);

    Tutorial findByAlias(String alias);

    void deleteByAlias(String author, String alias);

    TutorialStep findTutorialStep(String tutorialAlias, Integer stepId);

    TutorialStep updateTutorialStep(String tutorialAlias, Integer stepId, TutorialStep step);

    List<Tutorial> findAll();
}
