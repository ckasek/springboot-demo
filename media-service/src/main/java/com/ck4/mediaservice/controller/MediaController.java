package com.ck4.mediaservice.controller;

import com.ck4.mediaservice.entities.Media;
import com.ck4.mediaservice.service.MediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
public class MediaController {

    private final static Logger log = LoggerFactory.getLogger(MediaController.class);

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping("/media")
    public Media addMedia(@RequestBody @NonNull Media media) {
        return mediaService.saveMedia(media);
    }

    @PutMapping("/media")
    public Media updateMedia(@RequestBody @NonNull Media media) {
        return mediaService.updateMedia(media);
    }

    @GetMapping("/media/{id}")
    public Media getMedia(@PathVariable Long id) {
        return mediaService.findById(id);
    }

}