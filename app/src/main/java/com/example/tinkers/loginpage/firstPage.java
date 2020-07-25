package com.example.tinkers.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;


public class firstPage extends AppCompatActivity {
    Button btn_register;//注册按钮
    Button to_login; //返回按钮
    EditText user_name,psw1,psw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_success);
        init();
    }
    private void init() {
        btn_register=findViewById(R.id.btn_register);
        to_login=findViewById(R.id.to_login);

        user_name=findViewById(R.id.userName);
        psw1=findViewById(R.id.passwd);
        psw2=findViewById(R.id.passwd2);
        //返回按钮
        to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(firstPage.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //注册按钮
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(firstPage.this,MainActivity.class);
                intent.putExtra("username",user_name.getText().toString());
                intent.putExtra("psw",psw1.getText().toString());
                startActivity(intent);
            }
        });
    }

}
