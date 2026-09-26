import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Hospede(
    var nome: String,
    val data_cadastro: LocalDateTime
)

val lista_hospedes = mutableListOf<Hospede>()

fun cadastro_hospedes() {

    while (true) {

        println("CADASTRO DE HÓSPEDES - HOTEL SEREITEI!")
        println("1 - Cadastrar")
        println("2 - Pesquisar por nome exato")
        println("3 - Pesquisar por prefixo")
        println("4 - Listar ordenado (A-Z)")
        println("5 - Atualizar cadastro")
        println("6 - Remover cadastro")
        println("7 - Sair")

        val escolha = readln().toIntOrNull()

        when (escolha) {

            1 -> {
                if (lista_hospedes.size >= 15) {
                    println("Máximo de cadastros atingido")
                } else {

                    println("Qual o nome do hóspede?")
                    val nome = readln()

                    var existe = false

                    for (hospede in lista_hospedes) {
                        if (hospede.nome.equals(nome, ignoreCase = true)) {
                            existe = true
                            break
                        }
                    }

                    if (existe) {
                        println("Esse hospede já foi cadastrado!")
                    } else {

                        val novo_hospede = Hospede(
                            nome,
                            LocalDateTime.now()
                        )

                        lista_hospedes.add(novo_hospede)

                        println("Operação realizada com sucesso")
                    }
                }
            }

            2 -> {
                println("Digite o nome do hóspede:")
                val nome_pesquisa = readln()

                var encontrado = false

                for (hospede in lista_hospedes) {

                    if (hospede.nome.equals(nome_pesquisa, ignoreCase = true)) {
                        println("Hóspede ${hospede.nome} foi encontrado")
                        encontrado = true
                        break
                    }
                }

                if (!encontrado) {
                    println("Hóspede não encontrado")
                }
            }

            3 -> {
                println("Digite o início do nome que deseja pesquisar:")
                val prefixo = readln()

                var encontrado = false

                for (hospede in lista_hospedes) {

                    if (hospede.nome.startsWith(prefixo, ignoreCase = true)) {
                        println(hospede.nome)
                        encontrado = true
                    }
                }

                if (!encontrado) {
                    println("Hóspede não encontrado")
                }
            }

            4 -> {

                if (lista_hospedes.isEmpty()) {
                    println("Hóspede não encontrado")
                } else {

                    val hospedesOrdenados = lista_hospedes.sortedBy {
                        it.nome.uppercase()
                    }

                    val formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

                    println()
                    println("===== HÓSPEDES CADASTRADOS =====")

                    var indice = 0

                    for (hospede in hospedesOrdenados) {

                        println(
                            "$indice - ${hospede.nome} - " +
                                    hospede.data_cadastro.format(formato)
                        )

                        indice++
                    }
                }
            }

            5 -> {

                if (lista_hospedes.isEmpty()) {
                    println("Hóspede não encontrado")
                } else {

                    val hospedesOrdenados = lista_hospedes.sortedBy {
                        it.nome.uppercase()
                    }

                    println()
                    println("===== HÓSPEDES CADASTRADOS =====")

                    var indice = 0

                    for (hospede in hospedesOrdenados) {
                        println("$indice - ${hospede.nome}")
                        indice++
                    }

                    println()
                    println("Digite o índice do hóspede que deseja atualizar:")

                    val indice_escolhido = readln().toIntOrNull()

                    if (
                        indice_escolhido == null ||
                        indice_escolhido < 0 ||
                        indice_escolhido >= hospedesOrdenados.size
                    ) {

                        println("Hóspede não encontrado")

                    } else {

                        println("Digite o novo nome:")
                        val novoNome = readln()

                        var nomeDuplicado = false

                        for (hospede in lista_hospedes) {

                            if (
                                hospede.nome.equals(novoNome, ignoreCase = true) &&
                                hospede !== hospedesOrdenados[indice_escolhido]
                            ) {
                                nomeDuplicado = true
                                break
                            }
                        }

                        if (nomeDuplicado) {

                            println("Hóspede já cadastrado")

                        } else {

                            hospedesOrdenados[indice_escolhido].nome = novoNome

                            println("Operação realizada com sucesso")
                        }
                    }
                }
            }

            6 -> {

                if (lista_hospedes.isEmpty()) {
                    println("Hóspede não encontrado")
                } else {

                    val hospedes_ordenados = lista_hospedes.sortedBy {
                        it.nome.uppercase()
                    }

                    println()
                    println("===== HÓSPEDES CADASTRADOS =====")

                    var indice = 0

                    for (hospede in hospedes_ordenados) {
                        println("$indice - ${hospede.nome}")
                        indice++
                    }

                    println()
                    println("Digite o índice do hóspede que deseja remover:")

                    val indice_escolhido = readln().toIntOrNull()

                    if (
                        indice_escolhido == null ||
                        indice_escolhido < 0 ||
                        indice_escolhido >= hospedes_ordenados.size
                    ) {

                        println("Hóspede não encontrado")

                    } else {

                        lista_hospedes.remove(
                            hospedes_ordenados[indice_escolhido]
                        )

                        println("Operação realizada com sucesso")
                    }
                }
            }

            7 -> {
                 return
            }

            else -> {
                println("Opção inválida")
            }
        }
    }
}
