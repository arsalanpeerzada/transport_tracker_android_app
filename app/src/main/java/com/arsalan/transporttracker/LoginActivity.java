package com.arsalan.transporttracker;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.arsalan.transporttracker.Config.APIs;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    String TAG = "LoginActivity";
    TextView signup;
    Button login;
    // private FirebaseAuth mAuth;
    EditText Username, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //    mAuth = FirebaseAuth.getInstance();

        Username = (EditText) findViewById(R.id.studentID);
        Password = (EditText) findViewById(R.id.Password);


        signup = (TextView) findViewById(R.id.textView2);
        login = (Button) findViewById(R.id.button);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString().toLowerCase();
                String password = Password.getText().toString().toLowerCase();

                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Done Done", Toast.LENGTH_SHORT).show();
                    authenticate(username, password);

                } else {
                    Toast.makeText(LoginActivity.this, "one of more field is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void authenticate(String username, String password) {

        //Empty Fields Check

        // Utils.ProgressDialog.show(context);
        String postUrl = APIs.signup;

//            String userName = String.valueOf(username.getText());
//            String passWord = String.valueOf(password.getText());

        RequestParams params = new RequestParams();
        params.put("email", username);
        params.put("password", password);

        //Server Hit
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(postUrl, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                JSONObject testV = null;

                try {
                    testV = new JSONObject(new String(responseBody));
                  //  String message = testV.getString("message");
                    String accessToken = testV.getString("access_token");

                    Toast.makeText(LoginActivity.this, "Authenticated", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                    //  Utils.ProgressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, e.toString(), Toast.LENGTH_LONG);
                }
            }


            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                JSONObject testV = null;
                try {
                    testV = new JSONObject(new String(responseBody));
                    String message = testV.getString("message");

                    //  Utils.ProgressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    //  Utils.ProgressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

//    public void authenticate(String username, String password) {
//
//        mAuth.signInWithEmailAndPassword(username, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                            startActivity(intent);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithEmail:failure", task.getException());
//                            Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                           // updateUI(null);
//                        }
//
//                        // ...
//                    }
//                });
//    }

}

//                        if (message.equals("Login Successfully")) {
//                            JSONObject result = testV.getJSONObject("result");
//                            String token = result.getString("token");
//                            String fielduser_id = result.getString("user_id");
//                            String fielduser_name = result.getString("full_name");
//                            String role = result.getString("role");
//
//                           // SharedPrefrence(token,fielduser_name,fielduser_id,role);
//
//                         //   Utils.ProgressDialog.dismiss();
//
//                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
//
//                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                            startActivity(intent);
//
//
//                        } else {
//                         //   Utils.ProgressDialog.dismiss();
//                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG);
//                        }
