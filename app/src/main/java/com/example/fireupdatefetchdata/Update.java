package com.example.fireupdatefetchdata;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Update extends AppCompatActivity {
    Button SubmitButton;
    ProgressDialog progressDialog;
    List<StudentDetails> list = new ArrayList<>();
    EditText NameEditText, PhoneNumberEditText;
    String change, key="person",id="studentName";
            String NameHolder;

    DatabaseReference databaseReference1;
    public static final String Database_Path = "Student_Details_Database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        SubmitButton = (Button) findViewById(R.id.submit1);

        NameEditText = (EditText) findViewById(R.id.name1);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentDetails studentDetails = new StudentDetails();
                NameHolder = NameEditText.getText().toString().trim();
               databaseReference1=FirebaseDatabase.getInstance().getReference(Database_Path);
                studentDetails.setStudentName(NameHolder);
               databaseReference1.child("NLGb-qNHU8t8T9fBRPu").child("studentName").updateChildren((Map<String, Object>) studentDetails);
            }
        });
    }

}
