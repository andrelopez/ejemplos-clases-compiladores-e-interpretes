package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import modelo.Modelo;
import modelo.Figura;
import javax.swing.JPanel;


import controlador.Controlador;


public class Vista extends JPanel {
	static final long serialVersionUID = 0L;
	private Modelo modelo;
	private int posini=100;
	public Controlador controlador;  //IMPORTANTE DEBE SER REGISTRADO O TODO FALLA
	
	public Vista(Dimension size, Modelo modelo){
		super();
		this.modelo=modelo;
		
		setPreferredSize(size);
		setBackground(Color.gray);
		setFocusable(true);

		//Mejorable al 1000% solo por simplificacion realizado de esta forma
		MouseController mouseControl = new MouseController() {
			public void mouseClicked(MouseEvent event) {}
			public void mouseEntered(MouseEvent event) {}
			public void mouseExited(MouseEvent event) {}
			public void mouseMoved(MouseEvent event) {}
			public void mousePressed(MouseEvent event) {
			    eVmousePressed(event);	}
			public void mouseReleased(MouseEvent event) {
				eVmouseReleased(event);	}
			public void mouseDragged(MouseEvent event) {
				eVmouseDragged(event);	}
		};
		this.addMouseListener(mouseControl);
		this.addMouseMotionListener(mouseControl);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		pintarTodo(g2);
	}
	
	private void pintarTodo(Graphics2D g){
		for (Figura elemento : modelo.getListado()) {
			elemento.dibujar(g);
		}
	

		g.setStroke(new BasicStroke(10f)); //Grosor de 10 pixeles
		g.setColor(Color.darkGray);
	
		g.fill3DRect(0, posini, 200, 5, true);
		
		
	}

	public void eVmousePressed(MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmousePressed(ev);
		}
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmouseDragged(ev);
		}
	}
	
	public void eVmouseReleased (MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmouseReleased(ev);
		}
	}
	
}


/**************************************************
* SOLO para ahorrar espacio y simplificar cosas
**************************************************/
class MouseController implements MouseListener, MouseMotionListener {
	public void mouseClicked(MouseEvent event) {}
	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}
	public void mousePressed(MouseEvent event) {}
	public void mouseReleased(MouseEvent event) {}
	public void mouseDragged(MouseEvent event) {}
	public void mouseMoved(MouseEvent event) {}
}
