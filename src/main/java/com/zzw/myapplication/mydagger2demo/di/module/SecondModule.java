package com.zzw.myapplication.mydagger2demo.di.module;

import com.zzw.myapplication.mydagger2demo.bean.Cloth;
import com.zzw.myapplication.mydagger2demo.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zqy on 2017/10/11.
 *
 */


@Module
public class SecondModule {

	//@PerActivity 这里不能用这个自己写的注解,会报错
	@PerActivity
	@Provides
	public Cloth getBlueCloth() {
		Cloth cloth = new Cloth();
		cloth.setColor("蓝色");
		return cloth;
	}
	//写了BaseModule后这个不用了
	/*@Singleton
	@Provides
	public ClothesHandler getClothHandler() {
		return new ClothesHandler();
	}*/
}
