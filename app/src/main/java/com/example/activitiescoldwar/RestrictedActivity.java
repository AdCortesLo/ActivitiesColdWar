package com.example.activitiescoldwar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RestrictedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restricted);

        TextView tv = findViewById(R.id.textViewScrollView);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setResult(RESULT_OK);
                finish();
                return true;
            }
        });
    }

    public void onClickBack(View view){
        Intent i = new Intent();
        setResult(RESULT_CANCELED,i);
        finish();
    }
}
