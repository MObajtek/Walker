package com.example.walker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OwnerMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, ErrandOwnerFragment.class, null)
                    .commit();
        }
    }
    public void openAddPet(View view){
        Intent intent = new Intent(OwnerMainActivity.this, AddPetActivity.class);
        startActivity(intent);
    }
}