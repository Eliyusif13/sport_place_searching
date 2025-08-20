package com.sadiqov.soprt_place_search_app.controller;
import com.sadiqov.soprt_place_search_app.dto.PlaceDtos.*;
import com.sadiqov.soprt_place_search_app.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class GymInfoController {

    @Autowired
    private PlaceService placeService;

    @GetMapping()
    public List<PlaceResponse> searchPlacesByName(
            @RequestParam String name) {
        return placeService.getPlacesByName(name);
    }

    @GetMapping
    public List<PlaceResponse> getAllPlaces() {
        return placeService.getAllPlaces();
    }
}