package br.com.tiago.appcompreja.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.com.tiago.appcompreja.model.ClientePF
import br.com.tiago.appcompreja.model.ClientePJ
import br.com.tiago.appcompreja.model.Produto

@Composable
fun ClientePFList(clientesPF: List<ClientePF>, atualizar: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (clientePF in clientesPF) {
            ClientePFCard(clientePF, context = LocalContext.current, atualizar)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}