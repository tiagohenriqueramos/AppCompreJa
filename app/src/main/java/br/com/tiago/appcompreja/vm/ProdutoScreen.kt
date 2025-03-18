//package br.com.tiago.fiap_esg_app.produto
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import br.com.tiago.fiap_esg_app.components.CadastroProduto
//
//@Composable
//fun ProdutoScreen(produtoScreenViewModel: ProdutoScreenViewModel) {
//
//    val produtos by produtoScreenViewModel.produtosState.observeAsState(initial = emptyList())
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        Text("Cadastro de Produtos", style = MaterialTheme.typography.headlineSmall)
//        Spacer(modifier = Modifier.height(16.dp))
//
//        CadastroProduto(
//            value = produtoScreenViewModel.nomeState.value ?: "",
//            placeholder = "Nome do produto",
//            label = "Nome",
//            modifier = Modifier,
//            keyboardType = KeyboardType.Text,
//            atualizarValor = { produtoScreenViewModel.setNome(it) }
//        )
//
//        CadastroProduto(
//            value = produtoScreenViewModel.marcaState.value ?: "",
//            placeholder = "Marca",
//            label = "Marca",
//            modifier = Modifier,
//            keyboardType = KeyboardType.Text,
//            atualizarValor = { produtoScreenViewModel.setMarca(it) }
//        )
//
//        CadastroProduto(
//            value = produtoScreenViewModel.precoNormalState.value ?: "",
//            placeholder = "Preço Normal",
//            label = "Preço",
//            modifier = Modifier,
//            keyboardType = KeyboardType.Decimal,
//            atualizarValor = { produtoScreenViewModel.setPrecoNormal(it) }
//        )
//
//        CadastroProduto(
//            value = produtoScreenViewModel.descricaoState.value ?: "",
//            placeholder = "Descrição",
//            label = "Descrição",
//            modifier = Modifier,
//            keyboardType = KeyboardType.Text,
//            atualizarValor = { produtoScreenViewModel.setDescricao(it) }
//        )
//
//        CadastroProduto(
//            value = produtoScreenViewModel.categoriaState.value ?: "",
//            placeholder = "Categoria",
//            label = "Categoria",
//            modifier = Modifier,
//            keyboardType = KeyboardType.Text,
//            atualizarValor = { produtoScreenViewModel.setCategoria(it) }
//        )
//
//        CadastroProduto(
//            value = produtoScreenViewModel.pesoVolumeState.value ?: "",
//            placeholder = "Peso/Volume",
//            label = "Peso/Volume",
//            modifier = Modifier,
//            keyboardType = KeyboardType.Text,
//            atualizarValor = { produtoScreenViewModel.setPesoVolume(it) }
//        )
//
//        CadastroProduto(
//            value = produtoScreenViewModel.codigoInternoState.value ?: "",
//            placeholder = "Código Interno",
//            label = "Código Interno",
//            modifier = Modifier,
//            keyboardType = KeyboardType.Text,
//            atualizarValor = { produtoScreenViewModel.setCodigoInterno(it) }
//        )
//
//        CadastroProduto(
//            value = produtoScreenViewModel.codigoBarraState.value ?: "",
//            placeholder = "Código de Barras",
//            label = "Código de Barras",
//            modifier = Modifier,
//            keyboardType = KeyboardType.Number,
//            atualizarValor = { produtoScreenViewModel.setCodigoBarra(it) }
//        )
//
//        CadastroProduto(
//            value = produtoScreenViewModel.estoqueState.value ?: "",
//            placeholder = "Estoque",
//            label = "Estoque",
//            modifier = Modifier,
//            keyboardType = KeyboardType.Number,
//            atualizarValor = { produtoScreenViewModel.setEstoque(it) }
//        )
//
//        Row(modifier = Modifier.padding(vertical = 8.dp)) {
//            Checkbox(
//                checked = produtoScreenViewModel.emPromocaoState.value ?: false,
//                onCheckedChange = { produtoScreenViewModel.setEmPromocao(it) }
//            )
//            Text(text = "Em promoção")
//        }
//
//        Button(
//            onClick = { produtoScreenViewModel.salvarProduto() },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 16.dp)
//        ) {
//            Text(text = "SALVAR PRODUTO")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text("Lista de Produtos", style = MaterialTheme.typography.titleMedium)
//        LazyColumn {
//            items(produtos) { produto ->
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 8.dp),
//                    colors = CardDefaults.cardColors(
//                        containerColor = MaterialTheme.colorScheme.surfaceVariant
//                    )
//                ) {
//                    Column(modifier = Modifier.padding(16.dp)) {
//                        Text(produto.nome, style = MaterialTheme.typography.titleMedium)
//                        Text("Marca: ${produto.marca}", style = MaterialTheme.typography.bodySmall)
//                        Text("Categoria: ${produto.categoria}")
//                        Text("Descrição: ${produto.descricao}")
//                        Text("Peso/Volume: ${produto.pesoVolume}")
//                        Text("Código Interno: ${produto.codigoInterno}")
//                        Text("Código de Barras: ${produto.codigoBarra}")
//                        Text("Estoque: ${produto.estoque}")
//                        Text("Preço: R$${produto.precoNormal}")
//                        Text("Cadastro: ${produto.dataCadastro}")
//                        if (produto.isPromocao) {
//                            Text("🔥 Em promoção!", color = MaterialTheme.colorScheme.error)
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
