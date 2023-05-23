package dev.be.r2dbc

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table
data class R2Book(

    @Id
    val id: Long? = null,

    @Column
    val name: String,

    @Column
    val price: Int,
)