package cn.com.microcent.news.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ObjectUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.microcent.news.R;
import cn.com.microcent.news.app.App;
import cn.com.microcent.news.model.News;
import cn.com.microcent.news.ui.widget.RatioImageView;
import cn.com.microcent.news.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2018/1/24.
 */

@Getter
@Setter
public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<News> list;

    @Inject
    App app;

    @Inject
    public NewsAdapter() {
        super();
    }

    public NewsAdapter(List<News> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder item = (ItemViewHolder) holder;
        News news = list.get(position);
        String photo = news.getPhoto();
        String title = news.getTitle();
        String digest = news.getDigest();
        String time = DateUtil.formatDateTime(news.getTime());
        Glide.with(app.getApplicationContext()).load(photo).asBitmap() // gif格式有时会导致整体图片不显示，貌似有冲突
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.color.image_place_holder)
                .error(R.drawable.ic_load_fail)
                .into(item.ivPhoto);
        item.tvTitle.setText(title);
        item.tvDigest.setText(digest);
        item.tvTime.setText(time);
    }

    @Override
    public int getItemCount() {
        return (list != null && list.size() > 0) ? list.size() : 0;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_news_photo)
        ImageView ivPhoto;
        @BindView(R.id.tv_news_title)
        TextView tvTitle;
        @BindView(R.id.tv_news_digest)
        TextView tvDigest;
        @BindView(R.id.tv_news_time)
        TextView tvTime;

        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
