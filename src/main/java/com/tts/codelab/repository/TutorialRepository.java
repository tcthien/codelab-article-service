package com.tts.codelab.repository;

import com.tts.codelab.domain.Category;
import com.tts.codelab.domain.Tutorial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends CrudRepository<Tutorial, String> {

    List<Tutorial> findByTitle(String title);

    List<Tutorial> findByCategory(Category category);

    Tutorial findOneByTitle(String title);

    Tutorial findOneByAlias(String alias);

}
