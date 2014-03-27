package controllers;

import static play.data.Form.form;
import models.Curso;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.cursos.create;
import views.html.cursos.list;

public class CursoController extends Controller {
	
	private final static Form<Curso> cursoForm = form(Curso.class); 
	
	public static Result index() {		
		return retrieveAll();
	}

	public static Result save() {
		Form<Curso> filledForm = cursoForm.bindFromRequest();
		
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
		
		return redirect(routes.CursoController.create());
	}
	
	public static Result create() {
		return ok(create.render(cursoForm));
	}
	
	public static Result delete(Integer cursoId) {
		try {
			Curso.delete(cursoId);
			flash("success", "Resgistro deletado com sucesso");
			
		} catch (Exception e) {
			flash("error","Ocorreu um erro ao deletar o registro");
			e.printStackTrace();
		}
		
		return redirect(routes.CursoController.index());
	}
	
	public static Result retrieveAll() {
		return ok(list.render(Curso.findAll()));
	}
	
}
