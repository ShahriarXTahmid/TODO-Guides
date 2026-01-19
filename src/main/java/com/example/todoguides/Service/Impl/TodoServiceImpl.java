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
        savedTodoDto.setCompleted(savedTodoDto.isCompleted());

        return savedTodoDto;

    }
}
