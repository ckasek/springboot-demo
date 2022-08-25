package com.ck4.mediaservice.controller;

import com.ck4.mediaservice.entities.Inventory;
import com.ck4.mediaservice.model.AddInventoryBody;
import com.ck4.mediaservice.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {
    private final static Logger log = LoggerFactory.getLogger(InventoryController.class);

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/inventory")
    public void addInventory(@RequestBody @NonNull AddInventoryBody inventoryBody) {
        inventoryService.addInventory(inventoryBody.getMediaId(), inventoryBody.getQuantity());
    }

    @PutMapping("/inventory")
    public Inventory updateInventory(@RequestBody @NonNull Inventory inventory) {
        return inventoryService.updateInventory(inventory);
    }

    @GetMapping("/inventory/{id}")
    public Inventory getInventory(@PathVariable Long id) {
        return inventoryService.findById(id);
    }
}
