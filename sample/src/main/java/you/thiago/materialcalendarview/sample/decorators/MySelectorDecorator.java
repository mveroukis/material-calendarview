package you.thiago.materialcalendarview.sample.decorators;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import you.thiago.materialcalendarview.CalendarDay;
import you.thiago.materialcalendarview.DayViewDecorator;
import you.thiago.materialcalendarview.DayViewFacade;
import you.thiago.materialcalendarview.sample.R;

/**
 * Use a custom selector
 */
public class MySelectorDecorator implements DayViewDecorator {

  private final Drawable drawable;

  public MySelectorDecorator(Activity context) {
    drawable = context.getResources().getDrawable(R.drawable.my_selector);
  }

  @Override
  public boolean shouldDecorate(CalendarDay day) {
    return true;
  }

  @Override
  public void decorate(DayViewFacade view) {
    view.setSelectionDrawable(drawable);
  }
}
