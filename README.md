# MakeJarAAR
# Glin架构
## 这次写的是[loader](http://blog.csdn.net/qibin0506 "撸撸的博客")的封装后的网络架构，在此基础上，把API提供给大家，另外添加一些自定义的控件，方便开发~持续更新~谢谢~ <br> 

### API：
    1.GlideUtil：图片缓存框架，支持圆角
    //1
    GlideUtil.display(MainActivity.this, iv1, "http://img0.bdstatic.com/img/image/touxiang01.jpg",GlideOptionsFactory.get(GlideOptionsFactory.Type.RADIUS)); 
    //2
    GlideOptions glideOptions = new GlideOptions(R.drawable.pic_head, R.drawable.pic_head, 300);
    GlideUtil.display(MainActivity.this, iv2, "http://img0.bdstatic.com/img/image/touxiang01.jpg", glideOptions);
    //3
    GlideUtil.display(MainActivity.this, iv3, "http://img0.bdstatic.com/img/image/touxiang01.jpg");
<br>
    
    2.请求网络方法：doNewWork("id");
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
<br>
[![梁肖51CTO]](http://liangxiao.blog.51cto.com/)  
[梁肖51CTO]:https://raw.githubusercontent.com/geeklx/geeklx.github.com/master/images/shiningchen/shiningchen114.png "梁肖51CTO" 
### 未完待续....
