package com.example.database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new DatabaseHelper(this);
        btn1=(Button) findViewById(R.id.button1);

    }

    public void demo1(View view) {
        startActivity(new Intent(this,MainActivity1.class));
    }

    public void demo2(View view) {
        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);

    }

    public void demo3(View view) {
        Cursor res = mydb.getAllData();
        showMessage("Number of rows","Total records : "+res.getCount());
    }

    public void demo4(View view) {
        Intent intent =new Intent(MainActivity.this,MainActivity3.class);
        startActivity(intent);
    }

    private void showMessage(String m, String message) {
        AlertDialog dig = new AlertDialog.Builder(MainActivity.this)
                .setTitle(m)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        dig.show();
    }
}