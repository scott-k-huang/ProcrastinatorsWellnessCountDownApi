package com.procrastinatorswellnesscountdown.rest.controller;

import com.procrastinatorswellnesscountdown.rest.model.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class GoalManagement {
    @PostMapping("/category")
    Category createCategory(@RequestBody CreateCategoryRequest request){
        return new Category(UUID.randomUUID().toString(), request.name());
    }

    @PutMapping("/category")
    Category editCategory(@RequestBody EditCategoryRequest request){
        return new Category(request.id(), request.name());
    }

    @PostMapping("/item")
    Item createItem(@RequestBody CreateItemRequest request){
        return new Item(UUID.randomUUID().toString(), new Category(request.categoryId(), request.categoryId()), request.name(), request.weekGoalAmount());
    }

    @PutMapping("/item")
    Item editItem(@RequestBody EditItemRequest request){
        return new Item(request.itemId(), new Category(request.categoryId(), request.categoryId()), request.itemName(), request.weekGoalAmount());
    }

}
