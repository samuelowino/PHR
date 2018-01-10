package phr.muzima.org.phr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        password_editTextView = findViewById(R.id.password_edit_text);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticate(username_editTextView.getText().toString(),password_editTextView.getText().toString());
            }
        });
    }

    public void authenticate(String username,String password){
        if (username.isEmpty() || password.isEmpty()){
            startActivity( new Intent(getApplicationContext(),WrongPasswordActivity.class));
        }else {
            startActivity( new Intent(getApplicationContext(),InitialSetupActivity.class));
        }
    }
}
