package controllers;

import static play.data.Form.form;
import models.Frequencia;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.frequencias.create;
import views.html.frequencias.list;

public class FrequenciaController extends Controller {
	
	private final static Form<Frequencia> frequenciaForm = form(Frequencia.class); 
	
	public static Result index() {		
		return retrieveAll();
	}

	public static Result save() {
		Form<Frequencia> filledForm = frequenciaForm.bindFromRequest();
		
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
		
		return redirect(routes.FrequenciaController.create());
	}
	
	public static Result create() {
		return ok(create.render(frequenciaForm));
	}
	
	public static Result delete(Integer frequenciaId) {
		try {
			Frequencia.delete(frequenciaId);
			flash("success", "Resgistro deletado com sucesso");
			
		} catch (Exception e) {
			flash("error","Ocorreu um erro ao deletar o registro");
			e.printStackTrace();
		}
		
		return redirect(routes.FrequenciaController.index());
	}
	
	public static Result retrieveAll() {
		return ok(list.render(Frequencia.findAll()));
	}
	
}
