package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import domein.OrderRecord;

public class OrderRecordVerwerker {
	private static final String INNAAM = "src" + File.separator + "textFiles" + File.separator + "order.txt";
	private static final String UITNAAM = "src" + File.separator + "textFiles" + File.separator + "korting.txt";

	public static void genereerOverzichtKortingen() {
		List<OrderRecord> orders = new ArrayList<OrderRecord>();
		try (Scanner input = new Scanner(Files.newInputStream(Paths.get(INNAAM)))) {
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] words = line.split(" ");
				orders.add(
						new OrderRecord(words[0], words[1], Integer.parseInt(words[2]), Double.parseDouble(words[3])));
			}
			input.close();
		} catch (InvalidPathException e) {
			System.err.println("InvalidPathException was thrown.");
		} catch (IOException e) {
			System.err.println("IOException was thrown.");
		}

		List<OrderRecord> ordersMetKorting = orders.stream().filter(rec -> rec.heeftRechtOpKorting()).toList();

		try (Formatter output = new Formatter(Files.newOutputStream(Paths.get(UITNAAM)))) {
			for (OrderRecord order : ordersMetKorting)
				output.format(String.format("%s %s %d %.2f%n", order.getNaam(), order.getProduct(), order.getAantal(), order.geefPrijsMetKorting()));
			output.close();
		} catch (InvalidPathException e) {
			System.err.println("WRITE: InvalidPathException thrown");
		} catch (IOException e) {
			System.err.println("WRITE: IOException thrown");
		}
	}
}
