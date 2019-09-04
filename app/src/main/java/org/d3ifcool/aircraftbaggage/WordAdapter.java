package org.d3ifcool.aircraftbaggage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Word> listWord;
    private int mBackground;

    public WordAdapter(Context mContext, ArrayList<Word> listWord, int backgroundResId) {
        this.mContext = mContext;
        this.listWord = listWord;
        this.mBackground = ResourcesCompat.getColor(mContext.getResources(),backgroundResId,mContext.getTheme());
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        final TextView tv_judul, tv_keterangan;
        final ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_judul = itemView.findViewById(R.id.tv_judul);
            tv_keterangan = itemView.findViewById(R.id.tv_keterangan);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(mContext);
//        ViewHolder viewHolder = new ViewHolder(view);
        View view = LayoutInflater.from(mContext).inflate(R.layout.word_list_item,parent,false);
        view.setBackgroundColor(mBackground);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word w = listWord.get(position);
        holder.tv_judul.setText(w.getJudul());
        holder.tv_keterangan.setText(w.getKeterangan());
        holder.imageView.setImageResource(w.getImageResId());
    }

    @Override
    public int getItemCount() {
        return listWord.size();
    }
}
