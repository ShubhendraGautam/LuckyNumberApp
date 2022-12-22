package com.example.luckynumber;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    Button btn;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView=findViewById(R.id.lucky_number);
        textView2=findViewById(R.id.textView);

        btn=findViewById(R.id.button);
        Intent i=getIntent();
        String name=i.getStringExtra("name");

        int luckyNumber=randomNumber();
        textView.setText(""+luckyNumber);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(name,luckyNumber);

            }
        });
    }

    public int randomNumber(){
        Random r = new Random();
        int low = 10;
        int high = 100;
        int result = r.nextInt(high-low) + low;
        return result;
    }

    public void shareData(String name,int luckyNumber){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,name);
        i.putExtra(Intent.EXTRA_TEXT,luckyNumber);
        startActivity(Intent.createChooser(i,"Choose a platform"));
    }


}