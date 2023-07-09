package br.feevale.frequenciacardiacamaxima;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FrequenciaCardiacaAdaptater  extends BaseAdapter {
    LayoutInflater layoutInflater;
    List<Pessoa> pessoas;

    public FrequenciaCardiacaAdaptater(List<Pessoa> pessoas, Context ctx){
        this.pessoas = pessoas;
        this.layoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Object getItem(int i) {
        return pessoas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =  layoutInflater.inflate(R.layout.item_layout, null);
        TextView tvNome = v.findViewById(R.id.tvNomeItem);
        TextView tvFrequencia = v.findViewById(R.id.tvFrequencia);
        Pessoa p = pessoas.get(i);
        tvNome.setText(p.getNome());
        tvFrequencia.setText(p.getFrequenciaCardiaca());
        return v;
    }
}
