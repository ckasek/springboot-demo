package com.ck4.mediaservice.repository;

import com.ck4.mediaservice.entities.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    public List<Inventory> findAllByMediaId(Long mediaId);
}