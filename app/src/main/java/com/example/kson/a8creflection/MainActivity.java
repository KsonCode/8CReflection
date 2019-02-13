package com.example.kson.a8creflection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kson.a8creflection.butterknife.BindView;
import com.example.kson.a8creflection.butterknife.ButterKnife;
import com.example.kson.a8creflection.butterknife.ContentView;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.setContentView(R.layout.activity_main);
//
//        tv = findViewById(R.id.tv);
        ButterKnife.bind(this);

        tv.setText("kson1111111");
    }
}
