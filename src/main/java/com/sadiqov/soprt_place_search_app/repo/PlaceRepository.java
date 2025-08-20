package com.sadiqov.soprt_place_search_app.repo;

import com.sadiqov.soprt_place_search_app.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("SELECT p FROM Place p WHERE " +
            "(:searchTerm IS NULL OR " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(p.address) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(p.phone) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
    List<Place> searchPlaces(@Param("searchTerm") String searchTerm);

    @Query("SELECT p FROM Place p WHERE " +
            "(:minScore IS NULL OR p.score >= :minScore) AND " +
            "(:maxScore IS NULL OR p.score <= :maxScore)")
    List<Place> searchByScoreRange(
            @Param("minScore") Integer minScore,
            @Param("maxScore") Integer maxScore
    );
}