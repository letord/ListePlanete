package com.appli.listeplante;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.appli.listeplante.MainActivity;
import com.appli.listeplante.R;

import java.util.ArrayList;

public class PlaneteAdapter extends BaseAdapter {

    private ArrayList<String> planetes;
    String[] taillePlanetes;
    Context c;
    int nbCheck;
    boolean allCheck;

    public PlaneteAdapter(Context c){
        this.c=c;
        Data d=new Data();
        planetes=d.getPlanetes();
        taillePlanetes=d.getTaillePlanetes();
        this.nbCheck=0;
        this.allCheck=false;

    }
    @Override
    public int getCount() {
        return planetes.size();
    }
    @Override
    public Object getItem(int arg0) {
        return planetes.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        nomPlanete.setText(planetes.get(position));

        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(c, android.R.layout.simple_spinner_item, taillePlanetes);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                final CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);
                if (checkBox.isChecked()) {
                    spinner.setEnabled(false);
                    spinadapter.notifyDataSetChanged();

                } else {
                    spinner.setEnabled(true);
                    spinadapter.notifyDataSetChanged();
                }

            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout parent = (LinearLayout) checkBox.getParent().getParent().getParent();
                boolean x=true;
                ListView listView=parent.findViewById(R.id.listView);
                for (int i=0;i<planetes.size();i++) {
                    View vv=listView.getChildAt(i);
                    CheckBox checkBox=vv.findViewById(R.id.checkbox);
                    if (!checkBox.isChecked()) {
                        x = false;
                    }
                }
                if (x){
                    Button button =parent.findViewById(R.id.buttonSub);
                    button.setEnabled(true);
                }


            }
        });

        return itemView;
    }
}