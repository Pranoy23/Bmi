package com.san.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt,edtHeightIn;
        Button CalBtn;
        TextView txtResult;


        edtWeight=findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        CalBtn = findViewById(R.id.CalBtn);
        txtResult=findViewById(R.id.TxtResult);


        CalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt= Integer.parseInt(edtWeight.getText().toString());
                int ft= Integer.parseInt(edtHeightFt.getText().toString());
                int in= Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn=ft *12 +in;
                double SquaredIn= totalIn*totalIn;
                double bmi= (wt/SquaredIn)*703;

                if (bmi>25 && bmi<30) {
                    txtResult.setText("you are overweight");
                    txtResult.setBackgroundColor(getResources().getColor(R.color.colowt));
                } else if (bmi<18) {
                    txtResult.setText("you are underweight");
                    txtResult.setBackgroundColor(getResources().getColor(R.color.coluwt));
                }else if (bmi>30) {
                    txtResult.setText("you are obese");
                    txtResult.setBackgroundColor(getResources().getColor(R.color.colob));
                } else{
                    txtResult.setText("you are healthy");
                    txtResult.setBackgroundColor(getResources().getColor(R.color.colhl));
                }


            }
        });
    }
}