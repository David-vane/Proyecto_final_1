
package Controlador;

import Main.M_Vehiculo;
import Main.SistemaBD;
import Vista.Vehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador_persona implements ActionListener{
          Vehiculo vista_persona;
            SistemaBD base_D;
             M_Vehiculo modelo_persona; 
         
        public Controlador_persona(Vehiculo vista_persona,M_Vehiculo modelo_persona){
        this.vista_persona=vista_persona;
        this.modelo_persona=modelo_persona;
        this.vista_persona.getB_guardar().addActionListener(this);
        this.vista_persona.getB_editar().addActionListener(this);
        this.vista_persona.getB_verificar().addActionListener(this);
        
        }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //EDITAMOS
    
        if (ae.getSource() == vista_persona.getB_editar()) {
            vista_persona.desbloquearCampos();
            System.out.println("Boton editar");

        }// GUARDAMOS los valores
        if (ae.getSource() == vista_persona.getB_guardar()) {
            
            modelo_persona=vista_persona.GuardarPersona();
            vista_persona.bloquearCampos();

            base_D.guardarPersonaDB(modelo_persona);
        }
        
        //aqui VERIFICA la cedula
        if (ae.getSource() == vista_persona.getB_verificar()) {
           
          System.out.println("Verificando...");
          modelo_persona=base_D.buscarPersona(vista_persona.verificarPersona());
           
          //LIMPIA los capos,desbloquea y bloquea
          if(modelo_persona.getPlaca()==null){
                // no esta llamar->
                
                vista_persona.desbloquearCampos();
        }else{
            // si esta llamar->>>>
             vista_persona.bloquearCampos();
             JOptionPane.showMessageDialog(vista_persona, "La marca "+modelo_persona.getMarca()+"  ya se encuentra registrado");
              vista_persona.cargarCampos(modelo_persona);
          }
          
          
        }
    }}
    
    
