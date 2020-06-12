package com.my.network;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "t1";
    private TextView show_board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_board = (TextView) findViewById(R.id.tvId);
    }

    public void get_request_func(View view) {
        MyOkHttp.getInstance().requestGet("http://www.anant.club:8848/getTest", new MyOkHttp.OkHttpCallBack<String>() {

            @Override
            public void requestSuccess(String s) {
                showResponse(s);//更新ui
                Log.e(TAG, "success:" + s);
            }

            @Override
            public void requestFailure(String s) {
                Log.e(TAG, "failure:" + s);
                showResponse(s);//更新ui
            }
        }, String.class);
    }

    public void post_request_func(View view) {
        String urlStr = "http://www.anant.club:8848/getPost";
        ArrayMap<String, Object> parmas = new ArrayMap<>();
        parmas.put("username", "Dio");
        parmas.put("password", "13131313");
        parmas.put("argot", "You are geat!");
        parmas.put("num", 1111);

        MyOkHttp.getInstance().requestPost(urlStr, parmas, new MyOkHttp.OkHttpCallBack<String>() {
            @Override
            public void requestSuccess(String s) {
                Log.e(TAG, "success:" + s);
                showResponse(s);//更新ui
            }

            @Override
            public void requestFailure(String message) {
                Log.e(TAG, "failure:" + message);
                showResponse(message);//更新ui
            }
        }, String.class);
    }

    public void formdata_request_func(View view) {
        String url = "http://www.anant.club:8848/testFormdata";//接口地址

        ArrayMap<String, String> params = new ArrayMap<>();
        params.put("username", "dio");
        params.put("area", "guiyang");
        params.put("age", "19");
        params.put("action", "this is a action");

        MyOkHttp.getInstance().submitFormdata(url, params, new MyOkHttp.OkHttpCallBack<String>() {
            @Override
            public void requestSuccess(String s) {
                Log.e(TAG, "success:" + s);
                showResponse(s);//更新ui
            }

            @Override
            public void requestFailure(String message) {
                Log.e(TAG, "failure:" + message);
                showResponse(message);//更新ui
            }
        }, String.class);
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                show_board.setText(response);
            }
        });
    }
}
