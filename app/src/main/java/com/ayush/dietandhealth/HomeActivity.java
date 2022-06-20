package com.ayush.dietandhealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ayush.dietandhealth.adapter.SimpleArrayAdapter;
import com.ayush.dietandhealth.database.DatabaseHandler;
import com.ayush.dietandhealth.model.Post;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private DatabaseHandler databaseHandler;

    List<Post> postList=new ArrayList<>();

    private Button createPost,loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        ListView listView = (ListView) findViewById(R.id.post_list);

       /* createPost = findViewById(R.id.btn_create_post);
        createPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,CreatePostActivity.class);
                startActivity(intent);
            }
        });*/

        loginButton = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        databaseHandler=new DatabaseHandler(this);

        postList = databaseHandler.allPosts();

        postList.add(new Post("Test","Test"));
        postList.add(new Post("Test","Test"));
        postList.add(new Post("Test","Test"));
        postList.add(new Post("Test","Test"));
        postList.add(new Post("Test","Test"));

        SimpleArrayAdapter simpleArrayAdapter=new SimpleArrayAdapter(this,R.layout.simple_adapter_item,postList);

        listView.setAdapter(simpleArrayAdapter);



    }
}
