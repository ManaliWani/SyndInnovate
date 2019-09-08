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

public class TransactionActivity1 extends AppCompatActivity {

    TextView uname;
    String username_string;
    String acctNo;

    Button transfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction1);
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

        uname = (TextView)findViewById(R.id.textView);

        transfer = (Button)findViewById(R.id.transfer);

        Intent intent = getIntent();
        username_string = intent.getStringExtra("username");

        uname.setText("Welcome \n"+username_string+" !!!! ");





        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TransactionActivity1.this, Transfer.class);
                i.putExtra("username", username_string);
                startActivity(i);
            }
        });
    }

}
