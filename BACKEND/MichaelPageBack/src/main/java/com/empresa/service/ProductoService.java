package com.empresa.service;

import java.util.List;

import com.empresa.entity.Producto;

public interface ProductoService {

	//Para la consulta
//	public abstract List<Producto> listaproductoPorNombreDniUsuario(String dni, String nombre, int idUsuario,int estado);

	public abstract List<Producto> listaProductoPorNombreDniUsuario(String nombre,int precio, int cantidadStock, int idUsuario, String dni, int estado);

	//Para el Crud
	public abstract Producto insertaActualizaProducto(Producto Producto);
	public abstract List<Producto> listaProductoPorNombreLike(String nombre);
	public abstract void eliminaProducto(int id);
	public abstract Producto buscaProductoPorId(int idProducto);
	
	
}
