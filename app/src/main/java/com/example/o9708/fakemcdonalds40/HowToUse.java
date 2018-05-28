package com.example.o9708.fakemcdonalds40;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class HowToUse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use);

        //tool bar

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarHowtoUse);  //宣告一個tool bar
        setSupportActionBar(toolbar);  //利用tool bar取代action bar
        getSupportActionBar().setDisplayShowTitleEnabled(false);  //不顯示actionbar的名稱
        toolbar.setTitle("使用說明");  //設立toolbar的標題
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            //按下返回圖示的時候
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    /*

    //這個方法不寫
    //讓tool bar不產生menu item

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    */
}
