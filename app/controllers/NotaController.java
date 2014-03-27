package controllers;

import static play.data.Form.form;
import models.Nota;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.notas.create;
import views.html.notas.list;

public class NotaController extends Controller {
	
	private final static Form<Nota> notaForm = form(Nota.class); 
	
	public static Result index() {		
		return retrieveAll();
	}

	public static Result save() {
		Form<Nota> filledForm = notaForm.bindFromRequest();
		
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
		
		return redirect(routes.NotaController.create());
	}
	
	public static Result create() {
		return ok(create.render(notaForm));
	}
	
	public static Result delete(Integer notaId) {
		try {
			Nota.delete(notaId);
			flash("success", "Resgistro deletado com sucesso");
			
		} catch (Exception e) {
			flash("error","Ocorreu um erro ao deletar o registro");
			e.printStackTrace();
		}
		
		return redirect(routes.NotaController.index());
	}
	
	public static Result retrieveAll() {
		return ok(list.render(Nota.findAll()));
	}
	
}
