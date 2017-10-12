package com.zzw.myapplication.mydagger2demo.base;

import com.zzw.myapplication.mydagger2demo.util.ClothesHandler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zqy on 2017/10/11.
 *
 */
@Module
public class BaseModule {
	@Singleton
	@Provides
	public ClothesHandler clothesHandler(){
		return new ClothesHandler();
	}
}
