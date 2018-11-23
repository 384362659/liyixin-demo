package com.primeton.lyx.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.primeton.lyx.model.ResponseResult;


/**
 * 全局统一异常处理
 * @author 李一新
 *
 */
@ControllerAdvice
public class GlobalDemoExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalDemoExceptionHandler.class);

	public GlobalDemoExceptionHandler() {

	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseResult<Void> defaultErrorHandler(HttpServletRequest request, HttpServletResponse res, Exception e) {
		logger.info("Restful Http请求发生异常...");
		if (e instanceof NullPointerException) {
			logger.error( e.getMessage(), e);
			return new ResponseResult<Void>(00, "发生空指针异常");
		} else if (e instanceof IllegalArgumentException) {
			logger.error( e.getMessage(), e);
			return new ResponseResult<Void>(01, "请求参数类型不匹配");
		} else if (e instanceof SQLException) {
			logger.error( e.getMessage(), e);
			return new ResponseResult<Void>(02, "数据库访问异常");
		} else if (e instanceof NoHandlerFoundException) {
			logger.error( e.getMessage(), e);
			return new ResponseResult<Void>(404, "访问路径错误");
		}
		if (e instanceof DemoException) {
			DemoException service = (DemoException) e;
			logger.error(service.getCode());
			return new ResponseResult<Void>((DemoException) e);
		} else {
			logger.error(e.getMessage(), e);
			return new ResponseResult<Void>(99, "服务器代码发生异常,请联系管理员");
		}

	}
}
