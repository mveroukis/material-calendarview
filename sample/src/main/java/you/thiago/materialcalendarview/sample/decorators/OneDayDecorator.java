package you.thiago.materialcalendarview.sample.decorators;

import android.graphics.Typeface;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import you.thiago.materialcalendarview.CalendarDay;
import you.thiago.materialcalendarview.DayViewDecorator;
import you.thiago.materialcalendarview.DayViewFacade;
import you.thiago.materialcalendarview.MaterialCalendarView;
import org.threeten.bp.LocalDate;

/**
 * Decorate a day by making the text big and bold
 */
public class OneDayDecorator implements DayViewDecorator {

  private CalendarDay date;

  public OneDayDecorator() {
    date = CalendarDay.today();
  }

  @Override
  public boolean shouldDecorate(CalendarDay day) {
    return date != null && day.equals(date);
  }

  @Override
  public void decorate(DayViewFacade view) {
    view.addSpan(new StyleSpan(Typeface.BOLD));
    view.addSpan(new RelativeSizeSpan(1.4f));
  }

  /**
   * We're changing the internals, so make sure to call {@linkplain MaterialCalendarView#invalidateDecorators()}
   */
  public void setDate(LocalDate date) {
    this.date = CalendarDay.from(date);
  }
}
