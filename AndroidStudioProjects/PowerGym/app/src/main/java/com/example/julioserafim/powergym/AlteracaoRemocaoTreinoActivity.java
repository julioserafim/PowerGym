package com.example.julioserafim.powergym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.julioserafim.powergym.Model.Exercicio;
import com.example.julioserafim.powergym.repository.ImplementacaoExercicioRepository;

import io.realm.Realm;

public class AlteracaoRemocaoTreinoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alteracao_remocao_treino);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Realm realm = Realm.getDefaultInstance();

        Intent intent = getIntent();
        int codigo = intent.getIntExtra("Id",0);

        final Exercicio exercicio = realm.where(Exercicio.class).equalTo("codigo",codigo).findFirst();
        final EditText nomeExercicio = (EditText)findViewById(R.id.editTextNomeExercicio);
        final EditText numeroRepeticoes = (EditText)findViewById(R.id.editTextNumeroRepeticoes);
        final EditText peso = (EditText)findViewById(R.id.editTextPeso);
        final EditText numeroSeries = (EditText)findViewById(R.id.editTextNumeroSeries);
        final EditText tempoDescanso = (EditText)findViewById(R.id.editTextTempoDescanso);

        nomeExercicio.setText(exercicio.getNomeExercicio());
        numeroSeries.setText(exercicio.getSeries());
        peso.setText(exercicio.getPeso());
        numeroRepeticoes.setText(exercicio.getNumeroRepeticoes());
        tempoDescanso.setText(exercicio.getTempoDescanso());



        Button alterar = (Button)findViewById(R.id.buttonAlterar);
        alterar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                realm.beginTransaction();

                exercicio.setNomeExercicio(nomeExercicio.getText().toString());
                exercicio.setNumeroRepeticoes(numeroRepeticoes.getText().toString());
                exercicio.setTempoDescanso(tempoDescanso.getText().toString());
                exercicio.setPeso(peso.getText().toString());
                exercicio.setSeries(numeroSeries.getText().toString());

                realm.copyToRealm(exercicio);
                realm.commitTransaction();
                nomeExercicio.setText("");
                numeroRepeticoes.setText("");
                peso.setText("");
                numeroSeries.setText("");
                tempoDescanso.setText("");
                Toast.makeText(AlteracaoRemocaoTreinoActivity.this, "Exercício Alterado!", Toast.LENGTH_SHORT).show();

            }
        });


        Button remover = (Button)findViewById(R.id.buttonRemover);
        remover.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                realm.beginTransaction();
                exercicio.deleteFromRealm();
                realm.commitTransaction();

                nomeExercicio.setText("");
                numeroRepeticoes.setText("");
                peso.setText("");
                numeroSeries.setText("");
                tempoDescanso.setText("");
                Toast.makeText(AlteracaoRemocaoTreinoActivity.this, "Exercício Deletado!", Toast.LENGTH_SHORT).show();


            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tela_alteracao_remocao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.tela_inicial) {
            Intent i = new Intent(this,TelaInicialActivity.class);
            startActivity(i);

            return true;
        }

        if (id == R.id.alterar_treino) {

            /*exercicio.setNomeExercicio(nomeExercicio.getText().toString());
            exercicio.setNumeroRepeticoes(numeroRepeticoes.getText().toString());
            exercicio.setTempoDescanso(tempoDescanso.getText().toString());
            exercicio.setPeso(peso.getText().toString());
            exercicio.setSeries(numeroSeries.getText().toString());

            ImplementacaoExercicioRepository dao = new ImplementacaoExercicioRepository();
            dao.alterarExercicio(exercicio);

            Toast.makeText(this, "Exercício Alterado com sucesso!", Toast.LENGTH_SHORT).show();
            nomeExercicio.setText("");
            numeroRepeticoes.setText("");
            peso.setText("");
            numeroSeries.setText("");
            tempoDescanso.setText("");
*/

            return true;
        }

        if (id == R.id.excluir_treino) {
            /*Intent i = new Intent(this,EditTreinoActivity.class);
            startActivity(i);
            return true;*/
        }

        return super.onOptionsItemSelected(item);
    }

}
