package com.niuduz.recycleview_different_item.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.niuduz.recycleview_different_item.R;
import com.niuduz.recycleview_different_item.module.Bean;

import java.util.List;

/**
 * 作    者 ：llw
 * 创建日期 ：2017/10/14 14:26
 * 描   述 ：
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * RecycleViewAdapter 要素点：
     * <p/>
     * 1，ViewHolder必须继承RecyclerView.ViewHolder
     * 2，RecycleView.Adapter的泛型为自定义ViewHolder
     */


    private List<Bean> mData;
    private Context context;

    public enum Item_Type {
        
        RECYCLEVIEW_ITEM_TYPE_1,
        RECYCLEVIEW_ITEM_TYPE_2,
        RECYCLEVIEW_ITEM_TYPE_3
    }

    public RecycleAdapter(Context context, List<Bean> mData) {
        this.mData = mData;
        this.context = context;
    }


    /**
     * 创建ViewHolder
     *
     * @param parent
     * @param viewType :不同ItemView的类型
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == Item_Type.RECYCLEVIEW_ITEM_TYPE_1.ordinal()) {
            View mView = LayoutInflater.from(context).inflate(R.layout.recycle_item_a, null);
            ViewHolderA viewHolder = new ViewHolderA(mView);
            return viewHolder;

        } else if (viewType == Item_Type.RECYCLEVIEW_ITEM_TYPE_2.ordinal()) {

            View mView = LayoutInflater.from(context).inflate(R.layout.recycle_item_b, null);
            ViewHolderB viewHolder = new ViewHolderB(mView);
            return viewHolder;
        } else if (viewType == Item_Type.RECYCLEVIEW_ITEM_TYPE_3.ordinal()) {
            View mView = LayoutInflater.from(context).inflate(R.layout.recycle_item_c, null);
            ViewHolderC viewHolder = new ViewHolderC(mView);
            return viewHolder;
        }

        return null;
    }


    /**
     * 绑定数据：可以直接拿到已经绑定控件的Viewholder对象
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolderA) {
            ((ViewHolderA) holder).text.setText(mData.get(position).getText() + "------样式一");
        } else if (holder instanceof ViewHolderB) {
            ((ViewHolderB) holder).text.setText(mData.get(position).getText() + "------样式二");
        } else if (holder instanceof ViewHolderC) {
            ((ViewHolderC) holder).text.setText(mData.get(position).getText() + "------样式三");
        }

    }


    //返回值赋值给onCreateViewHolder的参数 viewType
    @Override
    public int getItemViewType(int position) {

        if (mData.get(position).getType() == 0) {
            return Item_Type.RECYCLEVIEW_ITEM_TYPE_1.ordinal();
        } else if (mData.get(position).getType() == 1) {
            return Item_Type.RECYCLEVIEW_ITEM_TYPE_2.ordinal();
        } else if (mData.get(position).getType() == 2) {
            return Item_Type.RECYCLEVIEW_ITEM_TYPE_3.ordinal();
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolderA extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolderA(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }


    class ViewHolderB extends RecyclerView.ViewHolder {

        public TextView text;

        public ViewHolderB(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    class ViewHolderC extends RecyclerView.ViewHolder {

        public TextView text;

        public ViewHolderC(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }


}
