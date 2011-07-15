package modelo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Color;
import java.io.File;

import javax.imageio.ImageIO;

public class DibujoT extends Figura{

	/*Clase que sirver para dibujar T*/
	/*Ojala y sirva!!*/

	private int ancho;
	private int alto;
	private Image image1;
	public DibujoT(Point posicion, int ancho,int alto){
		this.posicion=posicion;
		this.alto=alto;
		this.ancho=ancho;
		this.seleccionada=false;
		
		try {  
    		image1 = ImageIO.read(new File("image/T.png"));
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
	public void setAlto(int alto){
		this.alto=alto;
	}
	public int getAlto(){
		return alto;
	}
	
	
	
	/*Simplemente agrege alto a la clase y pinte un cuadra mas pequeño en el centro*/
	
	@Override
	public boolean dentroFigura(Point p) {
		int difX=Math.abs(p.x-(posicion.x+(ancho/2)));
		int difY=Math.abs(p.y-(posicion.y+(alto/2)));
		return ( (difX<ancho/2) && (difY<alto/2));   
	}

	@Override
	public void dibujar(Graphics g) {
		g.drawImage(image1,this.getX(),this.getY(),null);		
		if(this.getSeleccionada()){
			g.drawImage(image1,this.getX(),this.getY(),null);
		}
	}

}
