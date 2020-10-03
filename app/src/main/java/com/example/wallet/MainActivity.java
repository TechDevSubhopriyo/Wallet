package com.example.wallet;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        Button a = findViewById(R.id.A);
        Button v = findViewById(R.id.V);
        Button r = findViewById(R.id.R);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Add.class);
                startActivity(i);
            }
        });

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Passbook.class);
                startActivity(i);
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Res();

            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alt = new AlertDialog.Builder(this);
        alt.setTitle("Alet!")
                .setCancelable(false)
                .setMessage("Are you sure you want to quit")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog a = alt.create();
        a.show();
    }

    public void Res() {
        AlertDialog.Builder alt = new AlertDialog.Builder(this);
        alt.setTitle("Alet!")
                .setCancelable(false)
                .setMessage("Reset will Clear all saved data. Are you sure you want to Reset? ")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FileOutputStream fos = null;
                        try {
                            fos = openFileOutput("File", 0);
                            fos.write("".getBytes());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
        AlertDialog a = alt.create();
        a.show();
    }
}
