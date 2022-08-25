package com.ck4.mediaservice.repository;

import com.ck4.mediaservice.entities.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends CrudRepository<Title, Long> {
}