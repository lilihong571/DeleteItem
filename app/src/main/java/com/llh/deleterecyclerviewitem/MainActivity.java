package com.llh.deleterecyclerviewitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //声明控件
    private RecyclerView recyclerView;
    //创建链表
    private List<CheckDelete> checkDeleteList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.rv_main);
        //创建线性布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //给recyclerView设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //给链表添加值
        initCheckDelete();
        Log.d("llhData", "onCreate: "+checkDeleteList.size());
        //创建适配器
        CheckDeleteAdapter checkDeleteAdapter = new CheckDeleteAdapter(checkDeleteList);
        //设置列表项的点击时间
        //recyclerView.set

        //设置适配器
        recyclerView.setAdapter(checkDeleteAdapter);
        //外面控件的删除

    }

    private void initCheckDelete() {
        for (int i=0,len=10;i<len;i++){
            //创建CheckDelete实例
            CheckDelete checkDelete = new CheckDelete(false,"这是一个待删除的视图");
            checkDeleteList.add(checkDelete);
        }
    }
}
