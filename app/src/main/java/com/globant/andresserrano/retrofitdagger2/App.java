package com.globant.andresserrano.retrofitdagger2;


import android.app.Application;

import com.globant.andresserrano.retrofitdagger2.di.component.DaggerNetComponent;
import com.globant.andresserrano.retrofitdagger2.di.component.NetComponent;
import com.globant.andresserrano.retrofitdagger2.di.module.AppModule;
import com.globant.andresserrano.retrofitdagger2.di.module.NetModule;

public class App extends Application {

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(BuildConfig.JSONPLACEHOLDER_API_URL))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
