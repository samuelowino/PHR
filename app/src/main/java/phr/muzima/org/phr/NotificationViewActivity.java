package phr.muzima.org.phr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class NotificationViewActivity extends AppCompatActivity {

    TextView notificationBodyTextView;
    TextView notificationTitleTextView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detailed_view);

        notificationBodyTextView = findViewById(R.id.notification_body_textView);
        notificationTitleTextView = findViewById(R.id.notification_title_textView);
        toolbar = findViewById(R.id.detailed_notification_toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();

        String notificationBody = extras.getString("notification_body");
        String notificationTitle = extras.getString("notification_title");
        notificationBodyTextView.setText(notificationBody);
        notificationTitleTextView.setText(notificationTitle);

    }
}
