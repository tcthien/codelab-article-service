package com.tts.codelab.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tts.codelab.domain.Tutorial;
import com.tts.codelab.service.TutorialService;

@RestController
@RequestMapping(path = "tutorial")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @RequestMapping(path = "/{alias}", method = RequestMethod.GET)
    public Tutorial findByAlias(@PathVariable String alias) {
        return tutorialService.findByAlias(alias);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/{alias}", method = RequestMethod.DELETE)
    public String deleteByAlias(Principal principal, @PathVariable String alias) {
        tutorialService.deleteByAlias(principal.getName(), alias);
        return alias;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Tutorial> getAllTutorial() {
        return tutorialService.findAll();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String createTutorial(Principal principal, @Valid @RequestBody Tutorial tutorial) {
        tutorialService.createTutorial(principal.getName(), tutorial);
        return JSONObject.quote("success");
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public Tutorial updateTutorial(Principal principal, @Valid @RequestBody Tutorial tutorial) {
        tutorialService.updateTutorial(principal.getName(), tutorial);
        return tutorial;
    }

}
