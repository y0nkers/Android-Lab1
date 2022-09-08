package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText frequencyView;
    EditText depthView;
    EditText timeView;
    EditText channelsView;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frequencyView = findViewById(R.id.frequencyInput);
        depthView = findViewById(R.id.depthInput);
        timeView = findViewById(R.id.timeInput);
        channelsView = findViewById(R.id.channelInput);
        button = findViewById(R.id.calculateButton);
        textView = findViewById(R.id.calculatedLabel);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int frequency = Integer.parseInt(frequencyView.getText().toString());
                    int depth = Integer.parseInt(depthView.getText().toString());
                    int time = Integer.parseInt(timeView.getText().toString());
                    int channels = Integer.parseInt(channelsView.getText().toString());

                    if (frequency < 0 || depth < 0 || time < 0 || channels < 0) {
                        Toast.makeText(getApplicationContext(), "Введены некорректные данные", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Double result = frequency * depth * time * channels * 1.0;
                        int bytes = (int) (result / 8.0);
                        textView.setText("Объём аудиофайла равен " + bytes + " байт.");
                    }
                } catch(Exception e) {
                    Toast.makeText(getApplicationContext(), "Введены некорректные данные", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}