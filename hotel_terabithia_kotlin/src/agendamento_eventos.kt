fun agendamento_eventos() {
    println ("EVENTOS - HOTEL SEREITEI")
    println ("QUal o número de convidados do evento?")
    val n_convidados = readln().toInt()

    val n_cadeiras = 220 - n_convidados

    val buffet_evento = {
        val cafe = 0.2
        val agua = 0.5
        val salgados = 7

        val valor_cafe = 0.80
        val valor_agua = 0.40
        val valor_salgados = 34

        val total_cafe = cafe * n_convidados
        val total_agua = agua * n_convidados
        val total_salgados = salgados * n_convidados

        val valor_cafe_total = total_cafe * valor_cafe
        val valor_agua_total = total_agua * valor_agua
        val valor_salgado_total = total_salgados * valor_salgados

        val valor_total = valor_cafe_total + valor_agua_total + valor_salgados

        println ("O evento precisará de $total_cafe litros de café, $total_agua litros de água, $total_salgados salgados.")
        println("São portanto necessários, R$ $valor_cafe_total de café, R$ $valor_agua_total de aguá e R$ $valor_salgado_total de salgados")

        valor_total


    }

    val evento_trabalho = {
        val custo_hora = 10.5

        println ("Qual a duração do evento? (Em horas por favor)")
        val duracao_evento = readln().toInt()

        val garcons_contratados = (n_convidados + 11) / 12
        val garcons_extras = duracao_evento / 2

        val total_garcons = garcons_contratados + garcons_extras
        val custo_total = total_garcons * custo_hora * duracao_evento

        println("Total de garçons necessários: $total_garcons")
        println ("Custo total com garçons: R$ $custo_total")

        custo_total

    }

    val agendamento_evento = {

        println("Agora vamos agendar o evento!")
        println("Qual o dia do evento?")
        val dia_evento = readln().toInt()

        println ("Qual o horário desejado?")
        val hora_evento = readln()

        println ("Qual o nome da empresa?")
        val nome_empresa = readln()

        println("Auditório reservado para a empresa: $nome_empresa no $dia_evento às $hora_evento")
        val custo_buffet = buffet_evento()
        val custo_garcons = evento_trabalho()
        val valor_total_total = custo_buffet + custo_garcons //Não consegui ajeitar

        println("Relátório de custos do evento:")
        println("Nome da empresa: $nome_empresa")
        println("Data: Dia $dia_evento, às $hora_evento")
        println("Quantidade de convidados: $n_convidados")
        println("Custo dos garçons para o evento: R$ $custo_garcons")
        println("Custo do Buffet para o evento: R$ $custo_buffet")
        println("Valor total do evento: R$ $valor_total_total")

        println ("Gostaria de efetuar a reserva? (S/N)")
        val escolha = readln().uppercase()
        when (escolha) {
            "S" -> println(" $nomeUsuario, reserva efetuada com sucesso!")
            "N" -> {
                println("Reserva não efetuada!")
                agendamento_eventos()
            }
            else -> {
                println("Desculpe, não consegui compreender.")
                agendamento_eventos()
            }

        }

    }

    if (n_convidados > 350 ) {
        println ("Número de convidados excede o limite permitido!")
        agendamento_eventos()
    } else if (n_convidados <= 0) {
        println("Número de convidados inválido!")
        agendamento_evento()
    }else {
        if (n_convidados > 220) {
            println ("Use o auditório colorado, por favor!")
            agendamento_eventos()
        } else {
            println ("Use o auditório Laranja (inclua mais $n_cadeiras cadeiras!")
            agendamento_eventos()
        }
    }

}




