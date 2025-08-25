package com.procrastinatorswellnesscountdown.rest.model;

public record CatProgressResponse(String catId, Integer weekOfYear, ItemProgress[] itemProgressList){}