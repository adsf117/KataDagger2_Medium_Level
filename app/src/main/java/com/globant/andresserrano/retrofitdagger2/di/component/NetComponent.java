package com.globant.andresserrano.retrofitdagger2.di.component;

import com.globant.andresserrano.retrofitdagger2.MainActivity;
import com.globant.andresserrano.retrofitdagger2.di.module.AppModule;
import com.globant.andresserrano.retrofitdagger2.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}
