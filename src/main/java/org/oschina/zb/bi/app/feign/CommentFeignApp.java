package org.oschina.zb.bi.app.feign;

import java.util.List;
import java.util.Map;

import org.oschina.zb.platform.core.response.InvokeResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通用模块
 */
@FeignClient(value = "comm-app")
@RequestMapping(value = "/comm")
public interface CommentFeignApp {

    /**
     * 项目专员列表
     * 
     * @return
     */
    @GetMapping("/rbac/specialist-list")
    InvokeResponse<List<Map<String, Object>>> speciaList();

}
