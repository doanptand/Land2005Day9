package com.t3h.day9.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.t3h.day9.R;
import com.t3h.day9.model.Message;

import java.util.List;

public class MessageAdapter extends BaseAdapter {
    private List<Message> arrMessages;
    private Context context;

    public MessageAdapter(List<Message> arrMessages, Context context) {
        this.arrMessages = arrMessages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return arrMessages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_message, parent, false);
            holder = new ViewHolder();
            holder.imgAvatar = view.findViewById(R.id.img_avatar);
            holder.tvMessage = view.findViewById(R.id.tv_message);
            holder.tvName = view.findViewById(R.id.tv_name);
            view.setTag(holder);
            Log.d("doanpt", "create new");
        } else {
            Log.d("doanpt", "use old");
            holder = (ViewHolder) view.getTag();
        }
        Message message = arrMessages.get(position);
        holder.tvMessage.setText(message.getMessage());
        holder.tvName.setText(message.getName());

        Glide.with(context)
                .load(R.drawable.ngoctrinh)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imgAvatar);
        return view;
    }

    class ViewHolder {
        ImageView imgAvatar;
        TextView tvName, tvMessage;
    }
    //    https://viblo.asia/p/tim-hieu-ve-layoutinflater-trong-android-07LKXzL2lV4
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = LayoutInflater.from(context)
//                .inflate(R.layout.item_message, parent, false);
//        ImageView imgAvatar = view.findViewById(R.id.img_avatar);
//        TextView tvName = view.findViewById(R.id.tv_name);
//        TextView tvMessage = view.findViewById(R.id.tv_message);
//
//        Message message = arrMessages.get(position);
//        tvMessage.setText(message.getMessage());
//        tvName.setText(message.getName());
//
//        Glide.with(context)
//                .load(R.drawable.ngoctrinh)
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
//                .into(imgAvatar);
//        return view;
//    }
}
