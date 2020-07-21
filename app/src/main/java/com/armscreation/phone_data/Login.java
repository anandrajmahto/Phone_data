package com.armscreation.phone_data;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;


    EditText mEmail, mPassword;
    Button mLoginBtn;
    ProgressBar progressBar;
    TextView textResetPassword;
    FirebaseAuth fAuth;
    private boolean isShowPassword = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        checkAndRequestPermissions();

        mEmail = findViewById(R.id.loginEmailId);
        mPassword = findViewById(R.id.loginPassword);
        mLoginBtn = findViewById(R.id.LoginBtn);
        textResetPassword = findViewById(R.id.Resetbtn);

        progressBar = findViewById(R.id.progressBar3);
        fAuth = FirebaseAuth.getInstance();

            Button showpass = findViewById(R.id.btnShow);
            showpass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isShowPassword) {
                        mPassword.setTransformationMethod(new PasswordTransformationMethod());

                        isShowPassword = false;
                    } else {
                        mPassword.setTransformationMethod(null);

                        isShowPassword = true;
                    }
                }
            });

            mLoginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final String email = mEmail.getText().toString().trim();
                    String password = mPassword.getText().toString().trim();

                    if (TextUtils.isEmpty(email)) {
                        mEmail.setError("Email is Required");
                        return;
                    }

                    if (TextUtils.isEmpty(password)) {
                        mPassword.setError("Password is Required");
                        return;
                    }


                    if (password.length() < 6) {
                        mPassword.setError("Password must be more than 6 character");
                        return;
                    }

                    progressBar.setVisibility(View.VISIBLE);

                    // authenticate the user


                    fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //  Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                UserSession userSession = new UserSession(Login.this);
                                userSession.setEmail(email);
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("name", userSession.getEmail());
                                startActivity(intent);
                                finish();

                            } else {
                                Toast.makeText(Login.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }


                        }
                    });
                }
            });


            Button CreateUserBtn = findViewById(R.id.CreateUserBtn);
            CreateUserBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), CreateUser.class);
                    startActivity(intent);
                    finish();
                }
            });


            textResetPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final EditText input = new EditText(getApplicationContext());
                    AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(Login.this, R.style.myDialog));
                    builder.setTitle("Forget Password")
                            .setMessage("Enter Your Email to Reset the Password.")
                            .setView(input)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Editable value = input.getText();

                                    FirebaseAuth auth = FirebaseAuth.getInstance();
                                    String emailaddress = String.valueOf(input.getText());
                                    auth.sendPasswordResetEmail(emailaddress)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        //    Log.d(TAG, "Email sent.");
                                                        Toast.makeText(getApplicationContext(), "Check Your Email", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });


                                }
                            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            // Do nothing.
                        }
                    }).show();

                    // Do something with value!


                }
            });




    }

    private boolean checkAndRequestPermissions() {
        List<String> listPermissionsNeeded = new ArrayList<>();

        //permission Name  Add your permission
        int per1 = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_SMS);
        int per2 = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CALL_LOG);

        //Check permission   Check your permission
        if (per1 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.READ_SMS);
        }
        if (per2 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.READ_CALL_LOG);
        }



        //Grant permission   Nothing to do here
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

}