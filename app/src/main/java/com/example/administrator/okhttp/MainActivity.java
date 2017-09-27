package com.example.administrator.okhttp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

        yibuqingqiu();
    }

    public void yibuqingqiu() {
        OkHttpClient client = new OkHttpClient();
        Request builder = new Request.Builder().url("http://huixinguiyu.cn/Assets/js/data.js").build();

        Call call = client.newCall(builder);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {//失败的操作

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
               // 比如我们希望获得返回的字符串，可以通过response.body().string()获取；
                // 如果希望获得返回的二进制字节数组，则调用response.body().bytes()；
                // 如果你想拿到返回的inputStream，则调用response.body().byteStream()
                tv.setText(s.toString());
            }
        });
    }
}
