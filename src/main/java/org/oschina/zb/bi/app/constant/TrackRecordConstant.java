package org.oschina.zb.bi.app.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 搜索引擎
 * 
 * @author ljw
 *
 */
public class TrackRecordConstant {
    /**
     * 
     */
    public static final String[] SEARCH_ENGINES = new String[] { "baidu.com", "sougou.com", "google.com", "so.com" };
    /**
     * 来源类型 外部链接
     */
    public static final int FORM_TYPE_OUT_COME = 1;
    /**
     * 来源类型 直接访问
     */
    public static final int FORM_TYPE_IN_COME = 2;
    /**
     * 来源类型 搜索引擎
     */
    public static final int FORM_TYPE_SEARCH_ENGINES = 3;

    private static Map<Integer, String> sourceType = new HashMap<>();

    public static String getSourceType(Integer status) {
        return sourceType.get(status);
    }

    static {
        sourceType.put(FORM_TYPE_OUT_COME, "外部链接");
        sourceType.put(FORM_TYPE_IN_COME, "直接访问");
        sourceType.put(FORM_TYPE_SEARCH_ENGINES, "搜索引擎");
    }
}
