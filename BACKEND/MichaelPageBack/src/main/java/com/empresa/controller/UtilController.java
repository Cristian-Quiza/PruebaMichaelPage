package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Usuario;
import com.empresa.service.UsuarioService;

@RestController
@RequestMapping("/rest/util")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilController {

	@Autowired
	private UsuarioService usuarioService;


	@GetMapping("/listaNombres")
	@ResponseBody
	public List<String> listaNombres() {
		return usuarioService.listaNombres();
	}

	@GetMapping("/listaTelefonos")
	@ResponseBody
	public List<String> listaTelefonos() {
		return usuarioService.listaTelefonos();
	}


	@GetMapping("/listaDirecciones")
	@ResponseBody
	public List<String> listaDirecciones() {
		return usuarioService.listaDirecciones();
	}

	@GetMapping("/listaDepartamentos")
	@ResponseBody
	public List<String> listaDepartamentos() {
		return usuarioService.listaDepartamentos();
	}

	@GetMapping("/listaProvincias/{paramDep}")
	@ResponseBody
	public List<String> listaProvincias(@PathVariable("paramDep") String dep) {
		return usuarioService.listaProvincias(dep);
	}

	@GetMapping("/listaDistritos/{paramDep}/{paramProv}")
	@ResponseBody
	public List<Usuario> listaDistritos(@PathVariable("paramDep") String dep, @PathVariable("paramProv") String prov) {
		return usuarioService.listaDistritos(dep, prov);
	}
}
