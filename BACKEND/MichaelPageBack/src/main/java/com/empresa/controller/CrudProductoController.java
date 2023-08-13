package com.empresa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Producto;
import com.empresa.service.ProductoService;
import com.empresa.util.Constantes;

@RestController
@RequestMapping("/rest/crudProducto")
@CrossOrigin(origins = "http://localhost:4200")
public class CrudProductoController {

	@Autowired
	private ProductoService service;
	
	
	@GetMapping("/listaProductoPorNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProductoPorNombreLike(@PathVariable("nom") String nom) {
		List<Producto> lista  = null;
		try {
			if (nom.equals("todos")) {
				lista = service.listaProductoPorNombreLike("%");
			}else {
				lista = service.listaProductoPorNombreLike("%" + nom + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaProducto(@RequestBody Producto obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdProducto(0);
			obj.setFechaRegistro(new Date());
			obj.setEstado(1);
			Producto objSalida =  service.insertaActualizaProducto(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProducto(@RequestBody Producto obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Producto objSalida =  service.insertaActualizaProducto(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaProducto/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaProducto(@PathVariable("id")int id) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Producto opt = service.buscaProductoPorId(id);
			if (opt != null) {
				service.eliminaProducto(id);
				Producto optProducto = service.buscaProductoPorId(id);
				if (optProducto == null) {
					salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
				} else {
					salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
				}
			}else {
				salida.put("mensaje", Constantes.MENSAJE_ELI_NO_EXISTE_ID);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
}







