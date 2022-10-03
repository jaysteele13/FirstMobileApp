package com.example.week1practical;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class txtMessage extends AppCompatActivity {
    final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;
    Button send;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt_message);

        send = (Button) findViewById(R.id.btn_send);
        //send.setEnabled(false);
    }

    private boolean checkPermission(String permission) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, permission);
        return (permissionCheck == getPackageManager().PERMISSION_GRANTED);
    }

        public void send(View view) {
            String phoneNumber = ((EditText) findViewById(R.id.edit_Phone)).getText().toString();
            String msg = ((EditText) findViewById(R.id.edit_Message)).getText().toString();

            if (phoneNumber == null || phoneNumber.length() == 0 || msg == null || msg.length() == 0) {
                return; }
            if(checkPermission(Manifest.permission.SEND_SMS)) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, msg, null, null);
                Toast.makeText(this, "Your message has been sent", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No Permission", Toast.LENGTH_SHORT).show();
            }


    }




}