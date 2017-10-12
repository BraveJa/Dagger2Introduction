package com.zzw.myapplication.mydagger2demo;

import android.app.Application;

import com.zzw.myapplication.mydagger2demo.base.BaseComponent;
import com.zzw.myapplication.mydagger2demo.base.BaseModule;
import com.zzw.myapplication.mydagger2demo.base.DaggerBaseComponent;

/**
 * Created by zqy on 2017/10/11.
 */

public class APP extends Application {

	public BaseComponent baseComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		baseComponent = DaggerBaseComponent.builder().baseModule(new BaseModule()).build();
	}

	public BaseComponent getBaseComponent() {
		return baseComponent;
	}
}
