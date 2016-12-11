package com.ricardoguzman.puppy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ricgu on 10/12/2016.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    private ArrayList<Mascota> mascotas;
    private Activity activity;


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder contactoViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        if(mascota.isLike())
            contactoViewHolder.btnLike.setImageResource(R.drawable.hueso_lleno);
        else
            contactoViewHolder.btnLike.setImageResource(R.drawable.hueso);

        contactoViewHolder.imgFoto.setImageResource(mascota.getFoto());
        contactoViewHolder.tvNombreCv.setText(mascota.getNombre());
        contactoViewHolder.tvnumeroLikes.setText(""+mascota.getLikes());

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean like = mascota.isLike();

                if(mascota.isLike()) {
                    Toast.makeText(activity,"Le quitaste un like a "+mascota.getNombre() + " :(",Toast.LENGTH_SHORT).show();
                    contactoViewHolder.tvnumeroLikes.setText(""+(mascota.getLikes()-1));
                    contactoViewHolder.btnLike.setImageResource(R.drawable.hueso);
                    mascota.setLike(false);
                    mascota.setLikes((mascota.getLikes()-1));
                }else{
                    Toast.makeText(activity,"Le diste like a "+mascota.getNombre()+ " :)",Toast.LENGTH_SHORT).show();
                    contactoViewHolder.tvnumeroLikes.setText(""+(mascota.getLikes()+1));
                    contactoViewHolder.btnLike.setImageResource(R.drawable.hueso_lleno);
                    mascota.setLike(true);
                    mascota.setLikes((mascota.getLikes()+1));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCv;
        private TextView tvnumeroLikes;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView){
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCv      = (TextView)itemView.findViewById(R.id.tvNombreCv);
            tvnumeroLikes    = (TextView)itemView.findViewById(R.id.tvnumeroLikes);
            btnLike         = (ImageButton)itemView.findViewById(R.id.btnLike);
        }
    }
}
