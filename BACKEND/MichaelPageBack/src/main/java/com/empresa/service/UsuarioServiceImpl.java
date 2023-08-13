package com.empresa.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Usuario;
import com.empresa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<String> listanombres() {
		return repository.listaDepartamentos();
	}
	@Override
	public List<String> listaNombres() {
		return repository.listaNombres();
	}
	@Override
	public List<String> listaTelefonos() {
		return repository.listaTelefonos();
	}
	@Override
	public List<String> listaDirecciones() {
		return repository.listaDirecciones();
	}

	@Override
	public List<String> listaDepartamentos() {
		return repository.listaDepartamentos();
	}

	@Override
	public List<String> listaProvincias(String departamento) {

		return repository.listaProvincias(departamento);
	}

	@Override
	public List<Usuario> listaDistritos(String departamento, String provincia) {
		return repository.listaDistritos(departamento, provincia);
	}

}
