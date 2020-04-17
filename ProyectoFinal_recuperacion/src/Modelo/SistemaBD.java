/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// metodos para recoleccion  de datos hacia la base de datos
public class SistemaBD {
    
    private static ArrayList<String> listaNombres;
    private static ArrayList<Clientes> listaClientes;
    
    //private static ArrayList<String> listaNombres;
    private static ArrayList<Productos> listaProductos;
    
    private static ArrayList<Factura> listaProductosfact;
    
    
    public static void guardarClienteBD(Clientes cliente){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","1234");
			System.out.print("Conexion establecida!");
                        
			Statement sentencia = conexion.createStatement();
				int insert = sentencia.executeUpdate("insert into clientes values('"+cliente.getCedula()+
						"','"+cliente.getNombres()+"','"+cliente.getApellidos()+"','"+cliente.getDireccion()+"','"
                                                +cliente.getTeléfono()
                                                +"','"+cliente.getCorreo()+"')");
				sentencia.close();
				conexion.close();	
		}catch(Exception ex){
			System.out.print("Error en la conexion"+ex);
		}
	}
    public static void eliminar(String cedula){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","1234");
			System.out.print("Conexion Establecida");
			Statement sentencia = conexion.createStatement();
			int insert = sentencia.executeUpdate("delete from clientes where cedula = '"+cedula+"'");
			
			sentencia.close();
			conexion.close();
		}catch(Exception ex){
			System.out.print("Error en la conexion"+ex);
		}
	}
    
    public static Clientes buscarCliente(String cedula){
    
           Clientes cliente = new Clientes();
           
              try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","1234");
			//System.out.print("Conexion Establecida");
			Statement sentencia = conexion.createStatement();
			ResultSet necesario = sentencia.executeQuery("select * from clientes "
                                + "where cedula = '"+cedula+"'");
                        
			while(necesario.next()){
					String ced= necesario.getString("cedula");
                                        String nom = necesario.getString("nombres");
					String ape = necesario.getString("apellidos");
                                       String dir = necesario.getString("direccion");
                                       String tel = necesario.getString("telefono");
                                       String cor = necesario.getString("correo");
                                       
                                      
					
                                        cliente.setCedula(ced);
					cliente.setNombres(nom);
					cliente.setApellidos(ape);
					cliente.setDireccion(dir);
                                       cliente.setTeléfono(tel);
                                       cliente.setCorreo(cor);
					 
					
			}
			sentencia.close();
			conexion.close();
		}catch(Exception ex){
			System.out.print("Error en la conexion"+ex);
		}
    
           return cliente;
    
     }
    public static ArrayList cargar(){
			
            try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","1234");
				System.out.print("Conexion establecida1!");
				Statement sentencia = conexion.createStatement();
				ResultSet necesario = sentencia.executeQuery("select * from clientes");
                                Clientes cliente;
				 
				listaClientes = new ArrayList<>();
				while(necesario.next()){
					
                                       String ced= necesario.getString("cedula");
                                       String nom = necesario.getString("nombres");
				       String ape = necesario.getString("apellidos");
                                       String dir = necesario.getString("direccion");
                                       String tel = necesario.getString("telefono");
                                       String cor = necesario.getString("correo");
                                       
                                        cliente=new Clientes();
                                        
					cliente.setCedula(ced);
					cliente.setNombres(nom);
					cliente.setApellidos(ape);
					cliente.setDireccion(dir);
                                        cliente.setTeléfono(tel);
                                        cliente.setCorreo(cor);
					 
					listaClientes.add(cliente);
				}
				sentencia.close();
				conexion.close();
				
			}catch(Exception ex){
				System.out.print("Error en la conexion"+ex);
			}
			return listaClientes;
			
	}


    
    //Metodos registro producto
    
    public static void guardarProductoBD(Productos producto){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","1234");
			System.out.print("Conexion establecida!");
                        
			Statement sentencia = conexion.createStatement();
				int insert = sentencia.executeUpdate("insert into productos values('"+producto.getCodigo()+
						"','"+producto.getArticulo()+"','"+producto.getDescripcion()+"','"+producto.getValor()+"','"
                                                +producto.getIva()
                                                +"','"+producto.getCantidad()+"')");
				sentencia.close();
				conexion.close();	
		}catch(Exception ex){
			System.out.print("Error en la conexion"+ex);
		}
	}
    public static void eliminarProductoBD(String codigo){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","1234");
			System.out.print("Conexion Establecida");
			Statement sentencia = conexion.createStatement();
			int insert = sentencia.executeUpdate("delete from productos where codigo = '"+codigo+"'");
			
			sentencia.close();
			conexion.close();
		}catch(Exception ex){
			System.out.print("Error en la conexion"+ex);
		}
	}
    
    public static Productos buscarProducto(String codigo){
    
           Productos producto = new Productos();
           
              try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","1234");
			//System.out.print("Conexion Establecida");
			Statement sentencia = conexion.createStatement();
			ResultSet necesario = sentencia.executeQuery("select * from productos "
                                + "where codigo = '"+codigo+"'");
                        
			while(necesario.next()){
					String cod= necesario.getString("codigo");
                                        String art = necesario.getString("articulo");
					String des = necesario.getString("descripcion");
                                       String val = necesario.getString("valor");
                                       String iva = necesario.getString("iva");
                                       String can = necesario.getString("cantidad");
                                       
                                      
					
                                        producto.setCodigo(cod);
					producto.setArticulo(art);
					producto.setDescripcion(des);
					producto.setValor(val);
                                       producto.setIva(iva);
                                       producto.setCantidad(can);
					 
					
			}
			sentencia.close();
			conexion.close();
		}catch(Exception ex){
			System.out.print("Error en la conexion"+ex);
		}
    
           return producto;
    
     }
    public static ArrayList cargarProducto(){
			
            try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","1234");
				System.out.print("Conexion establecida1!");
				Statement sentencia = conexion.createStatement();
				ResultSet necesario = sentencia.executeQuery("select * from productos");
                                Productos producto;
				 
				listaProductos = new ArrayList<>();
				while(necesario.next()){
					
                                       String cod= necesario.getString("codigo");
                                       String art = necesario.getString("articulo");
				       String des = necesario.getString("descripcion");
                                       String val = necesario.getString("valor");
                                       String iva = necesario.getString("iva");
                                       String can = necesario.getString("cantidad");
                                       
                                        producto=new Productos();
                                        
					producto.setCodigo(cod);
					producto.setArticulo(des);
					producto.setDescripcion(art);
					producto.setValor(val);
                                        producto.setIva(iva);
                                        producto.setCantidad(can);
					 
					listaProductos.add(producto);
				}
				sentencia.close();
				conexion.close();
				
			}catch(Exception ex){
				System.out.print("Error en la conexion"+ex);
			}
			return listaProductos;
			
	}
    public static Factura buscarClienteFact(String cedula){
    
           Factura factura = new Factura();
           
              try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","1234");
			//System.out.print("Conexion Establecida");
			Statement sentencia = conexion.createStatement();
			ResultSet necesario = sentencia.executeQuery("select * from clientes "
                                + "where cedula = '"+cedula+"'");
                        
			while(necesario.next()){
					String ced= necesario.getString("cedula");
                                        String nom = necesario.getString("nombres");
					String ape = necesario.getString("apellidos");
                                       String dir = necesario.getString("direccion");
                                       String tel = necesario.getString("telefono");
                                       
                                       
                                      
					
                                        factura.setCedula(ced);
					factura.setNombres(nom);
					factura.setApellidos(ape);
					factura.setDireccion(dir);
                                       factura.setTeléfono(tel);
                                       
					 
					
			}
			sentencia.close();
			conexion.close();
		}catch(Exception ex){
			System.out.print("Error en la conexion"+ex);
		}
    
           return factura;
    
     }
    public static ArrayList cargarFact(){
			
            try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","1234");
				System.out.print("Conexion establecida1!");
				Statement sentencia = conexion.createStatement();
				ResultSet necesario = sentencia.executeQuery("select * from productos");
                                Factura factura;
				 
				listaProductosfact = new ArrayList<>();
				while(necesario.next()){
					
                                       String cod= necesario.getString("codigo");
                                       String art = necesario.getString("articulo");
				       String des = necesario.getString("descripcion");
                                       String val = necesario.getString("valor");
                                       String iva = necesario.getString("iva");
                                       String can = necesario.getString("cantidad");
                                       
                                        factura=new Factura();
                                        
					factura.setCodigo(cod);
					factura.setArticulo(des);
					factura.setDescripcion(art);
					factura.setValor(val);
                                        factura.setIva(iva);
                                        factura.setCantidad(can);
					 
					listaProductosfact.add(factura);
				}
				sentencia.close();
				conexion.close();
				
			}catch(Exception ex){
				System.out.print("Error en la conexion"+ex);
			}
			return listaProductosfact;
			
	}

}
    



    