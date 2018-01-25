package cn.com.microcent.news.ui.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.microcent.news.R;
import cn.com.microcent.news.app.App;
import cn.com.microcent.news.ui.widget.RatioImageView;
import lombok.Setter;

/**
 * Created by Administrator on 2018/1/24.
 */

@Setter
public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Inject
    App app;

    protected List<String> list;

    @Inject
    public PhotoAdapter() {
        super();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide
                .with(App.getInstance().getApplicationContext())
                .load(list.get(position))
                .into(((ItemViewHolder) holder).ivPhoto);
    }

    @Override
    public int getItemCount() {
        return (list != null && list.size() > 0) ? list.size() : 0;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.photo_iv)
        RatioImageView ivPhoto;

        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ViewGroup.LayoutParams params = ivPhoto.getLayoutParams();
            //设置图片的相对于屏幕的宽高比
            int width = (int) (ScreenUtils.getScreenWidth() / 2);
            int height = (int) (width * (new Random().nextFloat() / 2 + 1));
            params.width = width;
            params.height = height;
            ivPhoto.setLayoutParams(params);
        }
    }
}
