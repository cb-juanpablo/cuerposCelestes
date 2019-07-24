package logic;

import java.util.ArrayList;

import entities.CelestialBody;
/*
 * Representa la órbita tomada por los cuerpos
 */
public class Orbit {
	
	private double gravityForce;
	private double distance;
	private CelestialBody celestialBody1;
	private CelestialBody celestialBody2;
	private ArrayList<CelestialBody> celestialBodies;
	private double g;
	
	/*
	 * Construcctor de la Orbita
	 */
	public Orbit(CelestialBody celestialBody1, CelestialBody celestialBody2) {
		this.celestialBody1 = celestialBody1;
		this.celestialBody2 = celestialBody2;
		this.celestialBodies = new ArrayList<CelestialBody>();
		this.g= 6.67*Math.pow(10, -11);
	}
	/*
	 * Se calcula la fuerza de gravedad para cada cuerpo celeste
	 */
	public void calculateGravityForce(CelestialBody celestialBody) {
		this.distance = Math.sqrt(Math.pow(celestialBody.getPositionX(), 2)+Math.pow(celestialBody.getPositionY(), 2));
		this.gravityForce = g * ((this.celestialBody1.getMasa()*celestialBody.getMasa())/Math.pow(this.distance, 2));
		this.calculateAceleration(celestialBody);
		this.calculateVelocity(celestialBody);
		this.calculateNewPosition(celestialBody);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	/*
	 * Guetters AND Setters
	 */
	public void calculateAceleration(CelestialBody celestialBody) {
		celestialBody.setAcelerationX(-this.gravityForce*celestialBody.getPositionX());
		celestialBody.setAcelerationY(-this.gravityForce*celestialBody.getPositionY());
	}
	
	public void calculateVelocity(CelestialBody celestialBody) {
		celestialBody.setVelocityX(celestialBody.getVelocityX()+celestialBody.getAcelerationX());
		celestialBody.setVelocityY(celestialBody.getVelocityY()+celestialBody.getAcelerationY());
	}
	
	public void calculateNewPosition(CelestialBody celestialBody) {
		celestialBody.setPositionX(celestialBody.getPositionX()+celestialBody.getVelocityX());
		celestialBody.setPositionY(celestialBody.getPositionY()+celestialBody.getVelocityY());
	}
	
	public void move() {
		for (int i = 0; i < this.celestialBodies.size(); i++) {
			this.calculateGravityForce(this.celestialBodies.get(i));			
		}
	}

	public double getGravityForce() {
		return gravityForce;
	}

	public void setGravityForce(double gravityForce) {
		this.gravityForce = gravityForce;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public CelestialBody getCelestialBody1() {
		return celestialBody1;
	}

	public void setCelestialBody1(CelestialBody celestialBody1) {
		this.celestialBody1 = celestialBody1;
	}

	public CelestialBody getCelestialBody2() {
		return celestialBody2;
	}

	public void setCelestialBody2(CelestialBody celestialBody2) {
		this.celestialBody2 = celestialBody2;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public ArrayList<CelestialBody> getCelestialBodies() {
		return celestialBodies;
	}

	public void setCelestialBodies(ArrayList<CelestialBody> celestialBodies) {
		this.celestialBodies = celestialBodies;
	}
	
	
}
