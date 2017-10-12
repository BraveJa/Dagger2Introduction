package com.zzw.myapplication.mydagger2demo.di.compnent;

import com.zzw.myapplication.mydagger2demo.SecondActivity;
import com.zzw.myapplication.mydagger2demo.base.BaseComponent;
import com.zzw.myapplication.mydagger2demo.di.module.SecondModule;
import com.zzw.myapplication.mydagger2demo.scope.PerActivity;

import dagger.Component;

/**
 * Created by zqy on 2017/10/11.
 */
//自定义注解范围,同@Singleton单利
@PerActivity
@Component(modules = SecondModule.class,dependencies = BaseComponent.class)
public interface SecondCompoenet {
	void inject(SecondActivity secondActivity);
}
