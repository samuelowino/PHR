package phr.muzima.org.phr;

import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar landingScreenToolbar;
    DrawerLayout landingScreenDrawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView landingScreenNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        landingScreenToolbar = findViewById(R.id.landing_screen_toolbar);
        landingScreenDrawerLayout = findViewById(R.id.landing_screen_drawer_layout);
        setSupportActionBar(landingScreenToolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, landingScreenDrawerLayout, landingScreenToolbar, R.string.open, R.string.close);
        landingScreenNavigationView = findViewById(R.id.landing_screen_navigation_view);

        landingScreenDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        landingScreenNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                /**
                 * Navigation item action code
                 */
                return true;
            }
        });

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}
