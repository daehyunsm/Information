package com.example.information;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tVResult, tVResultLabel;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tVResult = findViewById(R.id.tVResult);
        tVResultLabel = findViewById(R.id.tVResultLabel);
        Button btnRequest = findViewById(R.id.btnRequest);
        Button btnEnd = findViewById(R.id.btnEnd);
        EditText editTextID = findViewById(R.id.editTextID);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = editTextID.getText().toString();
                Intent it = new Intent(getApplicationContext(), InformationActivity.class);
                it.putExtra("id", str);
                startActivityForResult(it, 1);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 1) && (resultCode == RESULT_OK)) {
        tVResultLabel.setText("전송\n정보\n출력");
        str = "아이디" + str;
        str = str + "\n이름" + data.getStringExtra("name");
        str = str + "\n나이" + data.getStringExtra("age");
        str = str + "\n성별" + data.getStringExtra("sex");
        str = str + "\n자격증" + data.getStringExtra("license");
        tVResult.setText(str);
        }

    }
}