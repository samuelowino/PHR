package phr.muzima.org.phr;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import phr.muzima.org.phr.Tasks.MuzimaFormsDownloadTask;

public class InitialSetupActivity extends AppCompatActivity {

    ProgressBar initialSetUpProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_setup);

        initialSetUpProgressBar = findViewById(R.id.initial_setup_progressBar);
        Drawable progressDrawable = initialSetUpProgressBar.getIndeterminateDrawable().mutate();
        progressDrawable.setColorFilter(getResources().getColor(R.color.muzima_theme_blue), PorterDuff.Mode.SRC_IN);
        initialSetUpProgressBar.setProgressDrawable(progressDrawable);

        /**
         * Temporary delay - simulation
         */
         new Timer().schedule(new TimerTask() {
             @Override
             public void run() {
                 Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(intent);
             }
         },10000);

//        /**
//         * Start form download
//         */
//        try {
//            MuzimaFormsDownloadTask muzimaFormsDownloadTask = new MuzimaFormsDownloadTask();
//            muzimaFormsDownloadTask.execute(new URL("https://demo1.muzima.org/w2/rest"));
//        } catch (IOException exception) {
//            Logger.getAnonymousLogger().log(Level.SEVERE,exception.getStackTrace().toString());
//            Snackbar.make(null,exception.getMessage(),Snackbar.LENGTH_LONG).setAction("Go offline", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(),MainActivity.class);
//                    startActivity(intent);
//                }
//            });
//        }


    }

    public void startLandingPage(View view){
        Intent intent = new Intent(view.getContext(),MainActivity.class);
        startActivity(intent);
    }
}
