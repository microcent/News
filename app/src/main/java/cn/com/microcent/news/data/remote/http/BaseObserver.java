package cn.com.microcent.news.data.remote.http;

import android.accounts.NetworkErrorException;
import android.util.Log;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by xingwen on 2017/12/14.
 */

public abstract class BaseObserver<T> implements Observer<Response<T>> {

    private static final String TAG = BaseObserver.class.getSimpleName();

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Response<T> value) {
        if (value.isSuccess()) {
            try {
                T t = value.getData();
                onSuccess(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.e(TAG, "error:" + value.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        try {
            if (e instanceof ConnectException || e instanceof TimeoutException || e instanceof NetworkErrorException || e instanceof UnknownHostException) {
                onFailure(e, true);
            } else {
                onFailure(e, false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }

    protected abstract void onSuccess(T t) throws Exception;

    protected abstract void onFailure(Throwable e, boolean isNetworkError) throws Exception;
}
