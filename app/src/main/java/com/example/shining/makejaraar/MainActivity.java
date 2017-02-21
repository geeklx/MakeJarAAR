package com.example.shining.makejaraar;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myshininglibrary.glin.Callback;
import com.example.myshininglibrary.glin.Result;
import com.example.myshininglibrary.glinsample.glide.GlideOptions;
import com.example.myshininglibrary.glinsample.glide.GlideUtil;
import com.example.myshininglibrary.glinsample.juhenet.JuheNet;
import com.example.myshininglibrary.glinsample.net.Net;
import com.example.myshininglibrary.utilslib.device.DeviceUtil;
import com.example.shining.makejaraar.api.DemoApi;
import com.example.shining.makejaraar.api.JuheApi;
import com.example.shining.makejaraar.domain.DemoJuheFileModel;
import com.example.shining.makejaraar.domain.DemoJuheModel;
import com.example.shining.makejaraar.domain.DemoModel;
import com.example.shining.makejaraar.domain.DemoModel_item;
import com.example.shining.makejaraar.domain.DemoModel_list;
import com.example.shining.makejaraar.domain.DemoWeatherModel;
import com.example.shining.makejaraar.params.DemoParams;
import com.example.shining.makejaraar.utils.glinutils.ParamsUtils;
import com.example.shining.makejaraar.utils.loadingutils.MaterialProgressLoadingUtil;

import java.io.File;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DemoModel demoModel;
    private DemoModel_item demoModel_item;
    private List<DemoModel_list> demoModel_list;
    private ImageView iv1;
    private TextView tv_context1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv_context1 = (TextView) findViewById(R.id.tv_context1);
        GlideOptions glideOptions = new GlideOptions(R.drawable.pic_head, R.drawable.pic_head, 300);
        GlideUtil.display(MainActivity.this, iv1, "http://img0.bdstatic.com/img/image/touxiang01.jpg", glideOptions);
//        GlideUtil.display(MainActivity.this, iv1, "http://img0.bdstatic.com/img/image/touxiang01.jpg", GlideOptionsFactory.get(GlideOptionsFactory.Type.RADIUS));
//        doNewWork("id");
//        doNetWork_juhe("shehui", "03972d8ebd2a40194a80fa019b314fa3");
        //内置sd卡路径
        String sdcardPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Sounds/001.wav";
        File file = new File(sdcardPath);
        String rate = "16000";
        String pname = MainActivity.this.getPackageName();
        String device_id = DeviceUtil.getMac(this);
        String key = "76fe50b78862b2450ee9f24c8622fd3f";
        doNetWork_juhe_flie(file, rate, pname, device_id, key);
    }

    /**
     * 根据后台JSON格式协议解析的请求方式
     *
     * @param user_id
     * @JSON
     */
    private void doNewWork(String user_id) {
        Net.getInstance().get().cancel(getClass().getName() + "MainActivityTAG");
        MaterialProgressLoadingUtil.showProgressDialog(this, "加载中....");
        DemoParams p = new DemoParams(user_id);
        Net.build(DemoApi.class,
                getClass().getName() + "MainActivityTAG").getDemoModel(ParamsUtils.just(null)).enqueue(new Callback<DemoWeatherModel>() {
            @Override
            public void onResponse(Result<DemoWeatherModel> result) {
                if (result.isOK()) {
                    DemoWeatherModel dwm = result.getResult();
                    if (dwm != null) {
                        tv_context1.setText(dwm.getQlty() + "," + dwm.getTxt() + "," + dwm.getTmp());
                    }
//                    demoModel = new DemoModel();
//                    demoModel_item = new DemoModel_item();
//                    demoModel_list = new ArrayList<DemoModel_list>();
//                    demoModel_item = result.getResult().getPage_info();
//                    demoModel_list = result.getResult().getFood_list();
//                    if (demoModel_list != null && demoModel_list.size() > 0) {
//                        //有数据状态
//                        //处理自己的逻辑 你要是不会 神都救不了你了~
//                        ToastUtil.showToastCenter("有数据");
//                    } else {
//                        //无数据状态
//                        //可以使用自定义布局 参考：http://liangxiao.blog.51cto.com/3626612/1851105
//                        ToastUtil.showToastCenter("无数据");
//                    }
                } else {
                    //无网状态
//                    ToastUtil.showToastCenter("无网状态 请重新请求服务器！");
                }
//                MaterialProgressLoadingUtil.dismissProgressDialog();
            }
        });
    }

    /**
     * 直接根据地质拼接键值对解析的请求方式
     *
     * @param type
     * @param key
     */
    private void doNetWork_juhe(String type, String key) {
        JuheNet.getsInstance().get().cancel(getClass().getName() + "MainActivityTAG_JUHE");
//        String params = "{\"type\":\"" + type + "\",\"key\":\"" + key + "\"}";
        JuheNet.build(JuheApi.class, getClass().getName() + "MainActivityTAG_JUHE").getList(type, key).enqueue(new Callback<DemoJuheModel>() {
            @Override
            public void onResponse(Result<DemoJuheModel> result) {
                if (!result.isOK()) {
                    return;
                }
                DemoJuheModel djm = result.getResult();
                if (djm != null) {
                    tv_context1.setText(djm.getResult().getStat());
                }
            }
        });
    }

    /**
     * 直接根据地质拼接键值对解析的请求方式
     */
    private void doNetWork_juhe_flie(File file, String rate, String pname, String device_id, String key) {
        JuheNet.getsInstance().get().cancel(getClass().getName() + "MainActivityTAG_JUHE_FILE");
//        String params = "{\"type\":\"" + type + "\",\"key\":\"" + key + "\"}";
        JuheNet.build(JuheApi.class, getClass().getName() + "MainActivityTAG_JUHE_FILE").getfile(file, rate, pname, device_id, key).enqueue(new Callback<DemoJuheFileModel>() {
            @Override
            public void onResponse(Result<DemoJuheFileModel> result) {
                if (!result.isOK()) {
                    return;
                }
                String djm = result.getResult().getResult();
                tv_context1.setText(djm);
            }
        });
    }


}
