package com.example.julioserafim.powergym.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.julioserafim.powergym.R;

import java.util.List;

/**
 * Created by julioserafim on 12/3/16.
 */

public class DiasDaSemanaAdapter extends BaseAdapter{
    private final Context context;
    private final List<DiasDaSemana> diasDaSemana;

    public DiasDaSemanaAdapter(Context context, List<DiasDaSemana> diasDaSemana) {
        this.context = context;
        this.diasDaSemana = diasDaSemana;
    }

    @Override
    public int getCount() {
        return diasDaSemana != null ? diasDaSemana.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return diasDaSemana.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Infla a view
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_dias_semana, parent, false);
        // Faz findViewById das views que precisa atualizar
        TextView t = (TextView) view.findViewById(R.id.textViewDiaSemana);
        ImageView img = (ImageView) view.findViewById(R.id.imgDiaSemana);
        // Atualiza os valores das views
        DiasDaSemana diaDaSemana = diasDaSemana.get(position);
        t.setText(diaDaSemana.nome);
        img.setImageResource(diaDaSemana.img);
        // Retorna a view deste planeta
        return view;
    }
}
