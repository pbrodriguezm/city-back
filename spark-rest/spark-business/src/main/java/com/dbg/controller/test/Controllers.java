package com.dbg.controller.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import com.dbg.controller.AbstractController;
import com.dbg.model.error.ResponseError;
import com.dbg.model.test.Rol;
import com.dbg.model.test.TmPer;
import com.dbg.service.PersonaService;
import com.dbg.service.RolService;
import com.dbg.service.test.TestService;

public class Controllers extends AbstractController {

	private TestService testService;
	private PersonaService personaService;
	private RolService rolService;

	public Controllers() {
		testService = new TestService();
		personaService = new PersonaService();
		rolService = new RolService();
		initRoutes();
	}

	@Override
	protected void initRoutes() {
		Spark.setPort(8080);

		Spark.get(new Route("/test/:id") {

			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				final String id = request.params(":id");
				if (id == null || !Pattern.matches("[0-9]+", id)) {
					response.status(400);
					return mapper.toJson(new ResponseError("Bad Request!"));
				}
				response.status(200);
				return mapper.toJson(testService.findById(Integer.valueOf(id)));
			}
		});
		
		/* =======================================================
		* SERVICIOS ROLES
		* =======================================================
		*/
		Spark.get(new Route("/rol/:id") {
			@Override
			public Object handle(Request request, Response response) {
				
				response.type("application/json");
				final String id = request.params(":id");
				if (id == null || !Pattern.matches("[0-9]+", id)) {
					response.status(400);
					return mapper.toJson(new ResponseError("Bad Request!"));
				}
				response.status(200);
				System.out.println("iiiiiiii");
				return mapper.toJson(rolService.findById(Integer.valueOf(id)));
			}
		});
		
		Spark.post(new Route("/rol/add") {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
			
				response.status(200);
				
				Rol rol = new Rol();
		        String idrol = request.queryParams("rol");
		        String desc = request.queryParams("desc");
		        rol.setIdRol(Integer.parseInt(idrol));
		        rol.setDescRol(desc);
				return mapper.toJson(rolService.create(rol));
			}
		});
		Spark.get(new Route("/roles") {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				response.status(200);
				//rolService.findAll()
				return mapper.toJson(rolService.findAll());
				//return mapper.toJson(result);
			}
		});
		
		/* =======================================================
		* SERVICIOS PERSONA
		* =======================================================
		*/
		
		Spark.get(new Route("/persona/:id") {

			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				final String id = request.params(":id");
				if (id == null || !Pattern.matches("[0-9]+", id)) {
					response.status(400);
					return mapper.toJson(new ResponseError("Bad Request!"));
				}
				response.status(200);
				return mapper.toJson(personaService.findById(Integer.valueOf(id)));
			}
		});
		
		Spark.post(new Route("/persona/add") {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
			
				response.status(200);
				
				TmPer persona = new TmPer();
				persona.setDniPers(request.queryParams("dni"));
				persona.setIdPers(Integer.parseInt(request.queryParams("id")));
				persona.setNbPers(request.queryParams("nombre"));
	
				return mapper.toJson(personaService.create(persona));
			}
		});
		
		Spark.get(new Route("/personas") {
			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				response.status(200);
				return mapper.toJson(personaService.findAll());
			}
		});


	}
}
