package org.oschina.zb.bi.app.service;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.entity.model.TradeStatPandect;
import org.oschina.zb.bi.app.entity.model.TradeStatTrend;
import org.oschina.zb.bi.app.web.params.TradeStatTrendParam;

public interface TradeStatService {

	TradeStatPandect pandect();

	/**
	 * 查询项目GMV交易额
	 * 
	 * @param param
	 *            查询参数
	 * @return
	 */
	Map<String, List<TradeStatTrend>> findProjGMVGroupByDate(TradeStatTrendParam param);

}
