package com.example.forwardProject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button kakaoLoginButton = findViewById(R.id.kakao_login_button);
        Button googleLoginButton = findViewById(R.id.google_login_button);

        View.OnClickListener loginClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그인 성공 후 HomeFragment로 이동
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // LoginActivity를 종료하여 뒤로 가기 버튼으로 돌아가지 않도록 함
            }
        };

        kakaoLoginButton.setOnClickListener(loginClickListener);
        googleLoginButton.setOnClickListener(loginClickListener);
    }
}
