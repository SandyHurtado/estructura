package datos;

public class Lista {
	
	public Nodo primero;

	public Lista() {
		this.primero = null;
	}
	
	public boolean insertar(Object info){
		if ( primero == null ){
			try{
				this.primero = new Nodo(info);				
			}
			catch (Exception e){
				return false;
			}
		}
		else {
			Nodo aux = this.primero;
			while ( aux.siguiente != null )
				aux = aux.siguiente;
			try{
				aux.siguiente = new Nodo( info );				
			}
			catch (Exception e){
				return false;
			}
		}
		return true;
	}

	boolean insertarPorPrimero( Object info ){
		Nodo nuevoNodo = null;
		try {
			nuevoNodo = new Nodo( info );
		}
		catch (Exception e){
			return false;
		}
		if ( this.primero == null )
			this.primero = nuevoNodo;
		else{
			nuevoNodo.siguiente = primero;
			primero = nuevoNodo;
		}
		return true;
	}
	
	boolean insertar( Object info, int pos){
		if ( pos == 0 )
			return insertarPorPrimero(info);
		else{		
			int currentPos = 0; 
			Nodo nodoPrevio = this.primero;
			while (currentPos != pos - 1 && nodoPrevio != null){
				nodoPrevio = nodoPrevio.siguiente;
				currentPos ++;
			}
			if ( nodoPrevio != null ){
				Nodo nuevoNodo = null;
				try{
					nuevoNodo = new Nodo( info );
				}
				catch (Exception e){
					return false;
				}
				nuevoNodo.siguiente = nodoPrevio.siguiente;
				nodoPrevio.siguiente = nuevoNodo;
				return true;
			}
		}	
			return false;
	}
	
	public boolean borrar (int pos){
		if ( this.primero == null )
			return false;
		if ( pos == 0 )
			this.primero = this.primero.siguiente;
		else{
			int i = 0;
			Nodo aux = this.primero;
			while (i < pos - 1 && aux!=null){
				aux = aux.siguiente;
				i++;
			}
			if ( aux != null && aux.siguiente != null ) {
				aux.siguiente = aux.siguiente.siguiente;
			}
		}
		return true;
	}
	
	public Nodo buscar( Object valor ){
		Nodo aux = this.primero;
		while(aux != null){
			if(aux.info.equals(valor))
			  return aux;
		    aux = aux.siguiente;
		}
		return null;
	}
	
	public Object buscar ( int pos){
		Nodo aux = primero; 
		int i = 0;
		while ( aux!= null ){
			if ( i == pos )
				return aux.info;
			i++;
			aux = aux.siguiente;
		}
		return null;
	}
	
	public int cantCoincidencias ( Object valor ){
		Nodo aux = this.primero;
		int cantCoincidencias = 0;
		while( aux != null ){
			if( aux.info.equals(valor) )
			  cantCoincidencias ++;
		    aux = aux.siguiente;
		}
		return cantCoincidencias;
	}
	
	public void virarseAlReves(){
		//comenzar desde el primero de los nodos
		Nodo ultimo = this.primero;
		//Declarar referencia a pen�ltimo nodo, relativo a la posici�n desde la que estoy virando la lista
		Nodo penultimo = null;
		//iterar en la lista hasta encontrar al �ltimo de los nodos
		while ( ultimo.siguiente != null ){
			ultimo = ultimo.siguiente;
		}
		//guardar referencia al �ltimo de los nodos, que se convertir� en el primero de los nodos
		Nodo primeroR = ultimo;
		
		while (ultimo != this.primero){
			penultimo = primero;
			//iterar en la lista hasta encontrar al pen�ltimo de los nodos con respecto a �ltimo
			while ( penultimo.siguiente != ultimo ){
				penultimo = penultimo.siguiente;
			}
			ultimo.siguiente = penultimo;
			ultimo = penultimo;
		}
		ultimo.siguiente = null;
		primero = primeroR;
	}
		
	public void unir(Lista l2){
		Nodo aux = this.primero;
		if ( aux != null )
			while (aux.siguiente != null )
				aux = aux.siguiente;
		else // lista est� vac�a
			this.primero = l2.primero;
		if ( l2.primero == null )
			return;
		aux.siguiente = l2.primero;
	}
	
	public Lista unir(Lista l1, Lista l2){
	/*	if (l1.primero == null)
			return l2;
		Nodo aux = l1.primero;
		while ( aux.siguiente != null )
			aux = aux.siguiente;
		aux.siguiente = l2.primero;
		return l1;
	*/
		Lista listaResultante = new Lista();
		Nodo aux = l1.primero;
		while ( aux!= null ){
			listaResultante.insertar(aux.info);
			aux = aux.siguiente;
		}
		aux = l2.primero;
		while ( aux!= null ){
			listaResultante.insertar(aux.info);
			aux = aux.siguiente;
		}
		return listaResultante;	
	}
}
