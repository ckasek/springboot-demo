package com.ck4.mediaservice.controller;

import com.ck4.mediaservice.entities.Inventory;
import com.ck4.mediaservice.entities.Media;
import com.ck4.mediaservice.exception.EntityNotFoundException;
import com.ck4.mediaservice.controller.model.AddMediaBody;
import com.ck4.mediaservice.service.InventoryService;
import com.ck4.mediaservice.service.MediaService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/media")
public class MediaController {

    private final static Logger log = LoggerFactory.getLogger(MediaController.class);

    private final MediaService mediaService;
    private final InventoryService inventoryService;

    @PostMapping()
    public Media addMedia(@RequestBody @NonNull AddMediaBody addMediaBody) {
        try {
            return mediaService.addMedia(addMediaBody.getMediaTypeId(), addMediaBody.getTitleId(), addMediaBody.getReleaseDate());
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public Media updateMedia(@RequestBody @NonNull Media media) {
        return mediaService.updateMedia(media);
    }

    @GetMapping("/{id}")
    public Media getMedia(@PathVariable Long id) {
        return mediaService.findById(id);
    }
    @GetMapping("/{id}/inventory")
    public List<Inventory> getMediaInventory(@PathVariable Long id) {
        return inventoryService.findByMediaId(id);
    }

}