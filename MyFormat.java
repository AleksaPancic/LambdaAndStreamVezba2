package pancicaleksa;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormat extends Formatter {

	@Override
	public String format(LogRecord record) {
		return " Poruka: " + record.getMessage() + "\n";
	}

}
