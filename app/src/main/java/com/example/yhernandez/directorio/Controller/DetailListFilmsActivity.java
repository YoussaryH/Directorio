package com.example.yhernandez.directorio.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.yhernandez.directorio.R;
import com.example.yhernandez.directorio.model.Item;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class DetailListFilmsActivity extends AppCompatActivity
{

    @BindView(R.id.ivImagen)
    ImageView ivImagen;
    @BindView(R.id.tvTittleMovies)
    TextView tvTittleMovies;
    @BindView(R.id.tvDescription)

    TextView tvDescription;
    private String id;
    private String imagen;
    private String description;

    private Unbinder unbinder;
    private Item items;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        loadView();
        setUnbinder(ButterKnife.bind(this));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadData();
        setData();

    }

    private void loadView()
    {
        setContentView(R.layout.activity_detail);
    }

    private void loadData()
    {
        Bundle objetoRecibido = getIntent().getExtras();
        items = (Item) objetoRecibido.getParcelable("list");
    }

    private void setData()
    {
        tvTittleMovies.setText(items.getTitle());
        tvDescription.setText(items.getDescription());
        try {
            Glide.with(getApplicationContext())
                    .load(items.getImgenPoster())
                    .error(R.drawable.load)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(ivImagen);
        } catch (Exception e) {
            Log.d(getString(R.string.error), e.getMessage());
        }
    }

    @Override
    protected void onDestroy()
    {
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
        super.onDestroy();
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
