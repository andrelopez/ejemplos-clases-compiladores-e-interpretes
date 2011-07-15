package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;

import javax.imageio.ImageIO;

public class Circulo extends Figura {

	private int radio;
	private Image image1;
	
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
		try {  
    		image1 = ImageIO.read(new File("image/P.png"));
		}
        catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No se puede abrir el archivo ");
        }
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
		g.drawImage(image1,this.getX(),this.getY(),null);		
		if(this.getSeleccionada()){
			g.drawImage(image1,this.getX(),this.getY(),null);
		}
	}

}
