package org.oschina.zb.bi.app.service.manager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.ErrorCode;
import org.oschina.zb.bi.app.constant.DateLevelConstant;
import org.oschina.zb.platform.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 结果集管理类
 * 
 * @author ljw
 *
 */
public class ResultManager {

    private static final Logger logger = LoggerFactory.getLogger(ResultManager.class);

    /**
     * 计算list大小<br>
     * 基于参数条件
     * 
     * @param params
     * @return
     */
    public static int countListSize(Map<String, Object> params) {
        Calendar calendarBegin = Calendar.getInstance(), calendarEnd = Calendar.getInstance();
        calendarBegin.setTime(dateFormat(params.get("beginDate").toString()));
        calendarEnd.setTime(dateFormat(params.get("endDate").toString()));
        int dateLevel = Integer.parseInt(params.get("dateLevel").toString());
        if (dateLevel == DateLevelConstant.YEAR) {
            return calendarEnd.get(Calendar.YEAR) - calendarBegin.get(Calendar.YEAR);
        } else if (dateLevel == DateLevelConstant.QUARTER_YEAR) {
            return (int) Math.ceil(((calendarEnd.get(Calendar.YEAR) - calendarBegin.get(Calendar.YEAR)) * 12
                    + calendarEnd.get(Calendar.MONTH) - calendarBegin.get(Calendar.MONTH)) / 3);
        } else if (dateLevel == DateLevelConstant.MONTH) {
            return (calendarEnd.get(Calendar.YEAR) - calendarBegin.get(Calendar.YEAR)) * 12
                    + calendarEnd.get(Calendar.MONTH) - calendarBegin.get(Calendar.MONTH);
        } else if (dateLevel == DateLevelConstant.WEEK) {
            return (calendarEnd.get(Calendar.YEAR) - calendarBegin.get(Calendar.YEAR)) * 52
                    + calendarEnd.get(Calendar.DAY_OF_YEAR) / 7 - calendarBegin.get(Calendar.DAY_OF_YEAR) / 7;
        } else if (dateLevel == DateLevelConstant.DAY) {
            return (calendarEnd.get(Calendar.YEAR) - calendarBegin.get(Calendar.YEAR)) * 365
                    + calendarEnd.get(Calendar.DAY_OF_YEAR) - calendarBegin.get(Calendar.DAY_OF_YEAR);
        } else if (dateLevel == DateLevelConstant.HOUR) {
            return (calendarEnd.get(Calendar.YEAR) - calendarBegin.get(Calendar.YEAR)) * 365 * 24
                    + calendarEnd.get(Calendar.DAY_OF_YEAR) * 24 - calendarBegin.get(Calendar.DAY_OF_YEAR) * 24
                    + calendarEnd.get(Calendar.HOUR_OF_DAY) - calendarBegin.get(Calendar.HOUR);
        } else {
            return 0;
        }
    }

