package com.sadiqov.soprt_place_search_app.repo;

import com.sadiqov.soprt_place_search_app.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByCategoryId(Long categoryId);

    List<Place> findByName(String name);

    List<Place> findByNameContainingIgnoreCase(String name);

    List<Place> findByNameStartingWithIgnoreCase(String name);

    @Query("SELECT p FROM Place p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Place> searchByName(@Param("name") String name);
}