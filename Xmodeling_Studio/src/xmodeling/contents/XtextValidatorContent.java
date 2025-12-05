package xmodeling.contents;

import java.text.MessageFormat;

public class XtextValidatorContent implements FileContent {

	@Override
	public String getContentFor(String projectName, String projectClass) {
		return MessageFormat.format(
			"""
			
			""",
			projectClass);
	}

}
