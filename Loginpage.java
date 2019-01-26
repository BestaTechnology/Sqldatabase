package voice_to_text.sandy148101.com.sqldatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginpage extends AppCompatActivity {


  DatabaseHelper db;
    EditText email, password;
  Button loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
         db= new DatabaseHelper(this);
        email =(EditText)findViewById(R.id.editText_email);
        password =(EditText)findViewById(R.id.editText_password);
        loginbtn =(Button)findViewById(R.id.loginBtn);
  loginbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

          String s1 = email.getText().toString();
          String s2 = password.getText().toString();

          Boolean chkemail = db.chckEmailpassword(s1,s2);
          if(chkemail==true){

              Toast.makeText(getApplicationContext(),"Successfully login",Toast.LENGTH_SHORT).show();

              startActivity(new Intent(getApplicationContext(),Profile.class));
          }
          else{
              Toast.makeText(getApplicationContext(),"Emaiil and password do not match",Toast.LENGTH_SHORT).show();
          }
      }
  });



    }
}
