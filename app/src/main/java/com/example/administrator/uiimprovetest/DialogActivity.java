package com.example.administrator.uiimprovetest;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class DialogActivity extends AppCompatActivity {
private ImageView photo1,video;
    private Uri imageUri;
    public static final int TAKE_PHOTO=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        getSupportActionBar().hide();
        photo1=(ImageView)findViewById(R.id.photo1);
        video=(ImageView)findViewById(R.id.video);
        photo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File outputImage=new File(Environment.getExternalStorageDirectory(),"output_image.jpg");
                try{
                    if (outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                }catch(IOException e){
                    e.printStackTrace();
                }
                imageUri = Uri.fromFile(outputImage);
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivity(intent);
            }
        });
    }
}
