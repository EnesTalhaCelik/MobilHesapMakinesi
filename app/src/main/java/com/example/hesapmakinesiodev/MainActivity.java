package com.example.hesapmakinesiodev;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.Expression;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private int sayiUzunluk,toplamUzunluk = 1; // büyüdükçe texti küçült ve bir değişken kullan
    private String semboller[] = {"+","-","/","%"};
    private String sembollerHesap[] = {"+","-","/","%"};
    private String hesapYazisi;
    private int artEksTik = 0;
    int sonYapilanIslem = 1; // değer 0 ise cursorun sol tarafında bir işlem yoktur eğer 1 ise cursorun
    //sol tarafında matematiksel operatör vardır ve bir operatör eklendiğinde cursorun solundaki operatör
    //değiştirilecektir.



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
        Button butnTemizle = findViewById(R.id.btnC);
        Button butnNokta = findViewById(R.id.btnNokt);
        Button btnEsittir = findViewById(R.id.btnEsittir);
        Button butnTopla =  findViewById(R.id.btnTopla);
        Button butnCikar =  findViewById(R.id.btnCikar);
        Button butnCarp =  findViewById(R.id.btnCarp);
        Button butnBol =  findViewById(R.id.btnBol);

        Button ButnSil = findViewById(R.id.ButtonSil);
        Button ButnGecmis = findViewById(R.id.ButtonGecmis);
        Button ButnArtEks = findViewById(R.id.btnArtEks);
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
                    /*
                    sayiUzunluk +=1;
                    toplamUzunluk += 1;*/
                    //bunun yeirne text lenght
                    sonYapilanIslem = 0;
                } else
                {
                    txt_Islem.setText(b.getText().toString());
                    sonYapilanIslem = 0;

                }
                String displayStr = txt_Islem.getText().toString().replace("x", "*");
                Expression expression = new Expression(displayStr);
                Double result = expression.calculate();
                txt_Sonuc.setText(result.toString());

            });
        }


        ButnArtEks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sonYapilanIslem == 0){
                    if(artEksTik == 0){
                        artEksTik = 1;
                        txt_Islem.setText(txt_Islem.getText().toString()+"+");
                    }else {
                        artEksTik = 0;
                        txt_Islem.setText(txt_Islem.getText().toString()+"-");
                    }





                }else{

                    if(txt_Islem.getText().toString().charAt(txt_Islem.getText().toString().length() - 1) == '+'){
                        txt_Islem.setText(txt_Islem.getText().toString().substring(0, txt_Islem.length() - 1) + '-') ;
                        artEksTik = 0;
                    } else {
                        txt_Islem.setText(txt_Islem.getText().toString().substring(0, txt_Islem.length() - 1) + '+') ;
                        artEksTik = 1;
                    }
                }

                sonYapilanIslem = 1;

            }
        });



        butnCarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sonYapilanIslem == 0){
                    txt_Islem.setText(txt_Islem.getText().toString()+"x");

                    /*sayiUzunluk =0;
                    toplamUzunluk += 1;*/
                }else if(!txt_Islem.getText().toString().equals("0")&&sonYapilanIslem == 1){
                    //txt_Islem.setText(txt_Islem.getText().toString()+b.getText().toString());
                    //burada cursor pozisyonunu kullanarak işlem değişikliği yapacağız
                    /*sayiUzunluk =0;
                    toplamUzunluk += 1;*/
                }

                sonYapilanIslem = 1;

            }
        });

        butnTopla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sonYapilanIslem == 0){
                    txt_Islem.setText(txt_Islem.getText().toString()+"+");

                    /*sayiUzunluk =0;
                    toplamUzunluk += 1;*/
                }else if(!txt_Islem.getText().toString().equals("0")&&sonYapilanIslem == 1){
                    //txt_Islem.setText(txt_Islem.getText().toString()+b.getText().toString());
                    //burada cursor pozisyonunu kullanarak işlem değişikliği yapacağız
                    /*sayiUzunluk =0;
                    toplamUzunluk += 1;*/
                }

                sonYapilanIslem = 1;

            }
        });

        btnEsittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayStr = txt_Islem.getText().toString().replace("x", "*");
                Expression expression = new Expression(displayStr);
                Double result = expression.calculate();
                txt_Islem.setText(result.toString());
                txt_Sonuc.setText("");
                //Double sonuc = Calculator.evaluateExpression(displayStr);
               // txt_Sonuc.setText(sonuc.toString());
                sonYapilanIslem = 0;

            }
        });

        butnNokta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sonYapilanIslem == 0){
                    txt_Islem.setText(txt_Islem.getText().toString()+".");

                    /*sayiUzunluk =0;
                    toplamUzunluk += 1;*/
                }else if(!txt_Islem.getText().toString().equals("0")&&sonYapilanIslem == 1){
                    //txt_Islem.setText(txt_Islem.getText().toString()+b.getText().toString());
                    //burada cursor pozisyonunu kullanarak işlem değişikliği yapacağız
                    /*sayiUzunluk =0;
                    toplamUzunluk += 1;*/
                }

                sonYapilanIslem = 1;

            }
        });




        butnCikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sonYapilanIslem == 0){
                    txt_Islem.setText(txt_Islem.getText().toString()+"-");

                    /*sayiUzunluk =0;
                    toplamUzunluk += 1;*/
                }else if(!txt_Islem.getText().toString().equals("0")&&sonYapilanIslem == 1){
                    //txt_Islem.setText(txt_Islem.getText().toString()+b.getText().toString());
                    //burada cursor pozisyonunu kullanarak işlem değişikliği yapacağız
                    /*sayiUzunluk =0;
                    toplamUzunluk += 1;*/
                }

                sonYapilanIslem = 1;

            }
        });
        butnBol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sonYapilanIslem == 0){
                    txt_Islem.setText(txt_Islem.getText().toString()+"/");

                    /*sayiUzunluk =0;
                    toplamUzunluk += 1;*/
                }else if(!txt_Islem.getText().toString().equals("0")&&sonYapilanIslem == 1){
                    //txt_Islem.setText(txt_Islem.getText().toString()+b.getText().toString());
                    //burada cursor pozisyonunu kullanarak işlem değişikliği yapacağız
                    /*sayiUzunluk =0;
                    toplamUzunluk += 1;*/
                }

                sonYapilanIslem = 1;

            }
        });

        ButnSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!txt_Islem.getText().toString().equals("0")&&txt_Islem.getText().toString().length() != 1){
                    txt_Islem.setText(txt_Islem.getText().toString().substring(0, txt_Islem.length() - 1));

                    /*sayiUzunluk =0;
                    toplamUzunluk += 1;*/
                }else if(txt_Islem.getText().toString().length() == 1){
                    txt_Islem.setText("0");
                }else if(txt_Islem.getText().toString().length() == 0){
                    txt_Islem.setText("0");
                }

                if( txt_Islem.getText().toString().charAt(txt_Islem.getText().toString().length() - 1) == '+'||
                        txt_Islem.getText().toString().charAt(txt_Islem.getText().toString().length() - 1)== '-'||
                        txt_Islem.getText().toString().charAt(txt_Islem.getText().toString().length() - 1)=='x'||
                        txt_Islem.getText().toString().charAt(txt_Islem.getText().toString().length() - 1)== '/'||
                        txt_Islem.getText().toString().charAt(txt_Islem.getText().toString().length() - 1)== '%'||
                        txt_Islem.getText().toString().charAt(txt_Islem.getText().toString().length() - 1)== '.'){
                    sonYapilanIslem = 1;
                }else{
                    sonYapilanIslem = 0;
                }

            }

        });


        butnTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    txt_Islem.setText("0");
                    sonYapilanIslem = 0;
                    sayiUzunluk = 1;


            }
        });


    }


    @Override
    public void onClick(View view) {

    }
}