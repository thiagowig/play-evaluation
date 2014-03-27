package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import play.db.ebean.Model;
import src.domain.enumeration.TipoFrequenciaEnum;

import com.avaje.ebean.Ebean;

@Entity
public class Frequencia extends Model {

	@Id
	public Integer id;
	
	@Enumerated(EnumType.STRING)
	public TipoFrequenciaEnum tipoFrequenciaEnum;
	
	public Double valor;
	
	@ManyToOne
	public Disciplina disciplina;
	
	@Transient
	public String tipoFrequenciaEnumSelected;
	
	@Transient
	public String disciplinaSelected;
	
	public static List<Frequencia> findAll() {
		return Ebean.find(Frequencia.class).findList();
	}
	
	public static void delete(Integer id) {
		Frequencia frequencia = Ebean.find(Frequencia.class, id);
		Ebean.delete(frequencia);
	}
	
	@Override
	public void save() {
		tipoFrequenciaEnum = TipoFrequenciaEnum.findByName(tipoFrequenciaEnumSelected);
		
		if (disciplinaSelected != null) {
			disciplina = Ebean.find(Disciplina.class, Integer.valueOf(disciplinaSelected));
		}
		
		super.save();
	}
}
