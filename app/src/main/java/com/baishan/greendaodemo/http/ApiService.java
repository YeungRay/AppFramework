package com.baishan.greendaodemo.http;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;


/**
 *
 */
public interface ApiService {
    //baseUrl
//    String HOST = "http://192.168.0.101:8012/";
    String HOST = "http://111.47.198.193:8033/";
    String API_SERVER_URL = HOST + "api/";


    /**
     * 获取验证码
     */
    Observable<ResultResponse<String>> getCode(@Field("phone") String phone, @Field("state") int state);


    /**
     * 更新信息
     */
//    @GET(APP_UPDATE)
//    Observable<UpdateInfo> getUpdateInfo();

    /**
     * 下载更新apk
     */
    @Streaming
    @GET
    Observable<ResponseBody> downloadApk(@Url String path);

}
