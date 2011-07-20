package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.io.File;

import javax.imageio.ImageIO;

public class Maquina extends Figura {

	private int ancho;
	private Image image1;
	private String Plataforma;
	
	public Maquina(Point posicion, int ancho, String plataforma){
		this.posicion=posicion;
		this.ancho=ancho;
		this.Plataforma = plataforma;
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
	
		g.drawImage(image1,this.getX(),this.getY(),null);
		g.drawString(this.Plataforma, this.getX()+10, this.getY()+20);
		if(this.getSeleccionada()){
			g.drawImage(image1,this.getX(),this.getY(),null);
			g.drawString(this.Plataforma, this.getX()+10, this.getY()+20);
		}
	}	
}