
package Controlador;

import Main.SistemaBD;
import Vista.Revision;
import Vista.Vehiculo;
import Vista.V_principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class Controlador_principal implements ActionListener {
    
    V_principal vista_persona = new V_principal();

    public Controlador_principal(V_principal V_principal ) {
        this.vista_persona = V_principal;
  
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == vista_persona.getB_formulario()) {
                new Vehiculo().Mostrar();
                System.out.println("mostrar");
                }
        if (ae.getSource() == vista_persona.getB_revision()){
            new Revision().Mostrar();
        }
            }
        }

  


    

