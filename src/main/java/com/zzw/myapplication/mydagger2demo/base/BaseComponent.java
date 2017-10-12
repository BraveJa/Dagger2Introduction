package com.zzw.myapplication.mydagger2demo.base;

import com.zzw.myapplication.mydagger2demo.util.ClothesHandler;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zqy on 2017/10/11.
 *
 * 这个Component怎么有点不一样,怎么没有inject方法呢?上面讲过,我们通过inject方法依赖需求方实例送到Component中,
 * 从而帮助依赖需求方实现依赖,但是我们这个BaseComponent是给其他Component提供依赖的,所以我们就可以不用inject方法,
 * 但是BaseComponent中多了一个getClothHandler方法,它的返回值是ClothHandler对象,这个方法有什么用呢?
 * 它的作用就是告诉依赖于BaseComponent的Component,BaseComponent能为你们提供ClothHandler对象,如果没有这个方法,
 * BaseComponent就不能提供ClothHandler对象(这个提供规则和上面的依赖规则相同,可以实现单例).既然有了BaseComponent,
 * 那我们就可在其它Component中依赖它了.我们删除MainModule和SecondModule中的getClothHandler方法
 *
 * 接下来在MainComponent和SecondComponent中声明依赖,就要用到@Component中的dependencies属性了:
 */
@Singleton
@Component(modules = BaseModule.class)
public interface BaseComponent {
	ClothesHandler getClothesHandler();
}
