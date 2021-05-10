package org.oschina.zb.bi.app.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.oschina.zb.bi.app.dao.TradeStatDao;
import org.oschina.zb.bi.app.entity.model.TradeStatPandect;
import org.oschina.zb.bi.app.entity.model.TradeStatTrend;
import org.oschina.zb.bi.app.service.TradeStatService;
import org.oschina.zb.bi.app.web.params.TradeStatTrendParam;
import org.springframework.stereotype.Service;

@Service
public class TradeStatServiceImpl implements TradeStatService {

	@Resource
	private TradeStatDao tradeStatDao;

	public TradeStatPandect pandect() {

		TradeStatPandect pandect = new TradeStatPandect();
		// 1.累计GMV
		pandect.setTotalGMV(this.getTotalProjGMV() + this.getTotalRewardGMV());

		// 2.统计托管总额
		pandect.setTotalDepositAmount(
				this.getTotalProjDeposit() + this.getTotalProjWorkPlanDeposit() + this.getTotalProjGMV());

		// 3.累计验收总额
		pandect.setTotalAcceptAmount(this.getTotalProjWorkPlanAccept());

		// 4.累计支付总额
		pandect.setTotalPayAmount(this.getTotalProjWorkPlanUnfreeze() + this.getTotalRewardPay());

		// 5.累计支出总额
		pandect.setTotalOutAmount(this.getTotalOutAmount());

		// 6.累计收入总额
		pandect.setTotalInAmount(this.getTotalInAmount());

		return pandect;
	}

	public Long getTotalProjGMV() {
		return tradeStatDao.getTotalProjGMV();
	}

	public Long getTotalProjDeposit() {
		return tradeStatDao.getTotalProjDeposit();
	}

	public Long getTotalProjWorkPlanDeposit() {
		return tradeStatDao.getTotalProjWorkPlanDeposit();
	}

	public Long getTotalProjWorkPlanAccept() {
		return tradeStatDao.getTotalProjWorkPlanAccept();
	}

	public Long getTotalProjWorkPlanUnfreeze() {
		return tradeStatDao.getTotalProjWorkPlanUnfreeze();
	}

	public Long getTotalRewardGMV() {
		return tradeStatDao.getTotalRewardGMV();
	}

	public Long getTotalRewardPay() {
		return tradeStatDao.getTotalRewardPay();
	}

	private Long getTotalOutAmount() {
		return tradeStatDao.getTotalOutAmount();
	}

	private Long getTotalInAmount() {
		return tradeStatDao.getTotalInAmount();
	}

