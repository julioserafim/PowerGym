package com.example.julioserafim.powergym.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.julioserafim.powergym.R;

import java.util.List;


/**
 * Created by julioserafim on 11/12/16.
 */

public class ExercicioAdapter extends ArrayAdapter<Exercicio>{
    private final Context context;
    private final List<Exercicio> exercicios;

    public ExercicioAdapter(Context context, List<Exercicio>exercicios) {
        super(context, R.layout.linha_dados_exercicios, exercicios);
        this.context = context;
        this.exercicios = exercicios;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha_dados_exercicios,parent,false);

        TextView nomeExercicio = (TextView) rowView.findViewById(R.id.textViewNomeExercicio);
        TextView numeroSeries = (TextView) rowView.findViewById(R.id.textViewNumeroSeries);
        TextView peso = (TextView) rowView.findViewById(R.id.textViewPeso);
        TextView numeroRepeticoes = (TextView) rowView.findViewById(R.id.textViewNumeroRepeticoes);
        TextView tempoDescanso = (TextView) rowView.findViewById(R.id.textViewTempoDescanso);

        nomeExercicio.setText(exercicios.get(position).getNomeExercicio());
        numeroSeries.setText(exercicios.get(position).getSeries());
        peso.setText(exercicios.get(position).getPeso());
        numeroRepeticoes.setText(exercicios.get(position).getNumeroRepeticoes());
        tempoDescanso.setText(exercicios.get(position).getTempoDescanso());

        return rowView;




    }
}
