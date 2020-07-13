package microproyecto1;
import javax.swing.*;
public class Microproyecto1 {
    public static void main(String[] args) {
        String[] aGama = {"BMW", "AUDI", "VOLVO"};
        String marca = "";        
        boolean flag = false;
        int año,pMarca,cFinal;
        marca = JOptionPane.showInputDialog("Ingrese marca de su auto").toUpperCase();
        año = Integer.parseInt (JOptionPane.showInputDialog("Ingrese año del modelo"));
        flag = busqueda(aGama, marca);        
        if (!flag){
            pMarca = 890;
        } else pMarca = 1800;
        cFinal = pMarca+cotizacion(año);        
        JOptionPane.showMessageDialog(null,"Auto marca: "+marca+"\nAño: "+año+"\nValor de cuota final: $"+cFinal);        
    }
    public static boolean busqueda(String []a, String b){
        boolean c=false;
        for (String n:a){
            if (n.equals(b)){                
                c=true;
            }
        }
        return c;
}
    public static int cotizacion(int a){
        int b=350;
        if (a>=1990 && a<=1999){
            b=480;
        } else if (a>=2000 && a<=2010){
            b=780;
        } else if (a>=2011 && a<=2016){
            b=950;
        } else if (a>=2017 && a<=2020){
            b=1200;
        }
        return b;
    }    
}
