package com.example.julioserafim.powergym;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by julioserafim on 10/28/16.
 */
public class AdapterExercicios extends BaseAdapter{
    private String[] exercicios = new String[] {"Supino Reto","Supino Declinado","Alongamento de Pernas","Remada Curvada" +
            "Remada Cavalinho","Puxada Lateral","Levantamento Terra","Dorsal curvada","PumpIron",
            "Rosca Direta","Puxada Tríceps"};

    private Context context;

    public AdapterExercicios(Context context){
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return exercicios.length;
    }

    @Override
    public Object getItem(int position) {
        return exercicios[position];
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        String exercicio = exercicios[i];
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_exercicios,viewGroup,false);
        TextView t = (TextView)view.findViewById(R.id.textoExercicio);
        t.setText(exercicio);
        return view;
    }
}
