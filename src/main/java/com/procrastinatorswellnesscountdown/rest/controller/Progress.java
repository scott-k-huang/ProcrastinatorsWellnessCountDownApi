package com.procrastinatorswellnesscountdown.rest.controller;

import com.procrastinatorswellnesscountdown.rest.model.CategoryProgressResponse;
import com.procrastinatorswellnesscountdown.rest.model.ItemProgress;
import com.procrastinatorswellnesscountdown.rest.model.ItemProgressRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class Progress {
    @GetMapping("/progress/{weekOfYear}/{catId}")
    CategoryProgressResponse getCatProgress(@PathVariable("weekOfYear")Integer weekOfYear, @PathVariable("catId")String catId){
        ItemProgress item1 = new ItemProgress(UUID.randomUUID().toString(),"item 1", 100, 10, 10.0);
        ItemProgress item2 = new ItemProgress(UUID.randomUUID().toString(),"item 2",100, 20, 20.0);
        ItemProgress item3 = new ItemProgress(UUID.randomUUID().toString(),"item 3",100, 30, 30.0);
        ItemProgress[] array =  {item1, item2, item3};
        return new CategoryProgressResponse(catId, weekOfYear,array);
    }

    @PostMapping("/progress/{weekOfYear}")
    ItemProgress submitItemProgress(@PathVariable("weekOfYear")Integer weekOfYear, @RequestBody ItemProgressRequest request){
        return new ItemProgress(UUID.randomUUID().toString(), "Item Name",100, request.units(), Integer.valueOf(request.units() / 100 * 100).doubleValue());
    }





}
