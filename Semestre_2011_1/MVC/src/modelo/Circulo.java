package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circulo extends Figura {

	private int radio;
	
	public void setRadio(int ancho){
		this.radio=ancho;
	}
	
	public int getRadio(){
		return radio;
	}
	
	public Circulo(Point posicion, int radio){
		this.posicion=posicion;
		this.radio=radio;
		this.seleccionada=false;  //Deberia estar en el constructor de figura pero por simplicidad
	}
	
	@Override
	public boolean dentroFigura(Point p) {
		if ( radio >= Math.sqrt( Math.pow( p.x - posicion.x, 2 ) + Math.pow(p.y - posicion.y, 2 )))		
				return true;
		else
				return false;
	}

	@Override
	public void dibujar(Graphics g) {
		float punto=this.getRadio()/1.5f;
		g.setColor(Color.WHITE);
		/*Dibujando el programa*/
		g.fill3DRect(this.getX(), this.getY(), this.getRadio(), this.getRadio(),true);
		g.fillOval(this.getX()-2, this.getY()-30, this.getRadio()+5, this.getRadio()+5);
	
		
		g.setColor(Color.BLACK);
		g.drawRect(this.getX(), this.getY(), this.getRadio(), this.getRadio());
		//g.drawOval(this.getX()-2, this.getY()-30, this.getRadio()+5, this.getRadio()+5);
		
		
		if(this.getSeleccionada()){
			g.setColor(Color.red);
			g.draw3DRect(this.getX(), this.getY(), this.getRadio(), this.getRadio(),true);
		//	g.drawOval(this.getX()-2, this.getY()-30, this.getRadio()+5, this.getRadio()+5);
		
			
			
		}
	}

}
