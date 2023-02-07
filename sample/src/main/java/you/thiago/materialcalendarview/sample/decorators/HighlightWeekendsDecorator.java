package you.thiago.materialcalendarview.sample.decorators;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import you.thiago.materialcalendarview.CalendarDay;
import you.thiago.materialcalendarview.DayViewDecorator;
import you.thiago.materialcalendarview.DayViewFacade;
import java.time.DayOfWeek;

/**
 * Highlight Saturdays and Sundays with a background
 */
public class HighlightWeekendsDecorator implements DayViewDecorator {

  private final Drawable highlightDrawable;
  private static final int color = Color.parseColor("#228BC34A");

  public HighlightWeekendsDecorator() {
    highlightDrawable = new ColorDrawable(color);
  }

  @Override public boolean shouldDecorate(final CalendarDay day) {
    final DayOfWeek weekDay = day.getDate().getDayOfWeek();
    return weekDay == DayOfWeek.SATURDAY || weekDay == DayOfWeek.SUNDAY;
  }

  @Override public void decorate(final DayViewFacade view) {
    view.setBackgroundDrawable(highlightDrawable);
  }
}
