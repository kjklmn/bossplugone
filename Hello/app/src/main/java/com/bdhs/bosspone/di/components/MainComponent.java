package com.bdhs.bosspone.di.components;

import com.bdhs.bosspone.di.modules.MainModule;
import com.bdhs.bosspone.ui.activity.MainActivity;

import dagger.Component;

/**
 * 项目名称：Hello
 * 类描述：
 * 创建人：kejian
 * 创建时间：2017-12-12 10:54
 * 修改人：Administrator
 * 修改时间：2017-12-12 10:54
 * 修改备注：
 */

@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
