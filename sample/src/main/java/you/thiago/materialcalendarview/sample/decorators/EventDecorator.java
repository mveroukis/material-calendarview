package you.thiago.materialcalendarview.sample.decorators;

import you.thiago.materialcalendarview.CalendarDay;
import you.thiago.materialcalendarview.DayViewDecorator;
import you.thiago.materialcalendarview.DayViewFacade;
import you.thiago.materialcalendarview.spans.DotSpan;
import java.util.Collection;
import java.util.HashSet;

/**
 * Decorate several days with a dot
 */
public class EventDecorator implements DayViewDecorator {

  private int color;
  private HashSet<CalendarDay> dates;

  public EventDecorator(int color, Collection<CalendarDay> dates) {
    this.color = color;
    this.dates = new HashSet<>(dates);
  }

  @Override
  public boolean shouldDecorate(CalendarDay day) {
    return dates.contains(day);
  }

  @Override
  public void decorate(DayViewFacade view) {
    view.addSpan(new DotSpan(5, color));
  }
}
