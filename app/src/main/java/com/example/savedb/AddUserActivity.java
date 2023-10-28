package com.example.savedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddUserActivity extends AppCompatActivity {

    EditText name, dob, email, imgUrl;
    Button btnSave, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        name = (EditText) findViewById(R.id.nameTextView);
        dob = (EditText) findViewById(R.id.dobTextView);
        email = (EditText) findViewById(R.id.emailTextView);
        imgUrl=(EditText) findViewById(R.id.imgUrl);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
                clear();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void clear(){
        name.setText("");
        dob.setText("");
        email.setText("");
        imgUrl.setText("");
    }
    private void addUser(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("dob", dob.getText().toString());
        map.put("email", email.getText().toString());
        map.put("imgUrl", imgUrl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("User").push()
                .setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddUserActivity.this, "Add a new user successfully !", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure( Exception e) {
                        Toast.makeText(AddUserActivity.this, "Have Errors", Toast.LENGTH_LONG).show();
                    }
                });
    }
}