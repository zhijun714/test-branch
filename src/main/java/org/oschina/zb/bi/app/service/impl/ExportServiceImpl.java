package org.oschina.zb.bi.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.oschina.zb.bi.app.dao.ExportDao;
import org.oschina.zb.bi.app.dao.UserAccountCertificationPersonalDao;
import org.oschina.zb.bi.app.entity.UserAccountCertificationPersonal;
import org.oschina.zb.bi.app.feign.manager.CommentFeignAppManager;
import org.oschina.zb.bi.app.service.ExportService;
import org.oschina.zb.platform.utils.encrypt.IdNumberEncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 导出数据到文件
 * 
 * @author wjc
 *
 */
@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    private ExportDao revenueDao;
    @Autowired
    private UserAccountCertificationPersonalDao personalDao;
    @Autowired
    private CommentFeignAppManager commentFeignAppManager;

    /**
     * 导出进账记录
     */
    @Override
    public List<Object[]> revenue(Map<String, Object> params) {
        List<Map<String, Object>> revenue = revenueDao.revenue(params);
        List<Object[]> revenueData = new ArrayList<>();
        revenueData.add(new String[] { "进账ID", "用户", "真实姓名", "金额", "渠道", "交易事项", "支付日期", "支付内容", "支付账号", "流水号", "项目ID",
                "项目类型", "项目状态" });
        for (int i = 0; i < revenue.size(); i++) {
            Map<String, Object> m = revenue.get(i);
            revenueData.add(new Object[] { m.get("transaction_no_"), m.get("nickname_"), m.get("name_"),
                    m.get("amount_"), m.get("pay_type_"), m.get("transactionMatters"), m.get("notify_time_"),
                    m.get("biz_title_"), m.get("pay_account_"), m.get("trade_no_"), m.get("biz_id_"),
                    m.get("reward_type_"), m.get("reward_status_") });
        }
        return revenueData;
    }

    /**
     * 导出出账记录
     */
    @Override
    public List<Object[]> expenditure(Map<String, Object> params) {
        List<Map<String, Object>> expenditure = revenueDao.expenditure(params);
        List<Object[]> expenditureData = new ArrayList<>();
        expenditureData.add(new String[] { "出账编号", "用户昵称", "用户真实姓名", "证件号", "提现账号", "金额", "类型", "完成时间", "渠道" });
        for (int i = 0; i < expenditure.size(); i++) {
            Map<String, Object> m = expenditure.get(i);
            String DocNum = (String) m.get("document_num_");
            if (StringUtils.isNotBlank(DocNum)) {
                UserAccountCertificationPersonal personal = personalDao.getByIdCard(DocNum);
                if (null != personal) {
                    DocNum = IdNumberEncryptUtils.decrypt(DocNum);
                    m.put("document_num_", DocNum);
                }
            }
            expenditureData.add(new Object[] { m.get("transaction_no_"), m.get("nickname_"), m.get("name_"),
                    m.get("document_num_"), m.get("card_num_"), m.get("amount_"), m.get("type_"), m.get("finished_at_"),
                    m.get("pay_type_"), m.get("trade_no_") });
        }

        return expenditureData;
    }

    /**
     * 导出项目
     */
    @Override
    public List<Object[]> projectList(Map<String, Object> params) {
        List<Map<String, Object>> expenditure = revenueDao.projectList(params);
        List<Object[]> expenditureData = new ArrayList<>();
        expenditureData.add(
                new String[] { "项目编号", "项目名称", "发包人", "内部项目", "私有项目", "托管状态", "上下架状态", "预算(￥)", "周期", "项目状态", "状态最后时间",
                        "发布时间", "报名数量", "完成时间", "应用领域", "受理人", "受理时间", "签章时间", "合同总额(￥)", "已托管总额(￥)", "已解冻总额(￥)" });
        List<Map<String, Object>> speciaList = commentFeignAppManager.speciaList();
        Map<Long, String> speciaMap = new HashMap<Long, String>(speciaList.size());
        for (int i = 0; i < speciaList.size(); i++) {
            speciaMap.put(Long.valueOf(speciaList.get(i).get("id").toString()),
                    speciaList.get(i).get("name").toString());
        }
        for (int i = 0; i < expenditure.size(); i++) {
            Map<String, Object> m = expenditure.get(i);
            if (m.get("specialistId") != null && !StringUtils.isBlank(m.get("specialistId").toString())) {
                m.put("managerName", speciaMap.get(m.get("specialistId")));
            } else {
                m.put("managerName", "未受理");
            }
            expenditureData.add(new Object[] { m.get("projectNo"), m.get("name"), m.get("employerNickname"),
                    m.get("isInternal"), m.get("visible"), m.get("depositHostingStatus"), m.get("publishStatus"),
                    m.get("budgetMin").toString() + "-" + m.get("budgetMax").toString(), m.get("cycleName"),
                    m.get("status"), m.get("statusLastTime"), m.get("publishTime"), m.get("applyCount"),
                    m.get("doneTime"), m.get("applicationArea"), m.get("managerName"), m.get("handleTime"),
                    m.get("contractSignTime"), m.get("contractMoney"), m.get("actualHostedMoney"),
                    m.get("actualThrawMoney") });
        }
        return expenditureData;
    }

    /**
     * 导出悬赏
     */
    @Override
    public List<Object[]> rewardList(Map<String, Object> params) {
        List<Map<String, Object>> expenditure = revenueDao.rewardList(params);
        List<Object[]> expenditureData = new ArrayList<>();
        expenditureData.add(new String[] { "项目专员", "悬赏编号", "应用领域", "悬赏名称", "发布人", "托管状态", "发布时间", "悬赏周期(天)", "赏金(￥)",
                "报名数量", "赏金得主", "状态" });
        List<Map<String, Object>> speciaList = commentFeignAppManager.speciaList();
        Map<Long, String> speciaMap = new HashMap<Long, String>(speciaList.size());
        for (int i = 0; i < speciaList.size(); i++) {
            speciaMap.put(Long.valueOf(speciaList.get(i).get("id").toString()),
                    speciaList.get(i).get("name").toString());
        }
        for (int i = 0; i < expenditure.size(); i++) {
            Map<String, Object> m = expenditure.get(i);
            if (m.get("specialistId") != null && !StringUtils.isBlank(m.get("specialistId").toString())) {
                m.put("managerName", speciaMap.get(m.get("specialistId")));
            } else {
                m.put("managerName", "未受理");
            }
            expenditureData.add(new Object[] { m.get("managerName"), m.get("rewardNo"), m.get("applicationArea"),
                    m.get("name"), m.get("employerNickname"), m.get("bountyHostingStatus"), m.get("publishTime"),
                    m.get("expectedDuration"), m.get("bounty"), m.get("applyCount"), m.get("contractorNickname"),
                    m.get("status") });
        }
        return expenditureData;
    }

}
