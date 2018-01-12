package phr.muzima.org.phr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    EditText username_editTextView;
    EditText password_editTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.loginbutton);
        username_editTextView = findViewById(R.id.username_editText);
        password_editTextView = findViewById(R.id.password_editText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticate(username_editTextView.getText().toString(),password_editTextView.getText().toString());
            }
        });
    }

    public void authenticate(String username,String password){
        if (username.isEmpty() || password.isEmpty() || username.toLowerCase().contains("username")){
            startActivity( new Intent(getApplicationContext(),WrongPasswordActivity.class));
        }else {
            startActivity( new Intent(getApplicationContext(),InitialSetupActivity.class));
        }
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
        finish();
        return super.onOptionsItemSelected(item);
    }

}