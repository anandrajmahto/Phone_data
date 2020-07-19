package com.armscreation.phone_data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class Join extends AppCompatActivity {
    TextView turn_dis;
    EditText input_room_codee;
    Button reset_btn, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24, button25;
    Boolean Turn;
    String input_room_code;
    Button[] array = new Button[26];
    ImageView connection_check;
    Button connect;
    Thread myThread;
    private DatabaseReference mDatabase;
    private int flag;
    private int chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        reset_btn = findViewById(R.id.reset_btn);
        flag = 1;
        turn_dis = findViewById(R.id.turn_dis);
        connect = findViewById(R.id.btnConnect);
        connection_check = findViewById(R.id.connection_check);
        Turn = false;
        input_room_code = "0";
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        button23 = findViewById(R.id.button23);
        button24 = findViewById(R.id.button24);
        button25 = findViewById(R.id.button25);
        array[0] = button1;
        array[1] = button2;
        array[2] = button3;
        array[3] = button4;
        array[4] = button5;
        array[5] = button6;
        array[6] = button7;
        array[7] = button8;
        array[8] = button9;
        array[9] = button10;
        array[10] = button11;
        array[11] = button12;
        array[12] = button13;
        array[13] = button14;
        array[14] = button15;
        array[15] = button16;
        array[16] = button17;
        array[17] = button18;
        array[18] = button19;
        array[19] = button20;
        array[20] = button21;
        array[21] = button22;
        array[22] = button23;
        array[23] = button24;
        array[24] = button25;


        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetData();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(0);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button1.getText().toString().equals("X") && Turn) {
                    UpdateData(button1.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(1);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button2.getText().toString().equals("X") && Turn) {
                    UpdateData(button2.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(2);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button3.getText().toString().equals("X") && Turn) {
                    UpdateData(button3.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(3);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button4.getText().toString().equals("X") && Turn) {
                    UpdateData(button4.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(4);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button5.getText().toString().equals("X") && Turn) {
                    UpdateData(button5.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(5);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button6.getText().toString().equals("X") && Turn) {
                    UpdateData(button6.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(6);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button7.getText().toString().equals("X") && Turn) {
                    UpdateData(button7.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(7);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button8.getText().toString().equals("X") && Turn) {
                    UpdateData(button8.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(8);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button9.getText().toString().equals("X") && Turn) {
                    UpdateData(button9.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(9);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button10.getText().toString().equals("X") && Turn) {
                    UpdateData(button10.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(10);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button11.getText().toString().equals("X") && Turn) {
                    UpdateData(button11.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(11);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button12.getText().toString().equals("X") && Turn) {
                    UpdateData(button12.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(12);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button13.getText().toString().equals("X") && Turn) {
                    UpdateData(button13.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(13);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button14.getText().toString().equals("X") && Turn) {
                    UpdateData(button14.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(14);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button15.getText().toString().equals("X") && Turn) {
                    UpdateData(button15.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(15);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button16.getText().toString().equals("X") && Turn) {
                    UpdateData(button16.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(16);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button17.getText().toString().equals("X") && Turn) {
                    UpdateData(button17.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(17);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button18.getText().toString().equals("X") && Turn) {
                    UpdateData(button18.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(18);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button19.getText().toString().equals("X") && Turn) {
                    UpdateData(button19.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(19);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button20.getText().toString().equals("X") && Turn) {
                    UpdateData(button20.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(20);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button21.getText().toString().equals("X") && Turn) {
                    UpdateData(button21.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(21);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button22.getText().toString().equals("X") && Turn) {
                    UpdateData(button22.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(22);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button23.getText().toString().equals("X") && Turn) {
                    UpdateData(button23.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(23);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button24.getText().toString().equals("X") && Turn) {
                    UpdateData(button24.getText().toString());
                    check();
                }
                if (chk == 25) {
                    chk = 26;
                }
            }
        });
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean chkk = btn(24);
                if (chkk) {
                    chk++;
                }

                if (chk > 25 && !button25.getText().toString().equals("X") && Turn) {
                    UpdateData(button25.getText().toString());
                    check();
                    // Toast.makeText(Join.this, chk, Toast.LENGTH_SHORT).show();
                }
            }
        });
        /**
         button1.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        if (button1.getText().equals(" ") && Turn) {
        button1.setText("O");

        button1.setTextColor(Color.parseColor("#A6FF0000"));

        UpdateData("g1");
        // check();
        }
        }
        });
         button2.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        if (button2.getText().equals(" ") && Turn) {
        button2.setText("O");

        button2.setTextColor(Color.parseColor("#A6FF0000"));

        UpdateData("g2");
        // check();
        }
        }
        });
         button3.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        if (button3.getText().equals(" ") && Turn) {
        button3.setText("O");

        button3.setTextColor(Color.parseColor("#A6FF0000"));

        UpdateData("g3");
        //  check();
        }
        }
        });
         button4.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        if (button4.getText().equals(" ") && Turn) {
        button4.setText("O");

        button4.setTextColor(Color.parseColor("#A6FF0000"));

        UpdateData("g4");
        //    check();
        }
        }
        });
         button5.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        if (button5.getText().equals(" ") && Turn) {
        button5.setText("O");

        button5.setTextColor(Color.parseColor("#A6FF0000"));

        UpdateData("g5");
        //  check();
        }
        }
        });
         button6.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        if (button6.getText().equals(" ") && Turn) {
        button6.setText("O");

        button6.setTextColor(Color.parseColor("#A6FF0000"));

        UpdateData("g6");
        // check();
        }
        }
        });
         button7.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        if (button7.getText().equals(" ") && Turn) {
        button7.setText("O");

        button7.setTextColor(Color.parseColor("#A6FF0000"));

        UpdateData("g7");
        //   check();
        }
        }
        });
         button8.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        if (button8.getText().equals(" ") && Turn) {
        button8.setText("O");

        button8.setTextColor(Color.parseColor("#A6FF0000"));

        UpdateData("g8");
        //   check();
        }
        }
        });
         button9.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        if (button9.getText().equals(" ") && Turn) {
        button9.setText("O");

        button9.setTextColor(Color.parseColor("#A6FF0000"));

        UpdateData("g9");
        //   check();
        }
        }
        });
         **/
        mDatabase = FirebaseDatabase.getInstance().getReference();
        input_room_codee = findViewById(R.id.input_room_code);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                input_room_code = input_room_codee.getText().toString();
                if (!(input_room_codee.getText().toString().isEmpty())) {
                    hideKeyboard((Button) view);

                    mDatabase.child("Room_id").child(input_room_code).addValueEventListener(new ValueEventListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.getValue() != null) {
                                connect.setVisibility(View.INVISIBLE);
                                input_room_codee.setVisibility(View.INVISIBLE);
                                connection_check.setVisibility(View.VISIBLE);
                                reset_btn.setVisibility(View.VISIBLE);
                                mDatabase.child("Room_id").child(input_room_code).child("Moves").child("Turn").setValue("online");

                            } else {

                                reset_btn.setVisibility(View.INVISIBLE);
                                connect.setVisibility(View.VISIBLE);
                                turn_dis.setText(" ");
                                input_room_codee.setVisibility(View.VISIBLE);
                                clean();
                                connection_check.setVisibility(View.INVISIBLE);

                                Toast.makeText(Join.this, "Invalid Room Code", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Join.this, "error", Toast.LENGTH_SHORT).show();

                        }
                    });

                    mDatabase.child("Room_id").child(input_room_code).child("Turn").addValueEventListener(new ValueEventListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.getValue() != null) {
                                DataAdapter user = dataSnapshot.getValue(DataAdapter.class);

                                assert user != null;
                                if (user.getTurn().equals("2")) {
                                    Turn = true;
                                    turn_dis.setText("Your Turn");
                                } else if (user.getTurn().equals("1")) {
                                    turn_dis.setText("Your Opponent Turn");
                                    Turn = false;
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Join.this, "error", Toast.LENGTH_SHORT).show();

                        }
                    });

                    mDatabase.child("Room_id").child(input_room_code).child("Moves").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.getValue() != null) {
                                DataAdapter user = dataSnapshot.getValue(DataAdapter.class);


                                assert user != null;
                                String choice="30";
                                choice = user.getG1();
                                if (choice==null){
                                    choice="30";
                                }
                                //  Toast.makeText(Host.this, choice, Toast.LENGTH_SHORT).show();
                                Log.d("myTag", choice);
                                switch (choice) {
                                    case "1":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("1")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "2":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("2")) {
                                                array[i].setText("X");
                                            }
                                        }
                                        check();
                                        break;


                                    case "3":

                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("3")) {
                                                array[i].setText("X");
                                            }
                                        }
                                        check();
                                        break;


                                    case "4":

                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("4")) {
                                                array[i].setText("X");
                                            }
                                        }
                                        check();
                                        break;


                                    case "5":

                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("5")) {
                                                array[i].setText("X");
                                            }
                                        }
                                        check();
                                        break;


                                    case "6":

                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("6")) {
                                                array[i].setText("X");
                                            }
                                        }
                                        check();
                                        break;


                                    case "7":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("7")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "8":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("8")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "9":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("9")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "10":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("10")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "11":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("11")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "12":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("12")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "13":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("13")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "14":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("14")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "15":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("15")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "16":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("16")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "17":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("17")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "18":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("18")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "19":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("19")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "20":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("20")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "21":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("21")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "22":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("22")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "23":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("23")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "24":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("24")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;


                                    case "25":
                                        for (int i = 0; i < 25; i++) {
                                            if (array[i].getText().toString().equals("25")) {
                                                array[i].setText("X");
                                            }
                                        }

                                        check();
                                        break;
                                    default:
                                        check();
                                }
                                if (chk == 25) {
                                    chk = 26;
                                }

                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Join.this, "error", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
        // if (connection.getText()!=null){
        //Getting Values(Turn)


        //}

    }

    private void UpdateData(String g) {

        mDatabase.child("Room_id").child(input_room_code).child("Moves").child("g1").setValue(g);
        DataAdapter user2 = new DataAdapter("1", "Connected");
        mDatabase.child("Room_id").child(input_room_code).child("Turn").setValue(user2);

    }

    public void thread(final int i) {
        cleanO(i);
/**
 myThread = new Thread() {
@Override
public void run() {
try {
cleanO(i);
sleep(2000);


} catch (InterruptedException e) {
e.printStackTrace();
}

//Toast.makeText(getApplicationContext(),"mesage",Toast.LENGTH_SHORT).show();
}
};
 myThread.start();
 **/
    }

    public void check() {


        if (button1.getText().equals("X") && button2.getText().equals("X") && button3.getText().equals("X") && button4.getText().equals("X") && button5.getText().equals("X")) {

            thread(1);
            thread(2);
            thread(3);
            thread(4);
            thread(5);
        }
        if (button6.getText().equals("X") && button7.getText().equals("X") && button8.getText().equals("X") && button9.getText().equals("X") && button10.getText().equals("X")) {

            thread(6);
            thread(7);
            thread(8);
            thread(9);
            thread(10);
        }
        if (button11.getText().equals("X") && button12.getText().equals("X") && button13.getText().equals("X") && button14.getText().equals("X") && button15.getText().equals("X")) {

            thread(11);
            thread(12);
            thread(13);
            thread(14);
            thread(15);
        }
        if (button16.getText().equals("X") && button17.getText().equals("X") && button18.getText().equals("X") && button19.getText().equals("X") && button20.getText().equals("X")) {

            thread(16);
            thread(17);
            thread(18);
            thread(19);
            thread(20);
        }
        if (button21.getText().equals("X") && button22.getText().equals("X") && button23.getText().equals("X") && button24.getText().equals("X") && button25.getText().equals("X")) {

            thread(21);
            thread(22);
            thread(23);
            thread(24);
            thread(25);
        }
        if (button1.getText().equals("X") && button6.getText().equals("X") && button11.getText().equals("X") && button16.getText().equals("X") && button21.getText().equals("X")) {

            thread(1);
            thread(6);
            thread(11);
            thread(16);
            thread(21);
        }
        if (button2.getText().equals("X") && button7.getText().equals("X") && button12.getText().equals("X") && button17.getText().equals("X") && button22.getText().equals("X")) {

            thread(2);
            thread(7);
            thread(12);
            thread(17);
            thread(22);
        }
        if (button3.getText().equals("X") && button8.getText().equals("X") && button13.getText().equals("X") && button18.getText().equals("X") && button23.getText().equals("X")) {

            thread(3);
            thread(8);
            thread(13);
            thread(18);
            thread(23);
        }
        if (button4.getText().equals("X") && button9.getText().equals("X") && button14.getText().equals("X") && button19.getText().equals("X") && button24.getText().equals("X")) {

            thread(4);
            thread(9);
            thread(14);
            thread(19);
            thread(24);
        }
        if (button5.getText().equals("X") && button10.getText().equals("X") && button15.getText().equals("X") && button20.getText().equals("X") && button25.getText().equals("X")) {

            thread(5);
            thread(10);
            thread(15);
            thread(20);
            thread(25);
        }
        if (button1.getText().equals("X") && button7.getText().equals("X") && button13.getText().equals("X") && button19.getText().equals("X") && button25.getText().equals("X")) {

            thread(1);
            thread(7);
            thread(13);
            thread(19);
            thread(25);
        }
        if (button5.getText().equals("X") && button9.getText().equals("X") && button13.getText().equals("X") && button17.getText().equals("X") && button21.getText().equals("X")) {

            thread(5);
            thread(9);
            thread(13);
            thread(17);
            thread(21);
        }

    }

    private void ResetData() {
        mDatabase.child("Room_id").child(input_room_code).child("Moves").child("g1").setValue(" ");


        int min = 1;
        int max = 2;

        Random r = new Random();
        final int i = r.nextInt(max - min + 1) + min;
        if (i == 1) {
            DataAdapter user2 = new DataAdapter("1", "Connected");
            mDatabase.child("Room_id").child(input_room_code).child("Turn").setValue(user2);
            Turn = false;
        } else {
            DataAdapter user2 = new DataAdapter("2", "Connected");
            mDatabase.child("Room_id").child(input_room_code).child("Turn").setValue(user2);
            Turn = true;
        }
        clean();
    }

    void clean() {
        button1.setText(" ");
        button2.setText(" ");
        button3.setText(" ");
        button4.setText(" ");
        button5.setText(" ");
        button6.setText(" ");
        button7.setText(" ");
        button8.setText(" ");
        button9.setText(" ");
        button10.setText(" ");
        button11.setText(" ");
        button12.setText(" ");
        button13.setText(" ");
        button14.setText(" ");
        button15.setText(" ");
        button16.setText(" ");
        button17.setText(" ");
        button18.setText(" ");
        button19.setText(" ");
        button20.setText(" ");
        button21.setText(" ");
        button22.setText(" ");
        button23.setText(" ");
        button24.setText(" ");
        button25.setText(" ");
        flag = 1;
        chk = 0;
        button1.setTextColor(Color.parseColor("#473e3e"));
        button2.setTextColor(Color.parseColor("#473e3e"));
        button3.setTextColor(Color.parseColor("#473e3e"));
        button4.setTextColor(Color.parseColor("#473e3e"));
        button5.setTextColor(Color.parseColor("#473e3e"));
        button6.setTextColor(Color.parseColor("#473e3e"));
        button7.setTextColor(Color.parseColor("#473e3e"));
        button8.setTextColor(Color.parseColor("#473e3e"));
        button9.setTextColor(Color.parseColor("#473e3e"));
        button10.setTextColor(Color.parseColor("#473e3e"));
        button11.setTextColor(Color.parseColor("#473e3e"));
        button12.setTextColor(Color.parseColor("#473e3e"));
        button13.setTextColor(Color.parseColor("#473e3e"));
        button14.setTextColor(Color.parseColor("#473e3e"));
        button15.setTextColor(Color.parseColor("#473e3e"));
        button16.setTextColor(Color.parseColor("#473e3e"));
        button17.setTextColor(Color.parseColor("#473e3e"));
        button18.setTextColor(Color.parseColor("#473e3e"));
        button19.setTextColor(Color.parseColor("#473e3e"));
        button20.setTextColor(Color.parseColor("#473e3e"));
        button21.setTextColor(Color.parseColor("#473e3e"));
        button22.setTextColor(Color.parseColor("#473e3e"));
        button23.setTextColor(Color.parseColor("#473e3e"));
        button24.setTextColor(Color.parseColor("#473e3e"));
        button25.setTextColor(Color.parseColor("#473e3e"));


    }


    void cleanO(int i) {
        if (i == 1) {
            button1.setText("X");
            button1.setTextColor(Color.parseColor("#A6FF0000"));
        }
        if (i == 2) {
            button2.setText("X");
            button2.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 3) {
            button3.setText("X");
            button3.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 4) {
            button4.setText("X");
            button4.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 5) {
            button5.setText("X");
            button5.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 6) {
            button6.setText("X");
            button6.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 7) {
            button7.setText("X");
            button7.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 8) {
            button8.setText("X");
            button8.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 9) {
            button9.setText("X");
            button9.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 10) {
            button10.setText("X");
            button10.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 11) {
            button11.setText("X");
            button11.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 12) {
            button12.setText("X");
            button12.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 13) {
            button13.setText("X");
            button13.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 14) {
            button14.setText("X");
            button14.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 15) {
            button15.setText("X");
            button15.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 16) {
            button16.setText("X");
            button16.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 17) {
            button17.setText("X");
            button17.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 18) {
            button18.setText("X");
            button18.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 19) {
            button19.setText("X");
            button19.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 20) {
            button20.setText("X");
            button20.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 21) {
            button21.setText("X");
            button21.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 22) {
            button22.setText("X");
            button22.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 23) {
            button23.setText("X");
            button23.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 24) {
            button24.setText("X");
            button24.setTextColor(Color.parseColor("#A6FF0000"));
        }

        if (i == 25) {
            button25.setText("X");
            button25.setTextColor(Color.parseColor("#A6FF0000"));
        }

    }


    public void hideKeyboard(View view) {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception ignored) {
        }
    }

    public void onDestroy() {

        super.onDestroy();
        //Remove a value from realtime database
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //mDatabase.child("Room_id").child(input_room_code).child("Moves").child("Turn").setValue(" ");

        // mDatabase.child("Room_id").child(input_room_code).child("Moves").removeValue();
        mDatabase.child("Room_id").child(input_room_code).removeValue();
    }

    @SuppressLint("SetTextI18n")
    boolean btn(int j) {

        if (array[j].getText().equals(" ")) {

            array[j].setText(Integer.toString(flag));
            flag++;
            return true;
        }
        return false;
    }
}