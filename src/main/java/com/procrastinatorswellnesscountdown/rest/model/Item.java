package com.procrastinatorswellnesscountdown.rest.model;

public record Item(String id, Category category, String name, Integer weekGoalAmount) {
}
