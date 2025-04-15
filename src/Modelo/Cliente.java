package Modelo; 


public class Cliente { 



    private int id; // Este es el atributo id de tipo int.
    
    private int doc; // Este es el atributo doc de tipo String.
    
    private String nombres; // Este es el atributo nombres de tipo String.
    
    private int menu_1; // Este es el atributo doc de tipo int.
    
    private int menu_2; // Este es el atributo doc de tipo int.
    
    private int menu_3; // Este es el atributo doc de tipo int.
    
    private int menu_4; // Este es el atributo doc de tipo int.
    
    private int total; // Este es el atributo doc de tipo int.
    
   

	

    /** 
     * <b>Cliente()</b>
     * Objetivo:   Inicializa una instancia vacía de un nuevo objeto Cliente. 
     */ 

    public Cliente() { 
    } // Fin Método Constructor 

    public Cliente(int id, int doc, String nombres, int menu_1, int menu_2, int menu_3, int menu_4, int total) {
        this.id = id;
        this.doc = doc;
        this.nombres = nombres;
        this.menu_1 = menu_1;
        this.menu_2 = menu_2;
        this.menu_3 = menu_3;
        this.menu_4 = menu_4;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public int getDoc() {
        return doc;
    }

    public String getNombres() {
        return nombres;
    }

    public int getMenu_1() {
        return menu_1;
    }

    public int getMenu_2() {
        return menu_2;
    }

    public int getMenu_3() {
        return menu_3;
    }

    public int getMenu_4() {
        return menu_4;
    }

    public int getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setMenu_1(int menu_1) {
        this.menu_1 = menu_1;
    }

    public void setMenu_2(int menu_2) {
        this.menu_2 = menu_2;
    }

    public void setMenu_3(int menu_3) {
        this.menu_3 = menu_3;
    }

    public void setMenu_4(int menu_4) {
        this.menu_4 = menu_4;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
    

}//Fin de la Clase
