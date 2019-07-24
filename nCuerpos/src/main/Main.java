package main;

import entities.CelestialBody;
import gui.JFrameMain;
import logic.Orbit;

public class Main {

	public static void main(String[] args) {
		/*
		 * Establece el centro de gravedad
		 */
		CelestialBody body1 = new CelestialBody("Centro de Gravedad", 25000);
		body1.setVelocityX(0);
		body1.setVelocityY(0);
		body1.setPositionX(0);
		body1.setPositionY(0);
		
		/*
		 * Cualquier cuerpo generedado estará en una posición diferente al centro de gravedad
		 */
		CelestialBody body2 = new CelestialBody("N-Cuerpos", 10000);
		body2.setVelocityX(0.09);
		body2.setVelocityY(0.005);
		body2.setPositionX(body1.getPositionX()+(int)Math.random()*(10-250+1)+250);
		body2.setPositionY(body1.getPositionY()+(int)Math.random()*(10-250+1)+250);
		Orbit orbit = new Orbit(body1, body2);
		
		
		JFrameMain frameMain = new JFrameMain(orbit);
		frameMain.setVisible(true);
		frameMain.initThread();
	}

}
