package com.example.luckynumber;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText1);
        btn=findViewById(R.id.btn1);
        textView=findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText.getText().toString();

                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                i.putExtra("name",name);

                startActivity(i);

            }
        });

    }


}