package phr.muzima.org.phr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class NotificationViewActivity extends AppCompatActivity {

    TextView textView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detailed_view);

        textView = findViewById(R.id.notifications_title_textView);
        toolbar = findViewById(R.id.detailed_notification_toolbar);
        setSupportActionBar(toolbar);

        String notificationBody = savedInstanceState.getString("notification_body");
        textView.setText(notificationBody);

    }
}
