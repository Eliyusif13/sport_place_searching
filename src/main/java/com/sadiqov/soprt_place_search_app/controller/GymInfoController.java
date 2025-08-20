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

    @GetMapping("/search")
    public List<PlaceResponse> searchPlaces(
            @RequestParam(required = false) String searchWord) {

        return placeService.searchPlaces(searchWord);
    }

    @GetMapping("/search/score")
    public List<PlaceResponse> searchByScore(
            @RequestParam(required = false) Integer min,
            @RequestParam(required = false) Integer max) {

        return placeService.searchByScoreRange(min, max);
    }

    @GetMapping
    public List<PlaceResponse> getAllPlaces() {
        return placeService.getAllPlaces();
    }
}