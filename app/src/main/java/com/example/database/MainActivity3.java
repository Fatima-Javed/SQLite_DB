package com.example.database;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3  extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText E_id,E_name,E_surname,E_marks,E_contact,E_email,E_department,E_address;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();
        mydb = new DatabaseHelper(this);
        E_id = (EditText) findViewById(R.id.Id);
        E_name = (EditText) findViewById(R.id.person);
        E_surname = (EditText) findViewById(R.id.surname);
        E_marks = (EditText) findViewById(R.id.marks);
        E_contact = (EditText) findViewById(R.id.contact);
        E_email = (EditText) findViewById(R.id.email);
        E_department = (EditText) findViewById(R.id.department);
        E_address = (EditText) findViewById(R.id.address);
        btn1 = (Button) findViewById(R.id.button1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean Update = mydb.updateData(E_id.getText().toString(), E_name.getText().toString(), E_surname.getText().toString(), E_marks.getText().toString(), E_contact.getText().toString(), E_email.getText().toString(), E_department.getText().toString(), E_address.getText().toString());

                if (Update == true)
                    Toast.makeText(MainActivity3.this, "Data updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity3.this, "Data not updated", Toast.LENGTH_LONG).show();
            }
        });
    }
}

