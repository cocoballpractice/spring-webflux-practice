package dev.be.coroutine01

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table
data class Content(
    @Id
    val id : Long,

    @Column
    val userId : Long
)