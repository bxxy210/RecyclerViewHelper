package com.hadlink.recyclerviewhelpper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.hadlink.recyclerviewhelpper.unrelated.FuelAdapter;
import com.hadlink.recyclerviewhelpper.unrelated.FuelBean;
import com.hadlink.rvhelpperlib.adapter.OnRVItemClickListener;
import com.hadlink.rvhelpperlib.adapter.RecyclerViewAdapter;
import com.hadlink.rvhelpperlib.adapter.ViewHolderHelper;
import com.hadlink.rvhelpperlib.decoration.CommonItemDecoration;
import com.hadlink.rvhelpperlib.decoration.GridItemDecoration;
import com.hadlink.rvhelpperlib.manager.WRGridLayoutManager;
import com.hadlink.rvhelpperlib.manager.WRLinearLayoutManager;
import com.hadlink.rvhelpperlib.utils.DensityUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*demo1();*/

        demo2();


    }

    private void demo2() {
        List<FuelBean> beanList = new ArrayList<>();
        beanList.add(new FuelBean("1000", 96, "1000加油卡"));
        beanList.add(new FuelBean("100", 94, "100加油卡"));
        beanList.add(new FuelBean("10000", 98, "10000加油卡"));
        beanList.add(new FuelBean("500", 93, "500加油卡"));
        beanList.add(new FuelBean("500", 93, "500加油卡"));
        beanList.add(new FuelBean("500", 93, "500加油卡"));
        beanList.add(new FuelBean("500", 93, "500加油卡"));
        beanList.add(new FuelBean("500", 93, "500加油卡"));
        rv.setLayoutManager(new WRGridLayoutManager(this, 2));
        final FuelAdapter fuelAdapter = new FuelAdapter(rv, beanList);
        fuelAdapter.setOnRVItemClickListener(new OnRVItemClickListener() {
            @Override public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                fuelAdapter.setSelectItem(position, null);
            }
        });
        rv.addItemDecoration(new GridItemDecoration(2, DensityUtils.dip2px(this, 10f), true));
        /*rv.addItemDecoration(new CommonItemDecoration(DensityUtils.dip2px(this, 14f)));*/
        rv.setAdapter(fuelAdapter);
    }

    private void demo1() {
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "aaaaaaaaa", "bbbbbbbbbbbb", "ccccccccccc");
        rv.addItemDecoration(new CommonItemDecoration(14));
        rv.setLayoutManager(new WRLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new RecyclerViewAdapter<String>(rv, R.layout.item1, strings) {

            @Override protected void fillData(ViewHolderHelper viewHolderHelper, int position, String model) {
                viewHolderHelper.setText(R.id.tv, model);
            }
        });
    }

}