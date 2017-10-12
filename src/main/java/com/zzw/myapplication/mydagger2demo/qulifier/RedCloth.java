package com.zzw.myapplication.mydagger2demo.qulifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by zqy on 2017/10/11.
 * 限定
 * 保留
 * 1.RetentionPolicy.SOURCE —— 这种类型的Annotations只在源代码级别保留,编译时就会被忽略
 * 2.RetentionPolicy.CLASS —— 这种类型的Annotations编译时被保留,在class文件中存在,但JVM将会忽略
 * 3.RetentionPolicy.RUNTIME —— 这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用.
 *
 * 有了这个注解,我们就可以用它在替换掉上面的@Named("red"),效果是一样的.读者可以亲自试一试.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface RedCloth {
}
