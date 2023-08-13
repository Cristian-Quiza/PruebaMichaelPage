package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Producto;
import com.empresa.service.ProductoService;
import com.empresa.util.Constantes;

@RestController
@RequestMapping("/rest/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/listaProductoConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaProductoNombreDniUsuario(
			@RequestParam(name = "nombre", required = false, defaultValue = "") String nombre,
			@RequestParam(name = "precio", required = false, defaultValue = "") int precio,
			@RequestParam(name = "cantidadStock", required = false, defaultValue = "") int cantidadStock,
			@RequestParam(name = "idusuario", required = false, defaultValue = "-1") int idUsuario,
			@RequestParam(name = "dni", required = false, defaultValue = "") String dni,
			@RequestParam(name = "estado", required = true, defaultValue = "1") int estado) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Producto> lista = productoService.listaProductoPorNombreDniUsuario("%"+nombre+"%", precio, cantidadStock, idUsuario, dni, estado);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	

	
}







