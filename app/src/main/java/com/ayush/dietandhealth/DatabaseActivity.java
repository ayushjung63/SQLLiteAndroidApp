package com.ayush.dietandhealth;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ayush.dietandhealth.database.DatabaseHandler;
import com.ayush.dietandhealth.model.Post;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home);
        DatabaseHandler databaseHandler=new DatabaseHandler(this);

        databaseHandler.createPost(new Post("Healthy Food","Vegetables are good for health"));
        databaseHandler.createPost(new Post("Junk Food","Junk Food are bad for health"));
        databaseHandler.createPost(new Post("Fast Food","Fast food are fast and easy to eat."));

        List<Post> postList=databaseHandler.allPosts();
    }
}
