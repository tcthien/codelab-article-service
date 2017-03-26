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

    Tutorial findById(Integer id);

    Tutorial findByAlias(String alias);

    void deleteById(String author, Integer id);

    TutorialStep findTutorialStep(Integer tutorialId, Integer stepId);

    TutorialStep updateTutorialStep(Integer tutorialId, Integer stepId, TutorialStep step);
}
