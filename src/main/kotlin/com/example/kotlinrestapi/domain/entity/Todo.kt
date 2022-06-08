package com.example.kotlinrestapi.domain.entity

import javax.persistence.*

@Table(name = "TODO")
@Entity
class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  var id: Long? = null

  @Column(name = "title")
  var title: String = ""

  @Column(name = "description")
  var description: String = ""

  @Column(name = "completed")
  var completed: Boolean = false
}