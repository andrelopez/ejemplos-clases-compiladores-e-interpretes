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
import modelo.Modelo;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private Figura seleccionada;
	private Point punto;
	private JTextField data1, data2, data3;
	private Label label1, label2, label3;
	private JDialog nombrescompi;
	private Container contenedor;
	private JButton boton;
	private boolean envio = false;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		seleccionada = null;
		punto = new Point(10, 57);
		
		/* Ventana emergente para el compilador */
		nombrescompi = new JDialog();
		nombrescompi.setModal(true);// para que sea hijo del frama papa
		// y no se pueda salir sin antes
		// meter los datos
		nombrescompi.setBounds(this.vista.getxmouse(), this.vista.getymouse(),
				250, 150);
		contenedor = nombrescompi.getContentPane();
		contenedor.setLayout(new FlowLayout());
		nombrescompi.setResizable(false);

		label1 = new Label("Compilador de");
		label1.setLocation(0, 0);
		data1 = new JTextField(10);
		data1.setLocation(0, 10);
		contenedor.add(data1);
		contenedor.add(label1);

		label2 = new Label("A codigo");
		label2.setLocation(0, 20);
		data2 = new JTextField(10);// A codigo
		data2.setLocation(0, 30);
		contenedor.add(data2);
		contenedor.add(label2);

		label3 = new Label("Escrito en");
		label3.setLocation(0, 40);
		data3 = new JTextField(10);// Escrito En
		data3.setLocation(0, 50);
		contenedor.add(data3);
		contenedor.add(label3);

		boton = new JButton("Aceptar");

		boton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (data1.getText().compareTo("") != 0
						&& data2.getText().compareTo("") != 0
						&& data3.getText().compareTo("") != 0) {

					envio = true;
					nombrescompi.setVisible(false);

				}

			}

		});

		contenedor.add(boton);

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
			vista.setpresion(true, ((ev.getY() - 20) / 50) + 1);

		}
		if (vista.getpresion() && ev.getX() > 90) // Dibuja lo q tenga q dibujar
		{
			if (vista.geticono() == 5) {// Compilador

				// nombrescompi.pack();
				nombrescompi.setLocation(this.vista.getxmouse(), this.vista.getymouse());
				nombrescompi.setVisible(true);
				
				if (envio) {
					this.anyadirFigura(new DibujoT(ev.getPoint(), 100, 40,
							data1.getText(), data2.getText(), data3.getText()));
					envio = false;
					data1.setText("");
					data2.setText("");
					data3.setText("");

				}
			}
			if (vista.geticono() == 6)// Compilador
				this.anyadirFigura(new Cuadrado(ev.getPoint(), 80));
			if (vista.geticono() == 7)// Compilador
				this.anyadirFigura(new MVirtual(ev.getPoint(), 80));
			if (vista.geticono() == 9)// Compilador
				this.anyadirFigura(new Circulo(ev.getPoint(), 40));

			vista.setpresion(false, 0);

		}
	}

	public void eVmouseMoved(MouseEvent ev) {
		// TODO Auto-generated method stub
		vista.repaint();
	}

}
