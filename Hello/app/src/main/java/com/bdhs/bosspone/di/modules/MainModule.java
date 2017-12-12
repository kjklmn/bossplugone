package com.bdhs.bosspone.di.modules;

import com.bdhs.bosspone.base.BaseMvpView;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：Hello
 * 类描述：
 * 创建人：kejian
 * 创建时间：2017-12-12 10:48
 * 修改人：Administrator
 * 修改时间：2017-12-12 10:48
 * 修改备注：
 */
@Module
public class MainModule {
    private final BaseMvpView mView;

    public MainModule(BaseMvpView view) {
        mView = view;
    }

    @Provides
    BaseMvpView provideMainView() {
        return mView;
    }

}
