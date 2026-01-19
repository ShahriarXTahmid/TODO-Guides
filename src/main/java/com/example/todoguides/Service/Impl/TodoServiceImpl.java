package com.example.todoguides.Service.Impl;

import com.example.todoguides.DTO.TodoDto;
import com.example.todoguides.Entity.Todo;
import com.example.todoguides.Repo.TodoRepo;
import com.example.todoguides.Service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    private TodoRepo todoRepo;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        // convert TodoDto into Todo jpa entity
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        // todo jpa entity
        Todo savedTodo = todoRepo.save(todo);

        // savedTodo jpa entity into TodoDto
        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setCompleted(savedTodo.isCompleted());

        return savedTodoDto;

    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepo.findById(id).get();

        TodoDto todoDto = new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setDescription(todo.getDescription());
        todoDto.setCompleted(todo.isCompleted());

        return todoDto;
    }
}
