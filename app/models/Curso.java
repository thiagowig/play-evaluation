package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
public class Curso extends Model {

	@Id
	public Integer id;
	
	public String nome;
	
	public static List<Curso> findAll() {
		return Ebean.find(Curso.class).findList();
	}
	
	public static Map<String, String> findAllConvertedToSelect() {
		List<Curso> cursos = findAll();
		Map<String, String> convertedToSelect = new HashMap<String, String>();
		
		
		for (Curso curso : cursos) {
			convertedToSelect.put(curso.id.toString(), curso.nome);
		}
		
		return convertedToSelect;
	}
	
	public static void delete(Integer id) {
		Curso curso = Ebean.find(Curso.class, id);
		Ebean.delete(curso);
	}
}
