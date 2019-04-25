package br.eximia.jsfutils.action;

import java.io.IOException;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

public class MethodParamHandler extends TagHandler {

	private final TagAttribute name;
	private final TagAttribute value;

	public MethodParamHandler(TagConfig config) {
		super(config);
		this.name = this.getRequiredAttribute("name");
		this.value = this.getRequiredAttribute("value");

	}

	public void apply(FaceletContext ctx, UIComponent parent) throws IOException {
		String nameStr = name.getValue(ctx);
		ValueExpression valueExpression = value.getValueExpression(ctx, Object.class);
		MethodExpression methodExpression = new MethodExpressionValueExpressionAdapter(valueExpression);
		ctx.getVariableMapper().setVariable(nameStr, ctx.getExpressionFactory().createValueExpression(methodExpression, MethodExpression.class));
	}

}