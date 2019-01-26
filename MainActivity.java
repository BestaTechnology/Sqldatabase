package voice_to_text.sandy148101.com.sqldatabase;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     DatabaseHelper db;
    EditText email, password, cpassword;
    Button registerbtn, Loginbtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        email =(EditText)findViewById(R.id.editText_email);
        password = (EditText)findViewById(R.id.editText_password);
        cpassword = (EditText)findViewById(R.id.editText_cpassword);
        registerbtn = (Button)findViewById(R.id.registerBtn);
        Loginbtn =(Button)findViewById(R.id.LoginBtn);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String s1 = email.getText().toString();
               String s2 = password.getText().toString();
               String s3 = cpassword.getText().toString();

               if(s1.equals("")|| s2.equals("") || s3.equals("")){


                   Toast.makeText(getApplicationContext(),"Please fill the Empty field",Toast.LENGTH_SHORT).show();
               }else {

                  if(s2.equals(s3)) {

                      Boolean checkEmail = db.chckEmail(s1);
                      if (checkEmail == true) {
                          Boolean insert = db.insert(s1, s2);
                          if (insert == true) {
                              Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();
                          }else{
                              Toast.makeText(getApplicationContext(), "Register  not Successfully", Toast.LENGTH_SHORT).show();

                          }
                      } else {
                          Toast.makeText(getApplicationContext(), "Email already Exists", Toast.LENGTH_SHORT).show();
                      }
                  }
                      else{

                          Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
                      }
                  }
               }

        });

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Loginpage.class);
                startActivity(intent);
            }
        });



    }
}
