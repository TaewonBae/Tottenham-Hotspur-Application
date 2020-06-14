package tottenhamhotspur.tottenhamhostpur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class LoadingActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        //region//ImageView 형태의 splashGif 변수 11가지를 만들기 및 Glide로 gif파일 불러오기
        ImageView splashGif = (ImageView)findViewById(R.id.splash_gif_view);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(splashGif);
        Glide.with(this).load(R.raw.splash).into(splashGif);

        ImageView splashGif2 = (ImageView)findViewById(R.id.splash_gif_view2);
        GlideDrawableImageViewTarget gifImage2 = new GlideDrawableImageViewTarget(splashGif2);
        Glide.with(this).load(R.raw.splash2).into(splashGif2);

        ImageView splashGif3 = (ImageView)findViewById(R.id.splash_gif_view3);
        GlideDrawableImageViewTarget gifImage3 = new GlideDrawableImageViewTarget(splashGif3);
        Glide.with(this).load(R.raw.splash3).into(splashGif3);

        ImageView splashGif4 = (ImageView)findViewById(R.id.splash_gif_view4);
        GlideDrawableImageViewTarget gifImage4 = new GlideDrawableImageViewTarget(splashGif4);
        Glide.with(this).load(R.raw.splash4).into(splashGif4);

        ImageView splashGif5 = (ImageView)findViewById(R.id.splash_gif_view5);
        GlideDrawableImageViewTarget gifImage5 = new GlideDrawableImageViewTarget(splashGif5);
        Glide.with(this).load(R.raw.splash5).into(splashGif5);

        ImageView splashGif6 = (ImageView)findViewById(R.id.splash_gif_view6);
        GlideDrawableImageViewTarget gifImage6 = new GlideDrawableImageViewTarget(splashGif6);
        Glide.with(this).load(R.raw.splash6).into(splashGif6);

        ImageView splashGif7 = (ImageView)findViewById(R.id.splash_gif_view7);
        GlideDrawableImageViewTarget gifImage7 = new GlideDrawableImageViewTarget(splashGif7);
        Glide.with(this).load(R.raw.splash7).into(splashGif7);

        ImageView splashGif8 = (ImageView)findViewById(R.id.splash_gif_view8);
        GlideDrawableImageViewTarget gifImage8 = new GlideDrawableImageViewTarget(splashGif8);
        Glide.with(this).load(R.raw.splash8).into(splashGif8);

        ImageView splashGif9 = (ImageView)findViewById(R.id.splash_gif_view9);
        GlideDrawableImageViewTarget gifImage9 = new GlideDrawableImageViewTarget(splashGif9);
        Glide.with(this).load(R.raw.splash9).into(splashGif9);

        ImageView splashGif10 = (ImageView)findViewById(R.id.splash_gif_view10);
        GlideDrawableImageViewTarget gifImage10 = new GlideDrawableImageViewTarget(splashGif10);
        Glide.with(this).load(R.raw.splash10).into(splashGif10);

        ImageView splashGif11 = (ImageView)findViewById(R.id.splash_gif_view11);
        GlideDrawableImageViewTarget gifImage11 = new GlideDrawableImageViewTarget(splashGif11);
        Glide.with(this).load(R.raw.splash_jose).into(splashGif11);
        //endregion

        //startLoading함수 실행
        startLoading();
    }

    //region //startLoading함수 선언 및 Intent로 스플레쉬스크린 실행 후 메인으로 넘어가게하기
    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }//endregion
}
