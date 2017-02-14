package com.tts.codelab.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.codelab.domain.Tutorial;

@Repository
public interface TutorialRepository extends CrudRepository<Tutorial, Integer> {

    Tutorial findById(Integer id);
    
    List<Tutorial> findByTitle(String title);

}
