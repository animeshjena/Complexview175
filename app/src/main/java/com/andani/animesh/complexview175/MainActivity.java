package com.andani.animesh.complexview175;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity
{
    String[]title,description;ListView lv;
    int []img={R.drawable.pi1,R.drawable.pi3,R.drawable.pi4,R.drawable.pi6,R.drawable.pi7,R.drawable.pi9,R.drawable.dango_nyan05,R.drawable.download};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res=getResources();
        title=res.getStringArray(R.array.title);
        description=res.getStringArray(R.array.description);
        lv=(ListView)findViewById(R.id.listView);
        Andani andani=new Andani(this,title,description,img);
        lv.setAdapter(andani);
    }


}
class Myholder
{
    ImageView img;
    TextView t1;
    TextView t2;
    Myholder(View v)
    {
        img=(ImageView)v.findViewById(R.id.imageView);
        t1=(TextView)v.findViewById(R.id.textView);
        t2=(TextView)v.findViewById(R.id.textView2);

    }
}
class  Andani extends ArrayAdapter
{
    Context c;
    String[]title,desc;
    int[]img;
    Andani(Context c,String[]title,String[]desc,int[]img)
    {
        super(c,R.layout.single_row,R.id.textView,title);
        this.c=c;
        this.title=title;
        this.desc=desc;
        this.img=img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
       View row=convertView;
        Myholder mh=null;
        if(row==null)
        {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             row = inflater.inflate(R.layout.single_row, parent, false);
            mh = new Myholder(row);
            row.setTag(mh);
        }

        else {
            mh = (Myholder) row.getTag();
        }
            mh.img.setImageResource(img[position]);
            mh.t1.setText(title[position]);
            mh.t2.setText(desc[position]);

        return  row;
    }
}
