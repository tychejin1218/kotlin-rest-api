package com.example.kotlinrestapi.web.controller

import com.example.kotlinrestapi.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
class TodoController(
  val todoService: TodoService
) {

  @GetMapping("/api/todos")
  fun getTodos(
    httpServletRequest: HttpServletRequest,
    httpServletResponse: HttpServletResponse,
  ): ResponseEntity<Any?> {
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(todoService.getTodos())
  }
}