    /**
     * 合并结果集<br>
     * 将时间合并入结果
     * 
     * @param result
     * @param params
     */
    public static void mergeDateToResultMap(Map<String, Object> result, Map<String, Object> params) {
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.setTime(dateFormat(params.get("endDate").toString()));
        int dateLevel = Integer.parseInt(params.get("dateLevel").toString());
        if (dateLevel == DateLevelConstant.YEAR) {
            calendar.add(Calendar.YEAR, -1);
            result.put("date", calendar.get(Calendar.YEAR) + "年");
        } else if (dateLevel == DateLevelConstant.QUARTER_YEAR) {
            calendar.add(Calendar.MONTH, -3);
            result.put("date", calendar.get(Calendar.YEAR) + "年第" + ((calendar.get(Calendar.MONTH) / 3) + 1) + "季度");
        } else if (dateLevel == DateLevelConstant.MONTH) {
            calendar.add(Calendar.MONTH, -1);
            result.put("date", calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月");
        } else if (dateLevel == DateLevelConstant.WEEK) {
            calendar.add(Calendar.DAY_OF_MONTH, -7);
            result.put("date", calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月"
                    + calendar.get(Calendar.DAY_OF_MONTH) + "日");
        } else if (dateLevel == DateLevelConstant.DAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            result.put("date", calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月"
                    + calendar.get(Calendar.DAY_OF_MONTH) + "日");
        } else if (dateLevel == DateLevelConstant.HOUR) {
            calendar.add(Calendar.HOUR_OF_DAY, -1);
            result.put("date", +calendar.get(Calendar.HOUR_OF_DAY) + "时");
        }
        params.put("endDate", df.format(calendar.getTime()));
    }

    /**
     * 全自动格式化日期
     * 
     * @param date
     * @return
     */
    public static Date dateFormat(String date) {
        DateFormat df1 = new SimpleDateFormat("yyyy");
        DateFormat df2 = new SimpleDateFormat("yyyy-MM");
        DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df4 = new SimpleDateFormat("yyyy-MM-dd HH");
        DateFormat df5 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        DateFormat df6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (date.length() == 4) {
                return df1.parse(date);
            } else if (date.length() == 7) {
                return df2.parse(date);
            } else if (date.length() == 10) {
                return df3.parse(date);
            } else if (date.length() == 13) {
                return df4.parse(date);
            } else if (date.length() == 16) {
                return df5.parse(date);
            } else if (date.length() == 19) {
                return df6.parse(date);
            }
        } catch (ParseException e) {
            throw new BusinessException(ErrorCode.PARAM_CONVERT_ERROR, "时间");
        }
        throw new BusinessException(ErrorCode.PARAM_CONVERT_ERROR, "时间");
    }

