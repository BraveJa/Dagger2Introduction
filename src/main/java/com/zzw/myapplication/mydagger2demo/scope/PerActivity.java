package com.zzw.myapplication.mydagger2demo.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by zqy on 2017/10/11.
 * Scope范围(给对象的使用提供了一个范围,在这个范围内就是单利的@singleton就是@Scope的子类)
 * <p>
 * 这个注解有什么用呢?答案就是声明作用范围,当我们将这个注解使用在Module类中的Provide方法上时,
 * 就是声明这个Provide方法是在PerActivity作用范围内的,并且当一个Component要引用这个Module时,
 * 必须也要声明这个Component是PerActivity作用范围内的,否则就会报错,声明方法也很简单,就是在Component接口上使用这个注解.
 * 但是我们声明这个作用范围又有什么用呢?原来Dagger2有这样一个机制:在同一个作用范围内,Provide方法提供的依赖对象就会变成单例,
 * 也就是说依赖需求方不管依赖几次Provide方法提供的依赖对象,Dagger2都只会调用一次这个方法.就和上面那个例子一样,正常情况下,
 * 在注入MainActivity中的Cloth对象时会调用一次getRedCloth方法,注入Clothes对象时因为依赖Cloth对象,
 * 所以又会调用一次getRedCloth方法,导致这两个Cloth对象并不是同一个实例.但是我们给它声明作用范围后,
 * 这两次对Cloth的依赖只会调用一次getRedCloth方法,这样这两个Cloth对象就是同一实例了,这样就保证了在给MainActivity注入时,
 * 所有声明的Cloth依赖都是指向同一个实例.
 *
 * (注意:只有Module类中声明了作用范围的Provide方法才能实现单例,没声明的方法就不是单例的)
 * <p>
 * 查看源码你会发现Singleton其实是继承@Scope注解的,所以你知道了Singleton是怎么实现单例模式的吧.
 * 可能有些读者可能会问,Dagger2既然有了Singleton为什么还要我们自定义PerActivity注解?这就涉及到代码可读性了,
 * 当依赖需求方是Activity时,我们可以自定义一个PerActivity注解,当依赖需求方是Fragment时,我们又可以自定义一个PerFragment注解,
 * 这样我们就能清楚的区分依赖对象的提供目标了
 * 那我们通过构造函数提供依赖的方式又要怎么声明作用范围呢?答案就是在类名上使用注解标明,切记不要在构造函数上用注解标明,这样是无效的.
 * 读者可以试试用PerActivity注解代替上面例子中的Singleton注解,你会发现效果是一样的
 * <p>
 * 注意注意注意:单例是在同一个Component实例提供依赖的前提下才有效的,不同的Component实例只能通过Component依赖才能实现单例.
 * 也就是说,你虽然在两个Component接口上都添加了PerActivity注解,但是这两个Component提供依赖时是没有联系的,
 * 他们只能在各自的范围内实现单例.(下一个例子会体现到)
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
