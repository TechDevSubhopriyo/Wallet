package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Passbook extends AppCompatActivity {
    TextView viewit;
    Button d,c,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_passbook);
        getSupportActionBar().hide();
        viewit =findViewById(R.id.tv);
        d=findViewById(R.id.button);
        c=findViewById(R.id.button2);
        r=findViewById(R.id.button5);
        FileInputStream fis=null;
        String u="";
        try {
            fis=openFileInput("File");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            String text;
            while((text=br.readLine())!=null) {
                u=u+"\n"+text;
            }

            fis.close();

        }
        catch(Exception e)
        {}
        viewit.setText(u);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deb();

            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cre();
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref();
            }
        });

    }
    public void ref()
    {
        FileInputStream fis=null;
        String u="";
        try {
            fis=openFileInput("File");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            String text;
            while((text=br.readLine())!=null) {
                u=u+"\n"+text;
            }

            fis.close();

        }
        catch(Exception e)
        {}
        viewit.setText(u);
    }
    public void deb()
    {
        String s="";
        FileInputStream fis=null;
        try {
            fis=openFileInput("File");
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String text;
            while((text=br.readLine())!=null)
            {
                if(text.equals("Debit"))
                {
                    s=s+br.readLine()+"\n";
                    s=s+br.readLine()+"\n";
                    s=s+br.readLine()+"\n";
                    s=s+br.readLine()+"\n\n";
                }
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewit.setText(s);
    }
    public void cre()
    {
        String s="";
        FileInputStream fis=null;
        try {
            fis=openFileInput("File");
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String text;
            while((text=br.readLine())!=null)
            {
                if(text.equals("Credit"))
                {
                    s=s+br.readLine()+"\n";
                    s=s+br.readLine()+"\n";
                    s=s+br.readLine()+"\n";
                    s=s+br.readLine()+"\n\n";
                }
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewit.setText(s);
    }
}
