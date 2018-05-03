package com.niuduz.recycleview_different_item;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.niuduz.recycleview_different_item.manager.ModelChangeManager;
import com.niuduz.recycleview_different_item.module.Bean;
import com.niuduz.recycleview_different_item.recycleview.RecycleAdapter;
import com.niuduz.recycleview_different_item.recycleview.RecycleItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //设置适配器管理器：LinearLayoutManager GridLayoutManager StaggeredGridLayoutManager(瀑布流)，
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        //添加分割线
        mRecyclerView.addItemDecoration(new RecycleItemDecoration(context, RecycleItemDecoration.VERTICAL_LIST));

        mRecyclerView.setAdapter(new RecycleAdapter(context, initData()));
    }


    private List<Bean> initData() {

        List<Bean> mData = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {

            Bean bean = new Bean();
            bean.setText((char) i + "");
            int type = i % 3;
            if (type == 0) {
                bean.setType(0);
            } else if (type == 1) {
                bean.setType(1);
            } else if (type == 2) {
                bean.setType(2);
            }
            ModelChangeManager.INSTANCE.start();

            mData.add(bean);
        }
        return mData;
    }
}
