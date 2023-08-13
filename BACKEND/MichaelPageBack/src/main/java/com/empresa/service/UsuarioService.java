package com.empresa.service;

import java.util.List;

import com.empresa.entity.Usuario;

public interface UsuarioService {

	List<String> listanombres();

	public abstract List<String> listaNombres();
	public abstract List<String> listaTelefonos();
	public abstract List<String> listaDirecciones();
	public abstract List<String> listaDepartamentos();
	public abstract List<String> listaProvincias(String departamento);
	public abstract List<Usuario> listaDistritos(String departamento,String provincia);
	
}
