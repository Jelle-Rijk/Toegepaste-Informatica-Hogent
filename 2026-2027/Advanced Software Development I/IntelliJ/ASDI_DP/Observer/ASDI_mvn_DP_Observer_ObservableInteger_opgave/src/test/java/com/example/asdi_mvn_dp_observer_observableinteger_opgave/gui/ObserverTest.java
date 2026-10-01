package com.example.asdi_mvn_dp_observer_observableinteger_opgave.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.DomeinController;
import javafx.embed.swing.JFXPanel;

class ObserverTest {

	private ObservableIntegerFrameController frame;
	private DomeinController domeinController;
	
	@BeforeEach
	void setUp() {

		/*In testomgevingen is JFXPanel nodig om het JavaFX-thread-systeem te starten, 
		 zodat JavaFX-componenten correct worden geïnitialiseerd. 
		 Zonder dit zou JavaFX niet goed werken in een testomgeving zonder JavaFX-runtime.*/
		new JFXPanel();
		
		domeinController = new DomeinController();
		frame = new ObservableIntegerFrameController(domeinController);	
	}

	@Test
	void testUp()
	{
		domeinController.up();
		assertEquals("Value: 2", frame.getValue());
		domeinController.up();
		assertEquals("Value: 3", frame.getValue());
		domeinController.up();
		domeinController.up();
		assertEquals("Value: 5", frame.getValue());
	}
	
	@Test
	void testDown()
	{
		domeinController.down();
		assertEquals("Value: 0", frame.getValue());
		domeinController.down();
		assertEquals("Value: -1", frame.getValue());
		domeinController.down();
		domeinController.down();
		assertEquals("Value: -3", frame.getValue());
	}
	
	@Test
	void testDownUp()
	{
		domeinController.up();
		assertEquals("Value: 2", frame.getValue());
		domeinController.down();
		assertEquals("Value: 1", frame.getValue());
		domeinController.down();
		assertEquals("Value: 0", frame.getValue());
		domeinController.up();
		assertEquals("Value: 1", frame.getValue());
		domeinController.up();
		assertEquals("Value: 2", frame.getValue());
	}
}
