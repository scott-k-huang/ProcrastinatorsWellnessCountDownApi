package com.procrastinatorswellnesscountdown.rest.model;

public record ItemProgress(String itemId, String itemName, Integer itemGoal, Integer itemCount, Double itemCompletionPercentage) {}
