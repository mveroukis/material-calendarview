package you.thiago.materialcalendarview.sample;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import you.thiago.materialcalendarview.MaterialCalendarView;
import you.thiago.materialcalendarview.OnDateLongClickListener;
import you.thiago.materialcalendarview.OnMonthChangedListener;
import you.thiago.materialcalendarview.CalendarDay;

import org.threeten.bp.format.DateTimeFormatter;

/**
 * Shows off the most basic usage
 */
public class RotationActivity extends AppCompatActivity
    implements OnMonthChangedListener, OnDateLongClickListener {

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("EEE, d MMM yyyy");

  @BindView(R.id.calendarView)
  MaterialCalendarView widget;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rotation);
    ButterKnife.bind(this);

    widget.setOnDateLongClickListener(this);
    widget.setOnMonthChangedListener(this);
  }

  @Override
  public void onDateLongClick(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date) {
    final String text = String.format("%s is available", FORMATTER.format(date.getDate()));
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
    //noinspection ConstantConditions
    getSupportActionBar().setTitle(FORMATTER.format(date.getDate()));
  }
}
