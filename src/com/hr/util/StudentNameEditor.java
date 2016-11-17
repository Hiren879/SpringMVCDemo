package com.hr.util;

import java.beans.PropertyEditorSupport;

/**
 * This class will be used to check gender prefix.
 * @author hsavalia
 *
 */
public class StudentNameEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String studentName) throws IllegalArgumentException {
		if (studentName.contains("Mr.") || studentName.contains("Ms.")) {
			setValue(studentName);
		} else {
			studentName = "Ms." + studentName;
			setValue(studentName);
		}
	}
}
