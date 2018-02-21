package com.example.app.database_demo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration_activity extends AppCompatActivity {


    FirebaseAuth firebaseAuth;
    String email,password;
    TextView tv1;
    TextInputLayout textInputLayout1,textInputLayout2,textInputLayout3;
    EditText ed1,ed2,ed3;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_activity);

        tv1=(TextView)findViewById(R.id.reggistration_text_id);
        textInputLayout1=(TextInputLayout)findViewById(R.id.input_layout_username);
        textInputLayout2=(TextInputLayout)findViewById(R.id.input_layout_email_id);
        textInputLayout3=(TextInputLayout)findViewById(R.id.input_layout_password_id);
        ed1=(EditText)findViewById(R.id.username);
        ed2=(EditText)findViewById(R.id.email_id);
        ed3=(EditText)findViewById(R.id.password_id);
        btn1=(Button)findViewById(R.id.registration_btn_id);
        btn2=(Button)findViewById(R.id.login_btn_id);
        firebaseAuth =FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registration();
            }
        });



    }
    private void registration(){

        email=ed2.getText().toString();
        password=ed3.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email,password ).addOnCompleteListener(Registration_activity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(Registration_activity.this,"Registration success",Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(Registration_activity.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Registration_activity.this,"Registration failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
