package controllers;

import static play.data.Form.form;
import models.Turma;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.turmas.create;
import views.html.turmas.list;

public class TurmaController extends Controller {
	
	private final static Form<Turma> turmaForm = form(Turma.class); 
	
	public static Result index() {		
		return retrieveAll();
	}

	public static Result save() {
		Form<Turma> filledForm = turmaForm.bindFromRequest();
		
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
		
		return redirect(routes.TurmaController.create());
	}
	
	public static Result create() {
		return ok(create.render(turmaForm));
	}
	
	public static Result delete(Integer turmaId) {
		try {
			Turma.delete(turmaId);
			flash("success", "Resgistro deletado com sucesso");
			
		} catch (Exception e) {
			flash("error","Ocorreu um erro ao deletar o registro");
			e.printStackTrace();
		}
		
		return redirect(routes.TurmaController.index());
	}
	
	public static Result retrieveAll() {
		return ok(list.render(Turma.findAll()));
	}
	
}
