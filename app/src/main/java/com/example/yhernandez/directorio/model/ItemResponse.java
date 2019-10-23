package com.example.yhernandez.directorio.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ItemResponse implements Parcelable
{
    @SerializedName("results")
    @Expose
    private ArrayList<Item> items;

    public ArrayList<Item> getItems()
    {
        return items;
    }

    public void setItems(ArrayList<Item> items)
    {
        this.items = items;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeTypedList(this.items);
    }

    public ItemResponse()
    {
    }

    protected ItemResponse(Parcel in)
    {
        this.items = in.createTypedArrayList(Item.CREATOR);
    }

    public static final Creator<ItemResponse> CREATOR = new Creator<ItemResponse>()
    {
        @Override
        public ItemResponse createFromParcel(Parcel source)
        {
            return new ItemResponse(source);
        }

        @Override
        public ItemResponse[] newArray(int size)
        {
            return new ItemResponse[size];
        }
    };
}
