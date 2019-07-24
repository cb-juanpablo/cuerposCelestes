package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import entities.CelestialBody;
import logic.Orbit;

public class JFrameMain extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	private Orbit orbit;
	private Thread thread;
	private JLabel lbPlanet, lbUniverse;
	private static int CONSTANT_DIV = 250;


	
		/*
		 * Propiedades de la Interfaz Gráfica
		 */
		public JFrameMain(Orbit orbit) {
			this.orbit = orbit;
			this.getContentPane().setBackground(Color.BLACK);
			this.setSize(1000, 700);
			this.setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("N-Cuerpos");
			this.setLocationRelativeTo(null);			
			this.thread = new Thread(this);
			this.setLayout(null);
			this.centerPoint();
			this.addUniverse();
			this.addSun();
			this.addEarth();
			this.addMoon();
		}
		
		/*
		 * Permite agregar el sol al universo
		 * La posición Inicial es un alteatorio lo más cercano al punto de gravedad
		 * La masa es un valor constante para guardar las proporciones con los demás cuerpos
		 */
		public void addSun() {
			String path = "/img/Sol.png";  
			URL url = this.getClass().getResource(path);  
			ImageIcon icon = new ImageIcon(url);  
			ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(this.lbPlanet.getWidth(), this.lbPlanet.getHeight(), Image.SCALE_DEFAULT));
			CelestialBody body2 = new CelestialBody("Sol", 30000);
			body2.setVelocityX(0.09);
			body2.setVelocityY(0.005);
			body2.setPositionX((int)Math.random()*(0-50+1)+50);
			body2.setPositionY((int)Math.random()*(0-50+1)+50);
			body2.setIcon(icon2);
			this.orbit.getCelestialBodies().add(body2);
			this.repaint(0,0,1,1);
		}
		/*
		 * Agrega la luna al universo
		 * La posición Inicial es un alteatorio lo más cercano a la tierra
		 * La masa es un valor constante para guardar las proporciones con los demás cuerpos
		 */
		public void addMoon() {
			String path = "/img/luna.png";  
			URL url = this.getClass().getResource(path);  
			ImageIcon icon = new ImageIcon(url);  
			ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(this.lbPlanet.getWidth(), this.lbPlanet.getHeight(), Image.SCALE_DEFAULT));
			CelestialBody body2 = new CelestialBody("Luna", 9000);
			body2.setVelocityX(0.09);
			body2.setVelocityY(0.005);
			body2.setPositionX((int)Math.random()*(100-250+1)+200);
			body2.setPositionY((int)Math.random()*(100-250+1)+200);
			body2.setIcon(icon2);
			this.orbit.getCelestialBodies().add(body2);
		}
		/*
		 * Agrega la tierra al universo
		 * La posición Inicial es un alteatorio alejado de la tierra
		 * La masa es un valor constante para guardar las proporciones con los demás cuerpos
		 */
		public void addEarth() {
			String path = "/img/tierra.png";  
			URL url = this.getClass().getResource(path);  
			ImageIcon icon = new ImageIcon(url);  
			ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(this.lbPlanet.getWidth(), this.lbPlanet.getHeight(), Image.SCALE_DEFAULT));
			CelestialBody body2 = new CelestialBody("Tierra", 25000);
			body2.setVelocityX(0.09);
			body2.setVelocityY(0.005);
			body2.setPositionX((int)Math.random()*(100-200+1)+200);
			body2.setPositionY((int)Math.random()*(50-100+1)+100);
			body2.setIcon(icon2);
			this.orbit.getCelestialBodies().add(body2);
		}
		
		
		/*
		 * Representación del universo
		 */
		public void addUniverse() {
			this.lbUniverse = new JLabel();
			this.lbUniverse.setBounds(0,0,this.getWidth(), this.getHeight());
			String path = "/img/universe.png";  
			URL url = this.getClass().getResource(path);  
			ImageIcon icon = new ImageIcon(url);  
			ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(this.lbUniverse.getWidth(), this.lbUniverse.getHeight(), Image.SCALE_DEFAULT));
			this.lbUniverse.setIcon(icon2); 
			this.add(this.lbUniverse);
		}
		
		
	
		
		/*
		 * Representa un punto en el universo en el cuál existe una mayor atracción para los cuerpos celestes (Agujero)
		 */
		public void centerPoint() {
			this.lbPlanet = new JLabel("Punto Gravedad");
			this.lbPlanet.setBounds(this.getWidth()/2-(int)this.orbit.getCelestialBody1().getMasa()/CONSTANT_DIV, 
					this.getHeight()/2-((int)this.orbit.getCelestialBody1().getMasa()/CONSTANT_DIV)/2, 
					(int)this.orbit.getCelestialBody1().getMasa()/CONSTANT_DIV, (int)this.orbit.getCelestialBody1().getMasa()/CONSTANT_DIV);	
		}
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			//Pintar Sol
			g.drawImage(this.orbit.getCelestialBodies().get(0).getIcon().getImage(), this.lbPlanet.getX()+(int)this.orbit.getCelestialBodies().get(0).getPositionX(),
			this.lbPlanet.getY()-(int)this.orbit.getCelestialBodies().get(0).getPositionY(), (int)this.orbit.getCelestialBodies().get(0).getMasa()/CONSTANT_DIV,
			(int)this.orbit.getCelestialBodies().get(0).getMasa()/CONSTANT_DIV, this);
			
			//Pintar Tierra
			g.drawImage(this.orbit.getCelestialBodies().get(1).getIcon().getImage(), this.lbPlanet.getX()+(int)this.orbit.getCelestialBodies().get(1).getPositionX(),
					this.lbPlanet.getY()-(int)this.orbit.getCelestialBodies().get(1).getPositionY(), (int)this.orbit.getCelestialBodies().get(1).getMasa()/CONSTANT_DIV,
					(int)this.orbit.getCelestialBodies().get(1).getMasa()/CONSTANT_DIV, this);
					
			
			//Pintar Luna
			g.drawImage(this.orbit.getCelestialBodies().get(2).getIcon().getImage(), this.lbPlanet.getX()+(int)this.orbit.getCelestialBodies().get(2).getPositionX(),
					this.lbPlanet.getY()-(int)this.orbit.getCelestialBodies().get(2).getPositionY(), (int)this.orbit.getCelestialBodies().get(2).getMasa()/CONSTANT_DIV,
					(int)this.orbit.getCelestialBodies().get(2).getMasa()/CONSTANT_DIV, this);
			
		}
		@Override
		public void update(Graphics g) {
			// TODO Auto-generated method stub
			super.update(g);
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				this.orbit.move();
				repaint();
				
			}
			
		}
		
		public void initThread() {
			this.thread.start();
		}

}
