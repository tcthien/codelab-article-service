package com.tts.codelab.controller;

import com.tts.codelab.domain.TutorialStep;
import com.tts.codelab.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "step")
public class StepController {

    @Autowired
    private TutorialService tutorialService;

    @RequestMapping(path = "/{tutorialId}/{stepId}", method = RequestMethod.GET)
    public TutorialStep findById(@PathVariable Integer tutorialId, @PathVariable Integer stepId) {
        return tutorialService.findTutorialStep(tutorialId, stepId);
    }

    @RequestMapping(path = "/{tutorialId}/{stepId}", method = RequestMethod.PUT)
    public TutorialStep updateTutorialStep(@PathVariable Integer tutorialId, @PathVariable Integer stepId,
                                           @Valid @RequestBody TutorialStep step) {
        return tutorialService.updateTutorialStep(tutorialId, stepId, step);
    }
}
