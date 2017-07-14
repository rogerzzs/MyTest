package com.example.zhangzhongshuai.mytest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends Activity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = ((TextView)findViewById(R.id.firstText));
        final TextStatus textStatus = TextStatus.getTextStatus(1);
        textView.setText(textStatus.mDesc);
        GetVersionService service = RetrofitUtils.getRetrofit().create(GetVersionService.class);
        service.getVersionData("2.3.0").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                textView.setText(response.body().string());
                            }catch (IOException e){

                            }
                        }
                    });
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    interface GetVersionService{
        @GET(ServerAPI.GET_APP_VRESION + "{versionCode}")
        Call<ResponseBody> getVersionData(@Path(value = "versionCode",encoded = true) String versionCode);
    }
}
