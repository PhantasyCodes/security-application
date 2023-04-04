package com.playstr.security.shop;

import com.playstr.security.shop.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    private String name;
    private String description;
    private String url;
    private String price;
    private Integer categoryId;
}
