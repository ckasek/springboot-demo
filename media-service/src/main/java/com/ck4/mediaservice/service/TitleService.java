package com.ck4.mediaservice.service;

import com.ck4.mediaservice.entities.Title;
import com.ck4.mediaservice.exception.EntityNotFoundException;
import com.ck4.mediaservice.repository.TitleRepository;
import com.ck4.mediaservice.utils.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TitleService {

    private final TitleRepository titleRepository;

    public TitleService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    public Title updateTitle(Title title) {
        Title m = titleRepository.findById(title.getId()).orElseThrow();
        BeanUtils.copyProperties(title, m, ObjectUtils.getNullPropertyNames(title));
        return m;
    }

    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }

    public Title findById(Long id) {
            return titleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
}