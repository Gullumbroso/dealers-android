package com.dealers.dealers.server_apis;

import com.dealers.dealers.data.DealerItem;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by gullumbroso on 5/4/15.
 */
public interface DealersApi {

    @POST("/dealers/")
    void createDealer(@Body DealerItem dealer, Callback<DealerItem> request);

    @FormUrlEncoded
    @POST("/dealers-token-auth/")
    void getToken(@FieldMap Map<String, String> credentials, Callback<Map<String, String>> response);

    @GET("/dealerlogins/")
    void signDealerIn(Callback<DealerItem> response);
}
