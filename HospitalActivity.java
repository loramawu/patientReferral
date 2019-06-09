package com.example.emergencyreferralrhodes;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class HospitalActivity extends AppCompatActivity {

    private EditText HName;
    private EditText HTown;
    private EditText HDistrict;

    private Button Add;
    private FirebaseFirestore addFirebase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        HName = findViewById(R.id.nameText);
        HTown = findViewById(R.id.townText);
        HDistrict = findViewById(R.id.districtText);


        addFirebase = FirebaseFirestore.getInstance();

        Add = findViewById(R.id.add);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = HName.toString().trim();
                String town = HTown.toString().trim();
                String district = HDistrict.toString().trim();

                if (!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(town) && !TextUtils.isEmpty(district)){

                    Map<String, Object> hospitalAdd = new HashMap<>();
                    hospitalAdd.put("name", HName);
                    hospitalAdd.put("town", HTown);
                    hospitalAdd.put("district", HDistrict);



                    addFirebase.collection("Hospital").add(hospitalAdd).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {

                            Toast.makeText(HospitalActivity.this, "Hospital Added...", Toast.LENGTH_SHORT).show();
                            Intent main = new Intent(HospitalActivity.this,MainActivity.class);
                            startActivity(main);
                            finish();

                        }
                    });
                }
            }
        });





    }
}
