package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.MijnGetal;
// import exceptions.NegativeNumberException;


public class MijnGetalTest {

	private MijnGetal mg1, mg2, mg3, mg4;

	@BeforeEach
	public void before() {
		mg1 = new MijnGetal(6.0);
        mg2 = new MijnGetal(16.0);
        mg3 = new MijnGetal(17.64);
        mg4 = new MijnGetal(24.990001);

	}

    @Test
    public void maakMijnGetal_getalIs6_maaktObject() 
    { 
    	Assertions.assertEquals(6, mg1.getGetal());
    }

	/*
	 * @Test
	 * public void maakMijnGetal_getalIsMin6_werptException() {
	 * 	Assertions.assertThrows(NegativeNumberException.class , () ->
	 * 		new MijnGetal(-6));
	 * 	}
	 */


    @Test
    public void getVierkantswortel_getalIs16_geeft4Terug() 
    {  
    	Assertions.assertEquals(4.0, mg2.geefVierkantswortel());
    }

    @Test
    public void getVierkantswortel_getalIs17_64_geeft4_2Terug() 
    {
    	Assertions.assertEquals(4.2, mg3.geefVierkantswortel());
    }

    @Test
    public void getVierkantswortel_getalIs24_990001geeft4_999Terug()
    {
    	Assertions.assertEquals(4.999, mg4.geefVierkantswortel());
    }

}
