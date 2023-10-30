package com.neoex.materialcalendarview;

import androidx.annotation.NonNull;

public interface OnWeekChangedListener {
    void onWeekChanged(
            @NonNull MaterialCalendarView widget,
            @NonNull CalendarDay firstDayOfWeek,
            @NonNull CalendarDay lastDayOfWeek);
}
