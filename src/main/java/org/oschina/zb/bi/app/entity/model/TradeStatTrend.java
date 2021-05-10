package org.oschina.zb.bi.app.entity.model;

import org.oschina.zb.platform.utils.money.MoneyUtils;

/**
 * 交易趋势
 * 
 * @author donghu
 *
 */
public class TradeStatTrend implements Comparable<TradeStatTrend> {

	/**
	 * 日期
	 */
	private String date;

	/**
	 * 交易总额(分)
	 */
	private Long amount;

	public TradeStatTrend() {
	}

	public TradeStatTrend(String date, Long amount) {
		this.date = date;
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getAmount() {
		return amount;
	}

	public String getAmountByYuan() {

		if (amount == null) {
			return "0.00";
		}
		return MoneyUtils.convertCentToYuan(amount);
	}

	public String getAmountByTenThousandYuan() {

		return MoneyUtils.convertYuanToTenthousand(Double.parseDouble(getAmountByYuan()));
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public boolean equals(Object obj) {

		if (!(obj instanceof TradeStatTrend)) {
			return false;
		}
		if (this.date == null) {
			return super.equals(obj);
		}
		return this.date.equals(((TradeStatTrend) obj).getDate());
	}

	public int hashCode() {

		if (null != date) {
			return date.hashCode();
		}
		return super.hashCode();
	}

	@Override
	public int compareTo(TradeStatTrend obj) {
		if (null == this.date || obj == null) {
			return -1;
		}
		return this.date.compareTo(obj.getDate());
	}

}
