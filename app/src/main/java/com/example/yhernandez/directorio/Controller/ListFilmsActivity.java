package com.example.yhernandez.directorio.Controller;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yhernandez.directorio.Adapter.ItemAdapter;
import com.example.yhernandez.directorio.Api.Client;
import com.example.yhernandez.directorio.Api.Service;
import com.example.yhernandez.directorio.R;
import com.example.yhernandez.directorio.model.Item;
import com.example.yhernandez.directorio.model.ItemResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFilmsActivity extends AppCompatActivity
{

    @BindView(R.id.rvListFilms)
    RecyclerView rvListFilms;
    @BindView(R.id.disconnected)
    TextView disconnected;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;

    private RecyclerView.LayoutManager manager;
    TextView Disconnected;
    private Item item;
    ProgressDialog pd;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        loadsView();
        setUnbinder(ButterKnife.bind(this));
        initViews();
        loadSwiperRefresh();

    }

    private void loadSwiperRefresh()
    {
        swipeContainer.setColorSchemeResources(R.color.colorPrimaryDark);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                loadJSON();
            }
        });
    }

    private void loadsView()
    {
        setContentView(R.layout.activity_main);
    }

    private void initViews()
    {
        pd = new ProgressDialog(this);
        pd.setMessage(getString(R.string.loading));
        pd.setCancelable(false);
        pd.show();

        manager = new GridLayoutManager(this, 2);
        rvListFilms.setLayoutManager(manager);

        rvListFilms.smoothScrollToPosition(0);
        loadJSON();
    }

    private void loadJSON()
    {
        Disconnected = (TextView) findViewById(R.id.disconnected);
        try {
            Client Client = new Client();
            Service apiService =
                    Client.getClient().create(Service.class);
            Call<ItemResponse> call = apiService.getItems();
            call.enqueue(new Callback<ItemResponse>()
            {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response)
                {
                    ArrayList<Item> items = response.body().getItems();
                    rvListFilms.setAdapter(new ItemAdapter(getApplicationContext(), items));
                    rvListFilms.smoothScrollToPosition(0);
                    swipeContainer.setRefreshing(false);
                    pd.hide();
                }

                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t)
                {
                    Log.d(getString(R.string.error), t.getMessage());
                    Toast.makeText(ListFilmsActivity.this, getText(R.string.error_loads), Toast.LENGTH_SHORT).show();
                    Disconnected.setVisibility(View.VISIBLE);
                    pd.hide();

                }
            });

        } catch (Exception e) {
            pd.hide();
            Log.d(getString(R.string.error), e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
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
