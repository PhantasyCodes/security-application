package com.playstr.security.item;

import com.playstr.security.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String url;
    private String price;
    private String  description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
