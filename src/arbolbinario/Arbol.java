
package arbolbinario;

public class Arbol {
    
    private Nodo raiz = null;
    private int nivel = 0;
    private int max = 0;
    
    private String cadena="";
    private String cadena2="";
    private String cadena3="";
    private String aviso="";
    
    static int preIndex;
    
    public Nodo insertar(Nodo nodo, int valor){
        
        if(nodo == null){
        
            return(new Nodo(valor));
            
        }
        
        int valorRaiz = nodo.getValor();
        
        if(valor < valorRaiz){
            
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), valor));
            
        } else if(valor > valorRaiz){
        
            nodo.setDerecho(insertar(nodo.getDerecho(), valor));
            
        } else {
        
            aviso = "El nodo " + valor + " ya existe en el arbol.";
            return nodo;
        
        }
        
        return nodo;
        
    }
    
    public Nodo retirar(Nodo nodo, int valor){
        
        if (nodo == null){
            
            return nodo;
            
        }

        if (valor < nodo.getValor()){
            
            nodo.setIzquierdo(retirar(nodo.getIzquierdo(),valor)); 
  

        } else if (valor > nodo.getValor())  {
            
            nodo.setDerecho(retirar(nodo.getDerecho(),valor)); 
   
        } else {  
 
            if ((nodo.getIzquierdo() == null) || (nodo.getDerecho() == null)){
                
                Nodo temporal = null;
                
                if (temporal == nodo.getIzquierdo()){  
                    
                    temporal = nodo.getDerecho();  
                
                } else {
                    
                    temporal = nodo.getIzquierdo();  
  
                }
                    
                if (temporal == null){

                    temporal = nodo;  
                    nodo = null; 
                    
                } else {
                    
                    nodo = temporal; 
                    
                }
                
            } else {  
   
                Nodo temp = hallarNodoMenor(nodo.getDerecho());  
   
                nodo.setValor(temp.getValor());
   
                nodo.setDerecho(retirar(nodo.getDerecho(), temp.getValor()));  
                
            }  
        }  

        if (nodo == null){
            
            aviso = "El nodo " + valor + " no existe en el arbol.";
            System.out.println(aviso);
            return nodo;
        
        }
        
        return nodo;  
    
    }  
    
    Nodo hallarNodoMenor(Nodo nodo)  {  
        
        Nodo temp = nodo;  
  
        while (temp.getIzquierdo() != null){  
        
            temp = temp.getIzquierdo();  
  
        }
        
        return temp;  
        
    }
    String printInorder(Nodo nodo){
        
        if (nodo == null){ 
            return ""; 
        }
        
        nivel++;
        printInorder(nodo.getIzquierdo()); 
        nivel--;
        
        cadena = cadena + nodo.getValor() +", ";
        
        if(nivel > max){
        
            max = nivel;
            
        }
        
        nivel++;
        printInorder(nodo.getDerecho()); 
        nivel--;
        
        return cadena;
        
    } 
    
    String printPostOrder(Nodo nodo){
        
        if (nodo == null){ 
            return ""; 
        }

        printPostOrder(nodo.getIzquierdo()); 
        
        printPostOrder(nodo.getDerecho()); 
        
        cadena2 = cadena2 + nodo.getValor() +", ";
        
        return cadena2;
        
    } 
    
    String printPreOrder(Nodo nodo){
        
        if (nodo == null){ 
            return ""; 
        }
        
        cadena3 = cadena3 + nodo.getValor() +", ";
        
        printPreOrder(nodo.getIzquierdo()); 
        
        printPreOrder(nodo.getDerecho()); 
        
        return cadena3;
        
    } 
    
    public int Buscar(int arr[], int strt, int end, int value) { 
		
        int i; 
	
        for (i = strt; i <= end; i++) { 
	
            if (arr[i] == value) 
	
                return i; 
		
        } 
	
        return i; 
	
    } 
    
    public Nodo construirArbolPre(int in[], int pre[], int inicio, int fin){ 
        
        if (inicio > fin){
        
            return null; 

        }
         
        Nodo tempNodo = new Nodo(pre[preIndex++]); 
        
        System.out.println(tempNodo.getValor());
        
        if (inicio == fin){ 
        
            return tempNodo; 

        }

        int indiceInOrden = Buscar(in, inicio, fin, tempNodo.getValor()); 

        tempNodo.setIzquierdo( construirArbolPre(in, pre, inicio, indiceInOrden - 1));
        tempNodo.setDerecho( construirArbolPre(in, pre, indiceInOrden + 1, fin)); 

        
        return tempNodo; 
    }
    
    Nodo construir(int in[], int post[], int n) 
    { 
        Index pIndex = new Index(); 
        pIndex.index = n - 1; 
        return construirArbolPos(in, post, 0, n - 1, pIndex); 
    
    } 
    
    public Nodo construirArbolPos(int in[], int post[], int inicio, int fin, Index pIndex) { 
        
        if (inicio > fin){ 
        
            return null; 
  
        }
        
        Nodo tempNodo = new Nodo(post[pIndex.index]); 
        (pIndex.index)--; 

        if (inicio == fin){ 
        
            return tempNodo; 
        
        }
        
        int iIndex = Buscar(in, inicio, fin, tempNodo.getValor()); 
  
        tempNodo.setDerecho(construirArbolPos(in, post, iIndex + 1, fin, pIndex)); 
        tempNodo.setIzquierdo(construirArbolPos(in, post, inicio, iIndex - 1, pIndex));
  
        return tempNodo; 
    
    } 
    
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena2() {
        return cadena2;
    }

    public void setCadena2(String cadena2) {
        this.cadena2 = cadena2;
    }

    public String getCadena3() {
        return cadena3;
    }

    public void setCadena3(String cadena3) {
        this.cadena3 = cadena3;
    }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }
    
}

class Index { 
    int index; 
} 
