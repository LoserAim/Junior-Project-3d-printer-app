package com.a3dprinterapp.pre_sql.a3dprinterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import static java.lang.System.in;

public class activity_login extends AppCompatActivity {

    DB_DatabaseHelper db;
    EditText Email, Password;
    Singleton_Student Account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email = (EditText) findViewById(R.id.editText2);
        Password = (EditText) findViewById(R.id.editText);
        db = new DB_DatabaseHelper(getApplicationContext());
        Account = Singleton_Student.GetInstance();
    }

    public void goToRegisterActivity (View view){
        Intent intent = new Intent (this, activity_register.class);
        startActivity(intent);
    }

    public void goToHomeActivity (View view){

        List<MD_Student> temp = db.GetAllStudents();
        String l = Email.getText().toString();
        for(MD_Student g : temp)
        {
            if (l.equals(g.GetEmail()))
            {
                if(Password.getText().toString().equalsIgnoreCase(g.GetPassword()))
                {
                Account.student.SetAdmin(0);
                Account.student.SetEmail(g.GetEmail());
                Account.student.SetPassword(g.GetPassword());
                Account.student.SetID(g.GetId());
                Account.student.SetName(null);
                db.closeDB();
                Intent intent = new Intent (this, activity_home.class);
                startActivity(intent);
                }
            }
        }

    }

}
