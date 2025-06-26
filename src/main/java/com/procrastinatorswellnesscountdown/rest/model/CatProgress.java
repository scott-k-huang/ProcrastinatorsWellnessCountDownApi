package com.procrastinatorswellnesscountdown.rest.model;

public record CatProgress (String catId, Integer weekOfYear, ItemProgress[] itemProgressList){}