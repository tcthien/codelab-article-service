package com.tts.codelab.service;

import java.util.List;

import com.tts.codelab.domain.Category;
import com.tts.codelab.domain.Tutorial;

public interface TutorialService {

    Tutorial createTutorial(String author, Tutorial tutorial);
    
    Tutorial updateTutorial(String author, Tutorial tutorial);
    
    List<Tutorial> findByCategory(Category category);
    
    Tutorial findByTitle(String title);

    Tutorial findById(Integer id);

    Tutorial findByAlias(String alias);

    void deleteById(String author, Integer id);
}
