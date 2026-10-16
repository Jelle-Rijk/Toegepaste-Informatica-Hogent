package domein;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EmptyListException;

class TestStackGeneriek {

	private MyStack<String> woordenStack;
	private MyStack<Double> decGetallenStack;

	@BeforeEach
	void setUp() {
		woordenStack = new MyStack<>("woordenStack");
		decGetallenStack = new MyStack<>("decimaleGetallenStack");
	}

// STAP2
/*
		@Test void woordenToevoegenVerwijderen() {
		   	woordenStack.push("lekker"); woordenStack.push("zijn");
		   	woordenStack.push("wafels");
		 
		  	assertEquals("wafels", woordenStack.pop());
		  	assertFalse(woordenStack.isEmpty());
		  	assertEquals("zijn", woordenStack.pop());
		  	assertFalse(woordenStack.isEmpty());
		  
		  	assertEquals("lekker", woordenStack.pop());
		  	assertTrue(woordenStack.isEmpty()); 
		}
		  
		@Test void decGetallenToevoegenVerwijderen() {
		  	decGetallenStack.push(12.5); decGetallenStack.push(24.3);
		  	decGetallenStack.push(30.5); decGetallenStack.push(40.5);
		  
		  	assertEquals(40.5, decGetallenStack.pop());
		  	assertFalse(decGetallenStack.isEmpty());
		  	assertEquals(30.5, decGetallenStack.pop());
		  	assertFalse(decGetallenStack.isEmpty());
		  	assertEquals(24.3, decGetallenStack.pop());
		  	assertFalse(decGetallenStack.isEmpty());
		  
		  	assertEquals(12.5, decGetallenStack.pop());
		  	assertTrue(decGetallenStack.isEmpty()); 
		}
*/

/* Uit commentaar zetten
	@Test
	void toevoegenVerwijderenTesten() {
		String[] woorden = { "lekker", "zijn", "wafels" };
		Double[] decGetallen = { 12.5, 24.3, 30.5, 40.5 };
		itemsToevoegenVerwijderen(woordenStack, woorden);
		itemsToevoegenVerwijderen(decGetallenStack, decGetallen);
	}

	private TODO void itemsToevoegenVerwijderen(MyStack TODO myStack, TODO items)


	}
*/
	
	@Test
	void stackLeeg() {
		assertTrue(woordenStack.isEmpty());
	}

	@Test
	void woordenToevoegen() {
		woordenStack.push("lekker");
		woordenStack.push("zijn");
		woordenStack.push("wafels");
		assertFalse(woordenStack.isEmpty());
	}

	@Test
	void woordenDoorElkaarToevoegenVerwijderen() {
		woordenStack.push("lekker");
		woordenStack.push("zijn");

		assertEquals("zijn", woordenStack.pop());
		woordenStack.push("wafels");

		assertEquals("wafels", woordenStack.pop());
		assertEquals("lekker", woordenStack.pop());
		assertTrue(woordenStack.isEmpty());
	}

	@Test
	void woordenVerwijderen() {
		woordenStack.push("lekker");
		woordenStack.push("zijn");
		woordenStack.push("wafels");
		assertFalse(woordenStack.isEmpty());
		assertEquals("wafels", woordenStack.pop());
		assertEquals("zijn", woordenStack.pop());
		assertEquals("lekker", woordenStack.pop());
		assertTrue(woordenStack.isEmpty());
	}

	@Test
	void legeStackElementVerwijderen() {
		assertThrows(EmptyListException.class, () -> {
			woordenStack.pop();
		});
	}

	@Test
	void toonStack() {
		woordenStack.push("lekker");
		woordenStack.push("zijn");
		woordenStack.push("wafels");
		String zin = woordenStack.toString().replaceAll("\\s+", " ").trim();
		assertEquals("The woordenStack is: wafels zijn lekker", zin);
	}

	@Test
	void toonLegeStack() {
		String zin = woordenStack.toString().replaceAll("\\s+", " ").trim();
		assertEquals("woordenStack is empty", zin);
	}
}
