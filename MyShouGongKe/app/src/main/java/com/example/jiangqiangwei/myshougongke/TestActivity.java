package com.example.jiangqiangwei.myshougongke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jiangqiangwei.myshougongke.http.HttpUtils;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        HttpUtils.getHttpUtils().getBannerData(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody responseBody) throws Exception {
                if(responseBody!=null){
                    String result = responseBody.string();
                    Log.i(">>>>",">>>"+ result);
                }
            }
        });
    }
}
