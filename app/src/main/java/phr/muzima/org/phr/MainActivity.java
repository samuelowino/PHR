package phr.muzima.org.phr;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar landingScreenToolbar;
    DrawerLayout landingScreenDrawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView landingScreenNavigationView;
    CardView dataCardView;
    CardView profileCardView;
    CardView formsCardView;
    CardView notificationsCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        landingScreenToolbar = findViewById(R.id.landing_screen_toolbar);
        landingScreenDrawerLayout = findViewById(R.id.landing_screen_drawer_layout);
        dataCardView = findViewById(R.id.data_cardView);
        formsCardView = findViewById(R.id.forms_cardView);
        profileCardView = findViewById(R.id.profile_cardView);
        notificationsCardView = findViewById(R.id.notifications_cardView);
        setSupportActionBar(landingScreenToolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, landingScreenDrawerLayout, landingScreenToolbar, R.string.open, R.string.close);
        landingScreenNavigationView = findViewById(R.id.landing_screen_navigation_view);

        landingScreenDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        dataCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DataViewActivity.class);
                startActivity(intent);
            }
        });

        formsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FormsViewActivity.class);
                startActivity(intent);
            }
        });

        profileCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProfileViewActivity.class);
                startActivity(intent);
            }
        });

        notificationsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NotificationsActivity.class);
                startActivity(intent);
            }
        });

        landingScreenNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                /**
                 * Navigation item action code
                 */
                switch (item.getItemId()) {
                    case R.id.client_profile_menu_item:
                        startActivity( new Intent(getApplicationContext(),ClientProfileActivity.class));
                    case R.id.settings_menu_item:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                    default:
                        break;
                }
                return true;
            }
        });

        Toast.makeText(this, "Hello, Welcome to mUzima PHR", Toast.LENGTH_LONG).show();

    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}
