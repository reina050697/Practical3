package com.edu.taruc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {

    TextView textViewStatus;
    TextView textViewMonthly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //To Receive Data From Other Activity
        Intent intent = getIntent(); //Asking "who called me?"
        double payment = intent.getDoubleExtra(MainActivity.MONTHLY_PAYMENT,0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);
        //TODO: Display the Output
        textViewStatus = (TextView)findViewById(R.id.textViewStatus);
        textViewMonthly = (TextView)findViewById(R.id.textViewMonthly);

        textViewMonthly.setText("Monthly Payment: RM"+ payment);
        textViewStatus.setText("Status: " + status);
    }

    public void closeActivity(View view)
    {
        //terminate the current Activity
        finish();
    }
}
