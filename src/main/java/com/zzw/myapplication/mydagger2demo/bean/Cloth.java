package com.zzw.myapplication.mydagger2demo.bean;

/**
 * Created by zqy on 2017/10/11.
 * 布料类
 */

public class Cloth {
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return color + "  布料";
	}
}
