package probniPrototip;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class NextPage extends JFrame {
	JButton button1;
	JButton button2;
	JPanel panel;
	
	Boolean hide = false;
	NextPage() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		//setTitle("Welcome");
		setSize(400, 200);
		setLocationRelativeTo(null);
		
		panel = new JPanel(new GridLayout(2, 1));
		
		button1 = new JButton("Try again.");
		button2 = new JButton("Cancel.");
		
		panel.add(button1);
		panel.add(button2);
		
		
		ListenForFirstButton firstAction = new ListenForFirstButton();
		button1.addActionListener(firstAction);
		
		add(panel);
	}
	
	class ListenForFirstButton implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			makeUnvisible();
		}
	}
	
	public void makeUnvisible() {
		this.setVisible(false);
	}
	
	
}



@SuppressWarnings("serial")
class Login extends JFrame implements ActionListener {
	JButton SUBMIT;
	JPanel panel;
	JLabel label1, label2;
	final JTextField text1, text2;
	ArrayList<Korisnik> korisnici;
	Korisnik konacni;
	
	Boolean showLogin;

	Login(ArrayList<Korisnik> kor) {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		showLogin = false;
		korisnici = kor;
		label1 = new JLabel();
		label1.setText("Username:");
		text1 = new JTextField(15);

		label2 = new JLabel();
		label2.setText("Password:");
		text2 = new JPasswordField(15);

		SUBMIT = new JButton("SUBMIT");

		panel = new JPanel(new GridLayout(3, 1));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(SUBMIT);
		add(panel, BorderLayout.CENTER);
		SUBMIT.addActionListener(this);
		setTitle("LOGIN");
	}

	public void actionPerformed(ActionEvent ae) {
		String value1 = text1.getText();
		String value2 = text2.getText();
		int brojac = korisnici.size();
		int i = 0;
		boolean flag = false;
		for (Korisnik kor : korisnici) {
			++i;
			if (value1.equals(kor.username) && value2.equals(kor.password)) {
				
				/*NextPage page = new NextPage();
				page.setVisible(true);
				JLabel label = new JLabel("Welcome:" + value1);
				page.getContentPane().add(label);*/
				flag = true;
				konacni = kor;
				System.out.println(konacni.ime);
				this.setVisible(false);
				break;

			} else {
				if (i == brojac && flag == false) {
					this.setVisible(false);
					System.out.println("enter the valid username and password");
					NextPage page = new NextPage();
					page.setVisible(true);
					page.setLocationRelativeTo(null);
					JLabel label = new JLabel("Wrong username or password.");
					page.getContentPane().add(label);
				}

			}
		}
	}
	
	public void showLogin() {
		this.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	class NextPage extends JFrame {
		JButton button1;
		JButton button2;
		JPanel panel;
		
		Boolean hide = false;
		NextPage() {
			setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			//setTitle("Welcome");
			setSize(400, 200);
			setLocationRelativeTo(null);
			
			panel = new JPanel(new GridLayout(2, 1));
			
			button1 = new JButton("Try again.");
			button2 = new JButton("Cancel.");
			
			panel.add(button1);
			panel.add(button2);
			
			
			ListenForFirstButton firstAction = new ListenForFirstButton();
			button1.addActionListener(firstAction);
			
			add(panel);
		}
		
		class ListenForFirstButton implements ActionListener {

			public void actionPerformed(ActionEvent arg0) {
				
				makeUnvisible();
				showLogin();
			}
		}
		
		public void makeUnvisible() {
			this.setVisible(false);
		}
		
	
		
		
	}
	
	
	
	
}

class LoginDemo {
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
		System.out.println(frame.konacni.prezime);
		return frame.konacni;
		
		
	}
}

