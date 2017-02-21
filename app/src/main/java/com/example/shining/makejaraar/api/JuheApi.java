package com.example.shining.makejaraar.api;

import com.example.myshininglibrary.glin.annotation.Arg;
import com.example.myshininglibrary.glin.annotation.POST;
import com.example.myshininglibrary.glin.call.Call;
import com.example.shining.makejaraar.domain.DemoJuheFileModel;
import com.example.shining.makejaraar.domain.DemoJuheModel;

import java.io.File;

import static com.example.shining.makejaraar.constant.ConstantNetUtil.SERVER_JUHE;

/**
 * Created by shining on 2017/2/10 0010.
 */

public interface JuheApi {
    @POST(SERVER_JUHE + "toutiao/index")
    Call<DemoJuheModel> getList(@Arg("type") String type, @Arg("key") String key);

    @POST("http://japi.juhe.cn/voice_words/getWords")
    Call<DemoJuheFileModel> getfile(@Arg("file") File file, @Arg("rate") String rate, @Arg("pname") String pname, @Arg("device_id") String device_id, @Arg("key") String key);

}
