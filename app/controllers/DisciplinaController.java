package controllers;

import static play.data.Form.form;
import models.Disciplina;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.disciplinas.create;
import views.html.disciplinas.list;

public class DisciplinaController extends Controller {
	
	private final static Form<Disciplina> disciplinaForm = form(Disciplina.class); 
	
	public static Result index() {		
		return retrieveAll();
	}

	public static Result save() {
		Form<Disciplina> filledForm = disciplinaForm.bindFromRequest();
		
		if(filledForm.hasErrors()){
			return badRequest(create.render(filledForm));
		}
		
		try {
			filledForm.get().save();
			flash("success", "Cadastro realizado com sucesso");
			
		} catch (Exception e) {
			flash("error","Ocorreu um erro ao realizar o cadastro");
			e.printStackTrace();
		}
		
		return redirect(routes.DisciplinaController.create());
	}
	
	public static Result create() {
		return ok(create.render(disciplinaForm));
	}
	
	public static Result delete(Integer disciplinaId) {
		try {
			Disciplina.delete(disciplinaId);
			flash("success", "Resgistro deletado com sucesso");
			
		} catch (Exception e) {
			flash("error","Ocorreu um erro ao deletar o registro");
			e.printStackTrace();
		}
		
		return redirect(routes.DisciplinaController.index());
	}
	
	public static Result retrieveAll() {
		return ok(list.render(Disciplina.findAll()));
	}
	
}
