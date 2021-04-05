package ketaki.mycompany.hostelmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {


    public DataBaseHelper( Context context) {
        super(context, "HostelStudents.Db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE Hostel_Students_Data (Enrolment_No TEXT PRIMARY KEY, Name TEXT, Email_Id TEXT, Roll_No TEXT, Course TEXT, Branch TEXT, Semester TEXT, Phone_No TEXT, Address TEXT, Gender TEXT, Hostel_Name TEXT, Room_No TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Hostel_Students_Data");
    }

    public boolean Insert (String Enrolment_No, String Name, String Email_Id, String Roll_No, String Course, String Branch, String Semester, String Phone_No, String Address, String Gender, String Hostel_Name, String Room_No )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Enrolment_NO", Enrolment_No);
        contentValues.put("Name", Name);
        contentValues.put("Email_Id", Email_Id);
        contentValues.put(" Roll_No",  Roll_No);
        contentValues.put("Course", Course);
        contentValues.put("Branch", Branch);
        contentValues.put("Semester", Semester);
        contentValues.put("Phone_No", Phone_No);
        contentValues.put("Address", Address);
        contentValues.put("Gender", Gender);
        contentValues.put("Hostel_Name", Hostel_Name);
        contentValues.put("Room_No", Room_No);
       long result = db.insert("Hostel_Students_Data",null,contentValues);
       if(result==-1)
           return false;
       return true;
    }

    public boolean Update (String Enrolment_No, String Name, String Email_Id, String Roll_No, String Course, String Branch, String Semester, String Phone_No, String Address, String Gender, String Hostel_Name, String Room_No )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", Name);
        contentValues.put("Email_Id", Email_Id);
        contentValues.put(" Roll_No",  Roll_No);
        contentValues.put("Course", Course);
        contentValues.put("Branch", Branch);
        contentValues.put("Semester", Semester);
        contentValues.put("Phone_No", Phone_No);
        contentValues.put("Address", Address);
        contentValues.put("Gender", Gender);
        contentValues.put("Hostel_Name", Hostel_Name);
        contentValues.put("Room_No", Room_No);

        Cursor cursor = db.rawQuery("SELECT * FROM Hostel_Students_Data WHERE Enrolment_No = ?" ,new  String[]{Enrolment_No});
        if(cursor.getCount()>0){

        long result = db.update("Hostel_Students_Data",contentValues,"Enrolment_No=?", new String[] {Enrolment_No});
        if(result==-1)
            return false;
        else
        return true;}
        else
            return false;
    }

    public boolean Delete (String Enrolment_No  ) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Hostel_Students_Data WHERE Enrolment_No = ?" ,new  String[]{Enrolment_No});
        if(cursor.getCount()>0){

            long result = db.delete("Hostel_Students_Data","Enrolment_No=?", new String[] {Enrolment_No});
            if(result==-1)
                return false;
            else
                return true;}
        else
            return false;
    }

    public Cursor Show () {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Hostel_Students_Data",null);
       return cursor;
    }

}
/*
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

 */