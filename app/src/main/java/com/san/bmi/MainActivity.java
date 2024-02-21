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
        System.out.println("");

        CalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = edtWeight.getText().toString();
                String heightFtStr = edtHeightFt.getText().toString();
                String heightInStr = edtHeightIn.getText().toString();

                if (weightStr.isEmpty() || heightFtStr.isEmpty() || heightInStr.isEmpty()) {
                    // Show a message indicating that all fields are required
                    txtResult.setText("Please fill in all fields");
                    return; // Exit the onClick method as validation failed
                }

                int wt = Integer.parseInt(weightStr);
                int ft = Integer.parseInt(heightFtStr);
                int in = Integer.parseInt(heightInStr);

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