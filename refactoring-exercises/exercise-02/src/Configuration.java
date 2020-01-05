import java.util.*;

public class Configuration {
	public int interval;

	public int duration;

	public int departure;
	
	// Instead of one big method, I divided into small methods to make it more understandable.
	
	public int checkInterval(Properties props) throws ConfigurationException {
		String valueString = props.getProperty("interval");
		int value;
		
		if (valueString == null) {
			throw new ConfigurationException("monitor interval");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("monitor interval > 0");
		}
		
		return value;
	}
	
	public int checkDuration(Properties props) throws ConfigurationException {
		String valueString = props.getProperty("duration");
		int value;
		
		if (valueString == null) {
			throw new ConfigurationException("duration");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("duration > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("duration % interval");
		}
		
		return value;
	}
	
	public int checkDeparture(Properties props) throws ConfigurationException {
		String valueString = props.getProperty("departure");
		int value;
		
		if (valueString == null) {
			throw new ConfigurationException("departure offset");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("departure > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("departure % interval");
		}
		
		return value;
	}

	
	public void load(Properties props) throws ConfigurationException {
		
		interval = checkInterval(props);
		departure = checkDeparture(props);
		duration = checkDuration(props);
	}
	
	/*
	public void load(Properties props) throws ConfigurationException {
		String valueString;
		int value;

		valueString = props.getProperty("interval");
		if (valueString == null) {
			throw new ConfigurationException("monitor interval");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("monitor interval > 0");
		}
		interval = value;

		valueString = props.getProperty("duration");
		if (valueString == null) {
			throw new ConfigurationException("duration");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("duration > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("duration % interval");
		}
		duration = value;

		valueString = props.getProperty("departure");
		if (valueString == null) {
			throw new ConfigurationException("departure offset");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("departure > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("departure % interval");
		}
		departure = value;
	}
	
	*/
}
