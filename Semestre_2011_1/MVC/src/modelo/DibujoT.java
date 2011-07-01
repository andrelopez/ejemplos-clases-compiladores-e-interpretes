package modelo;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class DibujoT extends Figura{

	/*Clase que sirver para dibujar T*/

	private int ancho;
	private int alto;
	public DibujoT(Point posicion, int ancho,int alto){
		this.posicion=posicion;
		this.alto=alto;
		this.ancho=ancho;
		this.seleccionada=false;  
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
		g.setColor(Color.WHITE);
		g.fillRect(this.getX(), this.getY(), this.getAncho(), this.getAlto());
		g.fillRect(this.getX()+(this.getAncho()/3), this.getY()+(this.getAlto()), this.getAlto(), this.getAlto());
		/*Borde para separar*/
		g.setColor(Color.BLACK);
		g.drawRect(this.getX(), this.getY(), this.getAncho(), this.getAlto());
		g.drawRect(this.getX()+(this.getAncho()/3), this.getY()+(this.getAlto()), this.getAlto(), this.getAlto());
		
		if(this.getSeleccionada()){
			g.setColor(Color.RED);
			g.drawRect(this.getX()+7, this.getY()+7, this.getAncho()-20, this.getAlto()-20);
		}
	}

}
