package com.example.kotlinrestapi.service

import com.example.kotlinrestapi.domain.repository.TodoRepository
import com.example.kotlinrestapi.dto.TodoDto
import com.example.kotlinrestapi.dto.TodoRequest
import com.example.kotlinrestapi.dto.TodoResponse
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoService(
  var todoRepository: TodoRepository
) {

  /** To-Do 목록 조회 */
  fun getTodos(): MutableList<TodoResponse> {
    return todoRepository.findAll().map {
      TodoDto().toDto(it)
    }.toMutableList()
  }

  /** To-Do 상세 조회 */
  fun getTodo(id: Long): TodoResponse {
    todoRepository.findByIdOrNull(id)?.let {
      return TodoDto().toDto(it)
    } ?: throw Exception()
  }

  /** To-Do 저장 */
  fun insertTodo(todoRequest: TodoRequest): TodoResponse? {
    return TodoResponse().let {
      TodoDto().toEntity(todoRequest)
    }.let {
      todoRepository.save(it)
    }?.let {
      TodoDto().toDto(it)
    }
  }

  /** To-Do 수정 */
  fun updateTodo(todoRequest: TodoRequest): TodoResponse? {
    return TodoResponse().let {
      TodoDto().toEntity(todoRequest)
    }.let {
      todoRepository.save(it)
    }?.let {
      TodoDto().toDto(it)
    }
  }

  /** To-Do 삭제 */
  fun deleteTodo(id: Long) {
    return getTodo(id).let {
      todoRepository.deleteById(id)
    }
  }
}