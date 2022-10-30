package com.example.tranquangthang_ktth_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected long backPressTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        if ( (backPressTime + 2000) > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        }
        else {
            Toast.makeText(this, "Nhan 1 lan nua de thoat", Toast.LENGTH_SHORT).show();
        }

        backPressTime = System.currentTimeMillis();
    }
}