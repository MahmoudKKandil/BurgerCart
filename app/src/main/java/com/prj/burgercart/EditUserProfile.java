package com.prj.burgercart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.regex.Pattern;

public class EditUserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);
        final EditText thenewemail=( EditText)findViewById(R.id.emaileditText);
        final  EditText thenewaddress=( EditText)findViewById(R.id.adressedittext);
        final String username=getIntent().getStringExtra("username");
         final OrdersDB userdata=new OrdersDB(this);
        final String oldemail=userdata.GetEmail(username).toString();
        final String oldaddress=userdata.GetAdress(username).toString();
        final String oldpassword=userdata.GetPassword(username);
        final  EditText oldpasstext=( EditText)findViewById(R.id.oldpass);
        final  EditText newpasstext=( EditText)findViewById(R.id.newpasseditbox);
        final  EditText confirmpasstext=( EditText)findViewById(R.id.confirmpass);
        thenewemail.setText(oldemail);
        thenewaddress.setText(oldaddress);
        Button savenewemail=(Button)findViewById(R.id.saveemailbutton);
        Button savenewaddress=(Button)findViewById(R.id.saveadressbutton);
        Button savepass=(Button)findViewById(R.id.savepassbutton);
        final Pattern Pass=Pattern.compile("^"+
                "(?=.*[0-9])"+
                "(?=.*[a-z])"+
                "(?=.*[A-Z])"+
                "(?=.*[a-zA-Z])"+
                "(?=\\S+$)"+
                ".{6,}"+
                "$");
        savenewemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(thenewemail.getText().toString())) {
                    thenewemail.setError("Email can`t be null ");
                    return;
                }

                if (thenewemail.getText().toString().equals(oldemail)) {
                    thenewemail.setError("Enter New Email ");
                    return;
                }

                if (userdata.CheckingEmail(thenewemail.getText().toString())) {
                    thenewemail.setError("This Email is already registered");
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(thenewemail.getText().toString().trim()).matches()) {
                    thenewemail.setError("Please Enter a valid Email");
                    return;
                }
                userdata.Updateuseremail(thenewemail.getText().toString(), username);
            }
        });
        savenewaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {int count=0;
                if (TextUtils.isEmpty(thenewaddress.getText().toString()))
                { thenewaddress.setError("adress can`t be null ");}
                else count++;
                if (thenewaddress.equals(oldaddress))
                {thenewaddress.setError("Enter New Email ");}
                else count++;
                if(count==2){userdata.Updateuseraddress(thenewemail.getText().toString(),username);}
            }
        });
        savepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { int count=0;
                if (TextUtils.isEmpty(oldpasstext.getText().toString()))
                   oldpasstext.setError("Password can`t be null ");
                else count++;
                if (TextUtils.isEmpty(confirmpasstext.getText().toString()))
                    confirmpasstext.setError("Please Re-Enter your password ");
                else count++;
                if (TextUtils.isEmpty(newpasstext.getText().toString()))
                    newpasstext.setError("Password can`t be null ");
                else count++;
                if(!oldpasstext.getText().toString().equals(oldpassword)) { oldpasstext.setError("wrong Password");}
                else count++;
                if(!newpasstext.getText().toString().trim().equals(confirmpasstext.getText().toString()))
                    confirmpasstext.setError("Passwords do not match");
                else count++;
                if(!Pass.matcher((newpasstext.getText().toString())).matches())
                   newpasstext.setError("Password should contain at least 6 characters including at least( 1 lower case letter, 1 upper case letter, 1 digit ");
                else count++;
                if(count==6){userdata.Updateuserpassword(newpasstext.getText().toString(),username);}
            }
        });

    }
}