package me.socialid.contactManagement.app.interceptor;

import org.hibernate.EmptyInterceptor;
import org.springframework.stereotype.Component;

@Component
public class HibernateStatisticsInterceptor extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ThreadLocal<Long> queryCount = new ThreadLocal<>();

	public void startCounter() {
		queryCount.set(0l);
	}

	public Long getQueryCount() {
		return queryCount.get();
	}

	public void clearCounter() {
		queryCount.remove();
	}

	@Override
	public String onPrepareStatement(String sql) {
		Long count = queryCount.get();
		if (count != null) {
			queryCount.set(count + 1);
		}
		//log.info(sql);
		return super.onPrepareStatement(sql);
	}
}