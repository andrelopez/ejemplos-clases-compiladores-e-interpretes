package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;

import javax.imageio.ImageIO;

public class Circulo extends Figura {

	
	private int radio;
	private int ancho;
	private Image image1;
	private String programa;
	private String Codigo;
	
	public void setRadio(int ancho){
		this.radio=ancho;
	}
	
	public int getRadio(){
		return radio;
	}
	
	public Circulo(Point posicion,int ancho, int radio, String prog, String Cod){
		this.posicion=posicion;
		this.radio=radio;
		this.ancho = ancho;
		this.programa = prog;
		this.Codigo = Cod;
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
		boolean band = false;
		boolean bandx = false;
		boolean bandy = false;
		if ( radio >= Math.sqrt( Math.pow( p.x - posicion.x, 2 ) + Math.pow(p.y - posicion.y, 2 )))		
				band = true;
		else
				band = false;
		
		if ( posicion.x + 5 <= p.getX() && p.getX() <= posicion.x + ancho + 5 )
			bandx = true;
		else
			bandx = false;
		
		if( ( ( posicion.y + ancho ) <= p.getY() ) && ( p.getY() <= posicion.y + (2*ancho) ) )
			bandy = true;
		else 
			bandy = false;
		
				
		if( band || ( bandx && bandy ) )
			return true;
		else 
			return false;
	}

	@Override
	public void dibujar(Graphics g) {
		g.drawImage(image1,this.getX(),this.getY(),null);
		g.drawString(this.programa, this.getX()+10, this.getY()+15);
		if(this.getSeleccionada()){
			g.drawImage(image1,this.getX(),this.getY(),null);
		}
	}

}
