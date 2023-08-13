package com.empresa.service;

import com.empresa.entity.Producto;
import com.empresa.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	public List<Producto> listaProductoPorNombreDniUsuario(String nombre,int precio, int cantidadStock, int idUsuario, String dni, int estado) {
		return repository.listaProductoPorNombreDniUsuario(nombre, precio, cantidadStock, idUsuario, dni, estado);
	}

	@Override
	public Producto insertaActualizaProducto(Producto producto) {
		return repository.save(producto);
	}

	@Override
	public List<Producto> listaProductoPorNombreLike(String nombre) {
		return repository.listaPorNombreLike(nombre);
	}

	@Override
	public void eliminaProducto(int id) {
		repository.deleteById(id);
	}

	@Override
	public Producto buscaProductoPorId(int idProducto) {return repository.buscaProductoPorId(idProducto);
	}

}
