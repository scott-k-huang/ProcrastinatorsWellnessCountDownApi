package com.procrastinatorswellnesscountdown.rest.controller;

import com.procrastinatorswellnesscountdown.rest.model.CatProgressResponse;
import com.procrastinatorswellnesscountdown.rest.model.ItemProgress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class Progress {
    @GetMapping("/progress/{weekOfYear}/{catId}")
    CatProgressResponse getCatProgress(@PathVariable("weekOfYear")Integer weekOfYear, @PathVariable("catId")String catId){
        ItemProgress item1 = new ItemProgress(UUID.randomUUID().toString(),"item 1", 100, 10, 10.0);
        ItemProgress item2 = new ItemProgress(UUID.randomUUID().toString(),"item 2",100, 20, 20.0);
        ItemProgress item3 = new ItemProgress(UUID.randomUUID().toString(),"item 3",100, 30, 30.0);
        ItemProgress[] array =  {item1, item2, item3};
        return new CatProgressResponse(catId, weekOfYear,array);
    }

    @PostMapping("/progress/{weekOfYear}/{itemId}")
    ItemProgress submitItemProgress(@PathVariable("weekOfYear")Integer weekOfYear, @PathVariable("itemId")String itemId){
        return new ItemProgress(UUID.randomUUID().toString(), "Item Name",100, 50, 50.0);
    }





}
