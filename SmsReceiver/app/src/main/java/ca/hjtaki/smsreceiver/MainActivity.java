package ca.hjtaki.smsreceiver;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //위험권한 부여

        // 이미 있는지 확인
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        if(permissionCheck == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"SMS 수신권한 이미 있음 ",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"SMS 수신권한 없음  ",Toast.LENGTH_LONG).show();

//            //설명이 필요하면
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.RECEIVE_SMS)){
//                Toast.makeText(this,"권한 설명 필요함 ", Toast.LENGTH_LONG).show();
//            }else{
//                //시스템에 권한 요청함
//                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.RECEIVE_SMS},1);
//
//            }

        }

    }

    // 권한 요청후 받았는지 확인 하기 오버라이드
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1: // 코드가 1로 세팅했음으로
                if (grantResults.length>0){
                if (grantResults[0]== getPackageManager().PERMISSION_GRANTED){
                    Toast.makeText(this, "sms 수신권한을 사용자가 승인함", Toast.LENGTH_LONG).show();
                }else if  (grantResults[0]== getPackageManager().PERMISSION_DENIED){
                    Toast.makeText(this, "sms 수신권한을 사용자가 거부함", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(this,"SMS 수신권한을 부여받지 못함",Toast.LENGTH_LONG).show();
                }


            }
        }
    }
}
