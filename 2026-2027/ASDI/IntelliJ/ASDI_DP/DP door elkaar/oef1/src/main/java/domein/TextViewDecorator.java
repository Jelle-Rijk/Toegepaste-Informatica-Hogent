package domein;

import java.util.Objects;

public abstract class TextViewDecorator implements TextView {

	protected final TextView textview;

	public TextViewDecorator(TextView textview) {
		this.textview = Objects.requireNonNull(textview);
	}

}