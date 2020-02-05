package com.appli.listeplante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.appli.listeplante.PlaneteAdapter;
import com.appli.listeplante.Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private PlaneteAdapter adapter;
    Button submit=null;
    //Spinner spinner=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listView);
        submit=findViewById(R.id.buttonSub);


        adapter = new PlaneteAdapter(getApplicationContext());

        listview.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tousCheck()){
                    if(verifTaille()){
                        popUp("Bravo champion!!");
                    }
                    else{
                        popUp("Dommage, essayer encore");
                    }
                }
                else{
                    popUp("Vous devez cocher toutes les cases");
                }
            }
        });

    }

    public boolean tousCheck(){
        boolean x=true;
        for (int i=0;i<adapter.getCount()-1;i++){
            View b= (View) listview.getChildAt(i);
            CheckBox check=b.findViewById(R.id.checkbox);
            if(!check.isChecked()){
                x=false;
            }
        }
        return x;
    }
    public boolean verifTaille(){
        boolean x=true;
        for (int i=0;i<adapter.getCount();i++) {
            View itemview= (View) listview.getChildAt(i);
            Spinner spin=itemview.findViewById(R.id.spinner);
            Data d=new Data();
            if(d.getTaillePlanetes(i)!=spin.getSelectedItem().toString()){
                //popUp("pour i="+i+" nous avons rempli : "+spin.getPrompt().toString()+" alors que la plane"+d.getTaillePlanetes(i));
                x=false;
            }
        }
        return x;
    }
    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
