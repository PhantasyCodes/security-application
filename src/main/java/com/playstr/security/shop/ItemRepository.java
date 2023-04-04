package com.playstr.security.shop;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByName(String name);
}
