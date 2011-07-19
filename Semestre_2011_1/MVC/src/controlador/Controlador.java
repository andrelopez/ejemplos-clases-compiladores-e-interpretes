package controlador;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ListIterator;

import vista.Vista;
import modelo.Circulo;
import modelo.Cuadrado;
import modelo.DibujoT;
import modelo.Figura;
import modelo.MVirtual;
import modelo.Maquina;
import modelo.Modelo;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private Figura seleccionada;
	private Point punto;
	
	//Componentes Compilador
	private Container contenedor_c;
	private JDialog n_compilador;
	private JTextField c_data1, c_data2, c_data3;
	private Label c_label1, c_label2, c_label3;
	private JButton boton_c;
	private boolean envio_c = false;
	
	//Componentes Interprete
	private Container contenedor_i;
	private JDialog n_interprete;
	private JTextField i_data1, i_data2;
	private Label i_label1, i_label2;
	private JButton boton_i;
	private boolean envio_i = false;
	
	//Componentes Maquina
	private Container contenedor_m;
	private JDialog n_maquina;
	private JTextField m_data1, m_data2;
	private Label m_label1, m_label2;
	private JButton boton_m;
	private boolean envio_m = false;
	
	//Componentes Maquina Virtual
	private Container contenedor_vm;
	private JDialog n_vmaquina;
	private JTextField vm_data1, vm_data2;
	private Label vm_label1, vm_label2;
	private JButton boton_vm;
	private boolean envio_vm = false;
	
	//Componentes Programa
	private Container contenedor_p;
	private JDialog n_programa;
	private JTextField p_data1, p_data2;
	private Label p_label1, p_label2;
	private JButton boton_p;
	private boolean envio_p = false;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		seleccionada = null;
		punto = new Point(10, 57);
		
		/* Ventana emergente para el compilador */
		n_compilador = new JDialog();
		n_compilador.setModal(true);// para que sea hijo del frame papa y no se pueda salir sin antes meter los datos
		n_compilador.setBounds(this.vista.getxmouse(), this.vista.getymouse(),250, 150);
		contenedor_c = n_compilador.getContentPane();
		contenedor_c.setLayout(new FlowLayout());
		n_compilador.setResizable(false);
		c_label1 = new Label("Compilador de");
		c_label1.setLocation(0, 0);
		c_data1 = new JTextField(10);
		c_data1.setLocation(0, 10);
		c_data1.setToolTipText("Compilador de:");
		c_label2 = new Label("A codigo");
		contenedor_c.add(c_label1);
		contenedor_c.add(c_data1);		
		c_label2.setLocation(0, 20);
		c_data2 = new JTextField(10);// A codigo
		c_data2.setLocation(0, 30);
		c_data2.setToolTipText("A codigo:");
		c_label3 = new Label("Escrito en");		
		contenedor_c.add(c_label2);		
		contenedor_c.add(c_data2);
		c_label3.setLocation(0, 40);
		c_data3 = new JTextField(10);// Escrito En
		c_data3.setLocation(0, 50);
		c_data3.setToolTipText("Escrito en:");
		contenedor_c.add(c_label3);
		contenedor_c.add(c_data3);		
		boton_c = new JButton("Aceptar");
		boton_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c_data1.getText().compareTo("") != 0 && c_data2.getText().compareTo("") != 0 && c_data3.getText().compareTo("") != 0)
				{
					envio_c = true;
					n_compilador.setVisible(false);
				}
			}
		});
		contenedor_c.add(boton_c);
		
		/* Ventana emergente para el Interprete */
		n_interprete = new JDialog();
		n_interprete.setModal(true);
		n_interprete.setBounds(this.vista.getxmouse(), this.vista.getymouse(), 200, 150);
		contenedor_i = n_interprete.getContentPane();
		contenedor_i.setLayout(new FlowLayout());
		i_label1 = new Label("De: ");
		i_label1.setLocation(0, 20);
		i_label2 = new Label("Para");
		i_label2.setLocation(0, 20);
		i_data1 = new JTextField(10);
		i_data1.setLocation(0, 30);
		i_data1.setToolTipText("lenguaje entrante");
		i_data2 = new JTextField(10);
		i_data2.setLocation(0, 40);
		i_data2.setToolTipText("lenguaje saliente");
		boton_i = new JButton("Aceptar");
		boton_i.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (i_data1.getText().compareTo("") != 0 && i_data2.getText().compareTo("") != 0 )
				{
					envio_i = true;
					n_interprete.setVisible(false);
				}
			}
		});
		contenedor_i.add(i_label1);
		contenedor_i.add(i_data1);
		contenedor_i.add(i_label2);
		contenedor_i.add(i_data2);
		contenedor_i.add(boton_i);
		
		/* Ventana emergente para la Maquina */
		n_maquina = new JDialog();
		n_maquina.setModal(true);
		n_maquina.setBounds(this.vista.getxmouse(), this.vista.getymouse(), 200, 100);
		contenedor_m = n_maquina.getContentPane();
		contenedor_m.setLayout(new FlowLayout());
		m_label1 = new Label("De: ");
		m_label1.setLocation(0, 20);
		m_data1 = new JTextField(10);
		m_data1.setLocation(0, 30);
		m_data1.setToolTipText("Plataforma");
		boton_m = new JButton("Aceptar");
		boton_m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m_data1.getText().compareTo("") != 0)
				{
					envio_m = true;
					n_maquina.setVisible(false);
				}
			}
		});
		contenedor_m.add(m_label1);
		contenedor_m.add(m_data1);
		contenedor_m.add(boton_m);
		
		/* Ventana emergente para la Maquina Virtual */
		n_vmaquina = new JDialog();
		n_vmaquina.setModal(true);
		n_vmaquina.setBounds(this.vista.getxmouse(), this.vista.getymouse(), 200, 150);
		contenedor_vm = n_vmaquina.getContentPane();
		contenedor_vm.setLayout(new FlowLayout());
		vm_label1 = new Label("De: ");
		vm_label1.setLocation(0, 20);
		vm_label2 = new Label("Para");
		vm_label2.setLocation(0, 20);
		vm_data1 = new JTextField(10);
		vm_data1.setLocation(0, 30);
		vm_data1.setToolTipText("lenguaje entrante");
		vm_data2 = new JTextField(10);
		vm_data2.setLocation(0, 40);
		vm_data2.setToolTipText("lenguaje saliente");
		boton_vm = new JButton("Aceptar");
		boton_vm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vm_data1.getText().compareTo("") != 0 && vm_data2.getText().compareTo("") != 0 )
				{
					envio_vm = true;
					n_vmaquina.setVisible(false);
				}
			}
		});
		contenedor_vm.add(vm_label1);
		contenedor_vm.add(vm_data1);
		contenedor_vm.add(vm_label2);
		contenedor_vm.add(vm_data2);
		contenedor_vm.add(boton_vm);
		
		/* Ventana emergente para el programa */
		n_programa = new JDialog();
		n_programa.setModal(true);
		n_programa.setBounds(this.vista.getxmouse(), this.vista.getymouse(), 200, 150);
		contenedor_p = n_programa.getContentPane();
		contenedor_p.setLayout(new FlowLayout());
		p_label1 = new Label("programa: ");
		p_label1.setLocation(0, 20);
		p_label2 = new Label("codigo");
		p_label2.setLocation(0, 20);
		p_data1 = new JTextField(10);
		p_data1.setLocation(0, 30);
		p_data1.setToolTipText("programa");
		p_data2 = new JTextField(10);
		p_data2.setLocation(0, 40);
		p_data2.setToolTipText("codigo");
		boton_p = new JButton("Aceptar");
		boton_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p_data1.getText().compareTo("") != 0 && p_data2.getText().compareTo("") != 0 )
				{
					envio_p = true;
					n_programa.setVisible(false);
				}
			}
		});
		contenedor_p.add(p_label1);
		contenedor_p.add(p_data1);
		contenedor_p.add(p_label2);
		contenedor_p.add(p_data2);
		contenedor_p.add(boton_p);
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
		/* Si le dio click a la paleta :D */
		vista.repaint();
		if (vista.getpresion() == false && ev.getX() < 80) {// La magia dice que
			// paleta espicho
			vista.setpresion(true, ((ev.getY() - 20) / 50) + 1);

		}
		if (vista.getpresion() && ev.getX() > 90) // Dibuja lo q tenga q dibujar
		{
			if (vista.geticono() == 5) {// Compilador
				
				n_compilador.setLocation(this.vista.getxmouse(), this.vista.getymouse());
				n_compilador.setVisible(true);
				
				if (envio_c) {
					this.anyadirFigura(new DibujoT(ev.getPoint(), 100, 40, c_data1.getText(), c_data2.getText(), c_data3.getText()));
					envio_c = false;
					c_data1.setText("");
					c_data2.setText("");
					c_data3.setText("");

				}
			}
			if (vista.geticono() == 6)// Interprete
			{
				n_interprete.setLocation(this.vista.getxmouse(), this.vista.getymouse());
				n_interprete.setVisible(true);
				if(envio_i){
					this.anyadirFigura(new Cuadrado(ev.getPoint(), 80, i_data1.getText(), i_data2.getText() ) );
				}
			}
			if (vista.geticono() == 7)// maquina
			{
				n_maquina.setLocation(this.vista.getxmouse(), this.vista.getymouse());
				n_maquina.setVisible(true);
				if(envio_m){
					this.anyadirFigura( new Maquina( ev.getPoint(), 80, m_data1.getText()) );
				}
			}
			if (vista.geticono() == 8)// maquina Virtual
			{
				n_vmaquina.setLocation(this.vista.getxmouse(), this.vista.getymouse());
				n_vmaquina.setVisible(true);
				if(envio_vm){
					this.anyadirFigura(new MVirtual(ev.getPoint(), 80, vm_data1.getText(), vm_data2.getText() ) );
				}
			}
			if (vista.geticono() == 9)// Programa
			{
				n_vmaquina.setLocation(this.vista.getxmouse(), this.vista.getymouse());
				n_vmaquina.setVisible(true);
				if(envio_vm){
					this.anyadirFigura(new Circulo(ev.getPoint(), 30, 40, p_data1.getText(), p_data2.getText()));
				}
			}
			
			vista.setpresion(false, 0);

		}
	}

	public void eVmouseMoved(MouseEvent ev) {
		// TODO Auto-generated method stub
		vista.repaint();
	}

}
