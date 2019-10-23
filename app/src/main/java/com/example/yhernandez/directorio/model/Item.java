package com.example.yhernandez.directorio.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Parcelable
{
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("vote_average")
    @Expose
    private String voteCount;
    @SerializedName("poster_path")
    @Expose
    private String imgenPoster;
    @SerializedName("original_language")
    @Expose
    private String lenguage;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("overview")
    @Expose
    private String description;
    @SerializedName("release_date")
    @Expose
    private String date;

    public Item()
    {
        this.originalTitle = getOriginalTitle();
        this.voteCount = getVoteCount();
        this.imgenPoster = getImgenPoster();
        this.lenguage = getLenguage();
        this.title = getTitle();
        this.description = getDescription();
        this.date = getDate();
    }


    public String getOriginalTitle()
    {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle)
    {
        this.originalTitle = originalTitle;
    }

    public String getVoteCount()
    {
        return voteCount;
    }

    public void setVoteCount(String voteCount)
    {
        this.voteCount = voteCount;
    }

    public String getImgenPoster()
    {
        return "https://image.tmdb.org/t/p/w500" + imgenPoster;
    }

    public void setImgenPoster(String imgenPoster)
    {
        this.imgenPoster = imgenPoster;
    }


    public String getLenguage()
    {
        return lenguage;
    }

    public void setLenguage(String lenguage)
    {
        this.lenguage = lenguage;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.originalTitle);
        dest.writeString(this.voteCount);
        dest.writeString(this.imgenPoster);
        dest.writeString(this.lenguage);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.date);
    }

    protected Item(Parcel in)
    {
        this.originalTitle = in.readString();
        this.voteCount = in.readString();
        this.imgenPoster = in.readString();
        this.lenguage = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.date = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>()
    {
        @Override
        public Item createFromParcel(Parcel source)
        {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size)
        {
            return new Item[size];
        }
    };
}
