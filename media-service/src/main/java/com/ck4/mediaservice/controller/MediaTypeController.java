package com.ck4.mediaservice.controller;

import com.ck4.mediaservice.entities.MediaType;
import com.ck4.mediaservice.service.MediaTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
public class MediaTypeController {

    private final static Logger log = LoggerFactory.getLogger(MediaTypeController.class);

    private final MediaTypeService mediaTypeService;

    public MediaTypeController(MediaTypeService mediaTypeService) {
        this.mediaTypeService = mediaTypeService;
    }

    @PostMapping("/mediaType")
    public MediaType addMediaType(@RequestBody @NonNull MediaType media) {
        return mediaTypeService.saveMediaType(media);
    }

    @PutMapping("/mediaType")
    public MediaType updateMediaType(@RequestBody @NonNull MediaType media) {
        return mediaTypeService.updateMediaType(media);
    }

    @GetMapping("/mediaType/{id}")
    public MediaType getMediaType(@PathVariable Long id) {
        return mediaTypeService.findById(id);
    }

}