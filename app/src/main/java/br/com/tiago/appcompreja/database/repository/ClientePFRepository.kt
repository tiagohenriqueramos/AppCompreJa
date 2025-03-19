package br.com.tiago.appcompreja.database.repository

import android.content.Context
import br.com.tiago.appcompreja.database.dao.ClientePFDb
import br.com.tiago.appcompreja.database.dao.ClientePJDb
import br.com.tiago.appcompreja.database.dao.ProdutoDb
import br.com.tiago.appcompreja.model.ClientePF
import br.com.tiago.appcompreja.model.ClientePJ
import br.com.tiago.appcompreja.model.Produto


class ClientePFRepository(context: Context) {
    private val db = ClientePFDb.getDatabase(context).clientePFDao()

    fun salvar(clientePF: ClientePF): Long {
        return db.salvar(clientePF)
    }

    fun atualizar(clientePF: ClientePF): Int {
        return db.atualizar(clientePF)
    }

    fun excluir(clientePF: ClientePF): Int {
        return db.excluir(clientePF )
    }

    fun listarClientesPF(): List<ClientePF> {
        return db.listarClientesPF()
    }

    fun buscarClientesPFPeloId(id: Int): ClientePF {
        return db.buscarClientePFPeloId(id)
    }

}