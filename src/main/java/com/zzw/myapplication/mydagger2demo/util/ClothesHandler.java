package com.zzw.myapplication.mydagger2demo.util;

import com.zzw.myapplication.mydagger2demo.bean.Cloth;
import com.zzw.myapplication.mydagger2demo.bean.Clothes;

/**
 * Created by zqy on 2017/10/11.
 * 工具类,假设这个工具类每个activity都会用到
 */

public class ClothesHandler {
	public Clothes handle(Cloth cloth) {
		return new Clothes(cloth);
	}
}
