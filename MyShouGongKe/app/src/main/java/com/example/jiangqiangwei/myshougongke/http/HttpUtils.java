package com.example.jiangqiangwei.myshougongke.http;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by jiangqiangwei on 16/12/27.
 */

public class HttpUtils {
    private static HttpUtils httpUtils;
    private final ApiService apiService;

    private HttpUtils() {
        apiService = Api.getDefault();
    }
    public static HttpUtils getHttpUtils() {
        synchronized (HttpUtils.class) {
            if (httpUtils == null) {
                httpUtils = new HttpUtils();
            }
            return httpUtils;
        }
    }
    ////////////////////////////
    //所有访问接口写在这里面
    public void getBannerData(Consumer<ResponseBody> consumer){
        apiService.getHomeBanner()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }
}