    /**
     * 合并结果集<br>
     * 将时间合并入结果（反转时间顺序）
     * 
     * @param result
     * @param params
     */
    public static void mergeDateToResultMapReverse(Map<String, Object> result, Map<String, Object> params) {
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        try {
            calendar.setTime(df.parse(params.get("beginDate").toString()));
        } catch (ParseException e) {
            logger.warn("[BiApp]-[结果集管理类]-[参数转换错误,源数据:({})]", params.get("beginDate"));
            throw new BusinessException(ErrorCode.PARAM_CONVERT_ERROR, "时间格式错误");
        }
        int dateLevel = Integer.parseInt(params.get("dateLevel").toString());
        if (dateLevel == DateLevelConstant.YEAR) {
            calendar.add(Calendar.YEAR, 1);
            result.put("date", calendar.get(Calendar.YEAR) + "年");
        } else if (dateLevel == DateLevelConstant.QUARTER_YEAR) {
            calendar.add(Calendar.MONTH, 3);
            result.put("date", calendar.get(Calendar.YEAR) + "年第" + ((calendar.get(Calendar.MONTH) / 3) + 1) + "季度");
        } else if (dateLevel == DateLevelConstant.MONTH) {
            calendar.add(Calendar.MONTH, 1);
            result.put("date", calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月");
        }
        params.put("beginDate", df.format(calendar.getTime()));
    }

    /**
     * 合并结果集<br>
     * 根据 key=date 比较
     * 
     * @param source
     *            源数据
     * @param result
     *            结果
     * @param key
     *            放入结果的KEY
     */
    public static void mergeResultMapByDate(List<Map<String, Object>> source, Map<String, Object> result, String key) {
        for (Map<String, Object> sourceMap : source) {
            if (sourceMap.get("date").toString().equals(result.get("date").toString())) {
                result.put(key, sourceMap.get(key));
            }
        }
    }

    /**
     * 合并结果集<br>
     * 根据 key=date 比较
     * 
     * @param source
     *            源数据
     * @param result
     *            结果
     * @param key
     *            放入结果的KEYS
     */
    public static void mergeResultMapByDate(List<Map<String, Object>> source, Map<String, Object> result,
            String[] keys) {
        for (Map<String, Object> sourceMap : source) {
            if (sourceMap.get("date").toString().equals(result.get("date").toString())) {
                for (String key : keys) {
                	if (sourceMap.containsKey(key)) {
                		result.put(key, sourceMap.get(key));	
                	}
                    
                }
            }
        }
    }

    /**
     * 求和结果集<br>
     * 根据 key=date 比较
     * 
     * @param source
     *            源数据
     * @param result
     *            结果
     * @param key
     *            放入结果的KEYS
     */
    public static void sumResultMapByDate(List<Map<String, Object>> source, Map<String, Object> result, String[] keys) {
        for (Map<String, Object> sourceMap : source) {
            if (sourceMap.get("date").toString().equals(result.get("date").toString())) {
                for (String key : keys) {
                    Integer i = result.get(key) == null ? 0 : Integer.parseInt(result.get(key).toString());
                    Integer i2 = sourceMap.get(key) == null ? 0 : Integer.parseInt(sourceMap.get(key).toString());
                    result.put(key, i + i2);
                }
            }
        }
    }

    /**
     * 将结果集中的空转化为0
     * 
     * @param result
     * @param keys
     */
    public static void changeNullToZero(List<Map<String, Object>> result, String[] keys) {
        for (Map<String, Object> resultMap : result) {
            for (String key : keys) {
                if (resultMap.get(key) == null) {
                    resultMap.put(key, 0);
                }
            }
        }
    }

    /**
     * 为结果集计算总和
     * 
     * @param result
     * @param keys
     */
    public static void addTotalResult(List<Map<String, Object>> result, String[] keys) {
        Map<String, Object> totalLine = new HashMap<String, Object>();
        totalLine.put("date", "总计");
        for (String key : keys) {
            double total = 0;
            for (Map<String, Object> resultMap : result) {
                total += Double.valueOf(resultMap.get(key).toString());
            }
            totalLine.put(key, total);
        }
        result.add(0, totalLine);
    }

    /**
     * 为结果集计算平均值
     * 
     * @param result
     * @param keys
     */
    public static void addAvgResult(List<Map<String, Object>> result, String[] keys) {
        Map<String, Object> totalLine = new HashMap<String, Object>();
        totalLine.put("date", "平均");
        for (String key : keys) {
            double total = 0;
            for (Map<String, Object> resultMap : result) {
                total += Double.valueOf(resultMap.get(key).toString());
            }
            totalLine.put(key, result.isEmpty() ? 0 : String.format("%.2f", total / result.size()));
        }
        result.add(0, totalLine);
    }

    /**
     * 为结果集添加百分比<br>
     * 该方法依赖于 为结果集计算总和 否则会造成计算错误
     * 
     * @param result
     * @param keys
     */
    public static void addPercentResult(List<Map<String, Object>> result, String[] keys) {
        if (result.size() < 2) {
            return;
        }
        Map<String, Object> totalLine = result.get(0);
        for (String key : keys) {
            for (Map<String, Object> resultMap : result) {
                if (Double.valueOf(totalLine.get(key).toString()) == 0) {
                    resultMap.put(key + "Percent", 0);
                } else {
                    resultMap.put(key + "Percent", Math.round(Double.valueOf(resultMap.get(key).toString())
                            / Double.valueOf(totalLine.get(key).toString()) * 100000) / 1000f);
                }
            }
        }
    }

    /**
     * 将List<Map<String,Object>>转化为Map<String,Array> 形式
     * 
     * @param resultList
     * @return
     */
    public static Map<String, Object> changeListToMap(List<Map<String, Object>> resultList, String[] keys) {
    	
        Map<String, Object> result = new HashMap<String, Object>();
        String[] keysPlus = new String[keys.length + 1];
        keysPlus[0] = "date";
        System.arraycopy(keys, 0, keysPlus, 1, keys.length);
        for (String key : keysPlus) {
            List<Object> temp = new ArrayList<Object>();
            for (Map<String, Object> map : resultList) {
                temp.add(map.get(key));
            }
            result.put(key, temp.toArray(new Object[temp.size()]));
        }
        return result;
    }

}
