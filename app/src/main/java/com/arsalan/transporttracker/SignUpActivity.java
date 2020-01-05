package com.arsalan.transporttracker;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    String TAG = "SignUpActivity";
    private FirebaseAuth mAuth;
    EditText FirstName, LastName, Password;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();


        FirstName = (EditText) findViewById(R.id.firstName);
        LastName = (EditText) findViewById(R.id.lastName);
        Password = (EditText) findViewById(R.id.password);

        signup = (Button) findViewById(R.id.submitButton);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = FirstName.getText().toString().toLowerCase();
                String password = LastName.getText().toString().toLowerCase();

                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

                    createNewUser(email, password);
                }else Toast.makeText(SignUpActivity.this, "one or more field is empty", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void createNewUser(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(SignUpActivity.this, "User Created...!", Toast.LENGTH_SHORT).show();
                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Account Creation failed.",
                                    Toast.LENGTH_SHORT).show();
                            //   updateUI(null);
                        }

                        // ...
                    }
                });
    }
}
