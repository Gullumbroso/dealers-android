package com.dealers.dealers.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dealers.dealers.R;
import com.dealers.dealers.data.DealerItem;
import com.dealers.dealers.organizers.DealerOrganizer;
import com.dealers.dealers.server_apis.DealersApi;
import com.dealers.dealers.server_apis.ServerAPIGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SignInActivity extends Activity {

    private EditText emailField;
    private EditText passwordField;
    private Button signInButton;

    private String email;
    private String password;

    DealerItem mDealer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        setElements();
    }

    private void setElements() {
        emailField = (EditText) findViewById(R.id.emailField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        signInButton = (Button) findViewById(R.id.signInButton);
    }

    public void signIn(View view) {
        if (validate()) {
            email = emailField.getText().toString();
            password =  passwordField.getText().toString();
            showProgress();
            checkDealer();
        }
    }

    private void checkDealer() {
        DealersApi api = ServerAPIGenerator.createService(
                DealersApi.class,
                ServerAPIGenerator.BASE_URL,
                email,
                password);
        api.signDealerIn(new Callback<DealerItem>() {
            @Override
            public void success(DealerItem dealerItem, Response response) {
                Log.d("SignInActivity", "Signed up successfully!");
                mDealer = dealerItem;
                retrieveToken();
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });
    }

    private void retrieveToken() {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", email);
        credentials.put("password", password);
        DealersApi api = ServerAPIGenerator.createService(
                DealersApi.class,
                ServerAPIGenerator.BASE_URL,
                email,
                password);
        api.getToken(credentials, new Callback<Map<String, String>>() {
            @Override
            public void success(Map<String, String> map, Response response) {
                Log.d("SignInActivity", "Got token successfully!");
                hideProgress();
                String token = map.get("token");
                saveAndEnter(token);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d("SignInActivity", "Failed to get token.");
                hideProgress();
                new AlertDialog.Builder(SignInActivity.this)
                        .setTitle(getString(R.string.problem))
                        .setMessage(getString(R.string.please_try_again))
                        .setPositiveButton(getString(R.string.try_again), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                retrieveToken();
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .show();
            }
        });
    }

    private void saveAndEnter(String token) {
        DealerOrganizer organizer = new DealerOrganizer(this, mDealer);
        organizer.saveUserDetails();
        organizer.saveToken(token);
        // Enter Dealers...
    }

    private boolean validate() {
        if (!(emailField.getText().length() > 0)) {
            Toast.makeText(this, getString(R.string.enter_email), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(passwordField.getText().length() > 0)) {
            Toast.makeText(this, getString(R.string.enter_password), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    void showProgress() {
        final ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        if (progress.getVisibility() == View.INVISIBLE) {
            progress.setVisibility(View.VISIBLE);
            progress.setScaleX(0f);
            progress.setScaleY(0f);
            progress.setAlpha(0f);
            progress.animate()
                    .scaleX(1.0f)
                    .scaleY(1.0f)
                    .alpha(1.0f)
                    .setInterpolator(new DecelerateInterpolator());
            signInButton.setEnabled(false);
        }
    }

    void hideProgress() {
        final ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        if (progress.getVisibility() == View.VISIBLE) {
            progress.animate()
                    .scaleX(0f)
                    .scaleY(0f)
                    .alpha(0f)
                    .setInterpolator(new DecelerateInterpolator())
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            progress.setVisibility(View.INVISIBLE);
                            signInButton.setEnabled(true);
                        }
                    });
        }
    }
}
