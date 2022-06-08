package com.example.kotlinrestapi.service

import com.example.kotlinrestapi.domain.repository.TodoRepository
import com.example.kotlinrestapi.dto.TodoDto
import com.example.kotlinrestapi.dto.TodoResponse
import org.springframework.stereotype.Service

@Service
class TodoService(
  var todoRepository: TodoRepository
) {

  fun getTodos(): MutableList<TodoResponse> {

    print(todoRepository.findAll())

    return todoRepository.findAll().map {
      TodoDto().toDto(it)
    }.toMutableList()
  }
}