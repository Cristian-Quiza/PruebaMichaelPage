package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	@Query("SELECT x FROM Producto x WHERE (?1 IS '' OR x.nombre LIKE ?1) AND (?2 = -1 OR x.precio = ?2) AND (?3 = -1 OR x.cantidadStock = ?3) AND (?4 = -1 OR x.usuario.idUsuario = ?4) AND (?5 IS '' OR x.dni = ?5) AND x.estado = ?6")
	public List<Producto> listaProductoPorNombreDniUsuario(String nombre,int precio, int cantidadStock, int idUsuario, String dni, int estado);
	@Query("select x from Producto x where x.nombre like ?1")
	public List<Producto> listaPorNombreLike(String nombre);

	@Query("select x from Producto x where x.idProducto = ?1")
	public Producto buscaProductoPorId(int idProducto);

}
