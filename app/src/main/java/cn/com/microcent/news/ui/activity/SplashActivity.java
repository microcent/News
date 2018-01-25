package cn.com.microcent.news.ui.activity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import cn.com.microcent.news.R;
import cn.com.microcent.news.ui.base.BaseActivity;
import cn.com.microcent.news.ui.contract.SplashContract;
import cn.com.microcent.news.ui.presenter.SplashPresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {

    @BindView(R.id.iv_logo_outer)
    ImageView ivLogoOuter;
    @BindView(R.id.iv_logo_inner)
    ImageView ivLogoInner;
    @BindView(R.id.tv_app_name)
    TextView tvAppName;

    boolean isShowingRubberEffect = false;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initView() {
        initAnimation();
    }

    @Override
    protected void initData() {

    }


    private void initAnimation() {
        startLogoInner1();
        startLogoOuterAndAppName();
    }

    private void startLogoInner1() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_top_in);
        ivLogoInner.startAnimation(animation);
    }

    private void startLogoOuterAndAppName() {
        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                if (fraction >= 0.8 && !isShowingRubberEffect) {
                    isShowingRubberEffect = true;
                    startLogoOuter();
                    startShowAppName();
                    finishActivity();
                } else if (fraction >= 0.95) {
                    valueAnimator.cancel();
                    startLogoInner2();
                }

            }
        });
        valueAnimator.start();
    }

    private void startLogoOuter() {
        YoYo.with(Techniques.RubberBand).duration(1000).playOn(ivLogoOuter);
    }

    private void startShowAppName() {
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(tvAppName);
    }

    private void startLogoInner2() {
        YoYo.with(Techniques.Bounce).duration(1000).playOn(ivLogoInner);
    }

    private void finishActivity() {
        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    overridePendingTransition(0, android.R.anim.fade_out);
                    finish();
                });
    }

}
