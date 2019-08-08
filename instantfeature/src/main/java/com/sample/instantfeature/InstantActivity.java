package com.sample.instantfeature;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InstantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instant);

        Uri data = this.getIntent().getData();
        TextView textView = findViewById(R.id.textView);
        textView.setText(data.toString());
    }
}
