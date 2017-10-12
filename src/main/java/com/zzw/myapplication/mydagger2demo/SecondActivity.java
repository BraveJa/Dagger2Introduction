package com.zzw.myapplication.mydagger2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zzw.myapplication.mydagger2demo.bean.Cloth;
import com.zzw.myapplication.mydagger2demo.di.compnent.DaggerSecondCompoenet;
import com.zzw.myapplication.mydagger2demo.di.compnent.SecondCompoenet;
import com.zzw.myapplication.mydagger2demo.di.module.SecondModule;
import com.zzw.myapplication.mydagger2demo.util.ClothesHandler;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {
	@Inject
	Cloth blueCloth;
	@Inject
	ClothesHandler clothHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		TextView tv = (TextView) findViewById(R.id.textView2);
		SecondCompoenet build =
				DaggerSecondCompoenet.builder().baseComponent(((APP)getApplication()).getBaseComponent()).secondModule(new SecondModule()).build();
		/*SecondCompoenet build = DaggerSecondCompoenet.builder().secondModule(new SecondModule()).build();*/
		build.inject(this);
		tv.setText("蓝布料加工后变成了" + clothHandler.handle(blueCloth) + "\nclothHandler地址:" + clothHandler);
	}
}
