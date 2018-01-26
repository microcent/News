package cn.com.microcent.news.ui.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import cn.com.microcent.news.model.News;
import cn.com.microcent.news.ui.base.BasePresenter;
import cn.com.microcent.news.ui.contract.NewsContract;

/**
 * Created by Administrator on 2018/1/24.
 */

public class NewsPresenter extends BasePresenter<NewsContract.View> implements NewsContract.Presenter {

    private static final String TAG = NewsPresenter.class.getSimpleName();

    @Inject
    public NewsPresenter() {

    }

    @Override
    public void load(int channelId) {
        List<News> list = new ArrayList<>();
        if (channelId == 1) {
            list.add(new News("https://cms-bucket.nosdn.127.net/895c8433475946fe96c02a3be3e3f82620180126082842.png?imageView&thumbnail=220y165&quality=45&type=webp&interlace=1&enlarge=1", "习近平瑞士发表命运共同体演讲一周年", "习近平2017年达沃斯演讲的世界意义贺信引发拉美各界共鸣", ""));
            list.add(new News("https://cms-bucket.nosdn.127.net/20b67aaf3b1a431a95c088a6a47ddfc120180126102402.png?imageView&thumbnail=220y165&quality=45&type=webp&interlace=1&enlarge=1", "从“打”黑到“扫”黑 有何深意？", "人民日报:修宪必须依法按程序进行新时代的中共全面从严治党", ""));
            list.add(new News("http://pg-ad-b1.nosdn.127.net/yixiao/15141/6c72f1fa0d5b8c8c85783a437589d1ec.jpg", "对于全面从严治党有了什么新要求？", "坚持改革引领创新驱动奋力开创新时代公安工作新局面", ""));
        } else {
            list.add(new News("http://pg-ad-b1.nosdn.127.net/yixiao/15141/a662b37b17bd97133f7d52df5dc5f14f.jpg", "国企改革：探索实践中推动高质量发展", "暖新闻|北京重塑核心区老城风貌提升街区\"温度\"领航新征程", ""));
            list.add(new News("http://pg-ad-b1.nosdn.127.net/yixiao/15141/3d392c1b2dd97bce27eaec8a1e713be1.jpg", "去年20地上调最低工资 城镇新增就业1351万人", "2731.5亿元养老金已到账并开始投资 | 城乡居民人均月养老金超过120元", ""));
            list.add(new News("https://cms-bucket.nosdn.127.net/62c5f06e353742e9980f4cebd35208bf20180126112750.png?imageView&thumbnail=220y165&quality=45&type=webp&interlace=1&enlarge=1", "韩医院突发火灾数十人死伤 总统召集紧急会议", "中使馆：暂无中国人伤亡 | 专家：事发地难逃生 | 韩近年重大火灾盘点", ""));
            list.add(new News("https://cms-bucket.nosdn.127.net/7a7c6c78af6b48bc9f27ebe0264048fb20180126104530.png?imageView&thumbnail=220y165&quality=45&type=webp&interlace=1&enlarge=1", "中国首部涉北极白皮书：尊重国际社会整体利益", "中国是北极事务重要利益攸关方 | 没必要担心中国掠夺资源", ""));
        }
        mView.loadSuccess(list);
    }
}
