package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.baidu.oauth.sdk.auth.AuthInfo;
import com.baidu.oauth.sdk.auth.BdOauthSdk;
import com.baidu.oauth.sdk.auth.BdSsoHandler;
import com.baidu.oauth.sdk.callback.BdOauthCallback;
import com.baidu.oauth.sdk.dto.BdOauthDTO;
import com.baidu.oauth.sdk.result.BdOauthResult;


import java.util.UUID;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private BdSsoHandler bdSsoHandler;
    private static final String TAG = "oauth_demo";
    private static final int REQUEST_QR_LOGIN = 2001;
    private static final int PERMISSIONS_REQUEST_CAMERA = 0;
    private static int scanQrCodeType;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.oauth_login).setOnClickListener(this);
        findViewById(R.id.oauth_qr_login_show).setOnClickListener(this);
        findViewById(R.id.oauth_qr_login_scan).setOnClickListener(this);


        initSdk();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.oauth_login:
                oauthLogin();
                break;
            case R.id.oauth_qr_login_show:
              //  oauthQrLoginShow();
                break;
            case R.id.oauth_qr_login_scan:
                //oauthQrLoginScan();
                break;

            default:
                break;

        }

    }






    private void oauthLogin() {
        bdSsoHandler = new BdSsoHandler(MainActivity2.this);
        BdOauthDTO bdOauthDTO = new BdOauthDTO();
        bdOauthDTO.oauthType = BdOauthDTO.OAUTH_TYPE_BOTH;
        // 重定向后会携带state参数，建议开发者利用state参数来防止CSRF攻击
        bdOauthDTO.state = UUID.randomUUID().toString();
        bdSsoHandler.authorize(bdOauthDTO, new BdOauthCallback() {
            @Override
            public void onSuccess(BdOauthResult result) {
              //  ViewUtility.showToast("code = " + result.getCode() + " state = " + result.getState());

            }

            @Override
            public void onFailure(BdOauthResult result) {
               // ViewUtility.showToast("result code = " + result.getResultCode() + " msg = " + result.getResultMsg());
//
                Log.e("","result code = " + result.getResultCode() + " msg = " + result.getResultMsg());
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = data == null ? "" : data.getStringExtra("extra_oauth_result_json");
        Log.d(TAG, "on Activity Result data is " + result);
        // 处理授权回调
        if (bdSsoHandler != null) {
            bdSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }

        if (data != null) {
            // 处理扫码pass sdk二维码通过手百授权登录设备，同时返回调用方accessToken信息
           /// handlerQrLogin(requestCode, resultCode, data);
        }
    }


    // 二维码扫码回调 产品线调用时通过自身APP获取到二维码内容







    /**
     * 初始化SDK
     */
    private void initSdk() {
        String redirectUrl = "passport.baidu.com";
        String scope = "basic";
        String appKey = "XXIlWUS6GYbkDIG0OAkGzhEt";
        AuthInfo authInfo = new AuthInfo(MainActivity2.this, appKey, redirectUrl, scope);
        BdOauthSdk.init(authInfo);
        authInfo.isDebug(true);
    }



}
