package com.example.falconp.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by FalconP on 25/11/2017.
 */

public class FirstSectionActivity extends BaseActivity
    implements View.OnClickListener{

    private Switch mDefensa;
    private EditText mObservacion_1;
    private Switch mCabina;
    private EditText mObservacion_2;
    private Switch mMotor;
    private EditText mObservacion_3;
    private Switch mTanqueCombustible;
    private EditText mObservacion_4;
    private Switch mCabinaHerramienta;
    private EditText mObservacion_5;
    private Switch mCompresor;
    private EditText mObservacion_6;
    private Switch mFrenos;
    private EditText mObservacion_7;

    FirebaseUser user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.seccion_1);

        // Switches
        mDefensa = findViewById(R.id.sw_defensa);
        mCabina = findViewById(R.id.sw_pisocabina);
        mMotor = findViewById(R.id.sw_motor);
        mTanqueCombustible = findViewById(R.id.sw_tanquecombustible);
        mCabinaHerramienta = findViewById(R.id.sw_cabinaherramineta);
        mCompresor = findViewById(R.id.sw_compresor);
        mFrenos = findViewById(R.id.sw_frenosabs);

        // Edit Texts
        mObservacion_1 = findViewById(R.id.et_obs1);
        mObservacion_2 = findViewById(R.id.et_obs2);
        mObservacion_3 = findViewById(R.id.et_obs3);
        mObservacion_4 = findViewById(R.id.et_obs4);
        mObservacion_5 = findViewById(R.id.et_obs5);
        mObservacion_6 = findViewById(R.id.et_obs6);
        mObservacion_7 = findViewById(R.id.et_obs7);

        //Buttons
        findViewById(R.id.bt_registrar).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        user = mAuth.getCurrentUser();
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if(i == R.id.bt_registrar){

        }
    }
}
