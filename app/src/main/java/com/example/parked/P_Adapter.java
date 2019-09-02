package com.example.parked;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class P_Adapter extends RecyclerView.Adapter<P_Adapter.productViewHolder>implements View.OnClickListener {

    private Context mCtx;
    private List<P_model> pList;

    public P_Adapter(Context mCtx, List<P_model> pList) {
        this.mCtx = mCtx;
        this.pList = pList;
    }

    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recycler_layout, parent, false);
        return new productViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull productViewHolder holder, int position) {
        P_model p_model = pList.get(position);
        holder.textViewpName.setText( p_model.getP_name());
        holder.textViewaddrs.setText( p_model.getAddress());
        holder.textViewsa.setText("Available Slots: " + p_model.getP_space());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(mCtx,BookingMain.class);
                intent.putExtra("key",p_model.getId());
                intent.putExtra("longi",p_model.getLongi());
                intent.putExtra("lati",p_model.getLati());
                mCtx.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return pList.size();
    }

    @Override
    public void onClick(View v) {

    }

    class productViewHolder extends RecyclerView.ViewHolder {

        TextView textViewpName, textViewaddrs, textViewsa;
        CardView cardView;

        public productViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewpName = itemView.findViewById(R.id.text_view_pname);
            textViewaddrs = itemView.findViewById(R.id.text_address);
            textViewsa = itemView.findViewById(R.id.text_view_sa);
            cardView=itemView.findViewById(R.id.card1);
        }
    }
}
