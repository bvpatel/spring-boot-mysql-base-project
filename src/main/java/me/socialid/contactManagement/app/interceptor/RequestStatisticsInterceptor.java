package me.socialid.contactManagement.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
 
@Component
public class RequestStatisticsInterceptor implements AsyncHandlerInterceptor {

	private ThreadLocal<Long> time = new ThreadLocal<>();

	private static final Logger log = LoggerFactory.getLogger(RequestStatisticsInterceptor.class);

	@Autowired
	private HibernateStatisticsInterceptor statisticsInterceptor;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		time.set(System.currentTimeMillis());
		statisticsInterceptor.startCounter();
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		long duration = System.currentTimeMillis() - time.get();
		Long queryCount = statisticsInterceptor.getQueryCount();
		statisticsInterceptor.clearCounter();
		time.remove();
		log.info("[Time: {} ms] [Queries: {}] {} {}", duration, queryCount, request.getMethod(), request.getRequestURI());
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//concurrent handling cannot be supported here
		statisticsInterceptor.clearCounter();
		time.remove();
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}
