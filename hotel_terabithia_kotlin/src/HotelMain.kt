var nomeUsuario: String = ""

fun main() {


    // Função principal que chama a função inicio().
    inicio()
}

fun inicio() {
    print("Bem vindo ao HOTEL SEREITEI!\n")
    println ("Por favor, digite o nome de usuário: ")
    nomeUsuario = readln()

    var tentativas = 0
    val senhaCorreta = "2678"

    while (tentativas < 3) {
        print("Agora digite sua senha: ")
        val senha = readln()

        if (senha == senhaCorreta) {
            println()
            println("Bem-vindo ao Hotel Sereitei, $nomeUsuario. É um imenso prazer ter você por aqui!")
            menuPrincipal(nomeUsuario)
            return
        } else {
            tentativas++

            if (tentativas < 3) {
                println("Senha incorreta. Tentativas restantes: ${3 - tentativas}")
            }
        }
    }

    println("Sistema bloqueado. Você excedeu o limite de 3 tentativas.")
}

fun menuPrincipal (nome: String) {
    println()
    println("Escolha uma opção:")
    println("1-) Reserva de Quartos")
    println("2-) Cadastro de Hóspedes")
    println("3-) Agendamento de Eventos")
    println("4-) Ar condicionado")
    println("5-) Abastecimento de Carros")
    println("6-)Sair")

    val escolha = readln().toIntOrNull()
    when (escolha) {
        1 -> cadastrar_quartos()
        2 -> cadastro_hospedes()
        3 -> agendamento_eventos()
        4 -> ar_condicionado()
        5 -> abastecimento_carros()
        6 -> sairDoHotel()

        // 1 -> cadastrarQuartos() // Antigo, não quero perder
        //        2 -> CadastroHospedes()
        //        3 -> CadastroHospedesDataClass()
        //        4 -> AbastecimentoDeAutomoveis()
        //        5 -> sairDoHotel()
        else -> erro()
    }
}

fun erro(){
    println("Por favor, informe um número entre 1 e 6.")
    inicio()
}

fun sairDoHotel() {
    println("Você deseja sair?")
    val confirma = readln().toBoolean()
    if (confirma) {
        println("Até logo!")
    } else {
        inicio()
    }
}
