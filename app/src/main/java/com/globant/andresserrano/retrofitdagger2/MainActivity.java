package com.globant.andresserrano.retrofitdagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.globant.andresserrano.retrofitdagger2.service.api.ApiJsonPlaceHolder;
import com.globant.andresserrano.retrofitdagger2.service.response.User;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject Retrofit retrofit;

    @BindView(R.id.tv_email) TextView tvEmail;
    @BindView(R.id.tv_name) TextView tvName;

    private int POSITION_RAMDON_USER = 0;
    private List<User> userList;

    private int MAX_RAGE = 9;
    private int MIN_RAGE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ButterKnife.bind( this );
        ((App) getApplication()).getNetComponent().inject( this );
        getUsers();


    }

    @OnClick(R.id.btn_random)
    public void getRandonUser() {

        if (userList != null && userList.size() > 0) {
            Random rn = new Random();
            int range = MAX_RAGE - MIN_RAGE + 1;
            POSITION_RAMDON_USER = rn.nextInt( range ) + MIN_RAGE;
            showUser();
        }

    }


    public void getUsers() {
        Call<List<User>> users = retrofit.create( ApiJsonPlaceHolder.class ).getUsers();
        users.enqueue( new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                userList = response.body();
                showUser();

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText( getApplication(), "onFailure get User" + t.getMessage(), Toast.LENGTH_LONG );
            }
        } );
    }

    private void showUser() {

        User user = userList.get( POSITION_RAMDON_USER );
        if (user != null) {
            tvEmail.setText( user.getEmail() );
            tvName.setText( user.getName() );
        }
    }
}
