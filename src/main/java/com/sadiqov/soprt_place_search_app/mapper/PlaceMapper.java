package com.sadiqov.soprt_place_search_app.mapper;

import com.sadiqov.soprt_place_search_app.dto.PlaceDtos.PlaceResponse;
import com.sadiqov.soprt_place_search_app.entity.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaceMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "latitude", source = "latitude")
    @Mapping(target = "longitude", source = "longitude")
    @Mapping(target = "score", source = "score")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "website", source = "website")
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "openNow", expression = "java(com.sadiqov.soprt_place_search_app.util.OpeningCalculator.isOpenNow(place.getSchedules()))")
    @Mapping(target = "schedules", source = "schedules")
    PlaceResponse toResponse(Place place);

    List<PlaceResponse> toResponseList(List<Place> places);
}