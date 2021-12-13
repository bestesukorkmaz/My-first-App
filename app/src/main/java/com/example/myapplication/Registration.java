package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//import android.support.annotation.NonNull;

public class Registration extends AppCompatActivity {
    private Button login_button;
    private Button register_button;
    private EditText input_username , input_email, input_password, password_again;
    DataBase_Helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        login_button = (Button) findViewById(R.id.login_button);

        //tekrar log in ekranına dönmek için
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

        //yeni bir hesap için
        private void CreateNewAccount()
        {
            EditText username = (EditText) findViewById(R.id.input_username);
            EditText email = (EditText) findViewById(R.id.input_email);
            EditText password = (EditText) findViewById(R.id.input_password);
            EditText passwordagain = (EditText) findViewById(R.id.password_again);
            Button register_button = findViewById(R.id.register_button);
            DB = new DataBase_Helper(this);

            String semail = email.getText().toString();
            String spassword = password.getText().toString();
            String spasswordagain = passwordagain.getText().toString();
            String susername = username.getText().toString();


            if (susername.matches(""))
                Toast.makeText(this, "Lütfen kullanıcı adınızı giriniz...", Toast.LENGTH_SHORT).show();

            else if (semail.matches(""))
                Toast.makeText(this, "Lütfen email adresinizi giriniz...", Toast.LENGTH_SHORT).show();

            else if (spassword.matches("") || spasswordagain.matches("") )
                Toast.makeText(this, "Lütfen şifrenizi giriniz...", Toast.LENGTH_SHORT).show();

            else if( ! spasswordagain.equals(spassword) )
                Toast.makeText(this, "Şifreleriniz eşleşmiyor...", Toast.LENGTH_SHORT).show();

            else
            {


                            String usernameTXT = input_username.getText().toString();
                            String emailTXT = input_email.getText().toString();
                            String passwordTXT = input_password.getText().toString();

                            Boolean checkinsertdata = DB.insertUserdata(usernameTXT,emailTXT,passwordTXT);
                            if(checkinsertdata==true)
                                Toast.makeText(this, "Hesabınız başarıyla oluşturuldu.", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(this, "Hesabınız oluşturulamadı lütfen tekrar deneyiniz.", Toast.LENGTH_SHORT).show();




                }

            }
    }


