package com.example.kotlinrestapi.dto

import com.example.kotlinrestapi.domain.entity.Todo

class TodoDto {

  fun toEntity(dto: TodoRequest): Todo {
    return Todo().apply {
      this.id = dto.id
      this.title = dto.title
      this.description = dto.description
      this.completed = dto.completed
    }
  }

  fun toDto(entity: Todo): TodoResponse {
    return TodoResponse().apply {
      this.id = entity.id
      this.title = entity.title
      this.description = entity.description
      this.completed = entity.completed
    }
  }
}

data class TodoRequest(
  var id: Long? = null,
  var title: String = "",
  var description: String = "",
  var completed: Boolean = false
)

data class TodoResponse(

  var id: Long? = null,
  var title: String = "",
  var description: String = "",
  var completed: Boolean = false
)