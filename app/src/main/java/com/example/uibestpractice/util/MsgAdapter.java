package com.example.uibestpractice.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.uibestpractice.R;
import com.example.uibestpractice.entity.Msg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 安维 on 2017/4/26.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> msgList=new ArrayList<>();
    public MsgAdapter(List<Msg> msgs){
        msgList=msgs;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView leftTextView;
        TextView rightTextView;
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout=(LinearLayout)itemView.findViewById(R.id.left_layout);
            rightLayout=(LinearLayout)itemView.findViewById(R.id.right_layout);
            leftTextView=(TextView)itemView.findViewById(R.id.left_msg);
            rightTextView=(TextView)itemView.findViewById(R.id.right_msg);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg=msgList.get(position);
        if(msg.getType()==Msg.TYPE_SEND) {
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightTextView.setText(msg.getContent());
        }else if(msg.getType()==Msg.TYPE_RECEIVED){
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.leftTextView.setText(msg.getContent());
        }
    }
}
