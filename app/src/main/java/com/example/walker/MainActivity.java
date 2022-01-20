package com.example.walker;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

import database.AppDatabase;
import database.DatabaseGetter;
import database.Owner;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN_ACTIVITY";
    private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        AppDatabase db = DatabaseGetter.getInstance(getApplicationContext());
        List<Owner> owners = db.ownerDAO().getAll();
        Log.i(TAG, "onCreate: Saved owners: " + owners);
        Owner newOwner = new Owner();
        newOwner.firstName = "Adam";
        newOwner.lastName = "Małysz";
        newOwner.uid = (int) (Math.random() * 10000);
        db.ownerDAO().insertAll(newOwner);
        owners = db.ownerDAO().getAll();
        Log.i(TAG, "onCreate: Saved owners: " + owners);
        newOwner = new Owner();
        newOwner.firstName = "Mariusz";
        newOwner.lastName = "Pudzianowski";
        newOwner.uid = (int) (Math.random() * 10000);
        db.ownerDAO().insertAll(newOwner);
        owners = db.ownerDAO().getAll();
        Log.i(TAG, "onCreate: Saved owners: " + owners);



}


    public void openOwner(View view){
        Intent intent = new Intent(MainActivity.this, OwnerMainActivity.class);
        startActivity(intent);
    }

    public void openWalker(View view){
        Intent intent = new Intent(MainActivity.this, WalkerMainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
//            Uri selectedImage = data.getData();
//            Log.i(TAG, "onActivityResult: selected image Uri: " + selectedImage);
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            Cursor cursor = getContentResolver().query(selectedImage,
//                    filePathColumn, null, null, null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//
//        }
//    }


}