package me.socialid.contactManagement.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;

/**
 * This class returns the current time.
 *
 */
public class CurrentTimeDateTimeService implements DateTimeService {

	private static final Logger logger = LoggerFactory.getLogger(CurrentTimeDateTimeService.class);

	@Override
	public ZonedDateTime getCurrentDateAndTime() {
		ZonedDateTime currentDateAndTime = ZonedDateTime.now();

		logger.info("Returning current date and time: {}", currentDateAndTime);

		return currentDateAndTime;
	}
}
