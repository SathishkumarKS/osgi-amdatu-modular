package org.amdatu.tutorial.todo.storage.inmemory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.amdatu.tutorial.todo.storage.api.Todo;
import org.amdatu.tutorial.todo.storage.api.TodoService;
import org.apache.felix.dm.annotation.api.Component;

@Component
public class InMemTodoService implements TodoService {
	private final List<Todo> todos = new CopyOnWriteArrayList<>();

	  @Override
	  public void storeTodo(Todo todo) {
	    todos.add(todo);
	  }

	  @Override
	  public List<Todo> list(String user, int maxResults) {
	    return todos.stream()
	        .filter(t -> t.getUser().equals(user))
	        .collect(Collectors.toList());
	  }

	@Override
	public void markCompletedFor(String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long countRecords() {
		// TODO Auto-generated method stub
		return 0;
	}

}
