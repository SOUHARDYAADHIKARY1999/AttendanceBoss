package com.example.attendanceboss;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.attendanceboss.R1;
import com.android.attendance.bean.AttendanceBean;
import com.android.attendance.context.ApplicationContext;
import com.android.attendance.db.DBAdapter;

public class MenuActivity extends Activity {
    Button addStudent;
    Button addFaculty;
    Button viewStudent;
    Button viewFaculty;
    Button logout;
    Button attendancePerStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R1.layout.menu);

        addStudent =(Button)findViewById(R1.id.buttonaddstudent);
        addFaculty =(Button)findViewById(R1.id.buttonaddfaculty);
        viewStudent =(Button)findViewById(R1.id.buttonViewstudent);
        viewFaculty =(Button)findViewById(R1.id.buttonviewfaculty);
        logout =(Button)findViewById(R1.id.buttonlogout);

        addStudent.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(MenuActivity.this,AddStudentActivity.class);
                startActivity(intent);
            }
        });

        addFaculty.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(MenuActivity.this,AddFacultyActivity.class);
                startActivity(intent);
            }
        });

        viewFaculty.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /**Intent intent =new Intent(MenuActivity.this,ViewFacultyActivity.class);
                startActivity(intent);*/
            }
        });


        viewStudent.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /**Intent intent =new Intent(MenuActivity.this,ViewStudentActivity.class);
                startActivity(intent);*/
            }
        });
        logout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(MenuActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        attendancePerStudent=(Button)findViewById(R1.id.attendancePerStudentButton);
        attendancePerStudent.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                DBAdapter dbAdapter = new DBAdapter(MenuActivity.this);
                ArrayList<AttendanceBean> attendanceBeanList=dbAdapter.getAllAttendanceByStudent();
                ((ApplicationContext)MenuActivity.this.getApplicationContext()).setAttendanceBeanList(attendanceBeanList);

                /**Intent intent = new Intent(MenuActivity.this,ViewAttendancePerStudentActivity.class);
                startActivity(intent);*/

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
