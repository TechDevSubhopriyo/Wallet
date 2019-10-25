package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Add extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b1,b2;
    String a,b,c,d,e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add);
        getSupportActionBar().hide();
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        b1=findViewById(R.id.s1);
        b2=findViewById(R.id.s2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date c1= Calendar.getInstance().getTime();
                System.out.println("Current time => "+c1);
                SimpleDateFormat df=new SimpleDateFormat("dd-MMM-YYY");
                e="Debit"+"\n";
                d="Date: "+df.format(c1)+"\n\n";
                a="Rs."+e1.getText().toString()+"\n";
                b="Gateway: "+e2.getText().toString()+"\n";
                c="Purpose: "+e3.getText().toString()+"\n";
                if(!a.equals("") && !b.equals("") && !c.equals(""))
                {
                    save();
                }
                else
                {


                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date c1= Calendar.getInstance().getTime();
                System.out.println("Current time => "+c1);
                SimpleDateFormat df=new SimpleDateFormat("dd-MMM-YYY");
                e="Credit"+"\n";
                d="Date: "+df.format(c1)+"\n\n";
                a="Rs."+e1.getText().toString()+"\n";
                b="Gateway: "+e2.getText().toString()+"\n";
                c="Purpose: "+e3.getText().toString()+"\n";
                if(!a.equals("") && !b.equals("") && !c.equals(""))
                {
                    save();
                }
                else
                {


                }
            }
        });
    }
    public void save()
    {
        e3.setText("File");
        FileOutputStream fos=null;
        try {
            fos=openFileOutput("File",MODE_APPEND);
            fos.write(e.getBytes());
            fos.write(a.getBytes());
            fos.write(b.getBytes());
            fos.write(c.getBytes());
            fos.write(d.getBytes());
            e1.getText().clear();
            e2.getText().clear();
            e3.getText().clear();
            Toast.makeText(this, "Saved to "+getFilesDir()+"/"+"File",Toast.LENGTH_SHORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                }
            }
        }

    }
}
