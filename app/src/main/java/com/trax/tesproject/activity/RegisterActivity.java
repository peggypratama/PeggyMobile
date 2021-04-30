package com.trax.tesproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.trax.tesproject.R;
import com.trax.tesproject.model.Base;
import com.trax.tesproject.model.login.login;
import com.trax.tesproject.network.Builder;
import com.trax.tesproject.network.InterfaceAPI;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity  implements Validator.ValidationListener {

    @NotEmpty(message = "Tidak boleh kosong")
    @BindView(R.id.edtlogin)
    EditText email;

    @NotEmpty(message = "Tidak boleh kosong")
    @BindView(R.id.edtpassword)
    EditText password;

    @NotEmpty(message = "Tidak boleh kosong")
    @BindView(R.id.edtusername)
    EditText username;

    InterfaceAPI interfaceAPI;
    Call<Base> call;
    Validator validator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @OnClick(R.id.btnregister)
    public void onclick(){
        validator.validate();
    }


    @Override
    public void onValidationSucceeded() {
        register();
    }

    public void register(){
        interfaceAPI = Builder.createService(InterfaceAPI.class);
        call = interfaceAPI.register(email.getText().toString(), password.getText().toString(), username.getText().toString());
        call.enqueue(new Callback<Base>() {
            @Override
            public void onResponse(Call<Base> call, Response<Base> response) {
                Base respon = response.body();
                //Toast.makeText(RegisterActivity.this, respon.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println(respon);
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }

            @Override
            public void onFailure(Call<Base> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, ""+t, Toast.LENGTH_SHORT).show();
                System.out.print(""+t);
            }
        });
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}