package app.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class ConsoleView {

	@SuppressWarnings("unused")
	public double getDoubleInput(String hint) {
		try {
			String raw = getInput(hint);
			return Double.parseDouble(raw);
		} catch (NumberFormatException e) {
			return getDoubleInput(hint);
		}
	}

	public String getInput(String hint) {
		System.out.println(hint);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String output = reader.readLine();
			return output;
		} catch (IOException e) {
			System.out.println("Invalid input!");
			return getInput(hint);
		}
	}

	public void showSelectionItem(int index, String col1, String col2) {
		System.out.println("\t" + index + ". " + col1 + " " + col2);
	}

	public int getIntInput(String hint) {
		try {
			String raw = getInput(hint);
			return Integer.parseInt(raw);
		} catch (NumberFormatException e) {
			return getIntInput(hint);
		}
	}

	public Date getDateInput(String hint) {
		// TODO Auto-generated method stub
		String raw = getInput(hint);
		return new Date();
	}

}
