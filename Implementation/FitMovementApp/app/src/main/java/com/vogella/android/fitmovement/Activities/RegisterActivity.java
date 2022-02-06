package com.vogella.android.fitmovement.Activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.vogella.android.fitmovement.R;

public class RegisterActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button register;
    //ProgressDialog pd; //Not sure if to use this when it's crossed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.editTextUsernameRegister);
        password = findViewById(R.id.editTextPasswordRegister);
        register = findViewById(R.id.RegisterUsbutton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                pd = new ProgressDialog((RegisterActivity.this));
//                pd.setMessage("Please wait...");
//                pd.show();
                String emailString = email.getText().toString();
                String passwordString = password.getText().toString();

                if (TextUtils.isEmpty(emailString)|| TextUtils.isEmpty(passwordString)){
                    Toast.makeText(RegisterActivity.this, "All fields need to be filled!", Toast.LENGTH_SHORT).show();
                } else {
                    //registerUser(emailString, passwordString);
                }

            }
        });


    }

//    private void registerUser(String email, String password){
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
////                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            String userid = user.getUid();
//
//                            reference = FirebaseDatabase.getInstance().getReference().child("Users").child(userid);
//                            HashMap<String, Object> hashMap = new HashMap<>();
//                            hashMap.put("id", userid);
//                            hashMap.put("email", email.toLowerCase());
//                            hashMap.put("password", password);
//                            hashMap.put("bio", "");
//                            hashMap.put("imageurl", "gs://fitapp-3824a.appspot.com/dummy-profile-pic-300x300-1.png");
//                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if(task.isSuccessful()){
//                                        //pd.dismiss();
//                                        Intent intent = new Intent(RegisterActivity.this, LoginInActivity.class);
//                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                                        startActivity(intent);
////                                        updateUI(user);
//                                    }
//                                }
//                            });
//
//                        } else {
//                            //pd.dismiss();
//                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//
////                            updateUI(null);
//                        }
//                    }
//                });
//    }
}