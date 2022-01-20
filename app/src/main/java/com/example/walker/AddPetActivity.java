package com.example.walker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

import database.AppDatabase;
import database.DatabaseGetter;
import database.Owner;
import database.Pet;

public class AddPetActivity extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE = 1;
    private static final String TAG = "ADD_PET_ACTIVITY";
    private static Uri PHOTO_URI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);
    }

    public void addPhoto(View view){
        // Loading picture
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (resultCode == RESULT_OK) {
                if (requestCode == RESULT_LOAD_IMAGE) {
                    PHOTO_URI = data.getData();
                }
            }
        } catch (Exception e) {
            Log.e("FileSelectorActivity", "File select error", e);
        }
    }
    public void addPet(View view){
        AppDatabase db = DatabaseGetter.getInstance(getApplicationContext());
        List<Pet> pets = db.petDAO().getAll();
        Log.i(TAG, "addPet: Saved pets: " + pets);
        Pet newPet = new Pet();
        newPet.petName = ((EditText)findViewById(R.id.petName)).getText().toString();
        newPet.petBreed = ((EditText)findViewById(R.id.petBreed)).getText().toString();
        newPet.petAge = Integer.valueOf(((EditText)findViewById(R.id.petAge)).getText().toString());
        newPet.petActivity = Integer.valueOf(((EditText)findViewById(R.id.petActivity)).getText().toString());
        newPet.petInfo = ((EditText)findViewById(R.id.petInfo)).getText().toString();
        newPet.uid = (int) (Math.random() * 10000);
        newPet.petUri = PHOTO_URI;
        newPet.ownerUid = 1440;
        db.petDAO().insertAll(newPet);
        Log.i(TAG, "addPet: Saved pets: " + pets);
    }




}