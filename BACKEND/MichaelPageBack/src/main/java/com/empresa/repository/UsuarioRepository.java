package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{


	@Query("select distinct x.nombre from Usuario x order by 1 asc")
	public abstract List<String> listaNombres();
	@Query("select distinct x.telefono from Usuario x order by 1 asc")
	public abstract List<String> listaTelefonos();
	@Query("select distinct x.direccion from Usuario x order by 1 asc")
	public abstract List<String> listaDirecciones();
	@Query("select distinct x.departamento from Usuario x order by 1 asc")
	public abstract List<String> listaDepartamentos();
	
	@Query("select distinct x.provincia from Usuario x where x.departamento = :var_dep  order by 1 asc")
	public abstract List<String> listaProvincias(@Param("var_dep") String departamento);  

	@Query("select x from Usuario x where x.departamento = :var_dep and x.provincia = :var_pro  order by x.distrito asc")
	public abstract List<Usuario> listaDistritos(@Param("var_dep") String departamento,@Param("var_pro") String provincia);
	
	
}
