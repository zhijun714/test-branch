package org.oschina.zb.bi.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.oschina.zb.bi.app.entity.model.TradeStatPandect;
import org.oschina.zb.bi.app.entity.model.TradeStatTrend;

@Mapper
public interface TradeStatMapper {

	TradeStatPandect pandect();

	/**
	 * 查询项目GMV交易额
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            开始时间
	 * @return
	 */
	List<TradeStatTrend> findProjGMVGroupByDate(@Param("isInternal") Short isInternal,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * 查询项目托管金额
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            开始时间
	 * @return
	 */
	List<TradeStatTrend> findProjDepositGroupByDate(@Param("isInternal") Short isItnernal,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * 查询项目阶段托管金额
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            开始时间
	 * @return
	 */
	List<TradeStatTrend> findProjWorkPlanDepositGroupByDate(@Param("isInternal") Short isItnernal,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * 查询项目验收金额
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            开始时间
	 * @return
	 */
	List<TradeStatTrend> findProjAcceptGroupByDate(@Param("isInternal") Short isItnernal,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * 查询项目解冻金额
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            开始时间
	 * @return
	 */
	List<TradeStatTrend> findProjUnfreezeGroupByDate(@Param("isInternal") Short isItnernal,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * 查询悬赏GMV交易额(托管金额)
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            开始时间
	 * @return
	 */
	List<TradeStatTrend> findRewardGMVGroupByDate(@Param("isInternal") Short isItnernal,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * 查询悬赏支付总额
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	List<TradeStatTrend> findRewardPayGroupByDate(@Param("isInternal") Short isItnernal,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * 获取项目总的GMV
	 * 
	 * @return
	 */
	Long getTotalProjGMV();

	/**
	 * 获取悬赏总的GMV
	 * 
	 * @return
	 */
	Long getTotalRewardGMV();

	Long getTotalProjDeposit();

	Long getTotalProjWorkPlanDeposit();

	Long getTotalProjWorkPlanAccept();

	Long getTotalProjWorkPlanUnfreeze();

	Long getTotalRewardPay();

	Long getTotalOutAmount();

	Long getTotalInAmount();

}
