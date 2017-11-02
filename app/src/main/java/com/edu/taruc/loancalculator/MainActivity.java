package com.edu.taruc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";
    EditText editTextVehicle;
    EditText editTextDown;
    EditText editTextRepayment;
    EditText editTextInterest;
    EditText editTextSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateLoan(View view)
    {
        //ToDO: Caclulate Payment and determine the loan status
        editTextVehicle = (EditText)findViewById(R.id.editTextVehicle);
        editTextDown = (EditText)findViewById(R.id.editTextDown);
        editTextRepayment = (EditText)findViewById(R.id.editTextRepayment);
        editTextInterest = (EditText)findViewById(R.id.editTextInterest);
        editTextSalary = (EditText)findViewById(R.id.editTextSalary);


        String status="";
        double totalInterest= (Double.parseDouble(editTextVehicle.getText().toString()) - Double.parseDouble(editTextDown.getText().toString()))*
                (Double.parseDouble(editTextInterest.getText().toString())/100)*(Double.parseDouble(editTextRepayment.getText().toString())/12);
        double totalLoan= (Double.parseDouble(editTextVehicle.getText().toString()) - Double.parseDouble(editTextDown.getText().toString())) + totalInterest;
        double monthlyPayment = totalLoan/(Double.parseDouble(editTextRepayment.getText().toString()));

        if(monthlyPayment> (Double.parseDouble(editTextSalary.getText().toString()))*0.3)
        {
            status = "Rejected";
            monthlyPayment=0;
        }

        else
        {
            status = "Approved";

        }
        //Create an Explicit Intent
        Intent intent = new Intent(this, ActivityResult.class);
        //TODO: Passing data using putExtra method
        //format: putTExtra(TAG, value)
        intent.putExtra(MONTHLY_PAYMENT, monthlyPayment);
        intent.putExtra(LOAN_STATUS,status);
        startActivity(intent);




    }

    public void resetValues(View view)
    {
        editTextVehicle.setText("");
        editTextDown.setText("");
        editTextRepayment.setText("");
        editTextInterest.setText("");
        editTextSalary.setText("");
    }





}
