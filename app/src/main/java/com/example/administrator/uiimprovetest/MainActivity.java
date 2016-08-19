package com.example.administrator.uiimprovetest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private ImageButton photo;
    private EditText edit;
    private RelativeLayout line1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
//        在动态调用fragment的时候会用到下面的方法
//        GridViewFragment fragment = new GridViewFragment();
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.frag_layout, fragment);
//        transaction.commit();
        photo = (ImageButton) findViewById(R.id.photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
//        edit=(EditText)findViewById(R.id.edit1) ;
//        line1=(RelativeLayout)findViewById(R.id.line1);
//        edit.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                 TODO Auto-generated method stub
//                edit.setCursorVisible(true);
//                edit.setFocusable(true);
//                edit.setFocusableInTouchMode(true);
//                edit.requestFocus();
//                return true;
//            }
//      });
    }
}
