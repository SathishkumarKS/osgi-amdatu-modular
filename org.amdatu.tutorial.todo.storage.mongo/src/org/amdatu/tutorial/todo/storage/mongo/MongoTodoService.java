package org.amdatu.tutorial.todo.storage.mongo;

import java.util.ArrayList;
import java.util.List;

import org.amdatu.mongo.MongoDBService;
import org.amdatu.tutorial.todo.storage.api.Todo;
import org.amdatu.tutorial.todo.storage.api.TodoService;
import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.apache.felix.dm.annotation.api.Start;
import org.mongojack.JacksonDBCollection;

import com.mongodb.DBCollection;

@Component
public class MongoTodoService implements TodoService{

  @ServiceDependency
  private volatile MongoDBService m_mongoDbService;
  private volatile JacksonDBCollection<Todo, String> todos;

  @Start
  public void start() {
    DBCollection collection = m_mongoDbService.getDB().getCollection("osgi-amdatu-modular");
    todos = JacksonDBCollection.wrap(collection, Todo.class, String.class);
  }

  @Override
  public void storeTodo(Todo todo) {
    //You might want validation here!
    todos.save(todo);
  }

  @Override
  public List<Todo> list(String user) {
    List<Todo> result = new ArrayList<>();

    todos.find().is("user", user).forEach(result::add);

    return result;
  }
}
