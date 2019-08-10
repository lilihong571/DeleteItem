package com.llh.deleterecyclerviewitem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * 项目名:    DeleteRecyclerViewItem
 * 包名:      com.llh.deleterecyclerviewitem
 * 文件名:    CheckDeleteAdapter
 * 创建者:    LLH
 * 创建时间:  2019/8/6 14:48
 * 描述:      TODO
 */
public class CheckDeleteAdapter extends RecyclerView.Adapter<CheckDeleteAdapter.MyViewHolder>{

   //创建链表
    private List<CheckDelete> checkDeleteList;
    //构造函数
    public CheckDeleteAdapter(List<CheckDelete> checkDeleteList){
        this.checkDeleteList = checkDeleteList;
    }

    //创建一个内部类，用来绑定该适配器绑定的布局中的子控件
    static class MyViewHolder extends RecyclerView.ViewHolder{
        //一个多选框
        CheckBox checkBox;
        //一个文本框
        TextView textView;
        //一个图片
        ImageView imageView;
        //构造函数  传入适配器绑定的布局
        public MyViewHolder(View view){
            super(view);
            //在适配器绑定的布局中绑定对应的子控件
            checkBox = view.findViewById(R.id.checkbox_select);
            textView = view.findViewById(R.id.tv_check_delete);
            imageView = view.findViewById(R.id.iv_delete);
        }

    }

    //给该适配器绑定布局，创建MyViewHolder的实例，返回实例
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_delete,viewGroup,false);
        //创建MyViewHolder实例
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    //用来
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        //通过i索引获取当前列表的item返回的是CheckDelete实例
        CheckDelete checkDelete = checkDeleteList.get(i);
        //给item中相应的控件赋值
        myViewHolder.checkBox.setChecked(checkDelete.getCheck());
        myViewHolder.textView.setText(checkDelete.getTextString());
        //给图片设置监听事件
        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除当前的item里面的控件
                removeData(i);
                Toast.makeText(v.getContext(),"你点击了删除按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }
    //删除子项函数
    public void removeData(int position){
        checkDeleteList.remove(position);
        //删除的时候不一定按照顺序删除的，也许是错位删除，这样会因为Position的原图造成角标越界异常，所以需要整体刷新一下
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return checkDeleteList.size();
    }
}
