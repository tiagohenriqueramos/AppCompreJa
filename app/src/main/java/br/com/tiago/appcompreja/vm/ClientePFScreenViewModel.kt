package br.com.tiago.fiap_esg_app.produto

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.tiago.appcompreja.database.repository.ClientePFRepository
import br.com.tiago.appcompreja.database.repository.ClientePJRepository
import br.com.tiago.appcompreja.database.repository.ProdutoRepository
import br.com.tiago.appcompreja.model.ClientePF
import br.com.tiago.appcompreja.model.ClientePJ
import br.com.tiago.appcompreja.model.Produto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClientePFScreenViewModel(private val context: Context) : ViewModel() {

    private val repository = ClientePFRepository(context)


    private val _nome = MutableLiveData<String>()
    val nomeState: LiveData<String> = _nome

    private val _cpf = MutableLiveData<String>()
    val cpfState: LiveData<String> = _cpf

    private val _endereco = MutableLiveData<String>()
    val enderecoState: LiveData<String> = _endereco


    fun setNome(nome: String) {
        _nome.value = nome
    }

    fun setCpf(cpf: String) {
        _cpf.value = cpf
    }

    fun setEndereco(endereco: String) {
        _endereco.value = endereco
    }
    private val _clientesPF = MutableLiveData<List<ClientePF>>()
    val clientesState: LiveData<List<ClientePF>> = _clientesPF



    fun salvarClientePF() {
        val clientePF = ClientePF(
            nome = _nome.value ?: "",
            cpf= _cpf.value ?: "",
            endereco = _endereco.value ?: ""
        )

        viewModelScope.launch(Dispatchers.IO) {
            repository.salvar(clientePF)
            carregarClientesPF()
        }
    }

    fun carregarClientesPF() {
        viewModelScope.launch(Dispatchers.IO) {
            _clientesPF.postValue(repository.listarClientesPF())
        }
    }

}