	/**
	 * 查询项目GMV交易额
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public Map<String, List<TradeStatTrend>> findProjGMVGroupByDate(TradeStatTrendParam param) {

		Map<String, List<TradeStatTrend>> result = new HashMap<>();
		List<TradeStatTrend> projGMVList = null;
		List<TradeStatTrend> projDepositList = null;
		List<TradeStatTrend> projWorkPlanDepositList = null;
		List<TradeStatTrend> projAcceptList = null;
		List<TradeStatTrend> projPayList = null;
		List<TradeStatTrend> rewardGMVList = null;
		List<TradeStatTrend> rewardPayList = null;

		if (param.getBizType() == null) {
			projGMVList = this.tradeStatDao.findProjGMVGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
			projDepositList = this.tradeStatDao.findProjDepositGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
			projWorkPlanDepositList = this.tradeStatDao.findProjWorkPlanDepositGroupByDate(param.getIsInternal(),
					param.getStartTime(), param.getEndTime());
			projAcceptList = this.tradeStatDao.findProjAcceptGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
			projPayList = this.tradeStatDao.findProjUnfreezeGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
			rewardGMVList = this.tradeStatDao.findRewardGMVGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
			rewardPayList = this.tradeStatDao.findRewardPayGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
		} else if (param.getBizType() == 1) {
			projGMVList = this.tradeStatDao.findProjGMVGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
			projDepositList = this.tradeStatDao.findProjDepositGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
			projWorkPlanDepositList = this.tradeStatDao.findProjWorkPlanDepositGroupByDate(param.getIsInternal(),
					param.getStartTime(), param.getEndTime());
			projAcceptList = this.tradeStatDao.findProjAcceptGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
			projPayList = this.tradeStatDao.findProjUnfreezeGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
		} else {
			rewardGMVList = this.tradeStatDao.findRewardGMVGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
			rewardPayList = this.tradeStatDao.findRewardPayGroupByDate(param.getIsInternal(), param.getStartTime(),
					param.getEndTime());
		}
		result.put("projGMVList", projGMVList);
		result.put("projDepositList", projDepositList);
		result.put("projWorkPlanDepositList", projWorkPlanDepositList);
		result.put("projAcceptList", projAcceptList);
		result.put("projPayList", projPayList);
		result.put("rewardGMVList", rewardGMVList);
		result.put("rewardPayList", rewardPayList);
		processData(result, param);

		Map<String, List<TradeStatTrend>> newResult = new HashMap<>();
		// 合并
		if (param.getBizType() == null) {
			// GMV
			projGMVList = result.get("projGMVList");
			rewardGMVList = result.get("rewardGMVList");
			for (int i = 0; i < projGMVList.size(); i++) {
				TradeStatTrend projGMVTrend = projGMVList.get(i);
				TradeStatTrend rewardGMVTrend = rewardGMVList.get(i);
				projGMVTrend.setAmount(projGMVTrend.getAmount() + rewardGMVTrend.getAmount());
			}
			newResult.put("gmvList", projGMVList);

			// 托管
			projDepositList = result.get("projDepositList");
			projWorkPlanDepositList = result.get("projWorkPlanDepositList");
			// 悬赏托管就是gmv
			rewardGMVList = result.get("rewardGMVList");
			for (int i = 0; i < projDepositList.size(); i++) {
				TradeStatTrend projDepositTrend = projDepositList.get(i);
				TradeStatTrend rewardGMVTrend = rewardGMVList.get(i);
				TradeStatTrend projWorkPlanTrend = projWorkPlanDepositList.get(i);
				projDepositTrend.setAmount(
						projDepositTrend.getAmount() + rewardGMVTrend.getAmount() + projWorkPlanTrend.getAmount());
			}
			newResult.put("depositList", projDepositList);

			// 验收总额, 只有项目有
			newResult.put("acceptList", result.get("projAcceptList"));

			// 支付总额
			projPayList = result.get("projPayList");
			rewardPayList = result.get("rewardPayList");
			for (int i = 0; i < projPayList.size(); i++) {
				TradeStatTrend projPayTrend = projPayList.get(i);
				TradeStatTrend rewardPayTrend = rewardGMVList.get(i);
				projPayTrend.setAmount(projPayTrend.getAmount() + rewardPayTrend.getAmount());
			}
			newResult.put("payList", projPayList);
		} else if (param.getBizType() == 1) {
			newResult.put("gmvList", result.get("projGMVList"));
			// deposit
			projDepositList = result.get("projDepositList");
			projWorkPlanDepositList = result.get("projWorkPlanDepositList");
			for (int i = 0; i < projDepositList.size(); i++) {
				TradeStatTrend projDepositTrend = projDepositList.get(i);
				TradeStatTrend projWorkPlanTrend = projWorkPlanDepositList.get(i);
				projDepositTrend.setAmount(projDepositTrend.getAmount() + projWorkPlanTrend.getAmount());
			}
			newResult.put("depositList", projDepositList);
			newResult.put("acceptList", result.get("projAcceptList"));
			newResult.put("payList", result.get("projPayList"));
		} else if (param.getBizType() == 2) {
			newResult.put("gmvList", result.get("rewardGMVList"));
			newResult.put("payList", result.get("rewardPayList"));
		}
		return newResult;
	}

	private void processData(Map<String, List<TradeStatTrend>> result, TradeStatTrendParam param) {

		// 1.填充缺失日期
		for (Map.Entry<String, List<TradeStatTrend>> entry : result.entrySet()) {

			List<TradeStatTrend> list = entry.getValue();
			if (list == null) {
				continue;
			}
			String startDate = param.getStartTime();
			String endDate = param.getEndTime();
			try {
				Set<String> daySet = findDays(startDate, endDate);
				TreeSet<TradeStatTrend> trendSet = new TreeSet<>();
				for (String day : daySet) {
					trendSet.add(new TradeStatTrend(day, 0L));
				}
				trendSet.removeAll(list);
				trendSet.addAll(list);
				list = new ArrayList<>(trendSet);
				result.put(entry.getKey(), list);
				if (param.getDimension() == 4) {
					List<TradeStatTrend> newList = new ArrayList<>();
					Long sumAmount = 0L;
					for (int i = 0; i < list.size(); i++) {
						TradeStatTrend trend = list.get(i);
						String date = trend.getDate();
						Calendar c = Calendar.getInstance();
						c.setFirstDayOfWeek(Calendar.MONDAY);
						c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
						// 如果不是周日且不是月末, ++
						if (c.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
								&& c.get(Calendar.DAY_OF_MONTH) != c.getActualMaximum(Calendar.DAY_OF_MONTH)) {

							sumAmount += trend.getAmount();
						} else {
							String year = c.get(Calendar.YEAR) + "年";
							String month = (c.get(Calendar.MONTH) + 1) + "月";
							String week = "第" + c.get(Calendar.WEEK_OF_MONTH) + "周";
							newList.add(new TradeStatTrend(year + month + week, sumAmount + trend.getAmount()));
							sumAmount = 0L;
						}
					}
					result.put(entry.getKey(), newList);
				} else if (param.getDimension() == 3) {// 月
					List<TradeStatTrend> newList = new ArrayList<>();
					long sumAmount = 0L;
					for (int i = 0; i < list.size(); i++) {
						TradeStatTrend trend = list.get(i);
						String date = trend.getDate();
						Calendar c = Calendar.getInstance();
						c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
						// 如果不是月底
						if (c.get(Calendar.DAY_OF_MONTH) != c.getActualMaximum(Calendar.DAY_OF_MONTH)) {
							// 如果是取后1个
							if (i == list.size() - 1) {
								String year = c.get(Calendar.YEAR) + "年";
								String month = (c.get(Calendar.MONTH) + 1) + "月";
								newList.add(new TradeStatTrend(year + month, sumAmount + trend.getAmount()));
							} else {
								sumAmount += trend.getAmount();
							}
						} else {
							String year = c.get(Calendar.YEAR) + "年";
							String month = (c.get(Calendar.MONTH) + 1) + "月";
							newList.add(new TradeStatTrend(year + month, sumAmount + trend.getAmount()));
							sumAmount = 0L;
						}
					}
					result.put(entry.getKey(), newList);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	public TreeSet<String> findDays(String startDate, String endDate) throws ParseException {

		Date start = DateUtils.parseDate(startDate, "yyyy-MM-dd HH:mm:ss");
		Date end = DateUtils.parseDate(endDate, "yyyy-MM-dd HH:mm:ss");
		TreeSet<String> result = new TreeSet<String>();
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(start);
		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(end);
		while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {
			result.add(new SimpleDateFormat("yyyy-MM-dd").format(tempStart.getTime()));
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}
		return result;
	}

	public static void main(String[] args) throws ParseException {

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2017);
		c.set(Calendar.MONTH, 3);
		c.set(Calendar.DAY_OF_MONTH, 1);

		System.out.println(c.getTime());
		System.out.println(c.get(Calendar.WEEK_OF_MONTH));
		c.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(c.get(Calendar.WEEK_OF_MONTH));

		c = Calendar.getInstance();
		System.out.println(c.get(Calendar.DAY_OF_MONTH));

		System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-05 23:25:25"));
	}

}
