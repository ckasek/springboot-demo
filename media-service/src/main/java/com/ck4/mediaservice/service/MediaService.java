package com.ck4.mediaservice.service;

import com.ck4.mediaservice.entities.Media;
import com.ck4.mediaservice.entities.MediaType;
import com.ck4.mediaservice.entities.Title;
import com.ck4.mediaservice.exception.EntityNotFoundException;
import com.ck4.mediaservice.repository.MediaRepository;
import com.ck4.mediaservice.repository.MediaTypeRepository;
import com.ck4.mediaservice.repository.TitleRepository;
import com.ck4.mediaservice.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class MediaService {

    private final MediaRepository mediaRepository;
    private final MediaTypeRepository mediaTypeRepository;
    private final TitleRepository titleRepository;

    public Media updateMedia(Media media) {
        Media m = mediaRepository.findById(media.getId()).orElseThrow();
        BeanUtils.copyProperties(media, m, ObjectUtils.getNullPropertyNames(media));
        return m;
    }

    public Media findById(Long id) {
            return mediaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public Media addMedia(long mediaTypeId, long titleId, LocalDate releaseDate) {
        if (!mediaTypeRepository.existsById(mediaTypeId)) {
            throw new EntityNotFoundException(mediaTypeId);
        } else if (!titleRepository.existsById(titleId)) {
            throw new EntityNotFoundException(titleId);
        } else {
            Title title = new Title();
            title.setId(titleId);
            MediaType mediaType = new MediaType();
            mediaType.setId(mediaTypeId);
            Media media = new Media();
            media.setTitle(title);
            media.setMediaType(mediaType);
            media.setReleaseDate(releaseDate);
            return mediaRepository.save(media);
        }
    }
}