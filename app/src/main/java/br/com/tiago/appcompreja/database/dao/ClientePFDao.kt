package br.com.tiago.appcompreja.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.tiago.appcompreja.model.ClientePF
import br.com.tiago.appcompreja.model.ClientePJ
import br.com.tiago.appcompreja.model.Produto

@Dao
interface ClientePFDao {

    @Insert
    fun salvar(clientePF: ClientePF): Long

    @Update
    fun atualizar(clientePF: ClientePF): Int

    @Delete
    fun excluir(clientePF: ClientePF): Int

    @Query("SELECT * FROM tb_cliente_pf WHERE id = :id")
    fun buscarClientePFPeloId(id: Int): ClientePF

    @Query("SELECT * FROM tb_cliente_pf ORDER BY nome ASC")
    fun listarClientesPF(): List<ClientePF>
}