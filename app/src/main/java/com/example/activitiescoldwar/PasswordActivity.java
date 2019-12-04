package com.example.activitiescoldwar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class PasswordActivity extends AppCompatActivity {

    public LinearLayout cl;
    public static String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        cl = findViewById(R.id.LayoutPassword);
        password = "1111";
    }

    public void onClickNext(View view) {
        EditText et = findViewById(R.id.editTextPassword);
        if (password.equals(et.getText().toString()))
            launchWelcomeActivity(view);
        else
            launchRestrictedActivity(view);
    }

    public void launchWelcomeActivity(View view) {
        Intent i = new Intent(this, WelcomeActivity.class);
        i.putExtra("password", password);
        startActivityForResult(i,1);

    }

    public void launchRestrictedActivity(View view) {
        Intent i = new Intent(this, RestrictedActivity.class);
        startActivityForResult(i,2);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EditText et = findViewById(R.id.editTextPassword);

        if (resultCode == RESULT_OK){
            if (requestCode == 2) {
                Log.i("123", "entra");
                cl.setBackgroundColor(Color.CYAN);
                Log.i("123", "entra despres color");

            }
            else if (requestCode == 1) {
                try {
                    password = data.getStringExtra("password");
                    et.setText(password);
                } catch (Exception ex) {

                }
            }

            else {


            }
        }
    }
}
