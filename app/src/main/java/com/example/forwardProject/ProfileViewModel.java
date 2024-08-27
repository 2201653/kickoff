package com.example.forwardProject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.graphics.Bitmap;

public class ProfileViewModel extends ViewModel {
    private final MutableLiveData<Bitmap> profileImageBitmap = new MutableLiveData<>();

    public LiveData<Bitmap> getProfileImageBitmap() {
        return profileImageBitmap;
    }

    public void setProfileImageBitmap(Bitmap bitmap) {
        profileImageBitmap.setValue(bitmap);
    }
}
