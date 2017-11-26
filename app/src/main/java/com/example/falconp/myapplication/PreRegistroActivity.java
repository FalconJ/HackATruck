package com.example.falconp.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.example.falconp.myapplication.Models.PreRegistro;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by FalconP on 25/11/2017.
 */

public class PreRegistroActivity extends BaseActivity
    implements View.OnClickListener{

    EditText mNoCaja;
    EditText mLineaCaja;
    EditText mNoTractor;
    EditText mLineaTractor;
    EditText mRemolque;
    EditText mPlacasCaja;
    EditText mOperador;
    EditText mEstado;
    EditText mPlacas;
    EditText mTemperatura;
    EditText mEscala;
    EditText mMotorObs;
    EditText mCabinaObs;

    Switch mCabina, mMotor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_registro);

        // EditText
        mNoCaja = findViewById(R.id.et_numcaja);
        mLineaCaja = findViewById(R.id.et_lineacaja);
        mNoTractor = findViewById(R.id.et_numtractor);
        mLineaTractor = findViewById(R.id.et_lineatractor);
        mRemolque = findViewById(R.id.et_remolque);
        mPlacasCaja = findViewById(R.id.et_placascaja);
        mOperador = findViewById(R.id.et_nombre);
        mEstado = findViewById(R.id.et_estado);
        mPlacas = findViewById(R.id.et_placas);
        mTemperatura = findViewById(R.id.et_temperatura);
        mEscala = findViewById(R.id.et_escala);
        mMotorObs = findViewById(R.id.et_motor_obs);
        mCabinaObs = findViewById(R.id.et_cabina_obs);

        mCabina = findViewById(R.id.sw_cabina);
        mMotor = findViewById(R.id.sw_motor);

        findViewById(R.id.bt_preregis).setOnClickListener(this);
    }

    private void saveInDatabase(){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("preregistro");
        String userId = mDatabase.push().getKey();

        PreRegistro registro = new PreRegistro(
                mNoCaja.getText().toString(),
                mLineaCaja.getText().toString(),
                mNoTractor.getText().toString(),
                mLineaTractor.getText().toString(),
                mRemolque.getText().toString(),
                mPlacasCaja.getText().toString(),
                mOperador.getText().toString(),
                mEstado.getText().toString(),
                mPlacas.getText().toString(),
                mTemperatura.getText().toString(),
                mEscala.getText().toString(),
                mMotor.isChecked(),
                mMotorObs.getText().toString(),
                mCabina.isChecked(),
                mCabinaObs.getText().toString()
        );

        mDatabase.child(userId).setValue(registro);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if(i == R.id.bt_preregis){
            saveInDatabase();
        }
    }
}
