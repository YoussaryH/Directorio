package com.example.yhernandez.directorio.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.yhernandez.directorio.Controller.DetailListFilmsActivity;
import com.example.yhernandez.directorio.R;
import com.example.yhernandez.directorio.model.Item;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>
{


    @BindView(R.id.ivImagen)
    CircleImageView ivImagen;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tvDetails)
    TextView tvDetails;
    @BindView(R.id.tvEvalua)
    TextView tvEvalua;
    private ArrayList<Item> listFilms;
    private Context context;
    private Unbinder unbinder;

    public ItemAdapter(Context applicationContext, ArrayList<Item> itemArrayList)
    {
        this.context = applicationContext;
        this.listFilms = itemArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_details, viewGroup, false);
        setUnbinder(ButterKnife.bind(this, view));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i)
    {
        title.setText(listFilms.get(i).getTitle());
        tvEvalua.setText(listFilms.get(i).getVoteCount());
        tvDetails.setText(listFilms.get(i).getLenguage()+" - "+listFilms.get(i).getDate());

        try {
            Glide.with(context)
                    .load(listFilms.get(i).getImgenPoster())
                    .error(R.drawable.load)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(ivImagen);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public int getItemCount()
    {
        return listFilms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title, githublink1;
        private CircleImageView imageView;

        public ViewHolder(View view)
        {
            super(view);
           /* title = (TextView) view.findViewById(R.id.title);
            tvEvalua = (TextView) view.findViewById(R.id.tvEvalua);
            ivImagen = (CircleImageView) view.findViewById(R.id.ivImagen);*/

            //on item click
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Item clickedDataItem = listFilms.get(pos);

                        Intent intent = new Intent(context, DetailListFilmsActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putParcelable("list", clickedDataItem);
                        intent.putExtras(bundle);

                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }

            });
        }
    }

    public Unbinder getUnbinder()
    {
        return unbinder;
    }

    public void setUnbinder(Unbinder unbinder)
    {
        this.unbinder = unbinder;
    }
}