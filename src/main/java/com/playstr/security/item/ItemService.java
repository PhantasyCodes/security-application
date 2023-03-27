package com.playstr.security.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item createItem(ItemRequest itemRequest) {
        var item = Item.builder()
                .name(itemRequest.getName())
                .description(itemRequest.getDescription())
                .url(itemRequest.getUrl())
                .price(itemRequest.getPrice())
                .build();
        itemRepository.save(item);
        return item;
    }

    public List<Item> createItems(ItemListRequest itemListRequest) {
        for (ItemRequest itemRequest: itemListRequest.getItems()) {
            var item = Item.builder()
                    .name(itemRequest.getName())
                    .description(itemRequest.getDescription())
                    .url(itemRequest.getUrl())
                    .price(itemRequest.getPrice())
                    .build();
            itemRepository.save(item);
        }
        return getItems();
    }
}
