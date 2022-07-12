package com.example.kotlinrestapi.web.controller

import com.example.kotlinrestapi.dto.TodoRequest
import com.example.kotlinrestapi.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
class TodoController(
  val todoService: TodoService
) {

  /** To-Do 목록 조회 */
  @GetMapping("/api/todos")
  fun getTodos(
    httpServletRequest: HttpServletRequest,
    httpServletResponse: HttpServletResponse,
  ): ResponseEntity<Any?> {
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(todoService.getTodos())
  }

  /** To-Do 상세 조회 */
  @GetMapping("/api/todo/{id}")
  fun getTodo(
    httpServletRequest: HttpServletRequest,
    httpServletResponse: HttpServletResponse,
    @PathVariable(value = "id") id: Long
  ): ResponseEntity<Any?> {
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(todoService.getTodo(id))
  }

  /** To-Do 저장 */
  @PostMapping("/api/todo")
  fun insertToDo(
    httpServletRequest: HttpServletRequest,
    httpServletResponse: HttpServletResponse,
    @RequestBody todoRequest: TodoRequest
  ): ResponseEntity<Any?> {
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(todoService.insertTodo(todoRequest))
  }

  /** To-Do 수정 */
  @PutMapping("/api/todo")
  fun updateToDo(
    httpServletRequest: HttpServletRequest,
    httpServletResponse: HttpServletResponse,
    @RequestBody todoRequest: TodoRequest
  ): ResponseEntity<Any?> {
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(todoService.updateTodo(todoRequest))
  }

  /** To-Do 삭제 */
  @DeleteMapping("/api/todo/{id}")
  fun deleteTodo(
    httpServletRequest: HttpServletRequest,
    httpServletResponse: HttpServletResponse,
    @PathVariable(value = "id") id: Long
  ): ResponseEntity<Any?> {
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(todoService.deleteTodo(id))
  }
}