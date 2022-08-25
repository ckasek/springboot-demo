package com.ck4.mediaservice.repository;

import com.ck4.mediaservice.entities.MediaType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaTypeRepository extends CrudRepository<MediaType, Long> {
}