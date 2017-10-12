package com.zzw.myapplication.mydagger2demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zzw.myapplication.mydagger2demo.bean.Cloth;
import com.zzw.myapplication.mydagger2demo.bean.Clothes;
import com.zzw.myapplication.mydagger2demo.bean.Shoe;
import com.zzw.myapplication.mydagger2demo.di.compnent.DaggerMainCompnent;
import com.zzw.myapplication.mydagger2demo.di.compnent.MainCompnent;
import com.zzw.myapplication.mydagger2demo.di.module.MainModule;
import com.zzw.myapplication.mydagger2demo.qulifier.RedCloth;
import com.zzw.myapplication.mydagger2demo.util.ClothesHandler;

import javax.inject.Inject;
import javax.inject.Named;

//http://blog.izouxiang.cn/2016/10/22/Dagger2%20%E5%85%A5%E9%97%A8/ 不敲一遍还以为自己都看会了

/*@Inject注解的字段不能是private和protected的.如果一定需要是private和protected的话,可以为该字段书写一个set方法,在该set方法上添加@Inject注解也可以声明. */

/*编写Module类时要在该类上声明@Module以表明该类是Module类,这样Dagger2才能识别*/

/*@Provides又是干嘛的呢?它的作用是声明Module类中哪些方法是用来提供依赖对象的,
 当Component类需要依赖对象时,他就会根据返回值的类型来在有@Provides注解的方法中选择调用哪个方法.在一个方法上声明@Provides注解,
 就相当于创建了一条生产线,这条生产线的产物就是方法的返回值类型.有了这条生产线,供应商就能提供这种类型的商品了,当商店老板发现有人需要这种类型的商品时,供应商就可以提供给他了*/

/*@Component注解有modules和dependencies两个属性,这两个属性的类型都是Class数组,modules的作用就是声明该Component含有哪几个Module,
当Component需要某个依赖对象时,就会通过这些Module类中对应的方法获取依赖对象,MainComponent中只包含MainModule,所以令modules=MainModule.class */

/*@Named注解,它怎么使用呢?它有一个value值,用来标识这个方法是给谁用的 因为dagger2是通过返回值来确定对象的,module里面返回相同的对象,就要用这个注解来区分了*/

/*@Qulifier功能和@Named一样,并且@Named就是继承@Qulifier的,我们要怎么使用@Qulifier注解呢?答案就是自定义一个注解:
有了这个注解,我们就可以用它在替换掉上面的@Named("red")*/
/*@Singleton 单利
* 1.首先,在module里面第一次提供对象的方getRedCloth方法上添加该注解
* 2.再在MainComponent接口上添加该注解*/

/*@Scope就是用来声明作用范围的.@Scope和@Qulifier一样,需要我们自定义注解才能使用,我们先自定义一个注解*/
public class MainActivity extends AppCompatActivity {
	@Inject
	//@Named("red")
	@RedCloth//自己写的注解 @Qulifier
			Cloth redCloth;//注入,但是注入到哪里,通过compnent来搭桥
	@Inject
	@Named("blue")
	Cloth blueCloth;
	@Inject
	Shoe shoe;//这个没有在module里面提供对象,但是在钩造方法上面加上了注解
	@Inject
	Clothes clothes;
	@Inject
	ClothesHandler clothHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) findViewById(R.id.tv);
		TextView tv2 = (TextView) findViewById(R.id.textView);
		findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});
		MainCompnent build =
				DaggerMainCompnent.builder().baseComponent(((APP)getApplication()).getBaseComponent()).mainModule(new MainModule()).build();
		/*MainCompnent build = DaggerMainCompnent.builder()
				.mainModule(new MainModule()).build();*/
		build.inject(this);//桥已经搭完了
		tv.setText("我现在有 " + redCloth + " 和 " + blueCloth + shoe + "还有" + clothes);//可以使用这个对象了
		tv2.setText("红布料加工后变成了" + clothHandler.handle(redCloth) + "\n clothHandler地址:" + clothHandler);
	}
}
