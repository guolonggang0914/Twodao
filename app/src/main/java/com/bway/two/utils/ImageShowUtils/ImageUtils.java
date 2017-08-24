package com.bway.two.utils.ImageShowUtils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bway.two.model.net.okhttp.HttpManager;

/**
 * 图片加载
 * date:2017/8/10
 */


public class ImageUtils {
    private volatile static ImageUtils instance;
    private ImageUtils(){

    }
    public static ImageUtils newInstance(){
        if (null == instance) {
            synchronized (HttpManager.class) {
                if (null == instance) {
                    instance = new ImageUtils();
                }
            }
        }
        return instance;
    }
    public void disPlay(Context context,String url, ImageView imageView){
        if(url!=null) {
            Glide.with(context).load(url).into(imageView);
        }else{
            Toast.makeText(context,"图片url错误",Toast.LENGTH_SHORT).show();
        }
    }
    public void YuanjiaoImage(final Context context, String url, final ImageView imageView){
        if(url!=null) {
     /*       Glide.with(context).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(imageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    imageView.setImageDrawable(circularBitmapDrawable);
                }
            });*/
            Glide.with(context).load(url).transform(new GlideRoundTransform(context, 20)).into(imageView);
        }else{
            Toast.makeText(context,"图片url错误",Toast.LENGTH_SHORT).show();
        }
    }
}
