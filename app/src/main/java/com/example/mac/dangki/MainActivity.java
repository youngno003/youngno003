package com.example.mac.dangki;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    Button btnDangki;
    EditText hoten,email,pass,sdt,repass;
    NguoiDung Nuser = new NguoiDung();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        AnhXa();
        btnDangki.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Dangki();
            }
        });
    }

    private void Dangki()
    {
        String Email = email.getText().toString();
        String Pass = pass.getText().toString();
        mAuth.createUserWithEmailAndPassword(Email, Pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });


    }

    private void AnhXa()
    {
        btnDangki = (Button)findViewById(R.id.btnDk);
        hoten = (EditText)findViewById(R.id.txtHovaten);
        email = (EditText)findViewById(R.id.txtEmail);
        pass = (EditText)findViewById(R.id.txtMatkhau);
        repass = (EditText)findViewById(R.id.txtRePass);
        sdt = (EditText)findViewById(R.id.txtSDT);
    }
}
