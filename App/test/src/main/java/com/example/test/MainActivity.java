package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;

import com.example.test.fragment.addFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment firstFragment = new addFragment();
        firstFragment.setArguments(getIntent().getExtras());
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.fragment_container, firstFragment)
//                .commit();
    }



}
