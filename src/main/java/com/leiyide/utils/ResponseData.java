/**
 * 
 */
package com.leiyide.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title:ResponseData
 * @Description: 接口返回数据
 * @Company: 智能科技
 * @version v0.1
 * @author leiyide
 * @date 2019年6月10日 下午2:37:04
 */
public class ResponseData {

	private int code;
	private String message;
	private Map<String, Object> body = new HashMap<String, Object>();

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getBody() {
		return body;
	}

	public ResponseData putDataValue(String key, Object value) {
		body.put(key, value);
		return this;
	}

	public ResponseData(int code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * @Description:服务器成功返回用户请求数据，该操作是幂等的
	 * @return
	 */
	public static ResponseData ok() {
		return new ResponseData(200, "OK");
	}

	/**
	 * @Description:用户新建或者修改数据成功
	 * @return
	 */
	public static ResponseData createOrUpdate() {
		return new ResponseData(201, "CREATED");
	}

	/**
	 * @Description:表示一个请求已经进入后台排队（异步任务）
	 * @return
	 */
	public static ResponseData acceptedRequest() {
		return new ResponseData(202, "Accepted");
	}

	/**
	 * @Description:用户删除数据成功
	 * @return
	 */
	public static ResponseData deleteOk() {
		return new ResponseData(204, "NO CONTENT");
	}

	/**
	 * TODO 方法说明。 用户未登录
	 * 
	 * @return
	 */
	public static ResponseData notLogin() {
		return new ResponseData(301, "用户未登录");
	}

	/**
	 * TODO 方法说明。 缺少参数
	 * 
	 * @return
	 */
	public static ResponseData missingParameter() {
		return new ResponseData(302, "缺少参数或参数异常");
	}

	/**
	 * @Description:未被授权，表示用户没有权限（令牌，用户名，密码错误）
	 * @return
	 */
	public static ResponseData unauthorized() {
		return new ResponseData(401, "未授权访问!");
	}

	/**
	 * @Description:越权访问，没有修改资源的访问权限
	 * @return
	 */
	public static ResponseData outOfBounds() {
		return new ResponseData(403, "没有修改资源的访问权限!");
	}

	/**
	 * @Description:越权访问，没有修改资源的访问权限
	 * @return
	 */
	public static ResponseData notFount() {
		return new ResponseData(404, "not found");
	}

	/**
	 * TODO 方法说明。 校验错误
	 * 
	 * @return
	 */
	public static ResponseData errorCode(String messsage) {
		return new ResponseData(405, messsage);
	}

	/**
	 * @Description:服务端报错
	 * @return
	 */
	private static ResponseData serverInternalError() {
		return new ResponseData(500, "Server Internal Error");
	}

	/*
	 * 调用实例
	 */
//	@GetMapping
//	@ResponseBody
//	public Map<String, Object> index() {
//		Map<String, Object> response = new HashMap<>();
//		response.put("code", 200);
//		response.put("message", "Ok");
//		response.put("body", new HashMap<String, String>());
//		return response;
//	}
//
//	@GetMapping("/test_response_data")
//	@ResponseBody
//	public ResponseData testResponseData() {
//		return ResponseData.ok().putDataValue("token", "XXXXXXXXXXXXXXXXXXXXXXX");
//	}

}
