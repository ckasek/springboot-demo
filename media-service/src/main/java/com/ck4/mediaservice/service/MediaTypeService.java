package com.ck4.mediaservice.service;

import com.ck4.mediaservice.entities.MediaType;
import com.ck4.mediaservice.exception.EntityNotFoundException;
import com.ck4.mediaservice.repository.MediaTypeRepository;
import com.ck4.mediaservice.utils.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MediaTypeService {

    private final MediaTypeRepository mediaTypeRepository;

    public MediaTypeService(MediaTypeRepository mediaTypeRepository) {
        this.mediaTypeRepository = mediaTypeRepository;
    }

    public MediaType updateMediaType(MediaType mediaType) {
        MediaType m = mediaTypeRepository.findById(mediaType.getId()).orElseThrow();
        BeanUtils.copyProperties(mediaType, m, ObjectUtils.getNullPropertyNames(mediaType));
        return m;
    }

    public MediaType saveMediaType(MediaType mediaType) {
        return mediaTypeRepository.save(mediaType);
    }

    public MediaType findById(Long id) {
            return mediaTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
}