package domein;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RekeningTest {


    @ParameterizedTest
    @ValueSource(strings = {"063-1547563-60", "999-9999999-48", "001-0000001-77"})
    void geldigRekeningnummer_ThrowtNiet() {
        String rekeningnummer = "063-1547563-60";
        assertDoesNotThrow(() -> new Rekening(rekeningnummer));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"000-0000000-00", "000-1234567-48", "123-0000000-36", "12-1234567-87", "1234-1234567-33",
            "123-123456-95", "123-12345678-72", "123-12345678-072", "001-0000021-0", "123123456787", "1231234567-87",
            "123-123456787", "063-15475363-60"})
    void ongeldigRekeningnummer_GooitIAE(String rekeningnummer) {
        assertThrows(IllegalArgumentException.class, () -> new Rekening(rekeningnummer));
    }

}