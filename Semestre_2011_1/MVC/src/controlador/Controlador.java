package controlador;

import java.awt.Point;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.util.ListIterator;

import vista.Vista;
import modelo.Circulo;
import modelo.Cuadrado;
import modelo.DibujoT;
import modelo.Figura;
import modelo.MVirtual;
import modelo.Modelo;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private Figura seleccionada;
	private Point punto;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		seleccionada = null;
		punto = new Point(10, 57);

	}

	public Figura obtenerFigura(Point posicion) {
		ListIterator<Figura> it = modelo.getListado().listIterator();
		while (it.hasNext()) {
			Figura tmp = it.next();
			if (tmp.dentroFigura(posicion)) {
				tmp.setSeleccionada(true);
				return tmp;
			}
		}
		return null;
	}

	public void cambiarPosicion(Figura f, Point p) {
		f.setPosicion(p);
	}

	public Vista getVista() {
		return vista;
	}

	public void anyadirFigura(Figura f) {
		modelo.anyadirFigura(f);
	}

	public Figura getFiguraEn(Point p) {
		return modelo.getFiguraEn(p);
	}

	public void eVmousePressed(MouseEvent ev) {

		if (SwingUtilities.isLeftMouseButton(ev)) { // Click boton izquierdo
													// selecciona figura
			seleccionada = this.getFiguraEn(ev.getPoint());
		} else if (SwingUtilities.isRightMouseButton(ev)) { // click boton
															// izquierdo añade
															// figura tipo
															// Dibujo T
			// this.anyadirFigura(new MVirtual(ev.getPoint(),80));
		} else if (SwingUtilities.isMiddleMouseButton(ev))// click boton medio
															// añade figura tipo
															// circulo
		{
			// this.anyadirFigura(new Circulo(ev.getPoint(),40));
		}
		vista.repaint();
	}

	public void eVmouseDragged(MouseEvent ev) {
		if (seleccionada != null) {
			// El movimiento puede ser mas fluido recalculando el pto
			this.cambiarPosicion(seleccionada, ev.getPoint());
			vista.repaint();
		}
	}

	public void eVmouseReleased(MouseEvent ev) {
		vista.repaint();
		if (seleccionada != null) {
			seleccionada.setSeleccionada(false);
			seleccionada = null;
		}
	}

	public void eVmouseClicked(MouseEvent ev) {
		// TODO Auto-generated method stub
		/* Si le dio click a la paleta :D */
		vista.repaint();
		if (vista.getpresion() == false && ev.getX() < 80) {// La magia dice que
															// paleta espicho
			vista.setpresion(true, ((ev.getY() - 20) / 50) + 1, true);

		}
		if (vista.getpresion() && ev.getX() > 90) // Dibuja lo q tenga q dibujar
		{
			if (vista.geticono() == 5)// Compilador
				this.anyadirFigura(new DibujoT(ev.getPoint(), 150, 40));
			if (vista.geticono() == 6)// Compilador
				this.anyadirFigura(new Cuadrado(ev.getPoint(), 80));
			if (vista.geticono() == 7)// Compilador
				this.anyadirFigura(new MVirtual(ev.getPoint(),80));
			if (vista.geticono() == 9)// Compilador
				this.anyadirFigura(new Circulo(ev.getPoint(),40));



			vista.setpresion(false, 0, false);

		}
	}

	public void eVmouseMoved(MouseEvent ev) {
		// TODO Auto-generated method stub
		vista.repaint();
	}

}
