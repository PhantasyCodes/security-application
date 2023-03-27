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

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/all-items")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody ItemRequest itemRequest) {
        return ResponseEntity.ok(itemService.createItem(itemRequest));
    }

    @PostMapping("/item-list")
    public ResponseEntity<List<Item>> createItems(@RequestBody ItemListRequest itemListRequest) {
        return ResponseEntity.ok(itemService.createItems(itemListRequest));
    }
}
