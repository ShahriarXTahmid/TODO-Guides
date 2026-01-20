package com.example.todoguides.Controller;

import com.example.todoguides.DTO.TodoDto;
import com.example.todoguides.Service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    // Build addTodo RSET api
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto savedTodo = todoService.addTodo(todoDto);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Build get todo rest api
    @GetMapping("{todoId}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long todoId) {
        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    // Build getAll todo Rest Api
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    //  Build UpdateTodo rest Api
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable Long id) {
        TodoDto updateTodo = todoService.updateTodo(todoDto, id);

        return new ResponseEntity<>(updateTodo, HttpStatus.OK);
    }

    // build deleteTodo rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("Todo deleted successfully", HttpStatus.OK);
    }

}
