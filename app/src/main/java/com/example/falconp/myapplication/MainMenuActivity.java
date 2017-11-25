package com.example.falconp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by FalconP on 25/11/2017.
 */

public class MainMenuActivity extends BaseActivity
        implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainmenu);



        //Buttons
        findViewById(R.id.logout_btn).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void signOut() {
        super.signOut();

        finishAffinity();
        startActivity(new Intent(MainMenuActivity.this, MainActivity.class));
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if(i == R.id.logout_btn){
            signOut();
        }
    }
}
