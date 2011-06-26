package modelo;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Figura {
	protected Point posicion;
	protected boolean seleccionada;
	private boolean espaleta=false;
	public abstract boolean dentroFigura(Point p);
	public abstract void dibujar(Graphics g);	
	
	

	public void setPosicion(Point posicion)
	{
		this.posicion=posicion;
	}
	/*Metodos para ver si es figura de la paleta*/
	public void setEspaleta(boolean es)
	{
		this.espaleta=es;
	}
	public boolean getEspaleta()
	{
		return this.espaleta;
	}
	/*Fin*/
	
	
	public int getX(){
		return posicion.x;
	}
	
	public int getY(){
		return posicion.y;
	}

	Point getPosicion(){
		return posicion;
	}
	
	public boolean getSeleccionada(){
		return seleccionada;
	}

	public void setSeleccionada(boolean sel){
		seleccionada=sel;
	}

}
