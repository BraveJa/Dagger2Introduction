package com.zzw.myapplication.mydagger2demo.bean;

/**
 * Created by zqy on 2017/10/11.
 * 衣服类,需要依赖布料类来做衣服
 */

public class Clothes {
	private Cloth cloth;

	public Clothes(Cloth cloth) {
		this.cloth = cloth;
	}

	public Cloth getCloth() {
		return cloth;
	}

	public void setCloth(Cloth cloth) {
		this.cloth = cloth;
	}

	@Override
	public String toString() {
		return cloth.getColor()+" 衣服 ";
	}
}
