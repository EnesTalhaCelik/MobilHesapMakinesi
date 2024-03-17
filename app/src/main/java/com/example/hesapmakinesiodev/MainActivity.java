package com.example.hesapmakinesiodev;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button butn0 =  findViewById(R.id.btn0);
        Button butn1 =  findViewById(R.id.btn1);
        Button butn2 =  findViewById(R.id.btn2);
        Button butn3 =  findViewById(R.id.btn3);
        Button butn4 =  findViewById(R.id.btn4);
        Button butn5 =  findViewById(R.id.btn5);
        Button butn6 =  findViewById(R.id.btn6);
        Button butn7 =  findViewById(R.id.btn7);
        Button butn8 =  findViewById(R.id.btn8);
        Button butn9 =  findViewById(R.id.btn9);
        TextView txt_Sonuc = findViewById(R.id.textViewSonuc);
        TextView txt_Islem = findViewById(R.id.textViewIslem);




        ArrayList<Button> nums = new ArrayList<>();
        nums.add(butn0);
        nums.add(butn1);
        nums.add(butn2);
        nums.add(butn3);
        nums.add(butn4);
        nums.add(butn5);
        nums.add(butn6);
        nums.add(butn7);
        nums.add(butn8);
        nums.add(butn9);



        for(Button b:nums){
            b.setOnClickListener(view ->{
                if(!txt_Islem.getText().toString().equals("0")){
                    txt_Islem.setText(txt_Islem.getText().toString()+b.getText().toString());
                }else{
                    txt_Islem.setText(b.getText().toString());
                }

            });
        }

    }


    @Override
    public void onClick(View view) {

    }
}