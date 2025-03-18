package br.com.tiago.appcompreja

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import br.com.tiago.appcompreja.ui.theme.AppCompreJaTheme
import br.com.tiago.appcompreja.vm.ProdutoScreenViewModelFactory
import br.com.tiago.fiap_esg_app.produto.ProdutoScreenViewModel
import br.com.tiago.fiap_esg_app.produto.ProdutosScreen
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCompreJaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.laranja)

                ) {
                    val viewModel: ProdutoScreenViewModel = viewModel(
                        factory = ProdutoScreenViewModelFactory(this)
                    )
                    ProdutosScreen(viewModel)
                }
            }
        }
    }
}
