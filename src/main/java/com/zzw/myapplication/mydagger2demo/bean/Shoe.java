package com.zzw.myapplication.mydagger2demo.bean;

import javax.inject.Inject;

/**
 * Created by zqy on 2017/10/11.
 * 鞋子,这个类没有在module里面声明对象
 * 而是在构造方法上面加上了@inject注解
 */

public class Shoe {
	@Inject
	public Shoe() {
	}

	@Override
	public String toString() {
		return " 鞋子 ";
	}
}
