package you.thiago.materialcalendarview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;

import java.time.DayOfWeek;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import you.thiago.materialcalendarview.format.WeekDayFormatter;

/**
 * Display a day of the week
 */
@SuppressLint("ViewConstructor") class WeekDayView extends AppCompatTextView {

  private WeekDayFormatter formatter = WeekDayFormatter.DEFAULT;
  private DayOfWeek dayOfWeek;

  public WeekDayView(final Context context, final DayOfWeek dayOfWeek) {
    super(context);

    setGravity(Gravity.CENTER);

    setTextAlignment(TEXT_ALIGNMENT_CENTER);

    setDayOfWeek(dayOfWeek);
  }

  public void setWeekDayFormatter(@Nullable final WeekDayFormatter formatter) {
    this.formatter = formatter == null ? WeekDayFormatter.DEFAULT : formatter;
    setDayOfWeek(dayOfWeek);
  }

  public void setDayOfWeek(final DayOfWeek dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
    setText(formatter.format(dayOfWeek));
  }
}
