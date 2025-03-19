package br.com.tiago.appcompreja.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_cliente_pf")
data class ClientePF(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val nome: String,
    val cpf: String,
    val endereco: String
)
