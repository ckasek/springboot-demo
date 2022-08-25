package com.ck4.mediaservice.service;

import com.ck4.mediaservice.entities.Inventory;
import com.ck4.mediaservice.entities.Media;
import com.ck4.mediaservice.exception.EntityNotFoundException;
import com.ck4.mediaservice.repository.InventoryRepository;
import com.ck4.mediaservice.utils.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory updateInventory(Inventory inventory) {
        Inventory m = inventoryRepository.findById(inventory.getId()).orElseThrow();
        BeanUtils.copyProperties(inventory, m, ObjectUtils.getNullPropertyNames(inventory));
        return m;
    }

    public Inventory findById(Long id) {
            return inventoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public void addInventory(long mediaId, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Inventory inventory = new Inventory();
            inventory.setActive(true);
            Media media = new Media();
            media.setId(mediaId);
            inventory.setMedia(media);
            inventoryRepository.save(inventory);
        }
    }

    public List<Inventory> findByMediaId(Long mediaId) {
        return inventoryRepository.findAllByMediaId(mediaId);
    }
}