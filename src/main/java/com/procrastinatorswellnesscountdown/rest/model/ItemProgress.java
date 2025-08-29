package com.procrastinatorswellnesscountdown.rest.model;

public record ItemProgress(String itemId, String itemName, Integer weekGoalAmount, Integer weekCount, Double weekGoalCompletionPercentage) {}
