package domein;

public class Scrollbar extends TextViewDecorator {
    public Scrollbar(TextView textview) {
        super(textview);
    }

    public String toon() {
        return "scrollbar\n" + textview.toon();
    }

}