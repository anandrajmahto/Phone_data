package com.armscreation.phone_data;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;

public class ProfileTab extends AppCompatActivity {
    TextView fullName,phone,email;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String UserId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_tab);
        fullName = findViewById(R.id.profileName);
        phone = findViewById(R.id.profilePhone);
        email =findViewById(R.id.profileEmail);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        UserId = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();

        DocumentReference documentReference = fStore.collection("Users").document(UserId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                assert documentSnapshot != null;
                fullName.setText(documentSnapshot.getString("Full Name"));
           phone.setText(documentSnapshot.getString("Phone Number"));
           email.setText(documentSnapshot.getString("Email Id"));


            }
        });






    }

    public void LogOut(View view) {
        FirebaseAuth.getInstance().signOut();
        new UserSession(ProfileTab.this).removeUser();
        startActivity(new Intent(ProfileTab.this, Login.class));
        finish();
    }
    public void buttonMaintab(View view) {

        startActivity(new Intent(ProfileTab.this, MainTab.class));
        finish();
    }
}