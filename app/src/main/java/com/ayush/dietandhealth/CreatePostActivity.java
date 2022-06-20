package com.ayush.dietandhealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ayush.dietandhealth.database.DatabaseHandler;
import com.ayush.dietandhealth.model.Post;

public class CreatePostActivity extends AppCompatActivity {
    private EditText title,description;
    private Button button;

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_post);

        title=findViewById(R.id.et_title);
        description=findViewById(R.id.et_description);
        button=findViewById(R.id.btn_create);

        databaseHandler=new DatabaseHandler(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post post=new Post(title.getText().toString(),description.getText().toString());
                databaseHandler.createPost(post);

                Intent intent=new Intent(CreatePostActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
