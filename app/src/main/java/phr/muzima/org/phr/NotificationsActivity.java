package phr.muzima.org.phr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import phr.muzima.org.phr.adapters.NotificationsAdapter;
import phr.muzima.org.phr.model.Notification;

public class NotificationsActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView notificationsListView;
    ListAdapter notificationsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_view);

        toolbar = findViewById(R.id.notifications_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(getString(R.string.phr_notifications));
        }
        notificationsListView = findViewById(R.id.notifications_list_view);

        /**
         * Dummy data
         */
        List<Notification> notificationList = Arrays.asList(
                new Notification("CT Scan", "You have an CT scan appointment on Fri 30 2017 at The Eldoret Kenya Cancer Center", "Reschedule Appoinment"),
                new Notification("BDR Test", "The results for the BDR test you took at the Marta Hospital Nairobi are ready for collecting", "Book Appointment with Physician"),
                new Notification("Chemo Therapy Weekly Appointment", "Your weekly chemotherapy appointment is on 15 Aug 2018", "GOT IT !"));

        notificationsListAdapter = new NotificationsAdapter(getApplicationContext(), notificationList);
        notificationsListView.setAdapter(notificationsListAdapter);

        notificationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Notification notificationItem = (Notification)parent.getItemAtPosition(position);

                String title = notificationItem.getTitle();
                String body = notificationItem.getNotificationBody();
                String action = notificationItem.getAction();

                Intent detailedNotificationViewIntent = new Intent(view.getContext(), NotificationViewActivity.class);

                detailedNotificationViewIntent.putExtra("notification_body", body);
                detailedNotificationViewIntent.putExtra("notification_title",title);
                detailedNotificationViewIntent.putExtra("notification_action",action);
                NotificationsActivity.this.startActivity(detailedNotificationViewIntent);
            }
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
        public boolean onOptionsItemSelected (MenuItem item){
            /**
             * Pass values to individual form view activity
             * TODO create individual form view activity
             */
            if (item.getItemId() == android.R.id.home) {
                Intent mainActivityIntent = new Intent(this, MainActivity.class);
                startActivity(mainActivityIntent);
                finish();
            }
            return super.onOptionsItemSelected(item);
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.drawer_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }
    }
