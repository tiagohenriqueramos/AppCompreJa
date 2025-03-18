//package br.com.tiago.fiap_esg_app.produto
//
//import android.app.Application
//import androidx.lifecycle.*
//import br.com.tiago.fiap_esg_app.database.repository.ProdutoRepository
//import br.com.tiago.fiap_esg_app.model.Produto
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import java.text.SimpleDateFormat
//import java.util.*
//
//class ProdutoScreenViewModel(application: Application) : AndroidViewModel(application) {
//    private val repository = ProdutoRepository(application)
//
//    private val _nome = MutableLiveData<String>()
//    val nomeState: LiveData<String> = _nome
//
//    private val _marca = MutableLiveData<String>()
//    val marcaState: LiveData<String> = _marca
//
//    private val _precoNormal = MutableLiveData<String>()
//    val precoNormalState: LiveData<String> = _precoNormal
//
//    private val _descricao = MutableLiveData<String>()
//    val descricaoState: LiveData<String> = _descricao
//
//    private val _categoria = MutableLiveData<String>()
//    val categoriaState: LiveData<String> = _categoria
//
//    private val _pesoVolume = MutableLiveData<String>()
//    val pesoVolumeState: LiveData<String> = _pesoVolume
//
//    private val _codigoInterno = MutableLiveData<String>()
//    val codigoInternoState: LiveData<String> = _codigoInterno
//
//    private val _codigoBarra = MutableLiveData<String>()
//    val codigoBarraState: LiveData<String> = _codigoBarra
//
//    private val _estoque = MutableLiveData<String>()
//    val estoqueState: LiveData<String> = _estoque
//
//    private val _emPromocao = MutableLiveData<Boolean>()
//    val emPromocaoState: LiveData<Boolean> = _emPromocao
//
//    private val _produtos = MutableLiveData<List<Produto>>()
//    val produtosState: LiveData<List<Produto>> = _produtos
//
//    fun setNome(nome: String) { _nome.value = nome }
//    fun setMarca(marca: String) { _marca.value = marca }
//    fun setPrecoNormal(preco: String) { _precoNormal.value = preco }
//    fun setDescricao(descricao: String) { _descricao.value = descricao }
//    fun setCategoria(categoria: String) { _categoria.value = categoria }
//    fun setPesoVolume(pesoVolume: String) { _pesoVolume.value = pesoVolume }
//    fun setCodigoInterno(codigo: String) { _codigoInterno.value = codigo }
//    fun setCodigoBarra(codigo: String) { _codigoBarra.value = codigo }
//    fun setEstoque(estoque: String) { _estoque.value = estoque }
//    fun setEmPromocao(promocao: Boolean) { _emPromocao.value = promocao }
//
//    fun salvarProduto() {
//        val dataCadastro = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
//
//        val produto = Produto(
//            nome = _nome.value ?: "",
//            marca = _marca.value ?: "",
//            precoNormal = _precoNormal.value?.toDoubleOrNull() ?: 0.0,
//            precoOferta = null,
//            produtoEmOferta = _emPromocao.value ?: false,
//            estoque = _estoque.value?.toIntOrNull() ?: 0,
//            codigoBarra = _codigoBarra.value ?: "000000000",
//            isPromocao = _emPromocao.value ?: false,
//            descricao = _descricao.value ?: "",
//            categoria = _categoria.value ?: "",
//            pesoVolume = _pesoVolume.value ?: "",
//            codigoInterno = _codigoInterno.value ?: "",
//            dataCadastro = dataCadastro
//        )
//
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.salvar(produto)
//            carregarProdutos()
//        }
//    }
//
//    fun carregarProdutos() {
//        viewModelScope.launch(Dispatchers.IO) {
//            _produtos.postValue(repository.listarProdutos())
//        }
//    }
//}
