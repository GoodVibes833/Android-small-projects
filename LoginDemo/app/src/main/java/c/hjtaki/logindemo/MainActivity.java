package c.hjtaki.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.Profile;
import com.facebook.accountkit.AccessToken;
import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.PhoneNumber;
import com.facebook.login.LoginManager;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView phoneTextView;
    private TextView emailTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneTextView = findViewById(R.id.tv_phone);
        emailTextView = findViewById(R.id.tv_email);

        if (com.facebook.AccessToken.getCurrentAccessToken() != null) {
            Profile currentProfile = Profile.getCurrentProfile();
            if (currentProfile != null) {
                emailTextView.setText(currentProfile.getFirstName() + " " + currentProfile.getLastName());
            } else {
                //fetch the profile, whici will trigger the onCurrentProfile changed receiver
                Profile.fetchProfileForCurrentAccessToken();
            }
        } else {
            AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
                @Override
                public void onSuccess(Account account) {
                    if (account.getPhoneNumber() != null) {
                        PhoneNumber phoneNumber = account.getPhoneNumber();
                        String formatteredPhoneNumber = formatPhoneNumber(phoneNumber.toString());
                        phoneTextView.setText(formatteredPhoneNumber);
                    } else {
                        String email = account.getEmail();
                        emailTextView.setText(email);
                    }
                }

                @Override
                public void onError(AccountKitError accountKitError) {

                }
            });
        }
    }

    public void onLogout(View view) {
        AccountKit.logOut();
        LoginManager.getInstance().logOut();
        launchLoginActivity();
    }

    private void launchLoginActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private String formatPhoneNumber(String phoneNumber) {
        try {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber pn = phoneNumberUtil.parse(phoneNumber, Locale.getDefault().getCountry());
            phoneNumber = phoneNumberUtil.format(pn, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
        } catch (NumberParseException npe) {
            npe.printStackTrace();
        }
        return phoneNumber;
    }
}
