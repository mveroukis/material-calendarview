package com.neoex.materialcalendarview.sample.decorators;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ForegroundColorSpan;

import com.neoex.materialcalendarview.CalendarDay;
import com.neoex.materialcalendarview.DayViewDecorator;
import com.neoex.materialcalendarview.DayViewFacade;
import com.neoex.materialcalendarview.sample.R;

/**
 * Use a custom selector
 */
public class MySelectorDecorator implements DayViewDecorator {

  private final Drawable drawable;

  public MySelectorDecorator(Activity context) {
    drawable = context.getResources().getDrawable(R.drawable.my_selector);
//    drawable = new ColorDrawable(0x00000000);
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
