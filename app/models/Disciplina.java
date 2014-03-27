package models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import play.db.ebean.Model;

import com.avaje.ebean.Ebean;

@Entity
public class Disciplina extends Model {

	@Id
	public Integer id;
	
	public String nome;
	
	public Integer cargaHoraria;
	
	@ManyToOne
	public Turma turma;
	
	@OneToMany(mappedBy="disciplina")
	public List<Frequencia> frequencias;
	
	@OneToMany(mappedBy="disciplina")
	public List<Nota> notas;
	
	@Temporal(TemporalType.DATE)
	public Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	public Date dataFim;
	
	@ManyToOne
	public Curso curso;
	
	@Transient
	public String turmaSelected;
	
	@Transient
	public String cursoSelected;
	
	@Override
	public void save() {
		if (turmaSelected != null ) {
			turma = Ebean.find(Turma.class, Integer.valueOf(turmaSelected));
		}
		
		if (cursoSelected != null ) {
			curso = Ebean.find(Curso.class, Integer.valueOf(cursoSelected));
		}
		
		super.save();
	}
	
	public static Map<String, String> findAllConvertedToSelect() {
		List<Disciplina> disciplinas = findAll();
		Map<String, String> convertedToSelect = new HashMap<String, String>();
		
		
		for (Disciplina disciplina : disciplinas) {
			convertedToSelect.put(disciplina.id.toString(), disciplina.nome);
		}
		
		return convertedToSelect;
	}
	
	public static List<Disciplina> findAll() {
		return Ebean.find(Disciplina.class).findList();
	}
	
	public static void delete(Integer id) {
		Disciplina Disciplina = Ebean.find(Disciplina.class, id);
		Ebean.delete(Disciplina);
	}
	
	public String findFrequenciaValue(String tipoFrequencia){
		if (frequencias != null) {
			for (Frequencia frequencia : frequencias) {
				if (tipoFrequencia.equals(frequencia.tipoFrequenciaEnum.name())) {
					return frequencia.valor.toString();
				}
			}
		}
		
		return "";
	}
	
	public String findNotaValue(String tipoNota){
		if (notas != null) {
			for (Nota nota : notas) {
				if (tipoNota.equals(nota.tipoNotaEnum.name())) {
					return nota.valor.toString();
				}
			}
		}
		
		return "";
	}
	
}
