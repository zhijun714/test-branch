package org.oschina.zb.bi.app.dao;

import java.util.List;

import org.oschina.zb.bi.app.entity.model.TradeStatTrend;
import org.oschina.zb.bi.app.mapper.TradeStatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TradeStatDao {

	@Autowired
	private TradeStatMapper tradeStatMapper;

	/**
	 * 查询项目GMV交易额
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public List<TradeStatTrend> findProjGMVGroupByDate(Short isInternal, String startTime, String endTime) {

		return this.tradeStatMapper.findProjGMVGroupByDate(isInternal, startTime, endTime);
	}

	/**
	 * 查询项目托管金额.
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public List<TradeStatTrend> findProjDepositGroupByDate(Short isInternal, String startTime, String endTime) {

		return this.tradeStatMapper.findProjDepositGroupByDate(isInternal, startTime, endTime);
	}

	/**
	 * 查询项目验收金额.
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public List<TradeStatTrend> findProjAcceptGroupByDate(Short isInternal, String startTime, String endTime) {

		return this.tradeStatMapper.findProjAcceptGroupByDate(isInternal, startTime, endTime);
	}

	/**
	 * 查询项目解冻金额.
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public List<TradeStatTrend> findProjUnfreezeGroupByDate(Short isInternal, String startTime, String endTime) {

		return this.tradeStatMapper.findProjUnfreezeGroupByDate(isInternal, startTime, endTime);
	}

	/**
	 * 查询悬赏GMV交易额(托管金额)
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public List<TradeStatTrend> findRewardGMVGroupByDate(Short isInternal, String startTime, String endTime) {

		return this.tradeStatMapper.findRewardGMVGroupByDate(isInternal, startTime, endTime);
	}

	/**
	 * 查询悬赏支付总额
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public List<TradeStatTrend> findRewardPayGroupByDate(Short isInternal, String startTime, String endTime) {

		return this.tradeStatMapper.findRewardPayGroupByDate(isInternal, startTime, endTime);
	}

	public Long getTotalProjGMV() {

		return this.tradeStatMapper.getTotalProjGMV();
	}

	public Long getTotalRewardGMV() {

		return this.tradeStatMapper.getTotalRewardGMV();
	}

	public Long getTotalProjDeposit() {

		return this.tradeStatMapper.getTotalProjDeposit();
	}

	public Long getTotalProjWorkPlanDeposit() {

		return this.tradeStatMapper.getTotalProjWorkPlanDeposit();
	}

	public Long getTotalProjWorkPlanAccept() {

		return this.tradeStatMapper.getTotalProjWorkPlanAccept();
	}

	public Long getTotalProjWorkPlanUnfreeze() {

		return this.tradeStatMapper.getTotalProjWorkPlanUnfreeze();
	}

	public Long getTotalRewardPay() {

		return this.tradeStatMapper.getTotalRewardPay();
	}

	public Long getTotalOutAmount() {

		return this.tradeStatMapper.getTotalOutAmount();
	}

	public Long getTotalInAmount() {

		return this.tradeStatMapper.getTotalInAmount();
	}

	public List<TradeStatTrend> findProjWorkPlanDepositGroupByDate(Short isInternal, String startTime, String endTime) {

		return this.tradeStatMapper.findProjWorkPlanDepositGroupByDate(isInternal, startTime, endTime);
	}

}
