package com.example.falconp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FalconP on 25/11/2017.
 */

public class RegistroActivity extends BaseActivity
    implements View.OnClickListener{

    DatabaseReference mDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registropatio);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("pregistro");
        updateTrucks(mDatabase);

        findViewById(R.id.btnSubmit).setOnClickListener(this);
    }

    public void updateTrucks(DatabaseReference mRef){
        Query query = mRef.orderByChild("placas");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<String> placas = new ArrayList<>();
                for(DataSnapshot message: dataSnapshot.getChildren()){
                    String matricula = message.child("placas").getValue(String.class);
                    placas.add(matricula);
                }

                Spinner mats = (Spinner) findViewById(R.id.spinnerTrailer);
                ArrayAdapter<String> matAdapter = new ArrayAdapter<String>(RegistroActivity.this, android.R.layout.simple_spinner_item, placas);
                matAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                mats.setAdapter(matAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void fillSection(){
        Spinner mSection = findViewById(R.id.spinnerSection);
        String option = mSection.getSelectedItem().toString();
        int pos = mSection.getSelectedItemPosition();
        String[] values = getResources().getStringArray(R.array.size_values);
        int size = Integer.valueOf(values[pos]);
        Intent intent;
        switch (size){
            case 1:
                intent = new Intent(RegistroActivity.this, FirstSectionActivity.class);
                break;
            case 2:
                intent = new Intent(RegistroActivity.this, SecondSectionActivity.class);
                break;
            case 3:
                intent = new Intent(RegistroActivity.this, ThirdSectionActivity.class);
                break;
            default:
                intent = null;
        }

        if(intent != null){
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if(i == R.id.btnSubmit){
            fillSection();
        }
    }
}
