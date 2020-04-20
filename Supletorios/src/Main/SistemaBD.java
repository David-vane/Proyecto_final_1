
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SistemaBD {
     private static ArrayList<String> listaNombres;
    private static ArrayList<M_Vehiculo> listaPersonas;
    
    
    private static ArrayList<M_Revision> listaProductos;
//    
//    private static ArrayList<Factura> listaProductosfact;
    
    
    public static void guardarPersonaDB(M_Vehiculo vehiculo){
		try{
			Class.forName("com.mysql.jdbc.Driver");
                    try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/persona","root","rafa")) {
                        System.out.print("Conexion establecida!");
                        
                            try (Statement sentencia = conexion.createStatement()) {
                                int insert = sentencia.executeUpdate("insert into persona values('"+vehiculo.getPlaca()+
                                        "','"+vehiculo.getColor()+"','"+vehiculo.getFecha()+"','"
                                        +vehiculo.getMarca()
                                        +"','"+vehiculo.getModelo()+"')");
                            }
                    }	
		}catch(ClassNotFoundException | SQLException ex){
			System.out.print("Error en la conexion"+ex);
		}
	}
    
    
       public static M_Vehiculo buscarPersona(String placa){
    
           M_Vehiculo persona = new M_Vehiculo();
           
              try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/persona","root","rafa");
			//System.out.print("Conexion Establecida");
			Statement sentencia = conexion.createStatement();
			ResultSet necesario = sentencia.executeQuery("select * from persona "
                                + "where cedula = '"+placa+"'");
                        
			while(necesario.next()){
					String ced= necesario.getString("placa");
                                        String nom = necesario.getString("color");
					String fec = necesario.getString("fecha");
                                       String dir = necesario.getString("marca");
                                       String tel = necesario.getString("modelo");
                                       
                                       
                                      
					
                                        persona.setPlaca(ced);
					persona.setColor(nom);
                                        persona.setFecha(fec);
					persona.setMarca(dir);
                                        persona.setModelo(tel);
                                        
					 
					
			}
			sentencia.close();
			conexion.close();
		}catch(Exception ex){
			System.out.print("Error en la conexion"+ex);
		}
    
           return persona;
    
     }
    public static ArrayList cargar(){
			
            try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/persona","root","rafa");
				System.out.print("Conexion establecida1!");
				Statement sentencia = conexion.createStatement();
				ResultSet necesario = sentencia.executeQuery("select * from persona");
                                M_Vehiculo persona;
				 
				listaPersonas= new ArrayList<>();
				while(necesario.next()){
					
                                       String ced= necesario.getString("Cedula");
                                       String nom = necesario.getString("Nombres");
				       String fec = necesario.getString("Fecha");
                                       String dir = necesario.getString("Direccion");
                                       String tel = necesario.getString("Telefono");
                                       
                                       
                                       persona =new M_Vehiculo();
                                        
					persona.setPlaca(ced);
					persona.setColor(nom);
					persona.setFecha(fec);
					persona.setMarca(dir);
                                        persona.setModelo(tel);
                                        
					 
					listaPersonas.add(persona);
				}
				sentencia.close();
				conexion.close();
				
			}catch(Exception ex){
				System.out.print("Error en la conexion"+ex);
			}
			return listaPersonas;
			
	}
    
}
//    //REVISION
//public static void guardarRevionDB(M_Revision Revision){
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//                    try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/revision","root","rafa")) {
//                        System.out.print("Conexion establecida!");
//                        
//                            try (Statement sentencia = conexion.createStatement()) {
//                                int insert = sentencia.executeUpdate("insert into revision values('"+Revision.getPlaca()+
//                                        "','"+Revision.getFecha()+"','"+Revision.getDescripcion());
//                                        
//                            }
//                    }	
//		}catch(ClassNotFoundException | SQLException ex){
//			System.out.print("Error en la conexion"+ex);
//		}
//	}
//}
//    
////       public static M_Vehiculo buscarRevision(String placa){
////    
////           M_Revision persona = new M_Revision();
////           
////              try{
////			Class.forName("com.mysql.jdbc.Driver");
////			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/revision","root","rafa");
////			//System.out.print("Conexion Establecida");
////			Statement sentencia = conexion.createStatement();
////			ResultSet necesario = sentencia.executeQuery("select * from revision "
////                                + "where placa = '"+placa+"'");
////                        
////			while(necesario.next()){
////					String ced= necesario.getString("placa");
////                                     
////					String fec = necesario.getString("fecha");
////                                       
////                                       String tel = necesario.getString("descripcion");
////                                       
////                                       
////                                      
////					
////                                        persona.setPlaca(ced);
////					
////                                        persona.setFecha(fec);
////					
////                                        persona.setDescripcion(tel);
////                                        
////					 
////					
////			}
////			sentencia.close();
////			conexion.close();
////		}catch(Exception ex){
////			System.out.print("Error en la conexion"+ex);
////		}
////    
////           return persona;
////    
////     }
////    public static ArrayList cargar_1(){
////			
////            try{
////				Class.forName("com.mysql.jdbc.Driver");
////				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/persona","root","rafa");
////				System.out.print("Conexion establecida1!");
////				Statement sentencia = conexion.createStatement();
////				ResultSet necesario = sentencia.executeQuery("select * from persona");
////                                M_Vehiculo persona;
////				 
////				listaPersonas= new ArrayList<>();
////				while(necesario.next()){
////					
////                                       String ced= necesario.getString("Cedula");
////                                       String nom = necesario.getString("Nombres");
////				       String fec = necesario.getString("Fecha");
////                                       String dir = necesario.getString("Direccion");
////                                       String tel = necesario.getString("Telefono");
////                                       
////                                       
////                                       persona =new M_Vehiculo();
////                                        
////					persona.setPlaca(ced);
////					persona.setColor(nom);
////					persona.setFecha(fec);
////					persona.setMarca(dir);
////                                        persona.setModelo(tel);
////                                        
////					 
////					listaPersonas.add(persona);
////				}
////				sentencia.close();
////				conexion.close();
////				
////			}catch(Exception ex){
////				System.out.print("Error en la conexion"+ex);
////			}
////			return listaPersonas;
////			
////	}
////}
