package com.procrastinatorswellnesscountdown.rest.model;

public record EditItemRequest (String itemId, String categoryId, String itemName, Integer weekGoalAmount){
}
