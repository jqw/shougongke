package com.example.jiangqiangwei.myshougongke.http;


import com.example.jiangqiangwei.myshougongke.baseconfig.PathConfig;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface ApiService {
    // 系列页面广告接口
    @GET(PathConfig.HOME_BANNERS)
    Flowable<ResponseBody> getHomeBanner();
}
