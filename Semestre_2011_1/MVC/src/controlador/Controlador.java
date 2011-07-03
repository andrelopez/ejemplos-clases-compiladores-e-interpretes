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
import modelo.Modelo;

public class Controlador {
	
	private Modelo modelo;
	private Vista vista;
	private Figura seleccionada;
	private Point punto;
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
		seleccionada=null;
		punto= new Point(10,57);
		
		
		/*Paleta de figuras by Andrelopez*/
		this.anyadirFigura(new DibujoT(punto,90,20));
		modelo.darpaleta();
	}
	
	public Figura obtenerFigura(Point posicion){
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			tmp.setSeleccionada(true);
	    			return tmp;
	    		}
		    }
	    return null;
	}

	public void cambiarPosicion(Figura f, Point p){
		f.setPosicion(p);
	}
	
	public Vista getVista(){
		return vista;
	}
	
	public void anyadirFigura(Figura f){
		modelo.anyadirFigura(f);
	}
	
	public Figura getFiguraEn(Point p){
		return modelo.getFiguraEn(p);
	}
	
	public void eVmousePressed(MouseEvent ev) {
		if(SwingUtilities.isLeftMouseButton(ev)){ 			//Click boton izquierdo selecciona figura
			seleccionada=this.getFiguraEn(ev.getPoint());
		}else if(SwingUtilities.isRightMouseButton(ev)){		//click boton izquierdo añade figura tipo Dibujo T
			this.anyadirFigura(new DibujoT(ev.getPoint(),150,40));			
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio añade figura tipo circulo
		{
			this.anyadirFigura(new Circulo(ev.getPoint(),40));
		}
		vista.repaint();		
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		if(seleccionada!=null){
			//El movimiento puede ser mas fluido recalculando el pto
			
			/*Verificamos que no sea de la paleta si no muevase!*/
			if(!seleccionada.getEspaleta())
			{
				this.cambiarPosicion(seleccionada, ev.getPoint());
				vista.repaint();
				
			}
		}
	}

	public void eVmouseReleased (MouseEvent ev) {
		vista.repaint();
		if(seleccionada!=null){
			seleccionada.setSeleccionada(false);
			seleccionada=null;
		}
	}

}
