package phr.muzima.org.phr;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class NotificationViewActivity extends AppCompatActivity {

    TextView notificationBodyTextView;
    TextView notificationTitleTextView;
    Button confirmNotificationActionButton;
    Button declineNotificationActionButton;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detailed_view);

        notificationBodyTextView = findViewById(R.id.notification_body_textView);
        notificationTitleTextView = findViewById(R.id.notification_title_textView);
        confirmNotificationActionButton = findViewById(R.id.notification_action_button);
        declineNotificationActionButton = findViewById(R.id.decline_notification_button);

        Bundle extras = getIntent().getExtras();

        String notificationBody = extras.getString("notification_body");
        String notificationTitle = extras.getString("notification_title");

        toolbar = findViewById(R.id.detailed_notification_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getResources().getString(R.string.phr_notifications));
        }


        notificationBodyTextView.setText(notificationBody);
        notificationTitleTextView.setText(notificationTitle);

        confirmNotificationActionButton.setOnClickListener(v -> {
            Toast.makeText(v.getContext(),"Notification confirmed",Toast.LENGTH_LONG);
            startActivity( new Intent(v.getContext(),NotificationsActivity.class));
        });

        declineNotificationActionButton.setOnClickListener(v -> {
            Toast.makeText(v.getContext(),"Notification declined",Toast.LENGTH_LONG);
            startActivity( new Intent(v.getContext(),NotificationsActivity.class));
        });

    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     * <p>
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(getApplicationContext(), NotificationsActivity.class));
        return super.onOptionsItemSelected(item);
    }
}
