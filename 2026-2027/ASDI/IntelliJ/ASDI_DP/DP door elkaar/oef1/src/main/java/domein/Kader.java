package domein;

public class Kader extends TextViewDecorator {

    private final int borderWidth;

    public Kader(int borderWidth, TextView textView) {
        super(textView);
        this.borderWidth = borderWidth;
    }

    public String toon() {
        return "een zwart kader van %d dik%n".formatted(borderWidth) + textview.toon();
    }

}