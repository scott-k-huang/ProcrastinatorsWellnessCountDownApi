package com.procrastinatorswellnesscountdown.rest.controller;

import com.procrastinatorswellnesscountdown.rest.model.CatProgress;
import com.procrastinatorswellnesscountdown.rest.model.ItemProgress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Progress {
    @GetMapping("/progress/week/{weekOfYear}/cat/{catId}")
    CatProgress getCatProgress(@PathVariable("weekOfYear")Integer weekOfYear, @PathVariable("catId")String catId){
        ItemProgress item1 = new ItemProgress("1","item 1", 1, 10);
        ItemProgress item2 = new ItemProgress("2","item 2", 2, 20);
        ItemProgress item3 = new ItemProgress("3","item 3", 3, 30);
        ItemProgress[] array =  {item1, item2, item3};
        return new CatProgress(catId, weekOfYear,array);
    }
}
