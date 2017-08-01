package com.example.taruc.lab4_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void saveRecord(View v){
        EditText editTextPhone, editTextName, editTextEmail;

        editTextPhone = (EditText)findViewById(R.id.editTextPhone);
        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);

        UserRecord userRecord = new UserRecord();
        userRecord.setPhone(editTextPhone.getText().toString());
        userRecord.setName(editTextName.getText().toString());
        userRecord.setEmail(editTextEmail.getText().toString());

        UserSQLHelper userDataSource = new UserSQLHelper(this);
        userDataSource.insertUser(userRecord);

        this.finish(); //Terminate this Activity
    }

}
