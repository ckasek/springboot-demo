package com.ck4.mediaservice.controller;

import com.ck4.mediaservice.entities.Title;
import com.ck4.mediaservice.service.TitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
public class TitleController {
    private final static Logger log = LoggerFactory.getLogger(TitleController.class);

    private final TitleService titleService;

    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @PostMapping("/title")
    public Title addTitle(@RequestBody @NonNull Title title) {
        return titleService.saveTitle(title);
    }

    @PutMapping("/title")
    public Title updateTitle(@RequestBody @NonNull Title title) {
        return titleService.updateTitle(title);
    }

    @GetMapping("/title/{id}")
    public Title getTitle(@PathVariable Long id) {
        return titleService.findById(id);
    }
}
