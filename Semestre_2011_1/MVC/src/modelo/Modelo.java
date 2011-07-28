package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
	
	private List<Figura> listaFiguras;
	public String nombre;
	public Modelo(){
		listaFiguras = new ArrayList<Figura>();
	}
	
	public void AnyadirFigura(Figura f){
		listaFiguras.add(f);
	}
	
	public List<Figura> getListado(){
		return listaFiguras;
	}
	
	public void anyadirFigura(Figura f){
	
		listaFiguras.add(f);
	}
            public void eliminarFigura(Figura f){
	
		listaFiguras.remove(f);
	}
	
	public Figura getFiguraEn(Point p){
		for (Figura elemento : getListado()) {
			if(elemento.dentroFigura(p)){
				elemento.seleccionada=true;
				return elemento;				
			}
		}
		return null;
	}
	/*Metodo para especificar los dibujos que son paleta*/
	public void darpaleta(){
		int cont=0;
		for (Figura elemento : getListado()) {
			if(cont<1){
				elemento.setEspaleta(true);
							
			}
			cont++;
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	public void recargar(Modelo x)
	{
		for(int i=0;i<listaFiguras.size();i++)
		{	
			
			listaFiguras.remove(0);
			
		}
		System.out.println("Nuevo tama�ano "+ listaFiguras.size());
		for(Figura f:x.listaFiguras)
		{	
			listaFiguras.add(f);
			
		}
		listaFiguras=x.listaFiguras;
		System.out.println(listaFiguras);
		
	}
}
