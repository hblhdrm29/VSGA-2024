package com.habi.vsga_2024;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TambahMainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private EditText namaEditText, alamatEditText;
    private Button submitButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tambah_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new DBHelper(this);

        namaEditText = findViewById(R.id.namaEditText);
        alamatEditText = findViewById(R.id.alamatEditText);
        submitButton = findViewById(R.id.submitButton);
        cancelButton = findViewById(R.id.cancelButton);
        submitButton.setOnClickListener(v -> submit());
        cancelButton.setOnClickListener(v -> cancel());


    }

    public void cancel(){
        finish();
    }

    public void submit(){

        String nama = namaEditText.getText().toString();
        if(nama.isEmpty()){
            Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        String alamat = alamatEditText.getText().toString();
        if(alamat.isEmpty()){
            Toast.makeText(this, "Alamat tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        dbHelper.tambahKontak(nama, alamat);

        Toast.makeText(this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();

        finish();
    }

}