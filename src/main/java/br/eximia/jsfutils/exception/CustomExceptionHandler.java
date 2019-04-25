package br.eximia.jsfutils.exception;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import com.google.common.base.Strings;

import br.eximia.jsfutils.BundleUtils;
import br.eximia.jsfutils.MessageUtils;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;

	public CustomExceptionHandler(ExceptionHandler exception) {
		this.wrapped = exception;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}

	@Override
	public void handle() throws FacesException {
		final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();
		while (i.hasNext()) {
			ExceptionQueuedEvent event = i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			Throwable rootCause = getRootCauseCustom(context.getException());
			try {
				handleException(rootCause);
			} finally {
				i.remove();
			}
		}
		getWrapped().handle();
	}

	private Throwable getRootCauseCustom(Throwable t) {
		if (t.getCause() != null) {
			return getRootCauseCustom(t.getCause());
		}
		return t;
	}

	private void handleException(Throwable rootCause) {
		String message = BundleUtils.getMessage(rootCause.getClass().getCanonicalName());
		MessageUtils.jsfErrorMessage( Strings.isNullOrEmpty(message) ?  rootCause.getMessage() : message);
	}
	
}