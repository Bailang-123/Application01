package com.example.demo03.app;

import android.app.Application;
import android.content.Context;

import com.example.demo03.dao.DaoMaster;
import com.example.demo03.dao.DaoSession;
import com.uuzuche.lib_zxing.ZApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class MyApp extends ZApplication {
   private  static DaoSession mDaoSession;
   public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        initDatabase();
        context = this;
        ZXingLibrary.initDisplayOpinion(this);

    }

    private void initDatabase() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this,"bailang.db");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDb());
        mDaoSession = daoMaster.newSession();
    }
    public static DaoSession getmDaoSession(){
        return mDaoSession;
    }
}
