package vista;

import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;

import modelo.Modelo;
import modelo.Figura;

import javax.imageio.ImageIO;
import javax.swing.*;


import controlador.Controlador;


public class Vista extends JPanel implements ActionListener{
	static final long serialVersionUID = 0L;
	private Modelo modelo;
	private int posini=100;
	private int icono=0,xmouse,ymouse;
	public Controlador controlador;  //IMPORTANTE DEBE SER REGISTRADO O TODO FALLA
	
	JLabel bnuevo;
	
	Image paleta;
	Image nuevo;
	Image guardar;
	Image cargar;
	Image compilador;
	Image enlazador;
	Image maquina;
	Image vmaquina;
	Image interprete;
	Image programa;
	private boolean PresionoPaleta=false,MouseIcon=false;
	
	public Vista(Dimension size, Modelo modelo){
		super();
		this.modelo=modelo;
		
		setPreferredSize(size);
		setBackground(Color.gray);
		setFocusable(true);

		//Mejorable al 1000% solo por simplificacion realizado de esta forma
		MouseController mouseControl = new MouseController() {
			public void mouseClicked(MouseEvent event) {
				
				eVmouseClicked(event);
			}
			public void mouseEntered(MouseEvent event) {}
			public void mouseExited(MouseEvent event) {}
			public void mouseMoved(MouseEvent event) {
				xmouse=event.getX();
				ymouse=event.getY();
				eVmouseMoved(event);
				
			}
			public void mousePressed(MouseEvent event) {
			    eVmousePressed(event);	}
			public void mouseReleased(MouseEvent event) {
				eVmouseReleased(event);	}
			public void mouseDragged(MouseEvent event) {
				eVmouseDragged(event);	}
		};
		this.addMouseListener(mouseControl);
		this.addMouseMotionListener(mouseControl);
		
		try {  
			this.setLayout(null);
			bnuevo = new JLabel(new ImageIcon("images/nuevo.png"));
			bnuevo.setBounds(15, 15, 45, 45);
			bnuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			this.add(bnuevo);
			
    		paleta = ImageIO.read(new File("image/paleta.png"));
    		nuevo = ImageIO.read(new File("image/nuevo.png"));
    		guardar = ImageIO.read(new File("image/guarda.png"));
    		cargar = ImageIO.read(new File("image/abre.png"));
    		compilador = ImageIO.read(new File("image/Tm.png"));
    		enlazador = ImageIO.read(new File("image/Tm.png"));
    		interprete = ImageIO.read(new File("image/Im.png"));
    		maquina = ImageIO.read(new File("image/Mm.png"));
    		vmaquina = ImageIO.read(new File("image/Mm.png"));
    		programa = ImageIO.read(new File("image/Pm.png"));
    		
		}
        catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No se puede abrir el archivo ");
        }
	}
	public boolean getpresion()
	{
		return this.PresionoPaleta;
	}
	public void setpresion(boolean quepaso, int ico,boolean mouse)
	{
		this.PresionoPaleta=quepaso;
		this.MouseIcon=mouse;
		this.icono=ico;
		System.out.println(" "+icono);
	}
	public int geticono()
	{
		return this.icono;
		
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
		
		g.drawImage(paleta,0,0,null);
		g.drawImage(nuevo,25,15,null);
		g.drawImage(guardar,25,65,null);
		g.drawImage(cargar,25,115,null);
	
		g.drawImage(enlazador,10,230,null);
		g.drawImage(interprete,25,280,null);
		g.drawImage(maquina,25,330,null);
		g.drawImage(vmaquina,25,380,null);
		g.drawImage(programa,25,430,null);
		//Dibujar en la punta del muse 
		if(this.PresionoPaleta)
		{
			if(this.icono==5)//Espicharon Compilador
			{
				g.drawString("Compilador", xmouse, ymouse);
				
			}
			if(this.icono==6)//Espicharon Compilador
			{
				g.drawString("Interprete", xmouse, ymouse);
				
			}
			if(this.icono==7)//Espicharon Compilador
			{
				g.drawString("Maquina", xmouse, ymouse);
				
			}
			if(this.icono==9)//Espicharon Compilador
			{
				g.drawString("Programa", xmouse, ymouse);
				
			}
			
		}
	}
	
    public void eVmouseClicked(MouseEvent ev) {
		
		if(controlador!=null)
		{
			controlador.eVmouseClicked(ev);
		}
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
	public void eVmouseMoved (MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmouseMoved(ev);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
