package com.sadiqov.soprt_place_search_app.dto;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public final class PlaceDtos {

    public record PlaceResponse(
            Long id,
            String name,
            String address,
            BigDecimal latitude,
            BigDecimal longitude,
            Integer score,
            String description,
            String phone,
            String website,
            Long categoryId,
            String categoryName,
            boolean openNow,
            List<ScheduleResponse> schedules
    ) {
    }
    public record ScheduleResponse(
            Long id,
            DayOfWeek day,
            LocalTime openTime,
            LocalTime closeTime,
            boolean spansMidnight
    ) {
    }

}
