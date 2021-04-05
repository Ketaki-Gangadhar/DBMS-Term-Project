package ketaki.mycompany.hostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StaffRegister extends AppCompatActivity {
    private TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_register);
        getSupportActionBar().hide();
        login = findViewById(R.id.textView11);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLoginActivity();
            }


        });
    }
    private void startLoginActivity() {
        Intent i = new Intent(StaffRegister.this,StaffLogin.class);
        startActivity(i);
        finish();
    }
}