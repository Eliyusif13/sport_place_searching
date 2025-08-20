package com.sadiqov.soprt_place_search_app.service;

import com.sadiqov.soprt_place_search_app.dto.PlaceDtos.*;
import com.sadiqov.soprt_place_search_app.entity.Place;
import com.sadiqov.soprt_place_search_app.mapper.PlaceMapper;
import com.sadiqov.soprt_place_search_app.repo.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private PlaceMapper placeMapper;

    @Transactional(readOnly = true)
    public List<PlaceResponse> getPlacesByName(String name) {
        List<Place> places = placeRepository.findByNameContainingIgnoreCase(name);
        places.forEach(place -> {
            place.getSchedules().size();
            place.getCategory().getName();
        });
        return placeMapper.toResponseList(places);
    }

    @Transactional(readOnly = true)
    public List<PlaceResponse> getAllPlaces() {
        List<Place> places = placeRepository.findAll();
        return placeMapper.toResponseList(places);
    }
}
