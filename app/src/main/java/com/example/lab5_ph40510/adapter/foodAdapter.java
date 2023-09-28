package com.example.lab5_ph40510.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab5_ph40510.R;
import com.example.lab5_ph40510.model.Student;
import com.example.lab5_ph40510.model.food;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class foodAdapter extends BaseAdapter {
    int sl;
    int total=0;
    private final Context context;
    private final ArrayList<food> listfood;

    ArrayList<food> listfoododer = new ArrayList<>();
    public foodAdapter(Context context, ArrayList<food> listfood) {
        this.context = context;
        this.listfood = listfood;
    }

    @Override
    public int getCount() {
        return listfood.size();
    }

    @Override
    public Object getItem(int i) {
        return listfood.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        view=inflater.inflate(R.layout.item_app_food,viewGroup,false);

        ImageView imgfood = view.findViewById(R.id.imgfood);
        TextView txtfood = view.findViewById(R.id.txtfood);
        TextView txtprice = view.findViewById(R.id.txtprice);
        String price = String.valueOf(listfood.get(i).getPrice()) + "đ";
        Button btnoder = view.findViewById(R.id.btnoder);

        txtfood.setText(listfood.get(i).getFood());
        txtprice.setText(price);
        imgfood.setImageResource(listfood.get(i).getImgfood());

        btnoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendialog(listfood.get(i));
            }
        });
        return view;
    }
    public void opendialog(food food){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_oder_food,null);
        View view1=inflater.inflate(R.layout.item_app_food,null);
        builder.setView(view);
        Dialog dialog=builder.create();
        dialog.show();
        sl = 0;
        //anh xa
        ImageView imgfood = view.findViewById(R.id.imgfood_oder);
        TextView txtfood = view.findViewById(R.id.txtfood_oder);
        TextView txtsl = view.findViewById(R.id.txtsl);
        ImageButton btncong = view.findViewById(R.id.btncong);
        ImageButton btntru = view.findViewById(R.id.btntru);
        Button btnoder = view.findViewById(R.id.btnoder);
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sl++;
                txtsl.setText(String.valueOf(sl));
            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sl > 0){
                    sl--;
                    txtsl.setText(String.valueOf(sl));
                }
            }
        });
        imgfood.setImageResource(food.getImgfood());
        txtfood.setText(food.getFood());
    }
}
