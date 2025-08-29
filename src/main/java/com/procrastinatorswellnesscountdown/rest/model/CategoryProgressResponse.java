package com.procrastinatorswellnesscountdown.rest.model;

public record CategoryProgressResponse(String catId, Integer weekOfYear, ItemProgress[] itemProgressList){}