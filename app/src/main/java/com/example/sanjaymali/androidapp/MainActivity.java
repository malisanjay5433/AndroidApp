package com.example.sanjaymali.androidapp;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Arrays;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
//    String[] names;
//    String[] desingation;
//    int[] img{R.drawable.p1,R.drawable.p1, R.drawable.p1, R.drawable.p1, R.drawable.p1};
    String[] names = {"Sanjay","Vishwa","Firoz","Ganesh","Raj","Mahesh","Varun","Amol","Jaanvi"};
    String[] desingation = {"Developer","Sales","Marketing","PR","Marketing","Developer","Sales","Marketing","PR"};
    Integer[] imgId = {R.drawable.p1,R.drawable.p1,R.drawable.p1,R.drawable.p1,R.drawable.p1,R.drawable.p1,R.drawable.p1,R.drawable.p1,R.drawable.p1};
    String[] sortName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       list = (ListView) findViewById(R.id.list1);
        final DataItem dataItem = new DataItem(this,names,desingation,imgId);
        Arrays.sort(names);
       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(MainActivity.this, names[i] + " has designation:"+desingation[i], Toast.LENGTH_SHORT).show();
           }
       });
        list.setAdapter(dataItem);
    }
}