package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText resultTextView,inputEditText1, inputEditText2,history_data;
    private Button startButton1, startButton2, exitButton,retrieval1,retrieval2;
    private TextView textView2;
    private CheckBox saveCheckBox;

    private StringBuilder resultAll = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText1 = findViewById(R.id.input_edit_text1);
        inputEditText2 = findViewById(R.id.input_edit_text2);
        startButton1 = findViewById(R.id.start_button);
        startButton2 = findViewById(R.id.start_button2);
        exitButton = findViewById(R.id.exit_button);
        resultTextView = findViewById(R.id.result_text_view);
        saveCheckBox = findViewById(R.id.save_check_box);

        history_data = findViewById(R.id.history_data);
        retrieval1 = findViewById(R.id.retrieval1);
        retrieval2 = findViewById(R.id.retrieval2);
        textView2 = findViewById(R.id.textView2);

        startButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = inputEditText1.getText().toString();
                int input = Integer.parseInt(input1);
                // 在这里向后端发送随机数并获取返回的字符串
                String result = sendRequestToBackend(input, 1);
                resultTextView.setText(result);
            }
        });

        startButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input2 = inputEditText2.getText().toString();
                int input = Integer.parseInt(input2);
                // 在这里向后端发送随机数并获取返回的字符串
                String result = sendRequestToBackend(input, 2);
                resultTextView.setText(result);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 退出应用
            }
        });
        
        retrieval1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String historyData = history_data.getText().toString();
                String result = generateDoubleColorBallNumbers(1, 33, 6, 1, 16, 0,historyData);
                resultTextView.setText(result);
            }
        });

        retrieval2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String historyData = history_data.getText().toString();
                String result = generateMegaMillionsNumbers(1, 35, 5, 1, 12, 0,historyData);
                resultTextView.setText(result);
            }
        });
        
    }

    private int generateRandomNumber(int line) {
        Random random = new Random();
        return random.nextInt(line) + 1; // 生成1到line之间的随机数
    }

    private String sendRequestToBackend(int input, int type) {
        String result = "";
        if (type == 1) {
            for (int i = 0; i < input; i++) {
                int randomNumber=generateRandomNumber(17721088);
                String numbers = generateDoubleColorBallNumbers(1, 33, 6, 1, 16, randomNumber,null);
                result += numbers + "\n";
            }
        }
        if (type == 2) {
            for (int i = 0; i < input; i++) {
                int randomNumber=generateRandomNumber(21425712);
                String numbers = generateMegaMillionsNumbers(1, 35, 5, 1, 12, randomNumber,null);
                result += numbers + "\n";
            }
        }

        if (saveCheckBox.isChecked()) {
            resultAll.append(result);
            return resultAll.toString();
        }else if (resultAll.length()>0){
            resultAll=new StringBuilder();
        }
        return result;
    }

    private String generateDoubleColorBallNumbers(int minLucky,
                                                  int maxLucky,
                                                  int totalLucky,
                                                  int minBonus,
                                                  int maxBonus,
                                                  int randomNumber,
                                                  String history) {
        int count = 0;
        long timeStart=System.currentTimeMillis();
        for (int i = minLucky; i <= maxLucky - totalLucky + 1; i++) {
            for (int j = i + 1; j <= maxLucky - totalLucky + 2; j++) {
                for (int k = j + 1; k <= maxLucky - totalLucky + 3; k++) {
                    for (int l = k + 1; l <= maxLucky - totalLucky + 4; l++) {
                        for (int m = l + 1; m <= maxLucky - totalLucky + 5; m++) {
                            for (int n = m + 1; n <= maxLucky - totalLucky + 6; n++) {
                                for (int o = minBonus; o <= maxBonus; o++) {
                                    count++;
                                    if (count == randomNumber) {
                                        textView2.setText(randomNumber+"");
                                        // 格式化字符串
                                        String line = i + "," + j + "," + k + "," + l + "," + m + "," + n + " + " + o;
                                        return line;
                                    }
                                    if (history!=null){
                                        String line = i + "," + j + "," + k + "," + l + "," + m + "," + n + " + " + o;
                                        if (line.equals(history)) {
                                            long timeEnd = System.currentTimeMillis();
                                            return timeEnd-timeStart+"";
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return "";
    }

    private String generateMegaMillionsNumbers(int minLucky,
                                               int maxLucky,
                                               int totalLucky,
                                               int minBonus,
                                               int maxBonus,
                                               int randomNumber,
                                               String history) {
        int count = 0;
        long timeStart=System.currentTimeMillis();
        for (int i = minLucky; i <= maxLucky - totalLucky + 1; i++) {
            for (int j = i + 1; j <= maxLucky - totalLucky + 2; j++) {
                for (int k = j + 1; k <= maxLucky - totalLucky + 3; k++) {
                    for (int l = k + 1; l <= maxLucky - totalLucky + 4; l++) {
                        for (int m = l + 1; m <= maxLucky - totalLucky + 5; m++) {
                            for (int n = minBonus; n <= maxBonus - 1; n++) {
                                for (int o = n + 1; o <= maxBonus; o++) {
                                    count++;
                                    if (count == randomNumber) {
                                        textView2.setText(randomNumber+"");
                                        // 格式化字符串
                                        String line = i + "," + j + "," + k + "," + l + "," + m + " + " + n + "," + o;
                                        return line;
                                    }
                                    if (history!=null){
                                        // 格式化字符串
                                        String line = i + "," + j + "," + k + "," + l + "," + m + " + " + n + "," + o;
                                        if (line.equals(history)) {
                                            long timeEnd = System.currentTimeMillis();
                                            return timeEnd-timeStart+"";
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return "";
    }

}