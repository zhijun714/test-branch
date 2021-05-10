package org.oschina.zb.bi.app.constant;

/**
 * 项目状态常量值
 */
public class ProjectStatusConstant {

	/**
	 * 草稿
	 */
	public static final int DRAFT = 1;
	/**
	 * 待托管
	 */
	public static final int WAIT_HOSTED = 2;
	/**
	 * 竞标
	 */
	public static final int BID = 3;
	/**
	 * 实施
	 */
	public static final int IMPLEMENT = 4;
	/**
	 * 完成
	 */
	public static final int COMPLETED= 5;
	/**
	 * 仲裁
	 */
	public static final int ARBITRATED = 6;
	/**
	 * 终止
	 */
	public static final int TERMINATED = 7;
	/**
	 * 关闭
	 */
	public static final int CLOSED = 8;
	/**
	 * 下架
	 */
	public static final int SHELFED = 9;
	
	/** 竞标状态 1=已竞标，2=未竞标 */
	public static final short APPLY_STATUS_YES = 1;
	
	/** 竞标状态 1=已竞标，2=未竞标 */
	public static final short APPLY_STATUS_NO = 2;
}
