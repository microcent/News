package cn.com.microcent.news.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/1/26.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    private String photo;
    private String title;
    private String digest;
    private String time;

}
