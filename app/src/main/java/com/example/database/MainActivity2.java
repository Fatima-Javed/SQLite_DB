package com.example.database;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2  extends AppCompatActivity {

    DatabaseHelper mydb;
    ListView listView;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mydb=new DatabaseHelper(this);

        Cursor res = mydb.getAllData();
        if (res.getCount() == 0) {
            showMessage("Error", "Nothing found");
            return;
        }

        ArrayList<String> arrayList = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            count++;
            listView = (ListView) findViewById(R.id.listview);
            arrayList.add("\nID : " + res.getString(0) + "\nName : " + res.getString(1) + "\nSurname : " + res.getString(2) + "\nMARKS : " + res.getString(3) + "\nCONTACT : " + res.getString(4) + "\n"+"EMAIL : "+res.getString(5)+"\n"+"DEPARTMENT : "+res.getString(6)+ "\n"+"ADDRESS :"+res.getString(7)+"\n\n");

        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);
    }




        private void showMessage(String s, String message) {
            AlertDialog dig = new AlertDialog.Builder(MainActivity2.this)
                    .setTitle(s)
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
