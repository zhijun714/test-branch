package org.oschina.zb.bi.app.dao;

import java.util.HashMap;
import java.util.Map;

import org.oschina.zb.bi.app.constant.RewardStatusConstant;
import org.oschina.zb.bi.app.entity.Reward;
import org.oschina.zb.bi.app.mapper.RewardMapper;
import org.oschina.zb.platform.core.base.BaseDao;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * 悬赏查询
 * 
 * @author ljw
 */
@Repository
public class RewardDao extends BaseDao<RewardMapper, Reward> {
    /**
     * 计算悬赏总揽信息
     * 
     * @return
     */
    public Map<String, Object> getRewardTotal() {
        Map<String, Object> result = new HashMap<String, Object>();
        Wrapper<Reward> wrapper = new EntityWrapper<Reward>();
        int totalCount = selectCount(wrapper);
        result.put("totalCount", totalCount);
        wrapper = new EntityWrapper<Reward>();
        wrapper.eq("status_", RewardStatusConstant.COMPLETED);
        int dealCount = selectCount(wrapper);
        result.put("dealCount", dealCount);
        return result;
    }

}
