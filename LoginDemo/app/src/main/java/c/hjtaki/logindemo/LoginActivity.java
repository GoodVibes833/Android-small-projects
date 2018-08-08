package c.hjtaki.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.accountkit.AccessToken;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class LoginActivity extends AppCompatActivity {

    public static final int APP_REQUEST_CODE =1;
    private AppEventsLogger logger;
    private CallbackManager callbackManager;
    private LoginButton fbloginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AccessToken accessToken = AccountKit.getCurrentAccessToken();
        //60days?
        if(accessToken != null){
            launchMainActivity();
        }

        logger = AppEventsLogger.newLogger(this);
        callbackManager = CallbackManager.Factory.create();

        fbloginButton = findViewById(R.id.login_button);
        fbloginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                launchMainActivity();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(LoginActivity.this, error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        // check for an existing access token
        AccessToken accessToken1 = AccountKit.getCurrentAccessToken();
        com.facebook.AccessToken loginToken = com.facebook.AccessToken.getCurrentAccessToken();
        if(accessToken1 != null || loginToken != null){
            //if previously loged in, proceed to the account activity
            launchMainActivity();
        }



    }


    private void launchMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }

    private void onLogin(final LoginType logintype){
        //create intent for the account kit activity
        Intent intent = new Intent(this, AccountKitActivity.class);
        AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder
                = new AccountKitConfiguration.AccountKitConfigurationBuilder(
                logintype,
                AccountKitActivity.ResponseType.TOKEN
                // if there is own server change TOKEN to CODE
        );
        AccountKitConfiguration config = configurationBuilder.build();
        intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION, config);
        startActivityForResult(intent, APP_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode,resultCode,data);

        super.onActivityResult(requestCode, resultCode, data);
        // confirm that this response matches our request
        if(requestCode == APP_REQUEST_CODE){
            AccountKitLoginResult loginResult
                    = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            if(loginResult.getError() != null){
                Toast.makeText(this,loginResult.getError().getErrorType().getMessage(),Toast.LENGTH_LONG).show();
            }else if(loginResult.getAccessToken() != null){
                // on successful login, launch the MainActivity
                launchMainActivity();
            }
        }
    }

    public void onPhoneLogin(View view) {
        logger.logEvent("onSMSLogin");
        onLogin(LoginType.PHONE);

    }


    public void onEmailLogin(View view) {
        logger.logEvent("onEmailLogin");
        onLogin(LoginType.EMAIL);

    }
}
