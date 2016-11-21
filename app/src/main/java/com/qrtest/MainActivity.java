package com.qrtest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.QRCodeUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View create;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        create = findViewById(R.id.create);
        create.setOnClickListener(this);

        Intent intent = new Intent(this, CaptureActivity.class);
        startActivityForResult(intent, 1);
        File path = new File(Environment.getExternalStorageDirectory(), "test_qr_2.jpg");
        Result result = QRCodeUtils.scanningImage(path.getPath());
        if (result != null) {
            input.setText(result.getText());
        }
    }

    @Override
    public void onClick(View v) {
        if (v == create) {
            String label = input.getText().toString();
            Bitmap logo = BitmapFactory.decodeResource(getResources(), R.drawable.launcher_icon);
            String filePath = new File(Environment.getExternalStorageDirectory(), "create_qr_newtest.jpg").getAbsolutePath();
            QRCodeUtils.createQRImage(label, 400, 400, logo, filePath);
            Toast.makeText(this, "create success", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("result");
                input.setText(result);
            }
        }
    }
}
