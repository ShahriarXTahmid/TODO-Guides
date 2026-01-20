package com.example.todoguides.Service.Impl;

import com.example.todoguides.DTO.TodoDto;
import com.example.todoguides.Entity.Todo;
import com.example.todoguides.Exception.ResourceNotFoundException;
import com.example.todoguides.Repo.TodoRepo;
import com.example.todoguides.Service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    private TodoRepo todoRepo;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        // convert TodoDto into Todo jpa entity
        Todo todo = modelMapper.map(todoDto, Todo.class);

        // todo jpa entity
        Todo savedTodo = todoRepo.save(todo);

        // savedTodo jpa entity into TodoDto
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDto;

    }

    // getTodo jpa entity to TodoDto
    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + id));

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepo.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
        Todo todo = todoRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Todo not found with by ID:" + id));

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updateTodo = todoRepo.save(todo);

        return modelMapper.map(updateTodo, TodoDto.class);


    }


}
