package domein;

public class Held {
    private Wapen wapen;

    public Held() {
        setWapen(null);
    }

    public void valAan() {
        getWapen().valAan();
    }

    public Wapen getWapen() {
        return wapen;
    }

    public void setWapen(Wapen wapen) {
        this.wapen = wapen == null ? new Handen() : wapen;
    }
}