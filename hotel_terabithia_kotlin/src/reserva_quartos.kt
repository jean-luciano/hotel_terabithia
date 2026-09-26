fun cadastrar_quartos() {
    println("RESERVA DE QUARTOS - HOTEL SEREITEI")

    println("Qual o valor padrão da diária: ")
    val valor_diaria = readln().toDouble()

    if (valor_diaria >0) {
        println ("Quantos dias pretende passar em nosso hotel?")
        val numero_diarias = readln().toInt()

        if (numero_diarias > 0) {
            val total = valor_diaria * numero_diarias
            println("O valor de $numero_diarias dias em nosso hotel, é de R$ $total")

            println("Qual o nome do hospede?")
            val nome_hospede: String = readln()

            println("Qual o tipo de quarto?")
            println("S - Standard")
            println("E - Executivo")
            println("L - Luxo")

            val tipo_quarto = readln().uppercase()

            val fator = when (tipo_quarto) {
                "S" -> 1.00
                "E" -> 1.35
                "L" -> 1.65
                else -> {
                    println ("Tipo de quarto Inválido, $nomeUsuario")
                    return
                }
            }


            println("Qual quarto gostaria de reservar? (1-20)?")
            val numero_quarto = readln().toInt()

            if (numero_quarto > 0 && numero_quarto <20) {
                println("O quarto está disponivel!")
                println("$nomeUsuario, você confirma a hospedagem para $nome_hospede por $numero_diarias para o quarto $numero_quarto por R$ $valor_diaria? S/N")
                val escolha = readln().uppercase()

                when (escolha) {
                    "S" -> {
                        println("$nomeUsuario, reserva efetuada para $nome_hospede.")
                        println("Lista de quartos ja ocupados: Quarto numero $numero_quarto ocupado.")
                    }
                    "N" -> main()
                    else -> {
                        println("Desculpe, mas não compreendi")
                        cadastrar_quartos()
                    }
                }
            } else {
                println ("Valor inválido, $nomeUsuario")
                cadastrar_quartos()
            }
        }
    } else {
        println ("Valor Inválido, $nomeUsuario")
        cadastrar_quartos()
    }
}
