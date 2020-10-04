package com.my.read_write_file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView show_board;
    Util util = new Util();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_board = findViewById(R.id.tvId);
    }

    public void read_txt(View view) {
        String path = "Pictures/adc_code.txt";
        String result = util.loadFromSDFile(path);
        show_board.setText(result);
    }

    public void write_txt(View view) {
        String token = "13U1KJDKAHDU13891HQWEJQDALSDA";
        String path = "Pictures/token.txt";
        util.writeToSDFile(token, path);
    }

}