package com.example.activitiescoldwar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    public static String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        password = getIntent().getStringExtra("password");
        TextView tv = findViewById(R.id.textViewWelcome);
        tv.setText(tv.getText() + " " + password + "!");

    }

    public void onCheckboxClick(View view) {
        CheckBox cb = findViewById(R.id.changepwdCheckbox);
        EditText etPass = findViewById(R.id.editTextChangePassword);
        if (cb.isChecked()) {
            etPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        else {
            etPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public void openWeb (View view) {
        Uri uriUrl = Uri.parse("http://en.roscosmos.ru/");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void onClickDone(View view) {
        CheckBox cb = findViewById(R.id.changepwdCheckbox);
        if (cb.isChecked()) {
            EditText et = findViewById(R.id.editTextChangePassword);
            Intent i = new Intent();
            i.putExtra("password", et.getText().toString());
            setResult(RESULT_OK, i);
            finish();
        }
        else {
            finish();
        }
    }
}
