package ca.hjtaki.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";


    public MyService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"oncreat() 호출댐");
    }


    @Override // 명령어를 처리해 주세요 : 메인에서 보낸 인텐트는 여기서 받아야 한다. 한번 만들어지면 실행이 되어있기에
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand() 호출댐");

        if(intent == null){
            return Service.START_STICKY; // 다시 자동 실행
        }else{
            processCommand(intent); // 아래
        }

        return super.onStartCommand(intent, flags, startId);


    }

    private void processCommand(Intent intent){
       String command = intent.getStringExtra("command"); // 명령어를 구분하기위해 메세지를 띄움 다른 메세지도 ㅇㅋ
       String name =  intent.getStringExtra("name");

        Log.d(TAG,"받은 메세지  : "+ command + name);

        try {
            Thread.sleep(5000); // 5초 쉬기
        }catch(Exception e){}

        //화면이 없는 서비스를 액티비티에 띄우면 테스크가 없어서 에러가 난다
        // -> addflags 옵션을 준다

        Intent showIntent = new Intent(getApplicationContext(),MainActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                            Intent.FLAG_ACTIVITY_SINGLE_TOP|
                             Intent.FLAG_ACTIVITY_CLEAR_TOP);

        showIntent.putExtra("command","show");
        showIntent.putExtra("name",name +"from service");

        startActivity(showIntent); //


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() 호출댐");

    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
