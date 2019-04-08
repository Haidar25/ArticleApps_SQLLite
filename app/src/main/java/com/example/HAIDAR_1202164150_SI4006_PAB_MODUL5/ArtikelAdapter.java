package com.example.HAIDAR_1202164150_SI4006_PAB_MODUL5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.ArticleHolder> {

    private Context context;
    private List<ArtikelActivity> mList;

    public ArtikelAdapter(Context context, List<ArtikelActivity> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleHolder(LayoutInflater.from(context).inflate(R.layout.activity_artikel_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikelAdapter.ArticleHolder holder, int position) {
        final ArtikelActivity data = mList.get(position);

        holder.tvPublisher.setText(data.penulis);
        holder.tvTitle.setText(data.judul);
        holder.tvDesc.setText(data.deskripsi);

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Bagikan Artikel: " + data.judul, Toast.LENGTH_SHORT).show();

            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, ArtikelDetail.class);
                i.putExtra("penulis", data.penulis + ", " + data.created_at);
                i.putExtra("judul", data.judul);
                i.putExtra("deskripsi", data.deskripsi);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public ArtikelActivity getDataArticle(int position){
        return mList.get(position);
    }

    class ArticleHolder extends RecyclerView.ViewHolder {

        private TextView tvPublisher, tvTitle, tvDesc;
        private ImageView btnShare;
        private CardView cardView;

        ArticleHolder(@NonNull View itemView) {
            super(itemView);

            tvPublisher = itemView.findViewById(R.id.artikelnya);
            tvTitle = itemView.findViewById(R.id.textview_judulartikel);
            tvDesc = itemView.findViewById(R.id.textview_deskripsi);
            btnShare = itemView.findViewById(R.id.share);
            cardView = itemView.findViewById(R.id.card_item_article);
        }
    }
}
