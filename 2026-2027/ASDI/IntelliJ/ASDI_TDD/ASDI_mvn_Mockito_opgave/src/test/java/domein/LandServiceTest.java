package domein;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import persistentie.PersistentieController;

@ExtendWith(MockitoExtension.class)
class LandServiceTest {

	@Mock
	private PersistentieController persistentieControllerDummy;

	@InjectMocks
	private LandService landService;

	private static final int oppervlakte = 110;

	@ParameterizedTest
	@CsvSource({ "BE, 10, 0.1", "NL, 22, 0.2", "DE, 78, 0.7" })
	void testGeefLandStatistiekScenario(String landCode, int landOppervlakte, double verwachteResultaat) {
		when(persistentieControllerDummy.findLand(landCode)).
		                  thenReturn(new Land(landCode, landOppervlakte));

		when(persistentieControllerDummy.findOppervlakteAlleLanden()).thenReturn(oppervlakte);

		LandStatistiek stat = landService.geefLandStatistiek(landCode);

		assertEquals(landCode, stat.landCode());

		assertEquals(verwachteResultaat, stat.verhouding(), 0.01);

		verify(persistentieControllerDummy).findLand(landCode);
		verify(persistentieControllerDummy).findOppervlakteAlleLanden();

	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "        " })
	void lege_spaties_nullCode(String landCode) {
		assertThrows(IllegalArgumentException.class, () -> landService.geefLandStatistiek(landCode));
	}

	@Test
	void landBestaatNiet() {
		final String CODE_GEEN_LAND = "GEEN_LAND";
		
		//findLand(CODE_GEEN_LAND) wordt minstens 1x opgeroepen
		when(persistentieControllerDummy.findLand(CODE_GEEN_LAND)).thenReturn(null);
		
		//controle "findOppervlakteAlleLanden() wordt minstens 1x opgeroepen" willen we NIET
		lenient().when(persistentieControllerDummy.findOppervlakteAlleLanden()).thenReturn(100);
		
		assertNull(landService.geefLandStatistiek(CODE_GEEN_LAND));

		//1x
		verify(persistentieControllerDummy).findLand(CODE_GEEN_LAND);

		verify(persistentieControllerDummy,times(0)).findOppervlakteAlleLanden();

	}

}
