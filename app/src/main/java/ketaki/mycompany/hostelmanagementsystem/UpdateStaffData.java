package ketaki.mycompany.hostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateStaffData extends AppCompatActivity {
    private EditText staffName,staffGender,staffAddress,staffPhoneNo,staffRole,staffPass;
    private Button UpdateButton;
    private StaffDatabaseHelper db;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_staff_data);
        email = getIntent().getStringExtra("email");
        getSupportActionBar().hide();

        staffName=findViewById(R.id.staff_name_st);
        staffGender=findViewById(R.id.staff_Gender_st);
        staffAddress=findViewById(R.id.staff_address_st);
        staffPhoneNo=findViewById(R.id.staff_phone_no_st);
        staffRole=findViewById(R.id.staff_role_st);
      staffPass=findViewById(R.id.staff_password_st);

        UpdateButton=findViewById(R.id.staff_update_button);

        db = new StaffDatabaseHelper(this);

      UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = staffName.getText().toString();
                String address=staffAddress.getText().toString();
                String gender = staffGender.getText().toString();
                String phone_no = staffPhoneNo.getText().toString();
                String role = staffRole.getText().toString();
                String password = staffPass.getText().toString();

                boolean check = db.StaffDataUpdate ( email,  name,  gender,  address,  phone_no, role,  password);
                if(check==true)
                {
                    Toast.makeText(UpdateStaffData.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                    startPageActivity();
                }
                else
                {
                    Toast.makeText(UpdateStaffData.this, "Try Again!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void startPageActivity() {
        Intent i = new Intent(UpdateStaffData.this,StaffLogin.class);
        startActivity(i);
        finish();
    }
}