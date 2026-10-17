package com.example.asdi_mvn_dp_oef6_opgave.gui;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domein.DomeinController;
import javafx.embed.swing.JFXPanel;

	// selecteer 'Stage1' in FormPanel
	// controleer of 'Stage1' selectie door DetailPanel gezien wordt
	// selecteer 'Stage2' in FormPanel
	// controleer of 'Stage2' selectie door DetailPanel gezien wordt		
	// selecteer 'Bedrijf1' in FormPanel
	// controleer of 'Bedrijf1' selectie door DetailPanel gezien wordt	
	// controleer of 'Stage2' in DetailPanel ongewijzigd is			
	// selecteer 'Bedrijf2' in FormPanel
	// controleer of 'Bedrijf2' selectie door DetailPanel gezien wordt	
	// controleer of 'Stage2' in DetailPanel ongewijzigd is	
	// selecteer 'Stage3' in FormPanel
	// controleer of 'Stage3' selectie door DetailPanel gezien wordt	
	// controleer of 'Bedrijf2' in DetailPanel ongewijzigd is	
	// selecteer 'Stage1' in FormPanel
	// selecteer 'Bedrijf1' in FormPanel
	// controleer of 'Stage1' selectie door DetailPanel gezien wordt		
	// controleer of 'Bedrijf1' selectie door DetailPanel gezien wordt	

class TestOef6 {
	
	    private FormPanelController form;
	    private DetailPanelController detail;

	    @BeforeEach
	    void setUp() {

	        new JFXPanel(); 
	        DomeinController domeinController = new DomeinController();
	        form = new FormPanelController(domeinController);
	        detail = new DetailPanelController(domeinController);
	        //TODO
	        
	    }

	    private void controleer(String verwachtStageId, String verwachtBedrijfsId) {
	        assertEquals(verwachtStageId, detail.getStageId());
	        assertEquals(verwachtBedrijfsId, detail.getBedrijfId());
	    }

	    @Test
	    void observatieStageEnBedrijf_DetailPanel() {

	        // selecteer 'Stage1' in FormPanel
	        form.setStageId("Stage1");
	        // controleer of 'Stage1' selectie door DetailPanel gezien wordt
	        // controleer of 'bedrijfId' in DetailPanel leeg is
	        controleer("Stage1", "");

	        // selecteer 'Stage2' in FormPanel
	        form.setStageId("Stage2");
	        // controleer of 'Stage2' selectie door DetailPanel gezien wordt
	        // controleer of 'bedrijfId' in DetailPanel leeg is
	        controleer("Stage2", "");

	        // selecteer 'Bedrijf1' in FormPanel
	        form.setBedrijfId("Bedrijf1");
	        // controleer of 'Bedrijf1' selectie door DetailPanel gezien wordt	
	        // controleer of 'Stage2' in DetailPanel ongewijzigd is			
	        controleer("Stage2", "Bedrijf1");

	        // selecteer 'Bedrijf2' in FormPanel
	        form.setBedrijfId("Bedrijf2");
	        // controleer of 'Bedrijf2' selectie door DetailPanel gezien wordt	
	        // controleer of 'Stage2' in DetailPanel ongewijzigd is	
	        controleer("Stage2", "Bedrijf2");

	        // selecteer 'Stage3' in FormPanel
	        form.setStageId("Stage3");
	        // controleer of 'Stage3' selectie door DetailPanel gezien wordt	
	        // controleer of 'Bedrijf2' in DetailPanel ongewijzigd is	
	        controleer("Stage3", "Bedrijf2");

	        // selecteer 'Stage1' in FormPanel
	        // selecteer 'Bedrijf1' in FormPanel
	        form.setStageId("Stage1");
	        form.setBedrijfId("Bedrijf1");
	        // controleer of 'Stage1' selectie door DetailPanel gezien wordt		
	        // controleer of 'Bedrijf1' selectie door DetailPanel gezien wordt	
	        controleer("Stage1", "Bedrijf1");

	    }
	}