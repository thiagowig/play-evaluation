package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

import com.avaje.ebean.Ebean;

@Entity
public class Turma extends Model {

	@Id
	public Integer id;
	
	public String nome;
	
	public static List<Turma> findAll() {
		return Ebean.find(Turma.class).findList();
	}
	
	public static Map<String, String> findAllConvertedToSelect() {
		List<Turma> turmas = findAll();
		Map<String, String> convertedToSelect = new HashMap<String, String>();
		
		
		for (Turma turma : turmas) {
			convertedToSelect.put(turma.id.toString(), turma.nome);
		}
		
		return convertedToSelect;
	}
	
	public static void delete(Integer id) {
		Turma turma = Ebean.find(Turma.class, id);
		Ebean.delete(turma);
	}
}
