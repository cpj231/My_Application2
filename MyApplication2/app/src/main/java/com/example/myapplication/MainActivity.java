package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button sjButton, sj1Button, sj2Button,exitButton;
    private TextView sjText, sj1Text, sj2Text;

    private EditText fw1Number,fw2Number,slNumber;

    private Switch zjSwitch;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        sjButton = findViewById(R.id.sjButton);
        sj1Button = findViewById(R.id.sj1Button);
        sj2Button = findViewById(R.id.sj2Button);
        exitButton = findViewById(R.id.exitButton);
        sjText = findViewById(R.id.sjText);
        sj1Text = findViewById(R.id.sj1Text);
        sj2Text = findViewById(R.id.sj2Text);
        fw1Number = findViewById(R.id.fw1Number);
        fw2Number = findViewById(R.id.fw2Number);
        slNumber = findViewById(R.id.slNumber);
        zjSwitch = findViewById(R.id.zjSwitch);
        sjButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fw1 = fw1Number.getText().toString();
                if (fw1.isEmpty()) return;
                String fw2 = fw2Number.getText().toString();
                if (fw2.isEmpty()) return;
                int fw1Int = Integer.parseInt(fw1);
                int fw2Int = Integer.parseInt(fw2);
                int difference = fw1Int - fw2Int;
                if (difference==0) { sjText.setText(fw1Int);return;}

                String sl = slNumber.getText().toString();
                int slInt = 1;

                if (!sl.isEmpty()){
                    slInt = Integer.parseInt(sl);
                    slInt=slInt>0?slInt:1;
                    System.out.println(slInt);
                }
                if (Math.abs(difference)<slInt) {
                    slInt=Math.abs(difference);
                }
                if (difference<0) {

                    sjText.setText(random(fw1Int,fw2Int,slInt));

                }else {
                    sjText.setText(random(fw2Int,fw1Int,slInt));
                }
            }
        });

        sj1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zjSwitch.isChecked()){
                    sj1Text.append("\n"+random1());
                    return;
                }
                sj1Text.setText(random1());
            }
        });

        sj2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zjSwitch.isChecked()){
                    sj2Text.append("\n"+random2());
                    return;
                }
                sj2Text.setText(random2());
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private String random(int fw1,int fw2,int sl){
        HashSet<Integer> result = new HashSet<>();
        Random random = new Random();
        while (result.size() < sl) {
            result.add(random.nextInt(fw2-fw1+1)+fw1);
        }
        return repStr(result.toString());
    }

    private String random1(){
        HashSet<Integer> result1 = new HashSet<>();
        HashSet<Integer> result2 = new HashSet<>();
        Random random = new Random();
        while (result1.size()<6) {
            result1.add(random.nextInt(33)+1);
        }

        result2.add(random.nextInt(16)+1);

        return repStr(result1.toString())+" + "+repStr(result2.toString());
    }

    private String random2(){
        HashSet<Integer> result1 = new HashSet<>();
        HashSet<Integer> result2 = new HashSet<>();
        Random random = new Random();
        while (result1.size()<5) {
            result1.add(random.nextInt(35)+1);
        }
        while (result2.size()<2)
        {
            result2.add(random.nextInt(12)+1);
        }

        return repStr(result1.toString())+" + "+repStr(result2.toString());
    }

    private String repStr(String str){
        return str.replace("[","").replace("]","");
    }
}