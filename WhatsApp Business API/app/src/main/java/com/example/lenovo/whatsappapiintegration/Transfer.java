package com.example.lenovo.whatsappapiintegration;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

public class Transfer extends AppCompatActivity {

    TextView uname;
    String username_string;
    Button submit;

    public static final String ACCOUNT_SID = "AC70faac473cefff95c8c85936edb379f1";
    public static final String AUTH_TOKEN = "[AuthToken]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        uname = (TextView)findViewById(R.id.uname);

        Intent intent = getIntent();

        username_string = intent.getStringExtra("username");

        uname.setText("Welcome \n"+username_string+" !!!! ");

        submit = (Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+919284006219"),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        "Acct XX311 debited with INR-5000.00 on 08-Sept-19 & Acct XX341 credited. Your balance: 10520.30")
                        .create();

                System.out.println(message.getSid());

            }
        });
    }

}
