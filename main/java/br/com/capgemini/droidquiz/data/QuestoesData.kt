package br.com.capgemini.droidquiz.data

import br.com.capgemini.droidquiz.entities.Opcao
import br.com.capgemini.droidquiz.entities.Questao

object QuestoesData {
    val questoes = listOf(
        Questao(
            id = 1,
            pergunta = "O que é o Jetpack Compose no Android?",
            opcoes = listOf(
                Opcao(1, "Um toolkit moderno para criar interfaces nativas com Kotlin", 1,
                    "Correto! Jetpack Compose é o toolkit declarativo oficial do Android para construir UIs nativas usando Kotlin."),
                Opcao(2, "Um banco de dados local para Android", 1,
                    "Incorreto. Para banco de dados local o Android oferece o Room, que também faz parte do Jetpack."),
                Opcao(3, "Uma biblioteca exclusiva para animações 3D", 1,
                    "Incorreto. Compose suporta animações, mas é um toolkit completo de UI, não exclusivo para 3D."),
                Opcao(4, "Um emulador oficial do Android Studio", 1,
                    "Incorreto. O emulador do Android Studio é o AVD (Android Virtual Device), separado do Compose.")
            ),
            respostaCorreta = 1,
            nivel = 1
        ),
        Questao(
            id = 2,
            pergunta = "Qual função anotada é usada para declarar elementos de UI no Compose?",
            opcoes = listOf(
                Opcao(1, "@UI", 2,
                    "Incorreto. A anotação @UI não existe no Jetpack Compose."),
                Opcao(2, "@Composable", 2,
                    "Correto! @Composable marca funções que descrevem partes da UI e permite que o Compose as rastreie durante recomposições."),
                Opcao(3, "@Layout", 2,
                    "Incorreto. @Layout não existe no Compose; layouts são composables comuns como Column, Row e Box."),
                Opcao(4, "@Screen", 2,
                    "Incorreto. @Screen não é uma anotação do Jetpack Compose.")
            ),
            respostaCorreta = 2,
            nivel = 1
        ),
        Questao(
            id = 3,
            pergunta = "Qual componente é usado para exibir um texto simples na tela?",
            opcoes = listOf(
                Opcao(1, "Button", 3,
                    "Incorreto. Button é um componente de ação clicável, não um exibidor de texto simples."),
                Opcao(2, "Column", 3,
                    "Incorreto. Column é um layout que organiza elementos verticalmente, não exibe texto."),
                Opcao(3, "Text", 3,
                    "Correto! Text é o composable padrão para renderizar texto na tela no Jetpack Compose."),
                Opcao(4, "Image", 3,
                    "Incorreto. Image é usado para exibir imagens, não texto.")
            ),
            respostaCorreta = 3,
            nivel = 1
        ),
        Questao(
            id = 4,
            pergunta = "Qual layout organiza os elementos na vertical?",
            opcoes = listOf(
                Opcao(1, "Row", 4,
                    "Incorreto. Row organiza seus filhos na horizontal, da esquerda para a direita."),
                Opcao(2, "Box", 4,
                    "Incorreto. Box empilha elementos uns sobre os outros, sem eixo definido."),
                Opcao(3, "Column", 4,
                    "Correto! Column organiza seus filhos verticalmente, um abaixo do outro."),
                Opcao(4, "Spacer", 4,
                    "Incorreto. Spacer é usado apenas para adicionar espaço vazio entre elementos.")
            ),
            respostaCorreta = 3,
            nivel = 1
        ),
        Questao(
            id = 5,
            pergunta = "Qual função normalmente é usada para definir o conteúdo Compose em uma Activity?",
            opcoes = listOf(
                Opcao(1, "setScreen", 5,
                    "Incorreto. setScreen não é uma função do Android SDK."),
                Opcao(2, "composeContent", 5,
                    "Incorreto. composeContent não existe no Android SDK."),
                Opcao(3, "setContent", 5,
                    "Correto! setContent é a função de extensão de ComponentActivity que define a raiz do conteúdo Compose da Activity."),
                Opcao(4, "showContent", 5,
                    "Incorreto. showContent não é uma função do Android SDK.")
            ),
            respostaCorreta = 3,
            nivel = 1
        ),
        Questao(
            id = 6,
            pergunta = "Para que serve o remember no Jetpack Compose?",
            opcoes = listOf(
                Opcao(1, "Para criar permissões em tempo de execução", 6,
                    "Incorreto. Permissões são gerenciadas com ActivityResultContracts.RequestPermission, não com remember."),
                Opcao(2, "Para armazenar estado durante recomposições", 6,
                    "Correto! remember armazena um valor na memória da composição, fazendo com que ele sobreviva a recomposições sem ser recalculado."),
                Opcao(3, "Para navegar entre telas", 6,
                    "Incorreto. Navegação é feita com NavController e o componente NavHost."),
                Opcao(4, "Para acessar recursos XML", 6,
                    "Incorreto. Recursos são acessados por funções como stringResource() e painterResource().")
            ),
            respostaCorreta = 2,
            nivel = 2
        ),
        Questao(
            id = 7,
            pergunta = "Qual componente é mais indicado para listas grandes e eficientes no Compose?",
            opcoes = listOf(
                Opcao(1, "LazyColumn", 7,
                    "Correto! LazyColumn compõe e renderiza somente os itens visíveis na tela, sendo ideal para listas longas e performáticas."),
                Opcao(2, "Column", 7,
                    "Incorreto. Column renderiza todos os filhos de uma vez, o que degrada o desempenho em listas grandes."),
                Opcao(3, "Box", 7,
                    "Incorreto. Box empilha elementos e não possui mecanismo de reciclagem para listas."),
                Opcao(4, "Surface", 7,
                    "Incorreto. Surface é um contêiner de estilo Material Design, não um componente de lista.")
            ),
            respostaCorreta = 1,
            nivel = 2
        ),
        Questao(
            id = 8,
            pergunta = "O que acontece quando um State observado muda no Compose?",
            opcoes = listOf(
                Opcao(1, "A Activity é recriada automaticamente", 8,
                    "Incorreto. A Activity só é recriada em mudanças de configuração (rotação, idioma), não por mudança de State."),
                Opcao(2, "A UI relevante é recomposta", 8,
                    "Correto! O Compose rastreia quais composables leram um State e recompõe apenas esses quando o valor muda."),
                Opcao(3, "O aplicativo é reiniciado", 8,
                    "Incorreto. Uma mudança de State nunca reinicia o aplicativo."),
                Opcao(4, "Todos os composables são destruídos", 8,
                    "Incorreto. O Compose é inteligente e recompõe somente o escopo afetado, não destrói a árvore inteira.")
            ),
            respostaCorreta = 2,
            nivel = 2
        ),
        Questao(
            id = 9,
            pergunta = "Qual é a finalidade do Modifier no Compose?",
            opcoes = listOf(
                Opcao(1, "Executar requisições de rede", 9,
                    "Incorreto. Requisições de rede são feitas com bibliotecas como Retrofit ou Ktor, fora da camada de UI."),
                Opcao(2, "Alterar aparência, comportamento e layout de composables", 9,
                    "Correto! Modifier é uma cadeia de decoradores que permite modificar tamanho, padding, clique, scroll e muitos outros aspectos de qualquer composable."),
                Opcao(3, "Gerenciar banco de dados SQLite", 9,
                    "Incorreto. Banco de dados é gerenciado pelo Room ou SQLiteOpenHelper, na camada de dados."),
                Opcao(4, "Substituir a necessidade de ViewModel", 9,
                    "Incorreto. Modifier lida com aspectos visuais; ViewModel gerencia estado e lógica de apresentação.")
            ),
            respostaCorreta = 2,
            nivel = 2
        ),
        Questao(
            id = 10,
            pergunta = "Qual API é comumente usada para lembrar um estado mutável simples?",
            opcoes = listOf(
                Opcao(1, "mutableStateOf", 10,
                    "Correto! mutableStateOf cria um holder de estado observável; qualquer composable que ler seu valor será recomposto quando ele mudar."),
                Opcao(2, "liveDataOf", 10,
                    "Incorreto. liveDataOf não existe como API. LiveData é criada com MutableLiveData() e precisa ser observada com observeAsState() no Compose."),
                Opcao(3, "stateFlowOf", 10,
                    "Incorreto. stateFlowOf não existe. MutableStateFlow é da API de coroutines e é coletado no Compose com collectAsState()."),
                Opcao(4, "rememberText", 10,
                    "Incorreto. rememberText não é uma API do Jetpack Compose.")
            ),
            respostaCorreta = 1,
            nivel = 2
        ),
        Questao(
            id = 11,
            pergunta = "Qual é a principal vantagem de usar derivedStateOf em certos cenários?",
            opcoes = listOf(
                Opcao(1, "Criar navegação entre Activities", 11,
                    "Incorreto. Navegação entre Activities é feita com Intent; derivedStateOf é exclusivamente sobre otimização de estado."),
                Opcao(2, "Evitar recálculos desnecessários de valores derivados de estado", 11,
                    "Correto! derivedStateOf memoiza um cálculo baseado em outros estados, disparando recomposição apenas quando o resultado final muda, não toda vez que os estados de entrada mudam."),
                Opcao(3, "Substituir completamente o remember", 11,
                    "Incorreto. derivedStateOf é usado dentro de remember e é complementar, não um substituto."),
                Opcao(4, "Persistir dados em disco automaticamente", 11,
                    "Incorreto. Para persistência use rememberSaveable, DataStore ou Room.")
            ),
            respostaCorreta = 2,
            nivel = 3
        ),
        Questao(
            id = 12,
            pergunta = "Em uma arquitetura com Compose, qual é o papel ideal do ViewModel?",
            opcoes = listOf(
                Opcao(1, "Renderizar diretamente todos os composables", 12,
                    "Incorreto. Composables são funções Kotlin anotadas com @Composable; o ViewModel não os renderiza."),
                Opcao(2, "Gerenciar estado de UI e lógica de apresentação sobrevivendo a mudanças de configuração", 12,
                    "Correto! ViewModel sobrevive a recomposições e mudanças de configuração, sendo o local ideal para expor StateFlow/State e executar lógica de apresentação."),
                Opcao(3, "Substituir o uso de repositórios", 12,
                    "Incorreto. ViewModel e Repository têm responsabilidades distintas e devem coexistir na arquitetura."),
                Opcao(4, "Criar temas Material automaticamente", 12,
                    "Incorreto. Temas são definidos com MaterialTheme e funções de tema Compose, sem envolvimento do ViewModel.")
            ),
            respostaCorreta = 2,
            nivel = 3
        ),
        Questao(
            id = 13,
            pergunta = "Quando o uso de key em listas do Compose se torna importante?",
            opcoes = listOf(
                Opcao(1, "Quando os itens podem mudar de ordem ou serem atualizados dinamicamente", 13,
                    "Correto! key fornece uma identidade estável a cada item, permitindo que o Compose preserve estado e execute animações corretamente ao reordenar ou atualizar a lista."),
                Opcao(2, "Apenas quando a lista tem menos de 5 itens", 13,
                    "Incorreto. O tamanho da lista não determina a necessidade de key; o que importa é a mutabilidade e identidade dos itens."),
                Opcao(3, "Somente em telas sem scroll", 13,
                    "Incorreto. key é especialmente relevante em listas com scroll onde itens podem ser reordenados."),
                Opcao(4, "Somente em componentes Material 3", 13,
                    "Incorreto. key funciona independentemente do sistema de design utilizado.")
            ),
            respostaCorreta = 1,
            nivel = 3
        ),
        Questao(
            id = 14,
            pergunta = "Qual abordagem é mais adequada para coletar um Flow no Compose respeitando o ciclo de vida?",
            opcoes = listOf(
                Opcao(1, "collectAsStateWithLifecycle", 14,
                    "Correto! collectAsStateWithLifecycle coleta o Flow seguindo o ciclo de vida do composable, pausando a coleta quando a UI vai para background e retomando quando volta ao foreground."),
                Opcao(2, "runBlocking dentro do composable", 14,
                    "Incorreto. runBlocking bloqueia a thread principal, causando travamentos e violações de desempenho (ANR)."),
                Opcao(3, "GlobalScope.launch no composable", 14,
                    "Incorreto. GlobalScope ignora o ciclo de vida e pode causar vazamentos de memória e coroutines órfãs."),
                Opcao(4, "Thread.sleep para aguardar emissões", 14,
                    "Incorreto. Thread.sleep bloqueia a thread e não é uma abordagem reativa; nunca deve ser usado no contexto de UI.")
            ),
            respostaCorreta = 1,
            nivel = 3
        ),
        Questao(
            id = 15,
            pergunta = "Em termos de performance, por que estabilidade e imutabilidade podem ser importantes no Compose?",
            opcoes = listOf(
                Opcao(1, "Porque impedem qualquer recomposição", 15,
                    "Incorreto. Estabilidade não impede recomposições; ela apenas permite que o Compose as pule quando os parâmetros não mudaram."),
                Opcao(2, "Porque ajudam o Compose a decidir melhor quando pode pular recomposições", 15,
                    "Correto! Tipos estáveis e imutáveis permitem que o compilador do Compose marque funções como 'skippable', otimizando a performance ao evitar recomposições desnecessárias."),
                Opcao(3, "Porque tornam obrigatório o uso de XML", 15,
                    "Incorreto. Compose é totalmente declarativo em Kotlin; estabilidade não tem relação com XML."),
                Opcao(4, "Porque eliminam a necessidade de estado", 15,
                    "Incorreto. Estado ainda é necessário no Compose; estabilidade melhora apenas como o runtime lida com ele.")
            ),
            respostaCorreta = 2,
            nivel = 3
        )
    )
}
