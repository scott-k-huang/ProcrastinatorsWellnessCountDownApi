package com.procrastinatorswellnesscountdown.rest.model;

public record CreateItemRequest(String categoryId, String name, Integer weekGoalAmount) {
}
