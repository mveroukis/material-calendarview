package com.neoex.materialcalendarview.sample;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.neoex.materialcalendarview.MaterialCalendarView;
import com.neoex.materialcalendarview.sample.decorators.EventDecorator;
import com.neoex.materialcalendarview.sample.decorators.HighlightWeekendsDecorator;
import com.neoex.materialcalendarview.sample.decorators.MySelectorDecorator;
import com.neoex.materialcalendarview.sample.decorators.OneDayDecorator;
import com.neoex.materialcalendarview.CalendarDay;
import com.neoex.materialcalendarview.OnDateSelectedListener;
import com.neoex.materialcalendarview.sample.decorators.WeekDecorator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.time.LocalDate;
import java.time.Month;

/**
 * Shows off the most basic usage
 */
public class BasicActivityDecorated extends AppCompatActivity implements OnDateSelectedListener {

  private final OneDayDecorator oneDayDecorator = new OneDayDecorator();
  private WeekDecorator weekDecorator;

  @BindView(R.id.calendarView)
  MaterialCalendarView widget;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_basic);
    ButterKnife.bind(this);

    weekDecorator = new WeekDecorator(new ColorDrawable(0x0F00FF00),0xFF000000);

    widget.setOnDateChangedListener(this);
    widget.setShowOtherDates(MaterialCalendarView.SHOW_ALL);

    final LocalDate instance = LocalDate.now();

    final LocalDate min = LocalDate.of(instance.getYear(), Month.JANUARY, 1);
    final LocalDate max = LocalDate.of(instance.getYear(), Month.DECEMBER, 31);

    widget.state().edit().setMinimumDate(min).setMaximumDate(max).commit();

    widget.addDecorators(
//        new MySelectorDecorator(this),
        new HighlightWeekendsDecorator(),
        weekDecorator//,
  //      oneDayDecorator
    );

    widget.setSelectedDate(instance);

    new ApiSimulator().executeOnExecutor(Executors.newSingleThreadExecutor());
  }

  @Override
  public void onDateSelected(
      @NonNull MaterialCalendarView widget,
      @NonNull CalendarDay date,
      boolean selected) {
    //If you change a decorate, you need to invalidate decorators
    oneDayDecorator.setDate(date.getDate());
    weekDecorator.setFromWeekDate(date);

    widget.invalidateDecorators();
  }

  /**
   * Simulate an API call to show how to add decorators
   */
  private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

    @Override
    protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      LocalDate temp = LocalDate.now().minusMonths(2);
      final ArrayList<CalendarDay> dates = new ArrayList<>();
      for (int i = 0; i < 30; i++) {
        final CalendarDay day = CalendarDay.from(temp);
        dates.add(day);
        temp = temp.plusDays(5);
      }

      return dates;
    }

    @Override
    protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
      super.onPostExecute(calendarDays);

      if (isFinishing()) {
        return;
      }

      widget.addDecorator(new EventDecorator(Color.RED, calendarDays));
    }
  }
}
