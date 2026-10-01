package domein;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ReaderDecorator implements Reader {

	protected Reader reader;

}