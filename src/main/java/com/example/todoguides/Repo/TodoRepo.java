package com.example.todoguides.Repo;

import com.example.todoguides.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo, Long> {
}
