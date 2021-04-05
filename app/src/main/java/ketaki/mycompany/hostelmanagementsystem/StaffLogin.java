package ketaki.mycompany.hostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StaffLogin extends AppCompatActivity {
private TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);
        getSupportActionBar().hide();

        register=findViewById(R.id.textView10);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterActivity();
            }
        });

    }

    private void startRegisterActivity() {
        Intent i = new Intent(StaffLogin.this,StaffRegister.class);
        startActivity(i);
        finish();
    }
}