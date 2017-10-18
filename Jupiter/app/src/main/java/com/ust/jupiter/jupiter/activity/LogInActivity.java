package com.ust.jupiter.jupiter.activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ust.jupiter.jupiter.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LogInActivity extends AppCompatActivity {

    @InjectView(R.id.et_username)
    EditText etUsername;
    @InjectView(R.id.et_password)
    EditText etPassword;
    @InjectView(R.id.bt_go)
    Button btGo;
    @InjectView(R.id.cv)
    CardView cv;
    @InjectView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        SharedPreferences sharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE);
        String account = sharedPreferences.getString("account","");
        String password = sharedPreferences.getString("password","");
        if(!account.isEmpty()) {
            etUsername.setText(account);
            etPassword.setText(password);
        }

    }

    @OnClick({R.id.bt_go, R.id.fab})
    public void onClick(View view) {
        String username = etUsername.getText().toString();
        String userPasswd = etPassword.getText().toString();
        switch (view.getId()) {
            case R.id.fab:
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options =
                            ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
                    startActivity(new Intent(this, RegisterActivity.class), options.toBundle());
                } else {
                    startActivity(new Intent(this, RegisterActivity.class));
                }
                break;
            case R.id.bt_go:
                if (loginChecker(username, userPasswd)) {
                    Intent i2 = new Intent(this, com.ust.jupiter.jupiter.activity.MainActivity.class);
                    startActivity(i2);
                } else {

            }
                break;
        }
    }

    private Boolean loginChecker(String username, String userpasswd) {
        return true;
    }
}
