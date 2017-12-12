package com.bdhs.bosspone.http;



import com.bdhs.bosspone.presenter.shopinfo.ShopInfoRequest;
import com.bdhs.bosspone.presenter.shopinfo.ShopinfoResponse;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 网络访问接口
 */
public interface NetworkService {

    @POST("login_boss/login_in")
    Observable<ShopinfoResponse> handleLogin(@Body ShopInfoRequest bean);

    @FormUrlEncoded
    @POST("login_boss/login_in")
    Observable<ShopinfoResponse> getShopInfo(@Field("shop_id") String seller_name,
                                          @Field("sign") String seller_pwd,
                                          @Field("b_box") String b_box,
                                          @Field("v") String v);
}
