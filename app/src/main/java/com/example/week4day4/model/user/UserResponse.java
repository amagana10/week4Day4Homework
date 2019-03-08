
package com.example.week4day4.model.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse implements Parcelable
{

    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("stat")
    @Expose
    private String stat;
    public final static Creator<UserResponse> CREATOR = new Creator<UserResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserResponse createFromParcel(Parcel in) {
            return new UserResponse(in);
        }

        public UserResponse[] newArray(int size) {
            return (new UserResponse[size]);
        }

    }
    ;

    protected UserResponse(Parcel in) {
        this.photos = ((Photos) in.readValue((Photos.class.getClassLoader())));
        this.stat = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserResponse() {
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(photos);
        dest.writeValue(stat);
    }

    public int describeContents() {
        return  0;
    }

}
