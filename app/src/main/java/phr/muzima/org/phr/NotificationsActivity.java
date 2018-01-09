package phr.muzima.org.phr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

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
        setContentView(R.layout.activity_notification);

        toolbar = findViewById(R.id.notifications_toolbar);
        setSupportActionBar(toolbar);

        notificationsListView = findViewById(R.id.notifications_list_view);

        /**
         * Dummy data
         */
        List<Notification> notificationList = Arrays.asList( new Notification("BDR Visit"), new Notification("CT Scan"), new Notification("Cancer Screening Appointment"));

        notificationsListAdapter = new NotificationsAdapter(this,notificationList);
        notificationsListView.setAdapter(notificationsListAdapter);
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
        /**
         * Pass values to individual form view activity
         * TODO create individual form view activity
         */
        if (item.getItemId() == android.R.id.home) {
            Intent mainActivityIntent = new Intent(this, MainActivity.class);
            startActivity(mainActivityIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
