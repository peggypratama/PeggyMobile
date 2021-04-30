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


public class MainActivity extends AppCompatActivity implements Validator.ValidationListener {

    @NotEmpty(message = "Tidak boleh kosong")
    @BindView(R.id.edtlogin)
    EditText username;

    @NotEmpty(message = "Tidak boleh kosong")
    @BindView(R.id.edtpassword)
    EditText password;

    InterfaceAPI interfaceAPI;
    Call<Base> call;
    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @OnClick({R.id.btnloign, R.id.btnr})
    public void Onclick(View view){
        switch (view.getId()){
            case R.id.btnloign:
                ;validator.validate();
                break;
            case R.id.btnr:
                    startActivity(new Intent(MainActivity.this, RegisterActivity.class)
                    );
                    break;
        }
    }

    public void loginn(){
     interfaceAPI = Builder.createService(InterfaceAPI.class);
     call = interfaceAPI.login(password.getText().toString(), username.getText().toString());
     call.enqueue(new Callback<Base>() {
         @Override
         public void onResponse(Call<Base> call, Response<Base> response) {
             Base respon = response.body();
             System.out.println(response.body());
             System.out.println(respon);

             //startActivity(new Intent(MainActivity.this, HomeActivity.class));
         }

         @Override
         public void onFailure(Call<Base> call, Throwable t) {
             Toast.makeText(MainActivity.this, ""+t, Toast.LENGTH_SHORT).show();
         }
     });
    }

    @Override
    public void onValidationSucceeded() {
        loginn();
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