package microproyecto1;

import javax.swing.*;

public class Microproyecto1 {
    public static void main(String[] args) {
        String marca;
        int año, pMarca, cFinal;
        String[] aGama = {"BMW", "AUDI", "VOLVO"};
        boolean log = false, esAltaGama = false;
        log = userLogin();
        if (log) {
            marca = JOptionPane.showInputDialog(null, "Ingrese la marca del vehiculo", "Seguro", JOptionPane.WARNING_MESSAGE).toUpperCase();
            año = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año del vehiculo", "Seguro", JOptionPane.WARNING_MESSAGE));
            esAltaGama = busqueda(aGama, marca);
            if (esAltaGama) {
                pMarca = 5000;
            } else {
                pMarca = 900;
            }
            cFinal = pMarca + cotizacion(año);
            JOptionPane.showMessageDialog(null, "Auto marca: " + marca + "\nAño: " + año + "\nValor de cuota final: $" + cFinal, "Seguro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Maximo de intentos alcanzados", "Seguro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static boolean userLogin() {

        JPanel myPanel = new JPanel();
        JTextField User = new JTextField(15);
        JTextField Password = new JPasswordField(15);
        myPanel.add(new JLabel("Usurio:"));
        myPanel.add(User);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Contraseña:"));
        myPanel.add(Password);
        String[] baseUser = {"jfmunoz", "rperez"};
        String[] basePass = {"patito4321", "abcd1234"};
        int attempts = 1;
        boolean flag = false;
        do {
            JOptionPane.showConfirmDialog(null, myPanel, "Ingrese su usuario y contraseña", JOptionPane.OK_CANCEL_OPTION);
            flag = userBusqueda(baseUser, basePass, User, Password);
            if (flag) {
                JOptionPane.showMessageDialog(null, "Ingresando!", "Seguro", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrectos", "Seguro", JOptionPane.INFORMATION_MESSAGE);
                attempts++;
            }
        } while (attempts <= 3 && (!flag));
        return flag;
    }

    public static boolean busqueda(String[] a, String b) {
        boolean c = false;
        for (String n : a) {
            if (n.equals(b)) {
                c = true;
            }
        }
        return c;
    }

    public static boolean userBusqueda(String[] A1, String[] A2, JTextField B1, JTextField B2) {
        for (String N : A1) {
            for (String M : A2) {
                if (N.equals(B1.getText()) && M.equals(B2.getText())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int cotizacion(int a) {
        int b = 350;
        if (a >= 1990 && a <= 1999) {
            b = 480;
        } else if (a >= 2000 && a <= 2010) {
            b = 780;
        } else if (a >= 2011 && a <= 2016) {
            b = 950;
        } else if (a >= 2017 && a <= 2020) {
            b = 1200;
        }
        return b;
    }
}
