package com.dealers.dealers.server_apis;

import android.util.Base64;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by gullumbroso on 5/5/15.
 */
public class ServerAPIGenerator {

    public static final String BASE_URL = "http://www.dealers-web.com";
    // The test server: http://d-web-tier-elb-113029594.eu-west-1.elb.amazonaws.com

    private ServerAPIGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl, String username, String password) {
        RestAdapter.Builder builder = basicAdapterBuilder(baseUrl);
        if (username != null && password != null) {
            final String credentials = username + ":" + password;
            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    String string = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", string);
                }
            });
        }
        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl, final String token) {
        RestAdapter.Builder builder = basicAdapterBuilder(baseUrl);

        if (token != null) {
            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Authorization", token);
                }
            });
        }

        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }

    private static RestAdapter.Builder basicAdapterBuilder(String baseUrl) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return new RestAdapter.Builder()
                .setEndpoint(baseUrl)
                .setConverter(new GsonConverter(gson))
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL);
    }
}
