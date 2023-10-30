package com.neoex.materialcalendarview.sample.decorators;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ForegroundColorSpan;

import com.neoex.materialcalendarview.CalendarDay;
import com.neoex.materialcalendarview.DayViewDecorator;
import com.neoex.materialcalendarview.DayViewFacade;

import java.time.LocalDate;
import java.util.HashSet;

public class WeekDecorator implements DayViewDecorator  {
    private final HashSet<CalendarDay> list = new HashSet<>();
    private final Drawable backgroundDrawable;
    private final Drawable clearSelectorDrawable = new ColorDrawable(0x0);
    private final int spanColor;

    public WeekDecorator(Drawable drawable, int textColor) {
        this.backgroundDrawable = drawable;
        this.spanColor = textColor;
        this.setFromWeekDate(LocalDate.now());
    }

    public WeekDecorator(Drawable drawable, int textColor, LocalDate date) {
        this.backgroundDrawable = drawable;
        this.spanColor = textColor;
        this.setFromWeekDate(date);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return list.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(backgroundDrawable);
        view.addSpan(new ForegroundColorSpan(spanColor));
        view.setSelectionDrawable(clearSelectorDrawable);
    }

    public void setFromWeekDate(final CalendarDay date) {
        setFromWeekDate(date.getDate());
    }

    public void setFromWeekDate(final LocalDate date) {
        final int dayOfWeek = date.getDayOfWeek().ordinal();
        final LocalDate firstDay = date.minusDays((dayOfWeek + 1) % 7);

        list.clear();

        for (int i = 0; i < 7; i++) {
            list.add(CalendarDay.from(firstDay.plusDays(i)));
        }
    }
}
