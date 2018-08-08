package ca.hjtaki.smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {

    private  static final String TAG = "SmsReceiver";

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm");

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"onReceive() 호출됨");

        Bundle bundle = intent.getExtras();//인텐트 안에 있는 추가 데이터 뽑아내기

        SmsMessage[] messages = parseSmsMessage(bundle); // 이 메소드로 뽑아서 어레이에 저장

        if(messages.length>0){
            String sender = messages[0].getOriginatingAddress(); // 발신번호
            Log.d(TAG,"sender : " + sender);

            String contents = messages[0].getMessageBody().toString(); // 내용
            Log.d(TAG,"contents : " + contents);

            Date receivedDate = new Date(messages[0].getTimestampMillis()); // 내용
            Log.d(TAG,"date received : "+ receivedDate);
            // 로그에는 나오는데 화면에 띄우고 싶다면 인텐트를 만들어 담아주고 액티비티에 띠우면 된다 .


            sendToActivity(context,sender,contents,receivedDate);


        }


    }

    private void sendToActivity(Context context,String sender , String contents, Date receivedDate){
        Intent intent = new Intent(context,Sms2Activity.class); // 이 클래스를 띄워라
        context.startActivity(intent);

        //리시버,수신자는 화면이 없으므로 뉴 테스크 플래그가 필요하다
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        |Intent.FLAG_ACTIVITY_SINGLE_TOP
                        |Intent.FLAG_ACTIVITY_CLEAR_TOP
        );

        //부가 데이터 넣자
        intent.putExtra("sender",sender);
        intent.putExtra("contents",contents);
        intent.putExtra("receivedDate", format.format(receivedDate));



    }


    private SmsMessage[] parseSmsMessage(Bundle bundle){ // 리스트로 반환
        Object[] objs = (Object[]) bundle.get("pdu");
                    // pdus : 국제 표준 프로토콜 smpp 안에 이런 이름으로 데이터가 있다 :sms과 관련된 데이터
                    // 캐스팅후 어레이에 넣어준다
        SmsMessage[] messages =  new SmsMessage[objs.length];

        for(int i =0; i<objs.length; i++){

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){ // 마시멜로 이후 버전
                String format = bundle.getString("format");
                SmsMessage.createFromPdu((byte[])objs[i],format);
            }else{
                messages[i] = SmsMessage.createFromPdu((byte[])objs[i]); // 이전버전
            }
//

//            SmsMessage.createFromPdu((byte[])objs[i]);  // pdu  위에서 얻은걸 던저라 ,

        }


        return messages; // sms 데이터가 들어가있다 .

    }
}
