package com.example.alunoshift.androidcloud.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alunoshift.androidcloud.R;
import com.example.alunoshift.androidcloud.modelo.Carro;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;


/**
 * Created by alunoshift on 03/06/2017.
 */

public class CarroViewHolder extends RecyclerView.ViewHolder {

    public TextView tvModelo;
    public TextView tvFabricante;
    public Button bt_deletar;

    private List<Carro> carros;

    public CarroViewHolder(View itemView, final List<Carro> carros) {
        super(itemView);
        this.carros = carros;
        tvFabricante = (TextView) itemView.findViewById(R.id.tvFabricante);
        tvModelo = (TextView) itemView.findViewById(R.id.tvModelo);
        bt_deletar = (Button) itemView.findViewById(R.id.bt_deletar);

        bt_deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carro carro = carros.get(getAdapterPosition());

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

                ref.child("carros").child(carro.getId()).removeValue();

                Log.i("Carro", carro.getFabricante());
            }
        });
    }
}
