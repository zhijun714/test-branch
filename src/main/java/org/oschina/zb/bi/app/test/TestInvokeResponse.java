package org.oschina.zb.bi.app.test;

import org.oschina.zb.platform.core.exception.BaseException;
import org.oschina.zb.platform.core.response.InvokeResponse;

public class TestInvokeResponse<T> extends InvokeResponse<T> {
	private static int SUCCESS = 1;
	
	private static int ERROR = 0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public static <T> TestInvokeResponse<T> success() {
        return new TestInvokeResponse<T>(SUCCESS, "", null);
    }
    
    public static <T> TestInvokeResponse<T> success(T data) {
        return new TestInvokeResponse<T>(SUCCESS, "", data);
    }
    
    /**
     * <p>(适用条件[可选])
     * 1、适用于业务操作成功后统一向调用端返回输出既定格式的响应结果;<br/>
     * 2、适用于仅需要向客户端输出成功代码且无具体数据内容时调用.<br/>
     * </p>
     * <p>(执行流程[可选])
     * 1、初始化响应对象, 设置默认code码为成功.
     * </p>
     * <p>(使用方法[可选])</p>
     * <p>(注意事项[可选])</p>
     * 
     * @Title: success
     * @Description: 通用操作成功返回结果封装实现.
     * @return InvokeResponse
     * @throws
     */
    public static <T> TestInvokeResponse<T> error() {
        return error(ERROR, "");
    }
    
    public static <T> TestInvokeResponse<T> error(BaseException be) {
        return error(be.getCode(), be.getMessage());
    }
    
    public static <T> TestInvokeResponse<T> error(String message) {
        return error(ERROR, message);
    }
    
    public static <T> TestInvokeResponse<T> error(T data) {
        return error(ERROR, "", data);
    }
    
    public static <T> TestInvokeResponse<T> error(int code) {
        return error(code, null);
    }
    
    public static <T> TestInvokeResponse<T> error(int code, String message) {
        return error(code, message, null);
    }
    
    public static <T> TestInvokeResponse<T> error(int code, String message, T data) {
        return new TestInvokeResponse<T>(code, message, data);
    }

    
    public TestInvokeResponse(int code, String message) {
        super();
        setCode(code);
        setMessage(message);
    }


    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @param code
     * @param message
     * @param data
     */
    public TestInvokeResponse(int code, String message, T data) {
        super();
        setCode(code);
        setMessage(message);
        setData(data);
    }
}
