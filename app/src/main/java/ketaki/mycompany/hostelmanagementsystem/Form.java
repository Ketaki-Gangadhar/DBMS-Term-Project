package ketaki.mycompany.hostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Form extends AppCompatActivity {
private EditText Student_Name,Email,Course_s,Branch_s,Semester_s,Phone_no,Address_s,Roll_no,Enrolment_no,Room_no;
private RadioButton Male,Female,hostel1,hostel2,hostel3,rb1,rb2;
private RadioGroup r1,r2;
private Button Submit;

DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().hide();

        db = new DataBaseHelper(Form.this);

        Student_Name = findViewById(R.id.name);
        Email = findViewById(R.id.email);
        Course_s = findViewById(R.id.course);
        Branch_s = findViewById(R.id.branch);
        Semester_s = findViewById(R.id.semester);
        Phone_no = findViewById(R.id.Phone_Number);
        Address_s = findViewById(R.id.address);
        Roll_no = findViewById(R.id.roll_no);
        Enrolment_no = findViewById(R.id.enrolment_no);
        Room_no = findViewById(R.id.room_no);

        Male = findViewById(R.id.male);
        Female = findViewById(R.id.female);
        hostel1 = findViewById(R.id.hostel_a);
        hostel2 = findViewById(R.id.hostel_b);
        hostel3 = findViewById(R.id.hostel_c);

        r1=findViewById(R.id.radioGroup1);
        r2=findViewById(R.id.radioGroup2);

        Submit = findViewById(R.id.submit_button);

       Submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String Enrolment_No = Enrolment_no.getText().toString();
               String Name = Student_Name.getText().toString();
               String Email_Id = Email.getText().toString();
               String Roll_No = Roll_no.getText().toString();
               String Course = Course_s.getText().toString();
               String Branch = Branch_s.getText().toString();
               String Semester = Semester_s.getText().toString();
               String Phone_No = Phone_no.getText().toString();
               String Address = Address_s.getText().toString();
               String Room_No = Room_no.getText().toString();

               String Gender;
               String Hostel_Name;

               int select1 = r1.getCheckedRadioButtonId();
               rb1 = findViewById(select1);
               String str1 = rb1.getText().toString();

               if(str1 == "Male")
                   Gender="Male";
               else
                   Gender="Female";

               int select2 = r2.getCheckedRadioButtonId();
               rb2 = findViewById(select1);
               String str2 = rb1.getText().toString();

               if(str2 == "A")
                   Hostel_Name = "A";
               else if(str2 == "B")
                   Hostel_Name = "B";
               else
                   Hostel_Name = "C";

             boolean check = db.Insert(Enrolment_No,Name,Email_Id,Roll_No,Course,Branch,Semester,Phone_No,Address,Gender,Hostel_Name,Room_No);
             if(check == true)
                 Toast.makeText(Form.this, "Information Added Successfully!", Toast.LENGTH_SHORT).show();
             else
                 Toast.makeText(Form.this, "Try Again! Error Occurred.", Toast.LENGTH_SHORT).show();
           }
       });





    }
}