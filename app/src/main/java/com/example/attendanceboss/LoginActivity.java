package com.example.attendanceboss;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.attendance.bean.FacultyBean;
import com.android.attendance.context.ApplicationContext;
import com.android.attendance.db.DBAdapter;
import com.example.attendanceboss.R1;


public class LoginActivity extends Activity {

    Button login;
    EditText username,password;
    Spinner spinnerloginas;
    String userrole;
    private String[] userRoleString = new String[] { "admin", "faculty"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R1.layout.login);

        login =(Button)findViewById(R1.id.buttonlogin);
        username=(EditText)findViewById(R1.id.editTextusername);
        password=(EditText)findViewById(R1.id.editTextpassword);
        spinnerloginas=(Spinner)findViewById(R1.id.spinnerloginas);

        spinnerloginas.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,int arg2,long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                userrole =(String) spinnerloginas.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_role = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, userRoleString);
        adapter_role
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerloginas.setAdapter(adapter_role);

        login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if(userrole.equals("admin"))
                {

                    String user_name = username.getText().toString();
                    String pass_word = password.getText().toString();

                    if (TextUtils.isEmpty(user_name))
                    {
                        username.setError("Invalid User Name");
                    }
                    else if(TextUtils.isEmpty(pass_word))
                    {
                        password.setError("enter password");
                    }
                    else
                    {
                        if(user_name.equals("admin") & pass_word.equals("admin123")){
                            Intent intent =new Intent(LoginActivity.this,MenuActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                else
                {
                    String user_name = username.getText().toString();
                    String pass_word = password.getText().toString();

                    if (TextUtils.isEmpty(user_name))
                    {
                        username.setError("Invalid User Name");
                    }
                    else if(TextUtils.isEmpty(pass_word))
                    {
                        password.setError("enter password");
                    }
                    DBAdapter dbAdapter = new DBAdapter(LoginActivity.this);
                    FacultyBean facultyBean = dbAdapter.validateFaculty(user_name, pass_word);

                    if(facultyBean!=null)
                    {
                        Intent intent = new Intent(LoginActivity.this,AddAttandanceSessionActivity.class);
                        startActivity(intent);
                        ((ApplicationContext)LoginActivity.this.getApplicationContext()).setFacultyBean(facultyBean);
                        Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R1.menu.main, menu);
        return true;
    }

}
