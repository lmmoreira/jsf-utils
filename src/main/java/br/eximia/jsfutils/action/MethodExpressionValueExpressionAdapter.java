package br.eximia.jsfutils.action;

import javax.el.ELContext;
import javax.el.MethodExpression;
import javax.el.MethodInfo;
import javax.el.ValueExpression;

public class MethodExpressionValueExpressionAdapter extends MethodExpression {

	private static final long serialVersionUID = 1L;
	private final ValueExpression valueExpression;

	public MethodExpressionValueExpressionAdapter(ValueExpression valueExpression) {
		this.valueExpression = valueExpression;
	}

	@Override
	public Object invoke(ELContext context, Object[] params) {
		return valueExpression.getValue(context);
	}

	@Override
	public MethodInfo getMethodInfo(ELContext context) {
		return new MethodInfo(null, valueExpression.getExpectedType(), null);
	}

	@Override
	public boolean isLiteralText() {
		return false;
	}

	@Override
	public int hashCode() {
		return valueExpression.hashCode();
	}

	@Override
	public String getExpressionString() {
		return valueExpression.getExpressionString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (obj instanceof MethodExpressionValueExpressionAdapter) {
			return ((MethodExpressionValueExpressionAdapter) obj).getValueExpression().equals(valueExpression);
		}

		return false;
	}

	public ValueExpression getValueExpression() {
		return valueExpression;
	}

}