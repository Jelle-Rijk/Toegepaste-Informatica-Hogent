package gui;

import java.util.Collection;

import domein.DomeinController;
import dto.ContainerDTO;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class OverzichtsScherm extends BorderPane {
	private static final int SERIENUMMER = 0;
	private static final int EIGENAAR = 1;
	private static final int MASSA = 2;
	private static final int VOLUME = 3;
	private final DomeinController dc;
	private GridPane overzichtsPane;
	private Menu sorteerMenu;
	private int gekozenSortering = -1;

	public OverzichtsScherm(DomeinController dc) {
		this.dc = dc;
		buildGui();
	}

	private void buildGui() {
		MenuBar menuBar = buildMenuBar();
		setTop(menuBar);
		overzichtsPane = buildGridPane();
		setCenter(overzichtsPane);
		toonContainers(-1);
		
	}

	private GridPane buildGridPane() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(5);
		grid.setVgap(3);
		grid.setAlignment(Pos.TOP_CENTER);
		ColumnConstraints fixedSizeConstraint = new ColumnConstraints(100);
		grid.getColumnConstraints().addAll(fixedSizeConstraint, fixedSizeConstraint, fixedSizeConstraint,
				fixedSizeConstraint);
		Button[] buttons = { new Button("Serienummer"), new Button("Eigenaar"), new Button("Massa"),
				new Button("Volume") };
		int col = 0;
		for (Button button : buttons) {
			grid.add(button, col, 0);
			// TODO styleClass geven aan button
			button.getStyleClass().add("headerButton");
			GridPane.setHalignment(button, HPos.CENTER);
			final int sorteerSleutel = col;
			button.setOnAction(evt -> toonContainers(sorteerSleutel));
			button.setPrefWidth(100);
			col++;
		}
		return grid;
	}

	private MenuBar buildMenuBar() {
		MenuBar menuBar = new MenuBar();
		
//		Containermenu maken
		Menu containerMenu = new Menu("Containers");
		MenuItem overzichtMI = new MenuItem("Overzicht");
		overzichtMI.setOnAction(e -> show());
		MenuItem toevoegenMI = new MenuItem("Toevoegen");
		toevoegenMI.setOnAction(e -> voegContainerToe());
		MenuItem exitMI = new MenuItem("Exit");
		exitMI.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
		exitMI.setOnAction(e -> Platform.exit());
		containerMenu.getItems().addAll(overzichtMI, toevoegenMI,new SeparatorMenuItem(), exitMI);
		
//		Sorteermenu maken
		sorteerMenu = new Menu("Sorteren");
		String[] sorteerOpties = new String[] {"serienummer", "eigenaar", "massa", "volume"};
		for (int i = 0; i < sorteerOpties.length; i++) {
			MenuItem sorteerMI = new MenuItem(String.format("Op %s", sorteerOpties[i]));
			final int sorteersleutel = i;
			sorteerMI.setOnAction(e -> toonContainers(sorteersleutel));
			sorteerMenu.getItems().add(sorteerMI);
		}
		
		
		
		
		menuBar.getMenus().addAll(containerMenu, sorteerMenu);
		return menuBar;
	}

	public void show() {
		sorteerMenu.setDisable(false);
		setCenter(overzichtsPane);
		toonContainers(gekozenSortering);
	}

	private void voegContainerToe() {
		sorteerMenu.setDisable(true);
		setCenter(new ToevoegScherm(dc, this));
	}

	private void toonContainers(int sorteerSleutel) {
		gekozenSortering = sorteerSleutel;
		Collection<ContainerDTO> containers = switch (sorteerSleutel) {
		case SERIENUMMER -> dc.geefAlleContainersGesorteerdOpSerienummer();
		case EIGENAAR -> dc.geefAlleContainersGesorteerdOpEigenaar();
		case MASSA -> dc.geefAlleContainersGesorteerdOpMassa();
		case VOLUME -> dc.geefAlleContainersGesorteerdOpVolumeEnEigenaar();
		default -> dc.geefAlleContainers();
		};
		int rij = 1;
		for (ContainerDTO container : containers) {
			TextField txfSerienummer = maakUneditableTextField(Integer.toString(container.serienummer()));
			overzichtsPane.add(txfSerienummer, 0, rij);
			TextField txfEigenaar = maakUneditableTextField(container.eigenaar());
			overzichtsPane.add(txfEigenaar, 1, rij);
			TextField txfMassa = maakUneditableTextField(Integer.toString(container.massa()));
			overzichtsPane.add(txfMassa, 2, rij);
			TextField txfVolume = maakUneditableTextField(Integer.toString(container.volume()));
			overzichtsPane.add(txfVolume, 3, rij);
			rij++;
		}
	}

	private TextField maakUneditableTextField(String tekst) {
		TextField txfField = new TextField(tekst);
		txfField.setEditable(false);
		return txfField;
	}
}
