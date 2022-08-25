package com.ck4.mediaservice.service;

import com.ck4.mediaservice.entities.Media;
import com.ck4.mediaservice.exception.EntityNotFoundException;
import com.ck4.mediaservice.repository.MediaRepository;
import com.ck4.mediaservice.utils.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MediaService {

    private final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public Media updateMedia(Media media) {
        Media m = mediaRepository.findById(media.getId()).orElseThrow();
        BeanUtils.copyProperties(media, m, ObjectUtils.getNullPropertyNames(media));
        return m;
    }

    public Media saveMedia(Media media) {
        return mediaRepository.save(media);
    }

    public Media findById(Long id) {
            return mediaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
}