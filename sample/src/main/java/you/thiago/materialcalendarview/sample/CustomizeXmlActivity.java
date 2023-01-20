package you.thiago.materialcalendarview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import you.thiago.materialcalendarview.MaterialCalendarView;

public class CustomizeXmlActivity extends AppCompatActivity {

  @BindView(R.id.calendarView)
  MaterialCalendarView widget;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_customization);
    ButterKnife.bind(this);
  }
}
