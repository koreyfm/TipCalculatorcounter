package com.introtoandroid.tipcalculator_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private final int resetVal = 0;
    Button calcButton;
    Button resetButton;
    TextView totalTip;
    TextView billTotal;
    TextView amountPerPerson;
    float tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcButton = (Button) findViewById(R.id.calculateButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        totalTip = (TextView) findViewById(R.id.totalTip);
        billTotal = (TextView) findViewById(R.id.billTotal);
        amountPerPerson = (TextView) findViewById(R.id.amountPerPerson);

        //RadioButton tenPercent = (RadioButton) findViewById(R.id.tenPercent);
        //RadioButton fifteenPercent = (RadioButton) findViewById(R.id.fifteenPercent);
        //RadioButton twentyPercent = (RadioButton) findViewById(R.id.twentyPercent);

        calcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                EditText totalBill =  (EditText) findViewById(R.id.txtAmount);
                String inputBill = totalBill.getText().toString();

                EditText totalPeople =  (EditText) findViewById(R.id.txtPeople);
                String peopleAmount = totalPeople.getText().toString();

                EditText other =  (EditText) findViewById(R.id.txtTipOther);
                String otherPercent = other.getText().toString();

                //float bill = Float.valueOf(inputBill);
                //float peopleTotal = Float.valueOf(peopleAmount);

                //if(!(otherPercent.matches(""))) {
                    //float otherPercentInput = Float.valueOf(otherPercent);
                //}

                if (inputBill.matches("")) {

                    Toast.makeText(getApplicationContext(), "You Did Not Enter A Valid Bill Amount...", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (peopleAmount.matches("")) {

                    Toast.makeText(getApplicationContext(), "You Did Not Enter A Valid # Of People...", Toast.LENGTH_SHORT).show();
                    return;

                }

                float bill = Float.valueOf(inputBill);
                float peopleTotal = Float.valueOf(peopleAmount);

                if(bill < 1){
                    Toast.makeText(getApplicationContext(), "You Did Not Enter A Valid Bill Amount...", Toast.LENGTH_SHORT).show();
                    return;

                }

                if(peopleTotal < 1){

                    Toast.makeText(getApplicationContext(), "You Did Not Enter A Valid # Of People...", Toast.LENGTH_SHORT).show();
                    return;


                }





                RadioButton tenPercent = (RadioButton) findViewById(R.id.tenPercent);
                RadioButton fifteenPercent = (RadioButton) findViewById(R.id.fifteenPercent);
                RadioButton twentyPercent = (RadioButton) findViewById(R.id.twentyPercent);




                if(tenPercent.isChecked() && otherPercent.matches("")) {

                    tip = bill * 10 / 100;
                }



                else if(fifteenPercent.isChecked() && otherPercent.matches("")) {


                    tip = bill * 15 / 100;
                }




                else if(twentyPercent.isChecked() && otherPercent.matches("")) {

                    tip = bill * 20 / 100;
                }


                else if(!(otherPercent.matches(""))){

                    //if(!(otherPercent.matches(""))) {
                        //float otherPercentInput = Float.valueOf(otherPercent);
                    //}
                    float otherPercentInput = Float.valueOf(otherPercent);

                    if(otherPercentInput > 0){

                        //float otherPercentInput = Float.valueOf(otherPercent);

                        tip = bill * otherPercentInput / 100;



                    }
                    else{

                        Toast.makeText(getApplicationContext(), "You Must Enter Or Select A Valid %...", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    //float otherPercentInput = Float.valueOf(otherPercent);

                    //if (!(otherPercentInput < 1)) {
                        //float otherPercentInput = Float.valueOf(otherPercent);

                        //tip = bill * otherPercentInput/100;

                        //tenPercent.setChecked(false);
                        //fifteenPercent.setChecked(false);
                        //twentyPercent.setChecked(false);

                    //}

                    //else{

                      //  Toast.makeText(getApplicationContext(), "You Must Enter Or Select A Valid %...", Toast.LENGTH_SHORT).show();
                        //return;

                    //}
                }

                else{

                    Toast.makeText(getApplicationContext(), "You Must Enter Or Select A Valid %...", Toast.LENGTH_SHORT).show();
                    return;

                }



                float fullBill = tip+bill;

                billTotal.setText(String.format("$%.2f", fullBill));

                totalTip.setText(String.format("$%.2f",tip));

                amountPerPerson.setText(String.format("$%.2f",fullBill/peopleTotal));



                //tenPercent.setChecked(false);
                //fifteenPercent.setChecked(false);
                //twentyPercent.setChecked(false);
            }
        });





        resetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                totalTip.setText(Integer.toString(resetVal));
                billTotal.setText(Integer.toString(resetVal));
                amountPerPerson.setText(Integer.toString(resetVal));

                EditText other =  (EditText) findViewById(R.id.txtTipOther);
                EditText totalPeople =  (EditText) findViewById(R.id.txtPeople);
                EditText totalBill =  (EditText) findViewById(R.id.txtAmount);
                other.getText().clear();
                totalPeople.getText().clear();
                totalBill.getText().clear();

                //RadioButton tenPercent = (RadioButton) findViewById(R.id.tenPercent);
                //RadioButton fifteenPercent = (RadioButton) findViewById(R.id.fifteenPercent);
                //RadioButton twentyPercent = (RadioButton) findViewById(R.id.twentyPercent);

                //tenPercent.setChecked(false);
                //fifteenPercent.setChecked(false);
                //twentyPercent.setChecked(false);

                RadioGroup  group  = (RadioGroup)findViewById(R.id.radioGroup);
                group.clearCheck();




            }
        });
    }
}