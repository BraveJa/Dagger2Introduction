package com.zzw.myapplication.mydagger2demo.di.module;

import com.zzw.myapplication.mydagger2demo.bean.Cloth;
import com.zzw.myapplication.mydagger2demo.bean.Clothes;
import com.zzw.myapplication.mydagger2demo.qulifier.RedCloth;
import com.zzw.myapplication.mydagger2demo.scope.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zqy on 2017/10/11.
 */
@Module
public class MainModule {
	@Provides
	@PerActivity
	//@Named("red")
	@RedCloth
	public Cloth provideRedCloth() {
		Cloth cloth = new Cloth();
		cloth.setColor(" 红色 ");
		return cloth;
	}

	@Provides
	@Named("blue")
	public Cloth provideBlueCloth() {
		Cloth cloth = new Cloth();
		cloth.setColor(" 蓝色 ");
		return cloth;
	}

	@Provides
	public Clothes provideClothes(@Named("blue") Cloth cloth) {
		//Dagger2提供了这样的功能,我们只要在getClothes方法中添加Cloth参数,Dagger2就会像帮依赖需求方找依赖对象一样帮你找到该方法依赖的Cloth实例,所以我们代码可以这样改
		// Cloth cloth = new Cloth();
		// cloth.setColor("红色");
		// return new Clothes(cloth);
		return new Clothes(cloth);
	}

    //自己写的范围注解,单利同@Singleton
	/*@Singleton
	@Provides
	public ClothesHandler provideHandle() {
		return new ClothesHandler();
	}*/
}
