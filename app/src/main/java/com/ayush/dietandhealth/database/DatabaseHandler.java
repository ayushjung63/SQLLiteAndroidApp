package com.ayush.dietandhealth.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ayush.dietandhealth.model.Post;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "diet";
    private static final String TABLE_POST = "posts";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";

    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_QUERY = "CREATE TABLE " + TABLE_POST + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TITLE + " TEXT,"
                + KEY_DESCRIPTION + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_POST);
        onCreate(sqLiteDatabase);
    }

    public void createPost(Post post){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_TITLE,post.getTitle());
        values.put(KEY_DESCRIPTION,post.getDescription());

        database.insert(TABLE_POST,null,values);
        database.close();
    }

    public List<Post> allPosts(){
        List<Post>  postList=new ArrayList<>();

        String selectQuery="SELECT * FROM "+TABLE_POST;
        SQLiteDatabase database=getWritableDatabase();

        Cursor cursor = database.rawQuery(selectQuery,null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Post post = new Post();
                post.setId(Integer.parseInt(cursor.getString(0)));
                post.setTitle(cursor.getString(1));
                post.setDescription(cursor.getString(2));

                // Adding studnet to list
                postList.add(post);
            } while (cursor.moveToNext());
        }

        // return student list
        return postList;
    }

    public int updatePost(Post post) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, post.getTitle());
        values.put(KEY_DESCRIPTION, post.getDescription());

        // updating row
        return db.update(TABLE_POST, values, KEY_ID + " = ?",
                new String[] { String.valueOf(post.getId()) });
    }
}
