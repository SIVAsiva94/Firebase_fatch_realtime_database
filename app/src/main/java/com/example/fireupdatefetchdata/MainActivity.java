package com.example.fireupdatefetchdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button SubmitButton ;

    Button DisplayButton;

    EditText NameEditText, PhoneNumberEditText;
    String NameHolder, NumberHolder;
  String Date;


    DatabaseReference databaseReference;
    public static final String Database_Path = "Student_Details_Database";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        SubmitButton = (Button)findViewById(R.id.submit);

        NameEditText = (EditText)findViewById(R.id.name);
        DisplayButton = (Button)findViewById(R.id.DisplayButton);
        PhoneNumberEditText = (EditText)findViewById(R.id.phone_number);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StudentDetails studentDetails = new StudentDetails();

                GetDataFromEditText();


                studentDetails.setStudentName(NameHolder);


                studentDetails.setStudentPhoneNumber(NumberHolder);

                String StudentRecordIDFromServer = databaseReference.push().getKey();


                databaseReference.child(StudentRecordIDFromServer).setValue(studentDetails);

                Toast.makeText(MainActivity.this,"Data Inserted Successfully into Firebase Database", Toast.LENGTH_LONG).show();
            }
        });
        DisplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Update.class);
                startActivity(intent);

            }
        });

    }

    public void GetDataFromEditText(){
        NameHolder = NameEditText.getText().toString().trim();
        NumberHolder = PhoneNumberEditText.getText().toString().trim();
    }
}