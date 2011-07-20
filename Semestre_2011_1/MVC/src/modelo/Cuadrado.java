package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;

import javax.imageio.ImageIO;

public class Cuadrado extends Figura {

	private int ancho;
	private Image image1;
	private String De, Para;
	
	public Cuadrado(Point posicion, int ancho, String de, String para){
		this.posicion=posicion;
		this.ancho=ancho;
		this.seleccionada=false;  //Deberia estar en el constructor pero por simplicidad
		this.De = de;
		this.Para = para;
		
		try {  
    		image1 = ImageIO.read(new File("image/I.png"));
		}
        catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No se puede abrir el archivo ");
        }
	}
	
	public void setAncho(int ancho){
		this.ancho=ancho;
	}
	public int getAncho(){
		return ancho;
	}
	
	@Override
	//Muy rudimentario y solo a modo demostrativo, para uso serio debe ser mejorada
	public boolean dentroFigura(Point p) {
		int difX=Math.abs(p.x-(posicion.x+(ancho/2)));
		int difY=Math.abs(p.y-(posicion.y+(ancho/2)));
		return ( (difX<ancho/2) && (difY<ancho/2));   
	}
	
	@Override
	public void dibujar(Graphics g)
	{
		if(image1!=null)
		try {  
    		image1 = ImageIO.read(new File("image/I.png"));
		}
        catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No se puede abrir el archivo ");
        }
		g.drawImage(image1,this.getX(),this.getY(),null);
		g.drawString(this.De ,this.getX() + 10, this.getY() + 10);
		g.drawString(this.Para ,this.getX() + 10, this.getY() + 30);
		if(this.getSeleccionada()){
			g.drawImage(image1,this.getX(),this.getY(),null);
			g.drawString(this.De ,this.getX() + 10, this.getY() + 10);
			g.drawString(this.Para ,this.getX() + 10, this.getY() + 30);
		}
	}	
}
