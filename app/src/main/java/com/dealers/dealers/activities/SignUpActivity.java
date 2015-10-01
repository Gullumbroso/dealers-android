package com.dealers.dealers.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dealers.dealers.R;
import com.dealers.dealers.data.DealerItem;
import com.dealers.dealers.data.UserItem;
import com.dealers.dealers.dialogs.DatePickerFragment;
import com.dealers.dealers.dialogs.GenderPickerFragment;
import com.dealers.dealers.organizers.DealerOrganizer;
import com.dealers.dealers.server_apis.DealersApi;
import com.dealers.dealers.server_apis.ServerAPIGenerator;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SignUpActivity extends Activity implements DatePickerFragment.OnSelectDateListener, GenderPickerFragment.OnSelectGenderListener, View.OnClickListener {

    // UI elements
    private EditText fullNameField;
    private EditText emailField;
    private EditText passwordField;
    private TextView dateOfBirthField;
    private TextView genderField;
    private Button mSignUpButton;

    private DealerItem mDealer;

    private Calendar dateOfBirth;
    private DateFormat dateFormatter;

    private static final String username = "ubuntu";
    private static final String password = "090909deal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initialize();
        setElements();
    }

    private void initialize() {
        TextView terms = (TextView) findViewById(R.id.termsTextView);
        terms.setMovementMethod(LinkMovementMethod.getInstance());
        dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
    }

    private void setElements() {
        fullNameField = (EditText) findViewById(R.id.fullNameField);
        emailField = (EditText) findViewById(R.id.emailField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        dateOfBirthField = (TextView) findViewById(R.id.dateOfBirthField);
        dateOfBirthField.setOnClickListener(this);
        genderField = (TextView) findViewById(R.id.genderField);
        genderField.setOnClickListener(this);
        mSignUpButton = (Button) findViewById(R.id.signUpButton);
    }

    public void onSelectDate(Calendar calendar) {
        if (calendar != null) {
            dateOfBirth = calendar;
            String formattedDate = dateFormatter.format(calendar.getTime());
            dateOfBirthField.setText(formattedDate);
            dateOfBirthField.setTextColor(getResources().getColor(R.color.black));
        } else {
            resetDateOfBirth();
        }
    }

    public void resetDateOfBirth() {
        dateOfBirth = null;
        dateOfBirthField.setText(getResources().getString(R.string.date_of_birth_hint));
        dateOfBirthField.setTextColor(getResources().getColor(R.color.light_gray_text));
    }

    @Override
    public void onSelectGender(String gender) {
        if (gender != null) {
            genderField.setText(gender);
            genderField.setTextColor(getResources().getColor(R.color.black));
        } else {
            genderField.setText(getResources().getString(R.string.gender_hint));
            genderField.setTextColor(getResources().getColor(R.color.light_gray_text));
        }
    }

    @Override
    public void onClick(View v) {
        if (v == dateOfBirthField) {
            DialogFragment newFragment = DatePickerFragment.newInstance(dateOfBirth);
            newFragment.show(getFragmentManager(), "datePicker");
        } else if (v == genderField) {
            DialogFragment genderFragment = new GenderPickerFragment();
            genderFragment.show(getFragmentManager(), "genderPicker");
        }
    }

    public void signUp(View view) {
        if (validate()) {
            showProgress();
            saveUserDetails();
            uploadData();
        }
    }

    private boolean validate() {
        if (!(fullNameField.getText().toString().length() > 0)) {
            Toast.makeText(this, getString(R.string.enter_name), Toast.LENGTH_SHORT).show();
            return false;
        } else if (!(emailField.getText().toString().length() > 0)) {
            Toast.makeText(this, getString(R.string.enter_email), Toast.LENGTH_SHORT).show();
            return false;
        } else if (!(passwordField.getText().toString().length() > 0)) {
            Toast.makeText(this, getString(R.string.enter_password), Toast.LENGTH_SHORT).show();
            return false;
        } else if (dateOfBirth != null) {
            if (dateOfBirth.after(Calendar.getInstance())) {
                Toast.makeText(this, getString(R.string.enter_valid_birth_Date), Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    private void saveUserDetails() {
        mDealer = new DealerItem();
        mDealer.setFullName(fullNameField.getText().toString());
        mDealer.setEmail(emailField.getText().toString());
        mDealer.setUser(new UserItem());
        if (mDealer.getEmail().length() > 30) {
            mDealer.getUser().setUsername(mDealer.getEmail().substring(0, 30));
        } else {
            mDealer.getUser().setUsername(mDealer.getEmail());
        }
        mDealer.getUser().setPassword(passwordField.getText().toString());
        if (dateOfBirth != null) {
            mDealer.setDateOfBirth(dateOfBirth.getTime());
        }
        if (genderField.getText().equals(getString(R.string.male))) {
            mDealer.setGender(genderField.getText().toString());
        } else if (genderField.getText().equals(getString(R.string.female))) {
            mDealer.setGender(genderField.getText().toString());
        }
        mDealer.setRegisterDate(new Date());
    }

    private void uploadData() {
        DealersApi api = ServerAPIGenerator.createService(
                DealersApi.class,
                ServerAPIGenerator.BASE_URL,
                username,
                password);
        api.createDealer(mDealer, new Callback<DealerItem>() {
            @Override
            public void success(DealerItem dealerItem, Response response) {
                Log.d("SignUpActivity", "Signed up successfully!");
                mDealer = dealerItem;
                retrieveToken();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d("SignUpActivity", "Failed to sign up.");
                hideProgress();
                new AlertDialog.Builder(SignUpActivity.this)
                        .setTitle(getString(R.string.problem))
                        .setMessage(getString(R.string.please_try_again))
                        .setCancelable(true)
                        .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }

    private void retrieveToken() {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", mDealer.getUser().getUsername());
        credentials.put("password", passwordField.getText().toString());
        DealersApi api = ServerAPIGenerator.createService(
                DealersApi.class,
                ServerAPIGenerator.BASE_URL,
                username,
                password);
        api.getToken(credentials, new Callback<Map<String, String>>() {
            @Override
            public void success(Map<String, String> map, Response response) {
                Log.d("SignUpActivity", "Got token successfully!");
                hideProgress();
                String token = map.get("token");
                saveAndEnter(token);
            }
            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d("SignUpActivity", "Failed to get token.");
                hideProgress();
                new AlertDialog.Builder(SignUpActivity.this)
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
            mSignUpButton.setEnabled(false);
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
                            mSignUpButton.setEnabled(true);
                        }
                    });
        }
    }
}
