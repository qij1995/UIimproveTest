package com.example.administrator.uiimprovetest;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marvinlabs.widget.slideshow.SlideShowAdapter;
import com.marvinlabs.widget.slideshow.SlideShowView;
import com.marvinlabs.widget.slideshow.adapter.GenericBitmapAdapter;
import com.marvinlabs.widget.slideshow.adapter.ResourceBitmapAdapter;
import com.marvinlabs.widget.slideshow.picasso.GenericPicassoBitmapAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mDatas=new ArrayList<>();
    private SlideShowView slideShowView;
    private SlideShowAdapter adapter;
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private int[] ID1;
    public int i;
    public int j;

    private Integer[] slideResources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        getSupportActionBar().hide();
        txt3 = (TextView) findViewById(R.id.text3);
        txt2 = (TextView) findViewById(R.id.text4);
        txt1 = (TextView) findViewById(R.id.text1);
        //添加删除线
        txt1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        Intent intent = getIntent();
        txt3.setText(intent.getStringExtra("name"));
        txt2.setText(intent.getStringExtra("price"));
        txt1.setText(intent.getStringExtra("price2"));
        ID1= intent.getIntArrayExtra("resource");

        initDatas();
        //得到控件
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置适配器
        mAdapter = new GalleryAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);
        slideShowView = (SlideShowView) findViewById(R.id.slideshow);


    }

    /**
     * 以下是从网上直接copy过来的第三方工具使用方法
     */
    private SlideShowAdapter createAdapter() {
        slideResources=new Integer[ID1.length];
        for(i=0;i<=ID1.length-1;i++){
            slideResources[i] = ID1[i];
        }
//        Integer[] slideResources = new Integer[]{R.drawable.one, R.drawable.two, R.drawable.
//                three, R.drawable.four, R.drawable.five, R.drawable.six};
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 2;
        adapter = new ResourceBitmapAdapter(this, Arrays.asList(slideResources), opts);
        return adapter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        startSlideShow();
    }

    @Override
    protected void onStop() {
        //instanceof 它的作用是判断其左边对象是否为其右边类的实例，返回boolean类型的数据
        if (adapter instanceof GenericBitmapAdapter) {
            ((GenericBitmapAdapter) adapter).shutdown();
        } else if (adapter instanceof GenericPicassoBitmapAdapter) {
            ((GenericPicassoBitmapAdapter) adapter).shutdown();
        }
        super.onStop();
    }

    private void startSlideShow() {
        // Create an adapter
        // slideShowView.setAdapter(createResourceAdapter());
        slideShowView.setAdapter(createAdapter());
        // slideShowView.setAdapter(createPicassoAdapter());

        // Optional customisation follows
        // slideShowView.setTransitionFactory(new RandomTransitionFactory());
        // slideShowView.setPlaylist(new RandomPlayList());

        // Some listeners if needed
        //  slideShowView.setOnSlideShowEventListener(createAdapter);
        //  slideShowView.setOnSlideClickListener(createAdapter);

        // Then attach the adapter
        slideShowView.play();
    }
    /**
     * 以下是从网上直接copy过来的RecyclerView使用
     */
    private void initDatas() {
for(j=0;j<=ID1.length-1;j++){
    mDatas.add(ID1[j]);
}
// mDatas = new ArrayList<>(Arrays.asList(R.drawable.one, R.drawable.two, R.drawable.
//         three, R.drawable.four, R.drawable.five, R.drawable.six));

    }

    public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
        private LayoutInflater mInflater;
        private List<Integer> mDatas;

        public GalleryAdapter(Context context, List<Integer> datats) {
            mInflater = LayoutInflater.from(context);
            mDatas = datats;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(View arg0) {
                super(arg0);
            }

            ImageView mImg;
//                TextView mTxt;
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        /**
         * 创建ViewHolder
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = mInflater.inflate(R.layout.recycler_item,
                    viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(view);

            viewHolder.mImg = (ImageView) view
                    .findViewById(R.id.item_image);
            return viewHolder;
        }

        /**
         * 设置值
         */
        @Override
        public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
            viewHolder.mImg.setImageResource(mDatas.get(i));
        }

    }

}
