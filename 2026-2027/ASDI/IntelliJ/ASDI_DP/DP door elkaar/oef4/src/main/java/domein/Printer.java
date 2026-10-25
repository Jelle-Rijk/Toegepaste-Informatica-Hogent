package domein;

public class Printer {

    private PrinterState state;

    public Printer() {
        setState(new Ready(this));
    }

    public String print(String bestandsnaam) {
        StringBuilder output = new StringBuilder();
        do {
            output.append("%s%n".formatted(state.print(bestandsnaam)));
        } while (!(state instanceof Ready));
        return output.toString();
    }

    public void setState(PrinterState state) {
        this.state = state;
    }

}