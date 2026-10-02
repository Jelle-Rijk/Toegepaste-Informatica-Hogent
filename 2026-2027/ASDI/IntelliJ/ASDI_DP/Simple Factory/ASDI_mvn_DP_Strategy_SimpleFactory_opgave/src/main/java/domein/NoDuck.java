package domein;

public class NoDuck extends Duck {
    public NoDuck() {
        super(() -> "", () -> "", () -> "");
    }
}
