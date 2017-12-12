package com.bdhs.bosspone.presenter.shopinfo;

import com.bdhs.bosspone.base.BaseMvpView;
import com.bdhs.bosspone.base.BasePresenter;
import com.bdhs.bosspone.base.BaseResponse;
import com.bdhs.bosspone.model.shopinfo.ObtainShopInfo;
import com.bdhs.bosspone.model.shopinfo.OnObtainListener;
import com.bdhs.bosspone.utils.LogUtils;

/**
 * 项目名称：Hello
 * 类描述：
 * 创建人：kejian
 * 创建时间：2017-12-11 17:31
 * 修改人：Administrator
 * 修改时间：2017-12-11 17:31
 * 修改备注：
 */
public class ShopInfoPresenter extends BasePresenter<BaseMvpView> {
    private ObtainShopInfo obtainShopInfo;

    public ShopInfoPresenter() {
        this.obtainShopInfo = new ObtainShopInfo();
    }

    //,final OnLoginListener l
    public void getShopInfo(ShopInfoRequest shopInfoRequest) {
        checkViewAttached();
        getMvpView().showLoading();
        obtainShopInfo.getShopInfo(shopInfoRequest, new OnObtainListener() {
            @Override
            public void OnResultSucc(BaseResponse baseResponse) {
                if (isViewAttached()) {
                    getMvpView().hideLoading();
                    getMvpView().toMainActivity(baseResponse);
                }
            }

            @Override
            public void OnResultFail(Throwable throwable) {
                if (isViewAttached()) {
                    if(getMvpView() !=null) {
                        getMvpView().hideLoading();
                        getMvpView().showFailedError(throwable);
                    } else {
                        LogUtils.w("kejian","getMvpView is null");
                    }
                }
            }
        });
    }
}
