package ketaki.mycompany.hostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentRegister extends AppCompatActivity {
private TextView mLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);
        getSupportActionBar().hide();

        mLogin=findViewById(R.id.textView13);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLoginActivity();
            }
        });
    }
    private void startLoginActivity() {
        Intent i = new Intent(StudentRegister.this,StudentLogin.class);
        startActivity(i);
        finish();
    }
}