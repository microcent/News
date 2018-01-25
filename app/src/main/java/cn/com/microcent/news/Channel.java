package cn.com.microcent.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/1/25.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Channel {

    private int channelId;
    private String channelName;
    private int channelIndex;

}
