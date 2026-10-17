package domein;

import lombok.Getter;
import utils.Soort;

public class StringValue
{
    @Getter private String value;
    private final Soort soort;

    public StringValue(Soort soort) {
        setValue("");
        this.soort = soort;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
