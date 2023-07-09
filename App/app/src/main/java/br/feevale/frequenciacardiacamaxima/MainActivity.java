package br.feevale.frequenciacardiacamaxima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Pessoa> pessoas = new ArrayList<>();
    private EditText edNome;
    private EditText edIdade;
    private Button btCalcular;
    private ListView listView;
    private FrequenciaCardiacaAdaptater adaptater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        adaptater = new FrequenciaCardiacaAdaptater(pessoas, getBaseContext());
        listView.setAdapter(adaptater);

    }

    public void CalcularFrequencia(View v) {
        try {
            Pessoa p = new Pessoa();
            if (!edNome.getText().toString().isEmpty() && !edIdade.getText().toString().isEmpty()) {
                int idade = Integer.parseInt(edIdade.getText().toString());
                p.setNome(edNome.getText().toString());
                p.setIdade(idade);
                p.setFrequenciaCardiaca("FCM: " + (220 - idade));
                pessoas.add(p);
                adaptater.notifyDataSetChanged();
            }else{
                Toast.makeText(getBaseContext(), "Necessário informar todos os dados!", Toast.LENGTH_LONG).show();
            }
            edIdade.setText("");
            edNome.setText("");
            edNome.requestFocus();
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Erro ao fazer o cálculo!", Toast.LENGTH_LONG).show();
        }
    }

    public void inicializarComponentes() {
        edNome = findViewById(R.id.edNome);
        edIdade = findViewById(R.id.edIdade);
        btCalcular = findViewById(R.id.btCalcular);
        listView = findViewById(R.id.lvListaCalculos);
    }

    }
