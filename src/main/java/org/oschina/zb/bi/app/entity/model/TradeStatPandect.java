package org.oschina.zb.bi.app.entity.model;

import java.text.NumberFormat;

import org.oschina.zb.platform.utils.money.MoneyUtils;

/**
 * 交易总览
 * 
 * @author donghu
 *
 */
public class TradeStatPandect {

	/**
	 * 累计GMV(分)
	 */
	private Long totalGMV;

	/**
	 * 累计托管金额(分)
	 */
	private Long totalDepositAmount;

	/**
	 * 累计验收总额(分)
	 */
	private Long totalAcceptAmount;

	/**
	 * 项目支付金额(分)
	 */
	private Long totalPayAmount;

	/**
	 * 总支出金额
	 */
	private Long totalOutAmount;

	/**
	 * 总收入金额
	 */
	private Long totalInAmount;

	public Long getTotalGMV() {
		return totalGMV;
	}

	public String getTotalGMVByYuan() {

		if (null == totalGMV) {
			return "0.00";
		}
		return MoneyUtils.convertCentToYuan(this.totalGMV);
	}

	public String getTotalGMVByTenThousandYuan() {

		return formatGroup(MoneyUtils.convertYuanToTenthousand(Double.parseDouble(getTotalGMVByYuan())));
	}

	public void setTotalGMV(Long totalGMV) {
		this.totalGMV = totalGMV;
	}

	public Long getTotalDepositAmount() {
		return totalDepositAmount;
	}

	public String getTotalDepositAmountByYuan() {

		if (null == totalDepositAmount) {
			return "0.00";
		}
		return MoneyUtils.convertCentToYuan(this.totalDepositAmount);
	}

	public String getTotalDepositAmountByTenThousandYuan() {

		return formatGroup(MoneyUtils.convertYuanToTenthousand(Double.parseDouble(getTotalDepositAmountByYuan())));
	}

	public void setTotalDepositAmount(Long totalDepositAmount) {
		this.totalDepositAmount = totalDepositAmount;
	}

	public Long getTotalAcceptAmount() {
		return totalAcceptAmount;
	}

	public String getTotalAcceptAmountByYuan() {

		if (null == totalAcceptAmount) {
			return "0.00";
		}
		return MoneyUtils.convertCentToYuan(this.totalAcceptAmount);
	}

	public String getTotalAcceptAmountByTenThousandYuan() {

		return formatGroup(MoneyUtils.convertYuanToTenthousand(Double.parseDouble(getTotalAcceptAmountByYuan())));
	}

	public void setTotalAcceptAmount(Long totalAcceptAmount) {
		this.totalAcceptAmount = totalAcceptAmount;
	}

	public Long getTotalPayAmount() {
		return totalPayAmount;
	}

	public String getTotalPayAmountByYuan() {

		if (null == totalPayAmount) {
			return "0.00";
		}
		return MoneyUtils.convertCentToYuan(this.totalPayAmount);
	}

	public String getTotalPayAmountByTenThousandYuan() {

		return formatGroup(MoneyUtils.convertYuanToTenthousand(Double.parseDouble(getTotalPayAmountByYuan())));
	}

	public void setTotalPayAmount(Long totalPayAmount) {
		this.totalPayAmount = totalPayAmount;
	}

	public Long getTotalOutAmount() {
		return totalOutAmount;
	}

	public String getTotalOutAmountByYuan() {

		if (null == totalOutAmount) {
			return "0.00";
		}
		return MoneyUtils.convertCentToYuan(this.totalOutAmount);
	}

	public String getTotalOutAmountByTenThousandYuan() {

		return formatGroup(MoneyUtils.convertYuanToTenthousand(Double.parseDouble(getTotalOutAmountByYuan())));
	}

	public void setTotalOutAmount(Long totalOutAmount) {
		this.totalOutAmount = totalOutAmount;
	}

	public Long getTotalInAmount() {
		return totalInAmount;
	}

	public String getTotalInAmountByYuan() {

		if (null == totalInAmount) {
			return "0.00";
		}
		return MoneyUtils.convertCentToYuan(this.totalInAmount);
	}

	public String getTotalInAmountByTenThousandYuan() {

		return formatGroup(MoneyUtils.convertYuanToTenthousand(Double.parseDouble(getTotalInAmountByYuan())));
	}

	public void setTotalInAmount(Long totalInAmount) {
		this.totalInAmount = totalInAmount;
	}

	private String formatGroup(String number) {

		NumberFormat numberFormat1 = NumberFormat.getNumberInstance();
		return numberFormat1.format(Double.parseDouble(number)); // 结果是11,122.33
	}
}
