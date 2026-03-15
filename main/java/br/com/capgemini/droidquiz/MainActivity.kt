package br.com.capgemini.droidquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.capgemini.droidquiz.data.QuestoesData
import br.com.capgemini.droidquiz.entities.Questao
import br.com.capgemini.droidquiz.ui.theme.DroidQuizTheme

// Activity principal: define o conteúdo Compose exibido ao abrir o app.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Permite desenhar conteúdo atrás das barras do sistema.
        enableEdgeToEdge()
        setContent {
            // Tema global da aplicação para estilos, cores e tipografia.
            DroidQuizTheme {
                // Inicia sem filtro (nível 0) para listar todas as questões.
                ListaQuestoes(modifier = Modifier.padding(top = 16.dp), 0)
            }
        }
    }
}

@Composable
fun ListaQuestoes(modifier: Modifier = Modifier, nivel: Int) {
    // Estado do campo de filtro exibido no TextField.
    var nivelInicial by remember { mutableStateOf(if (nivel != 0) nivel.toString() else "0") }

    // Lista observável usada pela UI; quando muda, a tela é recomposta.
    val questoes = remember {
        mutableStateListOf<Questao>().apply {
            // Carga inicial da lista com ou sem filtro de nível.
            val inicial = if (nivel == 0) QuestoesData.questoes
                         else QuestoesData.questoes.filter { it.nivel == nivel }
            addAll(inicial)
        }
    }

    // Aplica o filtro informado no TextField e atualiza a lista em memória.
    fun aplicarFiltro() {
        // Converte texto para número; se inválido, o resultado será null.
        val n = nivelInicial.toIntOrNull()
        // Limpa a lista atual antes de preencher com o novo resultado.
        questoes.clear()
        questoes.addAll(
            // Nível 0 (ou inválido) = todas as questões.
            if (n == null || n == 0) QuestoesData.questoes
            // Nível 1, 2 ou 3 = somente questões desse nível.
            else QuestoesData.questoes.filter { it.nivel == n }
        )
    }

    // Contêiner visual da tela de listagem.
    Surface(modifier = modifier.fillMaxSize().padding(top = 16.dp)) {
        // Lista vertical com espaçamento entre os cards.
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Cabeçalho com título + área de filtro por nível.
            item {
                Text(
                    text = "Quiz Jetpack Compose",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Campo para digitar o nível desejado (1, 2 ou 3).
                    OutlinedTextField(
                        value = nivelInicial,
                        onValueChange = { nivelInicial = it },
                        label = { Text("Nível (1 - Fácil, 2 - Intermediário ou 3 - Dificil)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )
                    // Botão que executa o filtro com o valor digitado.
                    Button(onClick = { aplicarFiltro() }) {
                        Text("Filtrar")
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
            }

            // Renderiza um card para cada questão carregada na lista.
            items(items = questoes, key = { it.id }) { questao ->
                QuestaoCard(questao = questao)
            }
        }
    }
}

@Composable
fun QuestaoCard(questao: Questao) {
    // Guarda qual alternativa foi marcada pelo usuário nesta questão.
    var respostaSelecionada by remember { mutableStateOf<Int?>(null) }

    // Card visual da questão com enunciado e opções.
    Card {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Questão ${questao.id}",
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = questao.pergunta,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Percorre as alternativas da questão para exibir o checkbox de cada uma.
            questao.opcoes.forEach { opcao ->
                // true se esta opção foi marcada pelo usuário.
                val selecionada = respostaSelecionada == opcao.id
                // true se esta opção é a resposta correta cadastrada.
                val correta = opcao.id == questao.respostaCorreta

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Permite selecionar ou limpar a opção atual.
                    Checkbox(
                        checked = selecionada,
                        onCheckedChange = { checked ->
                            respostaSelecionada = if (checked) opcao.id else null
                        }
                    )
                    // Cor do texto muda para indicar acerto ou erro após seleção.
                    Text(
                        text = opcao.texto,
                        color = when {
                            selecionada && correta  -> Color(0xFF2E7D32)
                            selecionada && !correta -> Color(0xFFC62828)
                            else                    -> Color.Unspecified
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
                // Mostra feedback e explicação somente para a opção selecionada.
                if (selecionada) {
                    Text(
                        text = if (correta) "✓ ${opcao.explicacao}" else "✗ ${opcao.explicacao}",
                        color = if (correta) Color(0xFF2E7D32) else Color(0xFFC62828),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 48.dp, bottom = 4.dp)
                    )
                } else {
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DroidQuizTheme {
        ListaQuestoes(Modifier.padding(),0)
    }
}