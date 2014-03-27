package controllers;

import static play.data.Form.form;
import models.Curso;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import service.NotaFrequenciaService;
import views.html.notasfrequencias.list;

public class NotaFrequenciaController extends Controller {
	
	public static Result index() {		
		return retrieveAll();
	}
	
	public static Result retrieveAll() {
		return ok(list.render(NotaFrequenciaService.findDisciplinaWithNotaAndFrequencia()));
	}
	
}
