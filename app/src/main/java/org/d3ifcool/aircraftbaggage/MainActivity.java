package org.d3ifcool.aircraftbaggage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 // TODO declarate EditText, RadioButton, TextView, Button

    EditText edtNama, edtTujuan, edtPesawat, edtBerat;
    RadioButton rdbInter, rdbDomestic;
    TextView tvHarga;
    Button btnHarga, btnDaftar, btnShare;
    int totalHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNama = findViewById(R.id.edt_nama);
        edtTujuan = findViewById(R.id.edt_tujuan);
        edtPesawat = findViewById(R.id.edt_jenis_pesawat);
        edtBerat = findViewById(R.id.edt_berat_bagasi);

        rdbInter = findViewById(R.id.rdb_internasional);
        rdbDomestic = findViewById(R.id.rdb_domestic);

        btnHarga = findViewById(R.id.btn_harga);
        btnDaftar = findViewById(R.id.btn_daftar_pesawat);
        btnShare = findViewById(R.id.btn_share);

        tvHarga = findViewById(R.id.tv_harga);

        //setVisible TextView
        tvHarga.setVisibility(View.GONE);
        btnDaftar.setVisibility(View.GONE);
        btnShare.setVisibility(View.GONE);

    }

    public void harga(View view) {
        String nama = edtNama.getText().toString().trim();
        String tujuan = edtTujuan.getText().toString().trim();
        String pesawat = edtPesawat.getText().toString().trim();
        int berat = Integer.valueOf(edtBerat.getText().toString().trim());

        if (TextUtils.isEmpty(nama)){
            Toast.makeText(this,"Isikan nama terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(tujuan)){
            Toast.makeText(this,"Isikan tujuan terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pesawat)){
            Toast.makeText(this,"Isikan pesawat terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        if (rdbInter.isChecked()){
            totalHarga = berat * 45000;
        }else {
            totalHarga = berat *30000;
        }

        tvHarga.setText(String.valueOf("Harga Bagasi Rp."+totalHarga));

        tvHarga.setVisibility(View.VISIBLE);
        btnDaftar.setVisibility(View.VISIBLE);
        btnShare.setVisibility(View.VISIBLE);

    }

    public void sendEmail(View view) {
        String penerbangan = rdbInter.isChecked()? "Internasional" : "Domestic";
        String subject = "Total Harga Bagasi pesawat Terbang";
        String message = "Nama : "+edtNama.getText().toString()+"\n" +
                "Tujuan : "+edtTujuan.getText().toString()+"\n" +
                "Pesawat : "+edtPesawat.getText().toString()+"\n" +
                "Berat Bagasi : "+edtBerat.getText().toString()+" Kg "+"\n" +
                "Penerbangan : "+penerbangan+"\n" +tvHarga.getText().toString();

        composeEmail(new String[]{"mobpro.d3if@gmail.com"},subject,message);

    }

    public void composeEmail(String[] addresses, String subject, String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void daftar(View view) {
        Intent intent = new Intent(MainActivity.this, PesawatActivity.class);
        startActivity(intent);
    }
}
