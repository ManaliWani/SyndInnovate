package com.example.lenovo.whatsappapiintegration;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView profile;
    EditText accNo;
    EditText uname;
    Spinner accType;
    Button submit;
    Button proceed;
    String name;

    DatabaseReference dbrefpro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        accNo = (EditText)findViewById(R.id.accountNo);
        uname = (EditText)findViewById(R.id.username);
        accType = (Spinner)findViewById(R.id.accounttype);
        submit = (Button)findViewById(R.id.submit);
        proceed = (Button)findViewById(R.id.proceed);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name =  addProfile();
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                i.putExtra("username", name);
                startActivity(i);

            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                i.putExtra("username", name);
                startActivity(i);
            }
        });

        dbrefpro = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String addProfile(){
        String acctNo = accNo.getText().toString().trim();
        String name = uname.getText().toString().trim();
        String acctType = accType.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name) || !TextUtils.isEmpty(acctNo)){
            String id = dbrefpro.push().getKey();
            Profile prof = new Profile(id,name,acctNo,acctType);

            dbrefpro.child(id).setValue(prof);

            Toast.makeText(this, "Profile added", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this, "Please enter details", Toast.LENGTH_SHORT).show();
        }

        return name;

    }
}
