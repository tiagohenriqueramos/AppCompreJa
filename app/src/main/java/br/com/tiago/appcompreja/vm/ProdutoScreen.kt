package br.com.tiago.fiap_esg_app.produto

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import br.com.tiago.appcompreja.components.ProdutoForm
import br.com.tiago.appcompreja.components.ProdutoList
import br.com.tiago.appcompreja.database.repository.ProdutoRepository


@Composable
fun ProdutosScreen(produtoScreenViewModel: ProdutoScreenViewModel) {

    val context = LocalContext.current
    val produtoRepository = ProdutoRepository(context)

    var nomeState = remember { mutableStateOf("") }
    var marcaState = remember { mutableStateOf("") }
    var estoqueState = remember { mutableStateOf("") }
    var precoState = remember { mutableStateOf("") }
    var descricaoState = remember { mutableStateOf("") }
    var categoriaState = remember { mutableStateOf("") }
    var codigoBarraState = remember { mutableStateOf("") }
    var precoPromocionalState = remember { mutableStateOf("") }
    var promocaoState = remember { mutableStateOf(false) }
    var listaProdutosState = remember { mutableStateOf(produtoRepository.listarProdutos()) }

    Column {
        ProdutoForm(
            nome = nomeState.value,
            marca = marcaState.value,
            estoque = estoqueState.value,
            preco = precoState.value,
            descricao = descricaoState.value,
            categoria = categoriaState.value,
            codigoBarra = codigoBarraState.value,
            precoPromocional = precoPromocionalState.value,
            promocao = promocaoState.value,

            onNomeChange = { nomeState.value = it },
            onMarcaChange = { marcaState.value = it },
            onEstoqueChange = { estoqueState.value = it },
            onPrecoChange = { precoState.value = it },
            onDescricaoChange = { descricaoState.value = it },
            onCategoriaChange = { categoriaState.value = it },
            onCodigoBarraChange = { codigoBarraState.value = it },
            onPrecoPromocionalChange = { precoPromocionalState.value = it },
            onPromocaoChange = { promocaoState.value = it },
            atualizar = { listaProdutosState.value = produtoRepository.listarProdutos() }
        )
        ProdutoList(listaProdutosState.value) {
            listaProdutosState.value = produtoRepository.listarProdutos()
        }
    }
}