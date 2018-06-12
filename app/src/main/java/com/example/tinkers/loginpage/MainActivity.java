package com.example.tinkers.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
public class MainActivity extends AppCompatActivity  {

    private EditText et_username,et_password;
    private Button bt_login = null;
    private ImageView iv_wechat,iv_qq;
    private TextView tv_forgetPassword,tv_register;
    private CheckBox cb_checkbox = null;
    private String userName,passWord;//获取用户名和密码


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText)findViewById(R.id.username);
        et_password = (EditText)findViewById(R.id.password);
        iv_wechat = (ImageView)findViewById(R.id.wechat);
        iv_qq = (ImageView)findViewById(R.id.qq);
        bt_login = (Button)findViewById(R.id.login);
        cb_checkbox = (CheckBox)findViewById(R.id.checkbox);
        tv_forgetPassword = (TextView)findViewById(R.id.forgetPassword);
        tv_register = (TextView)findViewById(R.id.register);



        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //登录，获取用户名和密码
                userName = et_username.getText().toString().trim();
                passWord = et_password.getText().toString().trim();

                Intent intent1=new Intent(MainActivity.this,firstPage.class);
                intent1.putExtra("userName",userName);
                intent1.putExtra("passWord",passWord);

                //判断用户名和密码是否为空
                if (TextUtils.isEmpty(userName)){
                    Toast.makeText(MainActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(passWord)){
                    Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                } else if (passWord.equals("123456")&&userName.equals("username")){

                        intent1.putExtra("userName",userName);
                        intent1.putExtra("passWord",passWord);
                        startActivity(intent1);

                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //将CheckBox默认设置为未选择状态
         cb_checkbox.setChecked(false);
        //将Button默认设置为未启用状态
           bt_login.setEnabled(false);
        //判断checkbox是否被选中
        cb_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_checkbox.isChecked()) {
                    //如果CheckBox选中的话

                    //将Button设置为启用状态
                    bt_login.setEnabled(true);
                }else{

                    //将Button默认设置为未启用状态
                    bt_login.setEnabled(false);
                }
            }
        });
    }



}
