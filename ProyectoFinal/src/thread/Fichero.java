package thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.Beans.Producto;
import model.DAO.ProductoDAO;

public class Fichero extends Thread {
	public void run() {
		while (true) {
			String ruta = "C:\\Users\\cmuniz\\Desktop\\ficheros\\";
			File carpeta = new File(ruta + "waiting");
			File[] archivos = carpeta.listFiles();
			File archivo = null;
			BufferedReader br = null;
			Producto p = null;
			String nombre = null, linea = null;
			ProductoDAO dao = new ProductoDAO();
			if (archivos.length > 0) {
				nombre = archivos[0].getName();
				archivo = new File(ruta + "workspace\\" + nombre);
				archivos[0].renameTo(archivo);
				archivos[0].delete();
				try {
					br = new BufferedReader(new FileReader(ruta + "workspace\\" + nombre));
					linea = br.readLine();
					while (linea != null) {
						String[] campos = linea.split(";");
						p = new Producto(campos[0], campos[1], campos[2], Float.parseFloat(campos[3]));
						if (!dao.productoExiste(p.getCodProducto())) {
							dao.insertarProducto(p);
						} else {
							dao.cambiarProducto(p);
						}
						linea = br.readLine();
					}
					br.close();
					archivo.renameTo(new File(ruta + "completed\\ok\\" + nombre));
					archivo.delete();
				} catch (Exception e) {
					try {
						br.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					archivo.renameTo(new File(ruta + "completed\\error\\" + nombre));
					archivo.delete();
					e.getStackTrace();
				}
			}
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
