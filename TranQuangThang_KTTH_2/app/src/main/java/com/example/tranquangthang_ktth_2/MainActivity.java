package com.example.tranquangthang_ktth_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup groupNgoaiTe;
    Button btnVNDTo, btnNgoaiTeTo, btnClear;
    EditText edtVND, edtNgoaiTe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        groupNgoaiTe = findViewById(R.id.groupNgoaiTe);
        edtVND = findViewById(R.id.edtVND);
        edtNgoaiTe = findViewById(R.id.edtNgoaiTe);
        btnVNDTo = findViewById(R.id.btnVNDTo);
        btnVNDTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // cach 1
                double VND = Integer.parseInt(edtVND.getText().toString());
                double NgoaiTe = 0;
                int idRadioSelect = groupNgoaiTe.getCheckedRadioButtonId();
                switch (idRadioSelect) {
                    case 0: {
                        NgoaiTe = VND/22280;
                        edtNgoaiTe.setText(NgoaiTe+"");
                        break;
                    }
                    case 1: {
                        NgoaiTe = VND/24280;
                        edtNgoaiTe.setText(NgoaiTe+"");
                        break;
                    }
                    case 2: {
                        NgoaiTe = VND/204;
                        edtNgoaiTe.setText(NgoaiTe+"");
                        break;
                    }
                }

//                cach 2
//                doChangeVNDTo();
            }
        });
        btnNgoaiTeTo = findViewById(R.id.btnNgoaiTeTo);
        btnNgoaiTeTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // cach 1
                double VND = 0;
                double NgoaiTe = Integer.parseInt(edtNgoaiTe.getText().toString());
                int idRadioSelect = groupNgoaiTe.getCheckedRadioButtonId();
                switch (idRadioSelect) {
                    case 0: {
                        VND = NgoaiTe*22280;
                        edtVND.setText(VND+"");
                        break;
                    }
                    case 1: {
                        VND = NgoaiTe*24280;
                        edtVND.setText(VND+"");
                        break;
                    }
                    case 2: {
                        VND = NgoaiTe*204;
                        edtVND.setText(VND+"");
                        break;
                    }
                }

                // cach 2
//                doChangeNgoaiTeTo();
            }
        });
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtVND.setText("");
                edtNgoaiTe.setText("");
            }
        });
    }

    // chuyen tu VND sang ngoai te
    public  void doChangeVNDTo() {
        double VND = Integer.parseInt(edtVND.getText().toString());
        double NgoaiTe = 0;

        // lay id cua radio
        int idRadioSelect = groupNgoaiTe.getCheckedRadioButtonId(); // lay id cua radio dc chon

        if(VND == 0) {
            Toast.makeText(this, "Ban chua nhap so", Toast.LENGTH_SHORT).show();
        }
        else {
            if(idRadioSelect == 0 ) {
                NgoaiTe = VND/22280;
                edtNgoaiTe.setText(NgoaiTe+"");
            }
            if(idRadioSelect == 1 ) {
                NgoaiTe = VND/24280;
                edtNgoaiTe.setText(NgoaiTe+"");
            }
            if(idRadioSelect == 2 ) {
                NgoaiTe = VND/204;
                edtNgoaiTe.setText(NgoaiTe+"");
            }
            else {
                Toast.makeText(this, "Ban chua chon ngoai te", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // chuyen tu ngoai te sang VND
    public  void doChangeNgoaiTeTo() {
        double VND = 0;
        double NgoaiTe = Integer.parseInt(edtNgoaiTe.getText().toString());

        // lay id cua radio
        int idRadioSelect = groupNgoaiTe.getCheckedRadioButtonId(); // lay id cua radio dc chon

        if(NgoaiTe == 0) {
            Toast.makeText(this, "Ban chua nhap so", Toast.LENGTH_SHORT).show();
        }
        else {
            if(idRadioSelect == 0 ) {
                VND = NgoaiTe*22280;
                edtVND.setText(VND+"");
            }
            if(idRadioSelect == 1 ) {
                VND = NgoaiTe*24280;
                edtVND.setText(VND+"");
            }
            if(idRadioSelect == 2 ) {
                VND = NgoaiTe*204;
                edtVND.setText(VND+"");
            }
            else {
                Toast.makeText(this, "Ban chua chon ngoai te", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // tao dialog
    @Override
    public void onBackPressed() {
        // tao dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Canh bao");
        dialog.setMessage("Ban co muon thoat ung dung khong?");
        // dialog.setIcon(); luu icon vao src img roi dua vao de dung
        // tao  ham thoat ung dung
        dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish(); // thoat khoi ung dung
            }
        });
        dialog.setPositiveButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel(); // huy thoat va tat dialog
            }
        });
        dialog.create().show(); // hien thi dialog
    }
}