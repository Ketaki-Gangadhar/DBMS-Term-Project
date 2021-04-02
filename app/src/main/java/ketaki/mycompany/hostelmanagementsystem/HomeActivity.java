package ketaki.mycompany.hostelmanagementsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
private Button Insert,Update,Delete,Show;
DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        Insert = findViewById(R.id.button1);
        Show = findViewById(R.id.button2);
        Update = findViewById(R.id.button3);
        Delete = findViewById(R.id.button4);

        db = new DataBaseHelper(HomeActivity.this);


        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFormActivity();
            }
        });

        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.Show();
                if(res.getCount()==0)
                {
                    Toast.makeText(HomeActivity.this, "No Entry exists!", Toast.LENGTH_SHORT).show();
                   return ;}

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Enrolment_No :"+res.getString(0)+"\n");
                    buffer.append("Name :"+res.getString(1)+"\n");
                    buffer.append("Email Id :"+res.getString(2)+"\n");
                    buffer.append("Roll No :"+res.getString(3)+"\n");
                    buffer.append("Course :"+res.getString(4)+"\n");
                    buffer.append("Branch :"+res.getString(5)+"\n");
                    buffer.append("Semester :"+res.getString(6)+"\n");
                    buffer.append("Phone No :"+res.getString(7)+"\n");
                    buffer.append("Address :"+res.getString(8)+"\n");
                    buffer.append("Gender :"+res.getString(9)+"\n");
                    buffer.append("Hostel Name :"+res.getString(10)+"\n");
                    buffer.append("Room No :"+res.getString(11)+"\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Student Entries");
                builder.setMessage(buffer.toString());
                builder.show();






            }
        });






    }

    private void startFormActivity() {
        Intent i = new Intent(HomeActivity.this,Form.class);
        startActivity(i);
        finish();
    }
}