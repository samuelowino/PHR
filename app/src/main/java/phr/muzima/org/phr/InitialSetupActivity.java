package phr.muzima.org.phr;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

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
    }
}
