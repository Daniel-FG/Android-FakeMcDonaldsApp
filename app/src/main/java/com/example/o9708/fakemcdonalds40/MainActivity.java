package com.example.o9708.fakemcdonalds40;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity
{

    private ImageButton imageButton01, imageButton02, imageButton03;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar設定

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarCoupon);  //宣告一個tool bar
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
                finish();  //回到選擇優惠券的頁面
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener()
        {
            //按下使用說明的時候
            @Override
            public boolean onMenuItemClick(MenuItem menuItem)
            {
                switch(menuItem.getItemId())
                {
                    case R.id.how_to_use:
                        Intent intent = new Intent(MainActivity.this, HowToUse.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        //顯示期限

        TextView textView1, textView2, textView3;
        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        Calendar calendar = Calendar.getInstance();  //取得時間
        int year = calendar.get(Calendar.YEAR);  //年
        int month = calendar.get(Calendar.MONTH);  //月
        int day = calendar.get(Calendar.DATE);  //日
        int hour = calendar.get(Calendar.HOUR_OF_DAY);  //24小時制的目前時間，供產生優惠券日期時計算使用
        textView1.setText("期限：" + year + "年" + (month+1) + "月" + (day+3) + "日 尚餘：2天" + (24 - hour) + "小時");
        textView2.setText("期限：" + year + "年" + (month+1) + "月" + (day+2) + "日 尚餘：1天" + (24 - hour) + "小時");
        textView3.setText("期限：" + year + "年" + (month+1) + "月" + (day+1) + "日 尚餘：0天" + (24 - hour) + "小時");


        //優惠券設定

        imageButton01 = (ImageButton) findViewById(R.id.imageButton01);
        imageButton02 = (ImageButton) findViewById(R.id.imageButton02);
        imageButton03 = (ImageButton) findViewById(R.id.imageButton03);

        imageButton01.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                dialogCoupon(imageButton01);
                return true;
            }
        });

        imageButton01.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, UseCoupon.class);
                intent.putExtra("picture", (Integer)imageButton01.getTag());
                startActivity(intent);
            }
        });

        imageButton02.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                dialogCoupon(imageButton02);
                return true;
            }
        });

        imageButton02.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, UseCoupon.class);
                intent.putExtra("picture", (Integer)imageButton02.getTag());
                startActivity(intent);}
        });

        imageButton03.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                dialogCoupon(imageButton03);
                return true;
            }
        });

        imageButton03.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, UseCoupon.class);
                intent.putExtra("picture", (Integer)imageButton03.getTag());
                startActivity(intent);}
        });
    }

    public void dialogCoupon(final ImageButton imageButton)  //選擇優惠選擇對話框
    {
        AlertDialog.Builder dialogList = new AlertDialog.Builder(MainActivity.this);
        dialogList.setTitle("選擇優惠");
        String[] content = {"大薯單點買一送一", "四塊麥克雞塊單點買一送一", "勁辣雞腿堡單點買一送一", "板烤鷄腿堡單點買一送一",
                "大杯可口可樂單點買一送一", "買任一超值全餐送蘋果派", "買任一超值全餐送勁辣香雞翅", "買任一超值全餐送BBQ嫩鷄翅",
                "買任一超值全餐送聖代", "買40元大杯冷飲送麥香鷄", "1元驚喜蛋捲冰淇淋", "買33元冷/熱飲送吉事蛋堡",
                "1元驚喜小薯", "10元驚喜麥香魚", "10元驚喜吉事蛋堡", "買40元大杯冷飲送麥香魚"};

        dialogList.setItems(content, new DialogInterface.OnClickListener()  //在彈出式視窗顯示陣列，並設定按鈕監聽事件
        {
            @Override
            //當使用者點下顯示的其中一個按鈕時。which變數為使用者所點的第幾個按鈕，從0開始計算
            public void onClick(DialogInterface dialog, int which)
            {
//                Drawable d = getDrawable(CouponMaster.changeCoupon(which));
//                Bitmap b = ((BitmapDrawable)d).getBitmap();
//                imageButton.setImageBitmap(b);
                imageButton.setTag(CouponMaster.changeCoupon(which));
                imageButton.setImageBitmap(decodeSampledBitmapFromResource(getResources(), CouponMaster.changeCoupon(which), 350, 350));
            }
        });

        dialogList.show();  //顯示彈出式視窗
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight)
    {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth)
        {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth)
            {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight)
    {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
