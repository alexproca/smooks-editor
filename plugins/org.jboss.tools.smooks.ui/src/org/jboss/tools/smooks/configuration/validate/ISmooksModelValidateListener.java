package org.jboss.tools.smooks.configuration.validate;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;

public interface ISmooksModelValidateListener {
	void validateStart();
	void validateEnd(List<Diagnostic> diagnosticResult);
}
