package com.example.whatsappdirect;

import android.support.v7.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText number = (EditText) findViewById(R.id.num1);
                EditText message = (EditText) findViewById(R.id.mess);
                TextView result1 = (TextView) findViewById(R.id.result);

                String message1 = message.getText().toString();
                String s = number.getText().toString();

                int sum = 0;
                int sum1 = 0;

//                if (number.getText().toString().isEmpty()) {
//                    if (message.getText().toString().isEmpty()) {
//                        Alert_Dialog_Blank_Input1();
//                    }
//                }
//
//                if (number.getText().toString().length()!=10 && !number.getText().toString().isEmpty()) {
//                    Alert_Dialog_Blank_Input();
//                }

                if (number.getText().toString().isEmpty() && !message.getText().toString().isEmpty()) {
                    try {
                        String encoded = URLEncoder.encode(message1, "UTF-8");
                        String url1 = "https://wa.me/" + "?text=" + encoded;
                        result1.setText(url1);

                        for(int j=0; j<100000000; j++){
                            sum1=sum1+j;
                        }

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url1));
                        startActivity(i);
                    }
                    catch (UnsupportedEncodingException e) {
//                    Log.e("Exception: " + e.getMessage());
                    }
                }


                else if (message.getText().toString().isEmpty() && !number.getText().toString().isEmpty() && number.getText().toString().length() == 10) {

                    String url2 = "https://wa.me/" + "91" + s;
                    result1.setText(url2);

                    for(int j=0; j<100000000; j++){
                        sum=sum+j;
                    }

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url2));
                    startActivity(i);
                }

                else if (!message.getText().toString().isEmpty() && !number.getText().toString().isEmpty() && number.getText().toString().length() == 10){

                    try {
                        String encoded = URLEncoder.encode(message1, "UTF-8");
                        String url3 = "https://wa.me/" + "91" + s + "?text=" + encoded;
                        result1.setText(url3);

                        for(int j=0; j<100000000; j++){
                            sum1=sum1+j;
                        }

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url3));
                        startActivity(i);
                    }
                    catch (UnsupportedEncodingException e) {
//                    Log.e("Exception: " + e.getMessage());
                    }
                }

                else if (message.getText().toString().isEmpty() && number.getText().toString().isEmpty()){
                    Alert_Dialog_Blank_Input1();
                }


                else if (number.getText().toString().length()!=10 && !number.getText().toString().isEmpty()) {
                    Alert_Dialog_Blank_Input();
                }

            }
        });
    }

    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    public void Alert_Dialog_Blank_Input() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Error");
        builder.setMessage("Number to Sahi Daalo");
        AlertDialog alert = builder.create();
        alert.getWindow().setGravity(Gravity.CENTER);
        alert.show();
    }

    public void Alert_Dialog_Blank_Input1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Error");
        builder.setMessage("Kuch Daalo To");
        AlertDialog alert = builder.create();
        alert.getWindow().setGravity(Gravity.CENTER);
        alert.show();
    }
}









