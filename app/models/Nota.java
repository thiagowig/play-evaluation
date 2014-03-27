package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import play.db.ebean.Model;
import src.domain.enumeration.TipoNotaEnum;

import com.avaje.ebean.Ebean;

@Entity
public class Nota extends Model {

	@Id
	public Integer id;
	
	@Enumerated(EnumType.STRING)
	public TipoNotaEnum tipoNotaEnum;
	
	public Double valor;
	
	@ManyToOne
	public Disciplina disciplina;
	
	@Transient
	public String tipoNotaEnumSelected;
	
	@Transient
	public String disciplinaSelected;
	
	public static List<Nota> findAll() {
		return Ebean.find(Nota.class).findList();
	}
	
	public static void delete(Integer id) {
		Nota nota = Ebean.find(Nota.class, id);
		Ebean.delete(nota);
	}
	
	@Override
	public void save() {
		tipoNotaEnum = TipoNotaEnum.findByName(tipoNotaEnumSelected);
		
		if (disciplinaSelected != null) {
			disciplina = Ebean.find(Disciplina.class, Integer.valueOf(disciplinaSelected));
		}
		
		super.save();
	}
	
}
