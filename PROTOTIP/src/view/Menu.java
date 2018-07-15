package view;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Administrator;
import model.Korisnik;
import model.Operater;
import model.RadnikUCentrali;
import model.SefStanice;

public class Menu {
	public Menu(Korisnik ulogovani){
		if (ulogovani instanceof Administrator){
			MeniAdministratora meni = new MeniAdministratora();
			meni.setSize(300, 600);
			meni.setLocationRelativeTo(null);
			meni.setVisible(true);
			
		}else if (ulogovani instanceof RadnikUCentrali){
			MeniRadnikaUCentrali meni = new MeniRadnikaUCentrali();
			meni.setSize(300, 350);
			meni.setLocationRelativeTo(null);
			meni.setVisible(true);
			
		}else if (ulogovani instanceof SefStanice){
			MeniSefaStanice meni = new MeniSefaStanice();
			meni.setSize(300, 300);
			meni.setLocationRelativeTo(null);
			meni.setVisible(true);
			
		}else if (ulogovani instanceof Operater) {
			MeniOperatera meni = new MeniOperatera();
			meni.setSize(300, 300);
			meni.setLocationRelativeTo(null);
			meni.setVisible(true);
		}
		
	}
}

@SuppressWarnings("serial")
class MeniAdministratora extends JFrame{
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JLabel labela;
	
	JPanel panel;
	MeniAdministratora() {
		setTitle("Meni administratora");
		labela = new JLabel("Choose an option:", SwingConstants.CENTER);
		
		button1 = new JButton("1. Dodaj korisnika.");
		button2 = new JButton("2. Ukloni korisnika.");
		button3 = new JButton("3. Izmeni korisnika.");
		button4 = new JButton("4. Dodaj deonicu.");
		button5 = new JButton("5. Ukloni deonicu.");
		button6 = new JButton("6. Izmeni deonicu.");
		button7 = new JButton("7. Unesi naplatno mesto.");
		button8 = new JButton("8. Obrisi naplatno mesto.");
		button9 = new JButton("9. Exit.");

		panel = new JPanel(new GridLayout(10, 1));
		panel.add(labela);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		
		add(panel);
	}
	
}


@SuppressWarnings("serial")
class MeniRadnikaUCentrali extends JFrame{
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JLabel labela;
	JPanel panel;
	
	MeniRadnikaUCentrali() {
		setTitle("Meni radnika u centrali");
		labela = new JLabel("Kriterijumi za pravljenje izvestaja:", SwingConstants.CENTER);
		
		button1 = new JButton("1. Naplatna stanica.");
		button2 = new JButton("2. Datum.");
		button3 = new JButton("3. Period.");
		button4 = new JButton("4. Tip vozila.");
		button5 = new JButton("5. Exit.");
		

		panel = new JPanel(new GridLayout(6, 1));
		panel.add(labela);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);

		
		add(panel);
	}
	
}

@SuppressWarnings("serial")
class MeniSefaStanice extends JFrame{
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JLabel labela;
	JPanel panel;
	
	MeniSefaStanice() {
		setTitle("Meni sefa stanice");
		labela = new JLabel("Ponudjene opcije:", SwingConstants.CENTER);
		
		button1 = new JButton("1. Pregled izvestaja.");
		button2 = new JButton("2. Unos cena za deonice.");
		button3 = new JButton("3. Pregled kvarova.");
		button4 = new JButton("4. Exit.");
		
		panel = new JPanel(new GridLayout(5, 1));
		panel.add(labela);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);

		
		add(panel);
	}
}

@SuppressWarnings("serial")
class MeniOperatera extends JFrame{
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JLabel labela;
	JPanel panel;
	
	MeniOperatera() {
		setTitle("Meni operatera");
		labela = new JLabel("Ponudjene opcije:", SwingConstants.CENTER);
		
		button1 = new JButton("1. Podizanje rampe.");
		button2 = new JButton("2. Naplata.");
		button3 = new JButton("3. Postavi X.");
		button4 = new JButton("4. Exit.");
		
		panel = new JPanel(new GridLayout(5, 1));
		panel.add(labela);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);

		
		add(panel);
	}
	
}