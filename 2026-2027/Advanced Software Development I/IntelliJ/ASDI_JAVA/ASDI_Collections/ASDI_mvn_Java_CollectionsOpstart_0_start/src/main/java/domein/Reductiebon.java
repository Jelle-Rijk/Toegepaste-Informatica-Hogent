package domein;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "reductiebonCode")
public class Reductiebon {

	private String reductiebonCode;
    private int percentage;
    private LocalDate einddatum;
	    
	@Override
    public String toString()
    {
        return "%s, korting %d%%, geldig t.e.m. %3$te %3$tb %3$tY".formatted(
        		reductiebonCode, percentage, einddatum);
    }

}