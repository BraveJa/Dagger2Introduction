package com.zzw.myapplication.mydagger2demo.di.compnent;

import com.zzw.myapplication.mydagger2demo.MainActivity;
import com.zzw.myapplication.mydagger2demo.base.BaseComponent;
import com.zzw.myapplication.mydagger2demo.di.module.MainModule;
import com.zzw.myapplication.mydagger2demo.scope.PerActivity;

import dagger.Component;

/**
 * Created by zqy on 2017/10/11.
 */
@PerActivity
@Component(modules = MainModule.class,dependencies = BaseComponent.class)
public interface MainCompnent {
	void inject(MainActivity activity);
}
