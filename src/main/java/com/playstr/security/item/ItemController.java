package com.playstr.security.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody ItemRequest itemRequest) {
        return ResponseEntity.ok(itemService.createItem(itemRequest));
    }
}
