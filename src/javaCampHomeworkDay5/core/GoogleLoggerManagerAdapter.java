package javaCampHomeworkDay5.core;

import javaCampHomeworkDay5.googleLogger.GoogleLoggerManager;

public class GoogleLoggerManagerAdapter implements LoggerService {
	@Override
	public void signToSystem(String message, String whetherSigned) {
		GoogleLoggerManager manager = new GoogleLoggerManager();
		manager.log(message, whetherSigned);
	}
}
