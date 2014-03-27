package service;

import java.util.List;

import com.avaje.ebean.Ebean;

import models.Disciplina;

public class NotaFrequenciaService {

	public static List<Disciplina> findDisciplinaWithNotaAndFrequencia() {
		return Ebean.find(Disciplina.class)
					.fetch("frequencias")
					.fetch("notas")
					.findList();
	}
}
