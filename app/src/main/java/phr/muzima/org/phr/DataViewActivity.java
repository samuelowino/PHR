package phr.muzima.org.phr;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class DataViewActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton callImageButton;
    ImageButton smsImageButton;
    ImageButton emailImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_view);

        toolbar = findViewById(R.id.phr_data_toolbar);
        callImageButton = findViewById(R.id.call_provider_button);
        smsImageButton = findViewById(R.id.sms_provider_button);
        emailImageButton = findViewById(R.id.email_provider_image_button);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        callImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Calling Provider",Toast.LENGTH_LONG).show();
                Intent callIntent = new Intent();
                callIntent.setAction(Intent.ACTION_SEND);
                callIntent.putExtra(Intent.EXTRA_PHONE_NUMBER,"+254729204651");
                startActivity(callIntent);
            }
        });
    }

    /**
     * Intent invocation method, that makes a call to the
     * mUzima client's provider.
     *
     * @param provider_phone_number String
     */
    public void callProvider(String provider_phone_number,View view){
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_SEND);
        callIntent.putExtra(Intent.EXTRA_PHONE_NUMBER,provider_phone_number);
        startActivity(callIntent);

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
        startActivity( new Intent(getApplicationContext(),MainActivity.class));
        return super.onOptionsItemSelected(item);
    }
}
