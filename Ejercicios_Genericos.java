package Act5;

import java.util.*;

public class Ejercicios_Genericos {
	// CLase estatica nodo generico
	static class Node<T>{
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}
	//1. Buscar un elemento generico en una lista
	public static<T> boolean BuscarElemento(List<T> lista, T valor) {
		return lista.contains(valor);
	}
	
    // 2. Invertir una lista genérica
	public static<T> List<T> invertirLista(List<T> lista){
		List<T> invertida = new ArrayList<>();
		int i;
		for(i = lista.size() - 1; i >= 0; i--) {
			invertida.add(lista.get(i));
		}
		return invertida;
	}
	
    // 3. Insertar un nodo al final
	public static <T> void insertaAlFinal(Node<T> head, T valor) {
		Node<T> nuevo = new Node<>(valor);
		if(head == null) {
			System.out.println("La cabeza es nula. No se puede insertar.");
			return;
		}
		Node<T> actual = head;
		while(actual.next != null) {
			actual = actual.next;
		}
		actual.next = nuevo;
	}
	// 4. Contar los nodos
	public static<T> int contarNodos(Node<T> head) {
		int contador = 0;
		Node<T> actual = head;
		while (actual != null) {
			contador++;
			actual = actual.next;
		}
		return contador;
	}
	
	
	//5. Comparar dos listas
	public static<T> boolean sonIguales(Node<T> l1, Node<T> l2) {
		while(l1 != null && l2 != null) {
			if(!l1.data.equals(l2.data)) return false;
			l1 = l1.next;
			l2 = l2.next;
		}
		return l1 == null && l2 == null;
	}
	
	// 6. Concatenar dos listas
    public static <T> Node<T> concatenarListas(Node<T> l1, Node<T> l2) {
        if (l1 == null) return l2;
        Node<T> actual = l1;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = l2;
        return l1;
    }
	// Mostrar elementos de la lista enlazada
    public static <T> void imprimirLista(Node<T> head) {
        Node<T> actual = head;
        while (actual != null) {
            System.out.print(actual.data + " -> ");
            actual = actual.next;
        }
        System.out.println("null");
    }
    
    
    public static void main(String[] args) {
    	  // 1. Buscar elemento
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("¿Contiene el número 3? " + BuscarElemento(numeros, 3));

        // 2. Invertir lista
        List<String> nombres = Arrays.asList("Ana", "Luis", "Pedro");
        System.out.println("Lista invertida: " + invertirLista(nombres));

        // 3. Insertar al final
        Node<String> head = new Node<>("A");
        insertaAlFinal(head, "B");
        insertaAlFinal(head, "C");
        System.out.print("Lista enlazada: ");
        imprimirLista(head);

        // 4. Contar nodos
        System.out.println("Cantidad de nodos: " + contarNodos(head));

        // 5. Comparar dos listas
        Node<String> l1 = new Node<>("X");
        insertaAlFinal(l1, "Y");
        Node<String> l2 = new Node<>("X");
        insertaAlFinal(l2, "Y");
        System.out.println("¿Son iguales? " + sonIguales(l1, l2));

        // 6. Concatenar listas
        Node<String> concatenada = concatenarListas(head, l1);
        System.out.print("Lista concatenada: ");
        imprimirLista(concatenada);
    
    }

}
