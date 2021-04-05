package ketaki.mycompany.hostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentLogin extends AppCompatActivity {
private TextView mregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        getSupportActionBar().hide();

        mregister=findViewById(R.id.textView12);
        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterActivity();
            }
        });
    }
    private void startRegisterActivity() {
        Intent i = new Intent(StudentLogin.this,StudentRegister.class);
        startActivity(i);
        finish();
    }
}