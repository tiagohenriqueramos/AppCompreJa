package br.com.tiago.appcompreja

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.tiago.appcompreja.database.repository.ProdutoRepository
import br.com.tiago.appcompreja.model.Produto
import br.com.tiago.appcompreja.ui.theme.AppCompreJaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCompreJaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.laranja)

                ) {
                    Column {
                        ProdutosScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun ProdutosScreen() {

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProdutoForm(
    nome: String,
    marca: String,
    estoque: String,
    preco: String,
    descricao: String,
    categoria: String,
    codigoBarra: String,
    precoPromocional: String,
    promocao: Boolean,

    onNomeChange: (String) -> Unit,
    onMarcaChange: (String) -> Unit,
    onEstoqueChange: (String) -> Unit,
    onPrecoChange: (String) -> Unit,
    onDescricaoChange: (String) -> Unit,
    onCategoriaChange: (String) -> Unit,
    onCodigoBarraChange: (String) -> Unit,
    onPrecoPromocionalChange: (String) -> Unit,
    onPromocaoChange: (Boolean) -> Unit,
    atualizar: () -> Unit
) {
    val context = LocalContext.current
    val produtoRepository = ProdutoRepository(context)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 32.dp) // Espaço em cima e embaixo

    )
    {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 0.dp, max = 450.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xfff9f6f6)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {


            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())

            ) {
                Text(
                    text = "Cadastro de produtos",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.laranja)
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = nome,
                    onValueChange = { onNomeChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Nome do produto",
                            color = colorResource(id = R.color.laranja)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Words
                    ),

                    )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = marca,
                    onValueChange = { onMarcaChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Marca",
                            color = colorResource(id = R.color.laranja),

                            )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Words
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = preco,
                    onValueChange = { onPrecoChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Preço",
                            color = colorResource(id = R.color.laranja)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = estoque,
                    onValueChange = { onEstoqueChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Estoque",
                            color = colorResource(id = R.color.laranja)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = descricao,
                    onValueChange = { onDescricaoChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Descrição",
                            color = colorResource(id = R.color.laranja)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Words
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = categoria,
                    onValueChange = { onCategoriaChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Categoria",
                            color = colorResource(id = R.color.laranja)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Words
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = codigoBarra,
                    onValueChange = { onCodigoBarraChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Código de barras",
                            color = colorResource(id = R.color.laranja)

                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    )

                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = precoPromocional,
                    onValueChange = { onPrecoPromocionalChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Preço Promocional",
                            color = colorResource(id = R.color.laranja)

                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    )

                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = promocao, onCheckedChange = {
                            onPromocaoChange(it)
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.laranja),
                            uncheckedColor = colorResource(id = R.color.laranja),
                            checkmarkColor = colorResource(id = R.color.branco_creme)
                        )
                    )
                    Text(
                        text = "Em promoção",
                        color = colorResource(id = R.color.laranja)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        val produto = Produto(
                            nome = nome,
                            marca = marca,
                            preco = preco,
                            estoque = estoque,
                            descricao = descricao,
                            categoria = categoria,
                            codigoBarra = codigoBarra,
                            precoPromocional = precoPromocional,
                            isPromocao = promocao
                        )
                        produtoRepository.salvar(produto)
                        atualizar()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.branco_creme),
                        contentColor = colorResource(id = R.color.laranja)
                    )
                ) {
                    Text(
                        text = "CADASTRAR",
                        modifier = Modifier.padding(8.dp)
                    )
                }

            }
        }
    }
}

@Composable
fun ProdutoList(produtos: List<Produto>, atualizar: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (produto in produtos) {
            ProdutoCard(produto, context = LocalContext.current, atualizar)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun ProdutoCard(
    produto: Produto,
    context: Context,
    atualizar: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.branco_creme))

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(2f)
            ) {
                Text(text = "Produto: ${produto.nome}", fontSize = 16.sp)
                Text(text = "Marca: ${produto.marca}", fontSize = 16.sp)
                Text(text = "Estoque: ${produto.estoque}", fontSize = 16.sp)
                Text(text = "Descrição: ${produto.descricao}", fontSize = 16.sp)
                Text(text = "Categoria: ${produto.categoria}", fontSize = 16.sp)
                Text(text = "Código de barras: ${produto.codigoBarra}", fontSize = 16.sp)

                if (produto.isPromocao) {
                    Text(
                        text = "Preço promocional: R$ ${produto.precoPromocional}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                } else {
                    Text(
                        text = "Preço: R$ ${produto.preco}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            IconButton(onClick = {
                val produtoRepository = ProdutoRepository(context)
                produtoRepository.excluir(produto)
                atualizar()
            }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Excluir produto")
            }
        }
    }
}
