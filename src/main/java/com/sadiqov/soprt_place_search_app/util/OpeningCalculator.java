package com.sadiqov.soprt_place_search_app.util;
import com.sadiqov.soprt_place_search_app.entity.PlaceSchedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class OpeningCalculator {

    public static boolean isOpenNow(List<PlaceSchedule> schedules) {
        if (schedules == null || schedules.isEmpty()) {
            return false;
        }

        ZoneId zone = ZoneId.of("Asia/Baku");
        ZonedDateTime now = ZonedDateTime.now(zone);
        DayOfWeek today = now.getDayOfWeek();
        LocalTime currentTime = now.toLocalTime();

        for (PlaceSchedule schedule : schedules) {
            if (schedule == null) continue;

            DayOfWeek scheduleDay = schedule.getDay();
            LocalTime openTime = schedule.getOpenTime();
            LocalTime closeTime = schedule.getCloseTime();
            boolean spansMidnight = schedule.isSpansMidnight();

            if (scheduleDay != today) continue;

            if (!spansMidnight) {
                if (!currentTime.isBefore(openTime) && currentTime.isBefore(closeTime)) {
                    return true;
                }
            } else {
                if (!currentTime.isBefore(openTime) || currentTime.isBefore(closeTime)) {
                    return true;
                }
            }
        }
        return false;
    }
}