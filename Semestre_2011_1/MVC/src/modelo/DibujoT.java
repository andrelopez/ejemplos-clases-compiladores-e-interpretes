package modelo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Color;
import java.io.File;

import javax.imageio.ImageIO;

public class DibujoT extends Figura {

	/* Clase que sirver para dibujar T */
	/* Ojala y sirva!! */

	private int ancho;
	private int alto;
	static private Image image1;
	private String compilador, acodigo, escritoen;
	
	public DibujoT(Point posicion, int ancho, int alto, String comp, String acodi, String escrito) {
		this.posicion = posicion;
		this.alto = alto;
		this.ancho = ancho;
		this.seleccionada = false;
		this.compilador = comp;
		this.acodigo = acodi;
		this.escritoen = escrito;
		try {
			image1 = ImageIO.read(new File("image/T.png"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("No se puede abrir el archivo ");
		}
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAlto() {
		return alto;
	}

	@Override
	public boolean dentroFigura(Point p) {
		int difX = Math.abs(p.x - (posicion.x + (ancho / 2)));
		int difY = Math.abs(p.y - (posicion.y + (alto / 2)));
		return ((difX < ancho / 2) && (difY < alto / 2));
	}

	@Override
	public void dibujar(Graphics g) {
		if(image1!=null)
		try {
			image1 = ImageIO.read(new File("image/T.png"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("No se puede abrir el archivo ");
		}
		g.setColor(Color.blue);
		g.drawImage(image1, this.getX(), this.getY(), null);
		//g.fillRect(this.getX(), this.getY(), 100, 100);
		g.setColor(Color.gray);
		g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
		g.drawString(this.compilador, this.getX() + 10, this.getY() + 10);

		g.drawString(this.acodigo, this.getX() + ancho - 20, this.getY() + 10);

		g.drawString(this.escritoen, this.getX() + ancho / 2, this.getY()+ alto + 10);
		if (this.getSeleccionada()) {

			g.drawImage(image1, this.getX(), this.getY(), null);
			g.drawString(this.compilador, this.getX() + 10, this.getY() + 10);

			g.drawString(this.acodigo, this.getX() + ancho - 20,
					this.getY() + 10);

			g.drawString(this.escritoen, this.getX() + ancho / 2, this.getY()
					+ alto + 10);
		}
	}

	public void setAcodigo(String acodigo) {
		this.acodigo = acodigo;
	}

	public String getAcodigo() {
		return acodigo;
	}

	public void setCompilador(String compilador) {
		this.compilador = compilador;
	}

	public String getCompilador() {
		return compilador;
	}

	public void setEscritoen(String escritoen) {
		this.escritoen = escritoen;
	}

	public String getEscritoen() {
		return escritoen;
	}

}
