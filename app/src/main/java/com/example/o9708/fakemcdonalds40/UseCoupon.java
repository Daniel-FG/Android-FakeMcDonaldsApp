package com.example.o9708.fakemcdonalds40;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UseCoupon extends AppCompatActivity
{
    private TextView textViewCountDown;
    private ImageView imageViewCoupon, imageViewCountDown;
    private Integer resource;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_coupon);

        imageViewCountDown = (ImageView) findViewById(R.id.imageViewCountDown);
        textViewCountDown = (TextView) findViewById(R.id.textViewCountDown);
        imageViewCoupon = (ImageView) findViewById(R.id.imageView);

        resource = getIntent().getIntExtra("picture", 0);
        if(resource == 0)
            imageViewCoupon.setImageResource(R.drawable.coupon4_2);
        else
            imageViewCoupon.setImageResource(CouponMaster.getCoupon(resource));

        //Toolbar設定

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarUseCoupon);  //宣告一個tool bar
        setSupportActionBar(toolbar);  //利用tool bar取代action bar
        getSupportActionBar().setDisplayShowTitleEnabled(false);  //不顯示actionbar的名稱
        toolbar.setTitle("優惠券");  //設立toolbar的標題
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));  //tool bar上的返回箭頭
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            //按下返回箭頭圖示的時候
            @Override
            public void onClick(View v)
            {
                imageViewCountDown.setVisibility(View.INVISIBLE);
                textViewCountDown.setVisibility(View.INVISIBLE);
                finish();  //回到優惠券的頁面
            }
        });

        imageViewCoupon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialogUseMessage();
            }
        });
    }

    public void dialogUseMessage()  //按下兌換優惠按鈕之後的彈出對話框
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(UseCoupon.this);
        dialog.setTitle("確認兌換優惠");
        dialog.setMessage("請確認您已在麥當勞櫃台，點選「立即兌換」後，須於兩分鐘內出示給結帳人員");

        //按下立即兌換按鈕
        dialog.setPositiveButton("立即兌換", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                imageViewCountDown.setVisibility(View.VISIBLE);
                textViewCountDown.setVisibility(View.VISIBLE);
                new CountDownTimer(60000,1000)
                {

                    @Override
                    public void onFinish()
                    {
                        textViewCountDown.setText("00：00");
                    }

                    @Override
                    public void onTick(long millisUntilFinished)
                    {
                        if(millisUntilFinished/1000 < 10)
                        {
                            textViewCountDown.setText("01：0"+millisUntilFinished/1000);
                        }
                        else
                        {
                            textViewCountDown.setText("01：" + millisUntilFinished / 1000);
                        }
                    }

                }.start();
            }
        });

        dialog.setNegativeButton("暫不兌換", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                imageViewCountDown.setVisibility(View.INVISIBLE);
                textViewCountDown.setVisibility(View.INVISIBLE);
            }
        });
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coupon, menu);
        return true;
    }
}
