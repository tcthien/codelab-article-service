package com.tts.codelab.controller;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tts.codelab.domain.Tutorial;
import com.tts.codelab.service.TutorialService;

@RestController
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @RequestMapping(path = "/id/{id}", method = RequestMethod.GET)
    public Tutorial findById(@PathVariable Integer id) {
        return tutorialService.findById(id);
    }

    @RequestMapping(path = "/alias/{alias}", method = RequestMethod.GET)
    public Tutorial findByAlias(@PathVariable String alias) {
        return tutorialService.findByAlias(alias);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String createTutorial(@Valid @RequestBody Tutorial tutorial) {
        tutorialService.createTutorial(tutorial);
        return JSONObject.quote("success");
    }
    
    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public Tutorial updateTutorial(@Valid @RequestBody Tutorial tutorial) {
        tutorialService.updateTutorial(tutorial);
        return tutorial;
    }
    
    @RequestMapping(path = "/", method = RequestMethod.DELETE)
    public Integer deleteTutorial(@Valid @RequestBody Tutorial tutorial) {
        tutorialService.deleteById(tutorial.getId());
        return tutorial.getId();
    }
}
