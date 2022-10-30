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
        edtVND = findViewById(R.id.edtVND);
        edtNgoaiTe = findViewById(R.id.edtNgoaiTe);
        btnVNDTo = findViewById(R.id.btnVNDTo);
//        btnVNDTo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                doChangeVNDTo();
//            }
//        });
        btnNgoaiTeTo = findViewById(R.id.btnNgoaiTeTo);
//        btnNgoaiTeTo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                doChangeNgoaiTeTo();
//            }
//        });
        btnClear = findViewById(R.id.btnClear);
//        btnClear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                edtVND.setText("");
//                edtNgoaiTe.setText("");
//            }
//        });
    }
    // ham lay radio button
    public String getLoaiNgoaiTe() {
        // lay value tu group radio
        String loaiNgoaiTe = "";
        int idRadioSelect = groupNgoaiTe.getCheckedRadioButtonId(); // lay id cua radio dc chon
        RadioButton radioSelected = findViewById(idRadioSelect); // khai bao va anh xa id den voi doi tuong dc  chon
        loaiNgoaiTe = radioSelected.getText().toString();

        // tra ve loai ngoai te
        return loaiNgoaiTe;
    }

    // lay gia tri edt
    double VND = Integer.parseInt(edtVND.getText().toString());
    double NgoaiTe = Integer.parseInt(edtNgoaiTe.getText().toString());

    // chuyen tu VND sang ngoai te
    public  void doChangeVNDTo() {
        if(VND == 0) {
            Toast.makeText(this, "Ban chua nhap so", Toast.LENGTH_SHORT).show();
        }
        else {
            if(getLoaiNgoaiTe() == "") {
                Toast.makeText(this, "Ban chua chon ngoai te", Toast.LENGTH_SHORT).show();
            }
            else {
                if(getLoaiNgoaiTe() == "USD" ) {
                    NgoaiTe = VND/22280;
                    edtNgoaiTe.setText(NgoaiTe+"");
                }
                if(getLoaiNgoaiTe() == "EUR" ) {
                    NgoaiTe = VND/24280;
                    edtNgoaiTe.setText(NgoaiTe+"");
                }
                if(getLoaiNgoaiTe() == "JPY" ) {
                    NgoaiTe = VND/204;
                    edtNgoaiTe.setText(NgoaiTe+"");
                }
            }
        }
    }

    // chuyen tu ngoai te sang VND
    public  void doChangeNgoaiTeTo() {
        if(NgoaiTe == 0) {
            Toast.makeText(this, "Ban chua nhap so", Toast.LENGTH_SHORT).show();
        }
        else {
            if(getLoaiNgoaiTe() == "") {
                Toast.makeText(this, "Ban chua chon ngoai te", Toast.LENGTH_SHORT).show();
            }
            else {
                if(getLoaiNgoaiTe() == "USD" ) {
                    VND = NgoaiTe*22280;
                    edtVND.setText(VND+"");
                }
                if(getLoaiNgoaiTe() == "EUR" ) {
                    VND = NgoaiTe*24280;
                    edtVND.setText(VND+"");
                }
                if(getLoaiNgoaiTe() == "JPY" ) {
                    VND = NgoaiTe*204;
                    edtVND.setText(VND+"");
                }
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