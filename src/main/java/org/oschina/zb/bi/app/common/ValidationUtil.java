package org.oschina.zb.bi.app.common;

import java.util.List;
import java.util.Objects;

import org.oschina.zb.bi.app.ErrorCode;
import org.oschina.zb.platform.core.exception.BaseErrorCode;
import org.oschina.zb.platform.core.exception.BusinessException;
import org.oschina.zb.platform.core.exception.SystemException;
import org.oschina.zb.platform.core.response.InvokeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 验证工具类
 * 
 * @author ljw
 *
 */
public class ValidationUtil {

    private static final Logger logger = LoggerFactory.getLogger(ValidationUtil.class);
    private static final String PROJECT_NAME = "ProjectApp";

    /**
     * 调用接口返回值验证
     * 
     * @param i
     * @return
     */
    public static <T> InvokeResponse<T> invokeResponseValidate(String interfaceName, InvokeResponse<T> i) {
        if (i.getCode() != BaseErrorCode.SUCCESS) {
            logger.error(String.format("[%s][%s][调用接口异常]", PROJECT_NAME, interfaceName));
            throw new SystemException(i.getCode(), i.getMessage());
        }
        return i;
    }

    /**
     * 测试一个对象是否为空
     * 
     * @param interfaceName
     * @param o
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T isNullObjectValidate(String interfaceName, Object o, Class<?> c) {
        if (Objects.isNull(o)) {
            logger.error(String.format("[%s][%s][找不到%s]", PROJECT_NAME, interfaceName, c.getSimpleName()));
            throw new BusinessException(ErrorCode.RECORD_NOT_EXIST, c.getSimpleName());
        }
        return (T) o;
    }

    /**
     * 测试一个List是否为空
     * 
     * @param interfaceName
     * @param l
     * @param c
     * @return
     */
    public static <T> List<T> isNullObjectValidate(String interfaceName, List<T> l, Class<?> c) {
        if (Objects.isNull(l) || l.isEmpty()) {
            logger.error(String.format("[%s][%s][找不到%s]", PROJECT_NAME, interfaceName, c.getSimpleName()));
            throw new BusinessException(ErrorCode.RECORD_NOT_EXIST, c.getSimpleName());
        }
        return l;
    }

    /**
     * 请求参数验证 空的参数将会抛出异常
     * 
     * @param prams
     */
    public static void requestValidateNull(String interfaceName, String[] pramsNames, Object[] prams) {
        if (pramsNames.length != prams.length) {
            logger.error(String.format("[%s][%s][参数名称与参数数量不一致]", PROJECT_NAME, interfaceName));
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        for (int i = 0; i < pramsNames.length; i++) {
            if (Objects.isNull(prams[i])) {
                logger.error(String.format("[%s][%s][%s参数为空]", PROJECT_NAME, interfaceName, pramsNames[i]));
                throw new BusinessException(ErrorCode.MISS_REQUIRED_PARAM, pramsNames[i]);
            }
        }
    }

    /**
     * 请求参数验证 超过长度限制的参数将会抛出异常<br>
     * 该接口仅能验证String长度
     * 
     * @param prams
     */
    public static void requestValidateStringLength(String interfaceName, String[] pramsNames, String[] prams,
            Integer[] maxLengths) {
        Integer[] minLengths = new Integer[pramsNames.length];
        for (int i = 0; i < minLengths.length; i++) {
            minLengths[i] = 1;
        }
        requestValidateStringLength(interfaceName, pramsNames, prams, minLengths, maxLengths);
    }

    /**
     * 请求参数验证 超过长度限制的参数将会抛出异常<br>
     * 该接口仅能验证String长度
     * 
     * @param prams
     */
    public static void requestValidateStringLength(String interfaceName, String[] pramsNames, String[] prams,
            Integer[] minLengths, Integer[] maxLengths) {
        if (pramsNames.length != prams.length || pramsNames.length != minLengths.length
                || pramsNames.length != maxLengths.length) {
            logger.error(String.format("[%s][%s][参数名称与参数数量不一致]", PROJECT_NAME, interfaceName));
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        for (int i = 0; i < pramsNames.length; i++) {
            if (prams[i].length() < minLengths[i]) {
                logger.error(String.format("[%s][%s][%s参数值过短]", PROJECT_NAME, interfaceName, pramsNames[i]));
                throw new BusinessException(ErrorCode.PARAM_LENGTH_VALID, pramsNames[i] + "(" + prams[i].length() + ")",
                        minLengths[i]);
            }
            if (prams[i].length() > maxLengths[i]) {
                logger.error(String.format("[%s][%s][%s参数值过长]", PROJECT_NAME, interfaceName, pramsNames[i]));
                throw new BusinessException(ErrorCode.PARAM_LENGTH_VALID, pramsNames[i] + "(" + prams[i].length() + ")",
                        maxLengths[i]);
            }
        }
    }

    /**
     * 请求参数验证 超过长度限制的参数将会抛出异常<br>
     * 该接口仅能验证数字大小
     * 
     * @param prams
     */
    public static void requestValidateIntSize(String interfaceName, String[] pramsNames, Number[] prams,
            Integer[] maxSize) {
        Integer[] minSize = new Integer[pramsNames.length];
        for (int i = 0; i < minSize.length; i++) {
            minSize[i] = 0;
        }
        requestValidateIntSize(interfaceName, pramsNames, prams, minSize, maxSize);
    }

    /**
     * 请求参数验证 超过长度限制的参数将会抛出异常<br>
     * 该接口仅能验证数字大小
     * 
     * @param prams
     */
    public static void requestValidateIntSize(String interfaceName, String[] pramsNames, Number[] prams,
            Integer[] minSize, Integer[] maxSize) {
        if (pramsNames.length != prams.length || pramsNames.length != minSize.length
                || pramsNames.length != maxSize.length) {
            logger.error(String.format("[%s][%s][参数名称与参数数量不一致]", PROJECT_NAME, interfaceName));
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        for (int i = 0; i < pramsNames.length; i++) {
            if (prams[i].intValue() < minSize[i].intValue()) {
                logger.error(String.format("[%s][%s][%s参数值过短]", PROJECT_NAME, interfaceName, pramsNames[i]));
                throw new BusinessException(ErrorCode.PARAM_RANGE_VALID, pramsNames[i], minSize[i].intValue(),
                        prams[i].intValue());
            }
            if (prams[i].intValue() > maxSize[i].intValue()) {
                logger.error(String.format("[%s][%s][%s参数值过长]", PROJECT_NAME, interfaceName, pramsNames[i]));
                throw new BusinessException(ErrorCode.PARAM_RANGE_VALID, pramsNames[i], maxSize[i].intValue(),
                        prams[i].intValue());
            }
        }
    }

}
