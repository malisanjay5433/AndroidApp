package com.example.sanjaymali.androidapp;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by sanjaymali on 18/11/17.
 */
public class DataItem extends ArrayAdapter<String> {
    private String[] names;
    private String[] desc;
    private  Integer[] imgId;
    private Activity context;
    public DataItem(@NonNull Activity context, String[] names,String[] desc, Integer[] imgId) {
        super(context,R.layout.row,names);
        this.names = names;
        this.context = context;
        this.desc = desc;
        this.imgId = imgId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if (r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.row,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)r.getTag();
        }
        if (desc[position] == "Developer"){
            viewHolder.tv1.setText(names[position]);
            viewHolder.tv2.setText(desc[position]);
            viewHolder.tv2.setTextColor(Color.DKGRAY);
        }else{
            viewHolder.tv1.setText(names[position]);
            viewHolder.tv2.setText(desc[position]);
            viewHolder.tv2.setTextColor(Color.MAGENTA);
        }
        viewHolder.iv.setImageResource(imgId[position]);
        return r;
    }

    class ViewHolder {
        TextView tv1;
        TextView tv2;
        ImageView iv;
        ViewHolder(View v){
            tv1 = v.findViewById(R.id.text1);
            tv2 = v.findViewById(R.id.text2);
            iv = v.findViewById(R.id.icon);
        }
    }
}
