package com.example.jiangqiangwei.myshougongke.http;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

import com.example.jiangqiangwei.myshougongke.R;

/**
 * 网络工具类，需要 android.permission.ACCESS_NETWORK_STATE 权限
 */

public class NetWorkUtil {

    private boolean flag = false;
    private static ConnectivityManager connectivityManager;
    private static NetworkInfo localNetworkInfo;

    /**
     * 判断设备有没有网络
     */

    public  boolean isNetConnectedTwoTwo(final Context context) {
     connectivityManager = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE));
        localNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable())) {
            return true;
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle("网络提示信息");
            builder.setMessage("网络不可用，如果继续，请先设置网络！");
            builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = null;
                    /**
                     * 判断手机系统的版本！如果API大于10 就是3.0+
                     * 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同
                     */
                    if (android.os.Build.VERSION.SDK_INT > 10) {
                        intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
                    } else {
                        intent = new Intent();
                        ComponentName component = new ComponentName(
                                "com.android.settings",
                                "com.android.settings.WirelessSettings");
                        intent.setComponent(component);
                        intent.setAction("android.intent.action.VIEW");
                    }
                    context.startActivity(intent);
                }
            });

            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.create();
            builder.show();
        }
        return flag;
    }

    //判断网络的状态

    /**
     * 网络已经连接，然后去判断是wifi连接还是GPRS连接
     * 设置一些自己的逻辑调用
     */
    /**
     * 判断设备有没有网络
     */
    public static boolean isNetConnected(Context context) {
        NetworkInfo localNetworkInfo = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return (localNetworkInfo != null) && (localNetworkInfo.isAvailable());
    }



}
