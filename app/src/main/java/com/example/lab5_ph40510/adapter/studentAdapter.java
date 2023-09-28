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
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.lab5_ph40510.R;
import com.example.lab5_ph40510.model.Student;

import java.util.ArrayList;

public class studentAdapter extends BaseAdapter implements Filterable {

    private final Context context;
    private ArrayList<Student> listStudent;
    private final ArrayList<Student> listStudentOld;

    public studentAdapter(Context context, ArrayList<Student> listStudent) {
        this.context = context;
        this.listStudent = listStudent;
        this.listStudentOld = listStudent;
    }


    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int i) {
        return listStudent.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =((Activity)context).getLayoutInflater();
        view =inflater.inflate(R.layout.item_bai2, viewGroup,false);

        TextView txtbranch = view.findViewById(R.id.txtbranch);
        TextView txtname = view.findViewById(R.id.txtname);
        TextView txtaddress = view.findViewById(R.id.txtaddress);
        Button btndelete = view.findViewById(R.id.btndelete);
        Button btnupdate = view.findViewById(R.id.btnupdate);

        txtbranch.setText(listStudent.get(i).getBranch());
        txtname.setText(listStudent.get(i).getName());
        txtaddress.setText(listStudent.get(i).getAddress());

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listStudent.remove(i);
                notifyDataSetChanged();
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendialog(listStudent.get(i));
            }
        });
        return view;
    }

    public void opendialog(Student sv){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_update,null);
        builder.setView(view);
        Dialog dialog=builder.create();
        dialog.show();
        //anh xa
        EditText txtcs = view.findViewById(R.id.txtbranch_ud);
        EditText txtten = view.findViewById(R.id.txtname_up);
        EditText txtdiachi = view.findViewById(R.id.txtaddress_up);
        Button btnupdate=view.findViewById(R.id.btnupd);
        //gán du lieu lên các textview
        txtcs.setText(sv.getBranch());
        txtten.setText(sv.getName());
        txtdiachi.setText(sv.getAddress());
        //click update
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv.setBranch(txtcs.getText().toString());
                sv.setName(txtten.getText().toString());
                sv.setAddress(txtdiachi.getText().toString());
                dialog.dismiss();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public Filter getFilter() {
        return new Filter(){
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String s = charSequence.toString() ;
                if (s.isEmpty()){
                    listStudent=listStudentOld;
                } else {
                    ArrayList<Student> lists = new ArrayList<>();
                    for (Student st :listStudentOld){
                        if (st.getName().toLowerCase().contains(s.toLowerCase())){
                            lists.add(st);
                        }
                    }
                    listStudent=lists;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listStudent;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listStudent = (ArrayList<Student>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
