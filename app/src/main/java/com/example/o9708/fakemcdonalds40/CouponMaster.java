package com.example.o9708.fakemcdonalds40;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by o9708 on 2018/3/9.
 */

public class CouponMaster implements Runnable
{
    private static int[] couponCover = {R.drawable.coupon2_1, R.drawable.coupon3_1, R.drawable.coupon4_1,
            R.drawable.coupon5_1, R.drawable.coupon6_1, R.drawable.coupon11_1, R.drawable.coupon12_1,
            R.drawable.coupon13_1, R.drawable.coupon14_1, R.drawable.coupon21_1, R.drawable.coupon22_1,
            R.drawable.coupon23_1, R.drawable.coupon24_1, R.drawable.coupon25_1, R.drawable.coupon26_1,
            R.drawable.coupon27_1};

    private static int[] couponContent = {R.drawable.coupon2_2, R.drawable.coupon3_2, R.drawable.coupon4_2,
            R.drawable.coupon5_2, R.drawable.coupon6_2, R.drawable.coupon11_2, R.drawable.coupon12_2,
            R.drawable.coupon13_2, R.drawable.coupon14_2, R.drawable.coupon21_2, R.drawable.coupon22_2,
            R.drawable.coupon23_2, R.drawable.coupon24_2, R.drawable.coupon25_2, R.drawable.coupon26_2,
            R.drawable.coupon27_2};

    public static int changeCoupon(int index)
    {
        return couponCover[index];
    }

    public static int getCoupon(Integer resource)
    {
        int id = (int) resource;
        for(int i = 0; i < couponCover.length; i++)
        {
            if(id == couponCover[i])
                return couponContent[i];
        }

        return id;
    }

    public void run()
    {

    }
}
