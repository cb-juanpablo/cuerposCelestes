package entities;

import javax.swing.ImageIcon;
/*
 * Atributos del Cuerpo Celeste 
 */
public class CelestialBody {
	
	private String name;
	private double masa;
	private double velocityX;
	private double velocityY;
	private double acelerationX;
	private double acelerationY;
	private double velocity;
	private double positionX;
	private double positionY;
	private ImageIcon icon;
	
	/*
	 * Constructor del cuerpo celeste
	 */
	public CelestialBody(String name, double masa) {
		this.name = name;
		this.masa = masa;
	}
	
	/*
	 * Guetters AND Setters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMasa() {
		return masa;
	}

	public void setMasa(double masa) {
		this.masa = masa;
	}

	public double getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public double getVelocity() {
		this.velocity = this.velocityX+this.velocityY;
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double getAcelerationX() {
		return acelerationX;
	}

	public void setAcelerationX(double acelerationX) {
		this.acelerationX = acelerationX;
	}

	public double getAcelerationY() {
		return acelerationY;
	}

	public void setAcelerationY(double acelerationY) {
		this.acelerationY = acelerationY;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	

}
