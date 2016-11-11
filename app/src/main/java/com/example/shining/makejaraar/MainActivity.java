package com.example.shining.makejaraar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.myshininglibrary.glin.Callback;
import com.example.myshininglibrary.glin.Result;
import com.example.myshininglibrary.glinsample.net.Net;
import com.example.shining.makejaraar.api.DemoApi;
import com.example.shining.makejaraar.domain.DemoModel;
import com.example.shining.makejaraar.domain.DemoModel_item;
import com.example.shining.makejaraar.domain.DemoModel_list;
import com.example.shining.makejaraar.params.DemoParams;
import com.example.shining.makejaraar.utils.glinutils.ParamsUtils;
import com.example.shining.makejaraar.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DemoModel demoModel;
    private DemoModel_item demoModel_item;
    private List<DemoModel_list> demoModel_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doNewWork("id");
    }

    private void doNewWork(String user_id) {
        DemoParams p = new DemoParams(user_id);
        Net.build(DemoApi.class, getClass().getName()).getDemoModel(ParamsUtils.just(p)).enqueue(new Callback<DemoModel>() {
            @Override
            public void onResponse(Result<DemoModel> result) {
                if (result.isOK()) {
                    demoModel = new DemoModel();
                    demoModel_item = new DemoModel_item();
                    demoModel_list = new ArrayList<DemoModel_list>();
                    demoModel_item = result.getResult().getPage_info();
                    demoModel_list = result.getResult().getFood_list();
                    if (demoModel_list != null && demoModel_list.size() > 0) {
                        //有数据状态
                        //处理自己的逻辑 你要是不会 神都救不了你了~
                        ToastUtil.showToastCenter("有数据");
                    } else {
                        //无数据状态
                        //可以使用自定义布局 参考：http://liangxiao.blog.51cto.com/3626612/1851105
                        ToastUtil.showToastCenter("无数据");
                    }
                } else {
                    //无网状态
                    ToastUtil.showToastCenter("无网状态 请重新请求服务器！");
                }
            }
        });
    }
}
