package view;

import java.util.ArrayList;

import model.Korisnik;

public class LoginDemo {
	public Korisnik me(ArrayList<Korisnik> korisnici) {
		Login frame = new Login(korisnici);
		frame.setSize(300, 100);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		while (frame.konacni == null) {
			System.out.println("");
			/*
			try {
				frame.setSize(300, 100);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}*/
		}
		System.out.println(frame.konacni.getPrezime());
		return frame.konacni;
		
		
	}
}
