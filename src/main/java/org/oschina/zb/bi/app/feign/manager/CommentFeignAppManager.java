package org.oschina.zb.bi.app.feign.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.common.ValidationUtil;
import org.oschina.zb.bi.app.feign.CommentFeignApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通用模块
 * 
 * @author ljw
 */
@Service
public class CommentFeignAppManager {
    @Autowired
    private CommentFeignApp commentFeignApp;

    /**
     * 项目专员列表
     * 
     * @return
     */
    public List<Map<String, Object>> speciaList() {
        List<Map<String, Object>> speciaList = ValidationUtil
                .invokeResponseValidate("项目专员列表", commentFeignApp.speciaList()).getData();
        return speciaList == null ? new ArrayList<>() : speciaList;
    }

}
