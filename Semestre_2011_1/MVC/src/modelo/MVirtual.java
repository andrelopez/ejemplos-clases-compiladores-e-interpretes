package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.io.File;

import javax.imageio.ImageIO;

public class MVirtual extends Figura {

	private int ancho;
	private Image image1;
	private String cOrigen;
	private String cDestino;
	
	public MVirtual(Point posicion, int ancho, String entra, String sale){
		this.posicion=posicion;
		this.ancho=ancho;
		this.cOrigen = entra;
		this.cDestino = sale;
		this.seleccionada=false;  //Deberia estar en el constructor pero por simplicidad
		try {  
    		image1 = ImageIO.read(new File("image/M.png"));
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
    		image1 = ImageIO.read(new File("image/M.png"));
		}
        catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No se puede abrir el archivo ");
        }
		
                    g.setColor(Color.gray);
		g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
                g.drawImage(image1,this.getX(),this.getY(),null);
		g.drawString(this.cOrigen, this.getX()+10, this.getY()+10);
		g.drawString(this.cDestino, this.getX()+10, this.getY()+30);
		if(this.getSeleccionada()){
			g.drawImage(image1,this.getX(),this.getY(),null);
			g.drawString(this.cOrigen, this.getX()+10, this.getY()+10);
			g.drawString(this.cDestino, this.getX()+10, this.getY()+30);
		}
	}	
}