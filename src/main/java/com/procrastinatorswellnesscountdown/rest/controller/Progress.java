package com.procrastinatorswellnesscountdown.rest.controller;

import com.procrastinatorswellnesscountdown.rest.model.CategoryProgressResponse;
import com.procrastinatorswellnesscountdown.rest.model.ItemProgress;
import com.procrastinatorswellnesscountdown.rest.model.ItemProgressRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.UUID;

@RestController
@CrossOrigin
public class Progress {
    @GetMapping("/progress/{weekOfYear}/{catId}")
    CategoryProgressResponse getCatProgress(@PathVariable("weekOfYear")Integer weekOfYear, @PathVariable("catId") String catId){
        weekOfYear = weekOfYear == null ? currentWeekOfYear() : weekOfYear;
        ItemProgress item1 = new ItemProgress(UUID.randomUUID().toString(),"item 1", 100, 10, 10.0);
        ItemProgress item2 = new ItemProgress(UUID.randomUUID().toString(),"item 2",100, 20, 20.0);
        ItemProgress item3 = new ItemProgress(UUID.randomUUID().toString(),"item 3",100, 30, 30.0);
        ItemProgress item4 = new ItemProgress(UUID.randomUUID().toString(),"item 1", 100, 40, 40.0);
        ItemProgress item5 = new ItemProgress(UUID.randomUUID().toString(),"item 2",100, 50, 50.0);
        ItemProgress item6 = new ItemProgress(UUID.randomUUID().toString(),"item 3",100, 60, 60.0);
        ItemProgress[] array =  {item1, item2, item3, item4, item5, item6};
        return new CategoryProgressResponse(catId, weekOfYear,array);
    }

    /**
     * submits item progress for given week
     * @param weekOfYear defaults to current week of year if null, otherwise applies to the one provided
     * @param request
     * @return updated item progress for given week of year
     */
    @PostMapping("/progress/{weekOfYear}")
    ItemProgress submitItemProgress(@PathVariable("weekOfYear")Integer weekOfYear, @RequestBody ItemProgressRequest request){
        weekOfYear = weekOfYear == null ? currentWeekOfYear() : weekOfYear;
        return new ItemProgress(request.itemId(), "Item Name",80, request.units(), Integer.valueOf(request.units() / 80 * 100).doubleValue());
    }

    /**
     * calculations found here https://www.baeldung.com/java-get-week-number
     * @return week of year for current date
     */
    private Integer currentWeekOfYear(){

        LocalDate date = LocalDate.now();
        return date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
    }
}
