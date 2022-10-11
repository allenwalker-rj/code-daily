package com.allen.codedaily.day.info;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author allen
 * @date 2022/10/4 12:10
 */
@Data
@Component
@ConfigurationProperties(prefix = "keyboard")
public class KeyBoard {
    /**
     * 键盘的名称
     */
    private String name;
    /**
     * 键盘的logo
     */
    private String logo;
    /**
     * 是否是机械键盘
     */
    private boolean isMechanical;
    /**
     * 使用轴体
     */
    private String axis;
    /**
     * 键帽材质
     */
    private String keycaps;
    /**
     * 键位数量
     */
    private int keysNum;
}
