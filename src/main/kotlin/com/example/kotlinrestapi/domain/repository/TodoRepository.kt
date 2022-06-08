package com.example.kotlinrestapi.domain.repository

import com.example.kotlinrestapi.domain.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Long?> {
  
}