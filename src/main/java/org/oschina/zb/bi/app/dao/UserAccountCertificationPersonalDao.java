package org.oschina.zb.bi.app.dao;

import org.oschina.zb.bi.app.entity.UserAccountCertificationPersonal;
import org.oschina.zb.platform.core.base.BaseDao;
import org.oschina.zb.platform.core.base.BaseMapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * 导出数据到文件
 * @author wjc
 *
 */
@Repository
public class UserAccountCertificationPersonalDao extends BaseDao<BaseMapper<UserAccountCertificationPersonal>, UserAccountCertificationPersonal>{

    public UserAccountCertificationPersonal getByIdCard(String idCardNum) {
        EntityWrapper<UserAccountCertificationPersonal> ew = new EntityWrapper<>();
        ew.eq("id_card_num_", idCardNum);
        return get(ew);
    } 

    

    
}
