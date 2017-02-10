package com.example.shining.makejaraar.api;

import com.example.myshininglibrary.glin.annotation.Arg;
import com.example.myshininglibrary.glin.annotation.POST;
import com.example.myshininglibrary.glin.call.Call;
import com.example.shining.makejaraar.domain.DemoJuheModel;

import static com.example.shining.makejaraar.constant.ConstantNetUtil.SERVER_JUHE;

/**
 * Created by shining on 2017/2/10 0010.
 */

public interface JuheApi {
    @POST(SERVER_JUHE+"toutiao/index")
    Call<DemoJuheModel> getList(@Arg("type") String type, @Arg("key") String key);
}
