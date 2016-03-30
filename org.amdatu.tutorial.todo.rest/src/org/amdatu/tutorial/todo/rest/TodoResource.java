package org.amdatu.tutorial.todo.rest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.amdatu.tutorial.todo.storage.api.Todo;
import org.amdatu.tutorial.todo.storage.api.TodoService;
import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;


@Path("/todo")
@Component(provides=Object.class)
public class TodoResource {

  @ServiceDependency
  private volatile TodoService todoService;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("{user}")
  public List<Todo> list(@PathParam("user") String user) {
    return todoService.list(user, 10);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void saveTodo(Todo todo) {
    todoService.storeTodo(todo);
  }
  
  @POST
  @Path("complete/{user}")
  public void markComplete(@PathParam("user") String user) {
	  todoService.markCompletedFor(user);
  }
}