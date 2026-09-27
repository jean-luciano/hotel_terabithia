fun agendamento_eventos() {

    println()
    println("===== EVENTOS - HOTEL SEREITEI =====")

    // =========================================================
    // PARTE A - CAPACIDADE E SELEÇÃO DO AUDITÓRIO
    // =========================================================

    println("Qual o número de convidados do evento?")
    val n_convidados = readln().toIntOrNull()

    if (n_convidados == null || n_convidados < 0) {
        println("Número de convidados inválido")
        return
    }

    if (n_convidados > 350) {
        println("Número de convidados inválido")
        return
    }

    var auditorio: String
    var cadeiras_extras = 0

    if (n_convidados <= 150) {

        auditorio = "Laranja"

        println("O evento será realizado no Auditório Laranja.")

    } else if (n_convidados <= 220) {

        auditorio = "Laranja"

        cadeiras_extras = n_convidados - 150

        println("O evento será realizado no Auditório Laranja.")
        println("Serão necessárias $cadeiras_extras cadeiras adicionais.")

    } else {

        auditorio = "Colorado"

        println("O evento será realizado no Auditório Colorado.")
    }


    // =========================================================
    // PARTE B - AGENDA E DISPONIBILIDADE
    // =========================================================

    println()
    println("===== AGENDA DO EVENTO =====")

    println("Qual o dia do evento?")
    println("Digite o dia da semana em letras minúsculas e sem acentos.")
    val dia_evento = readln().lowercase()

    println("Qual a hora inicial do evento?")
    val hora_inicio = readln().toIntOrNull()

    if (hora_inicio == null) {
        println("Hora inicial inválida.")
        return
    }

    println("Qual a duração do evento? (1 a 12 horas)")
    val duracao_evento = readln().toIntOrNull()

    if (duracao_evento == null || duracao_evento < 1 || duracao_evento > 12) {
        println("Duração inválida. A duração deve estar entre 1 e 12 horas.")
        return
    }

    val hora_fim = hora_inicio + duracao_evento

    // Define o horário máximo de acordo com o dia
    val hora_abertura = 7
    val hora_fechamento: Int

    when (dia_evento) {

        "segunda",
        "terca",
        "quarta",
        "quinta",
        "sexta" -> {
            hora_fechamento = 23
        }

        "sabado",
        "domingo" -> {
            hora_fechamento = 15
        }

        else -> {
            println("Dia da semana inválido.")
            return
        }
    }

    // Verifica se o horário está dentro da janela permitida
    if (hora_inicio < hora_abertura || hora_fim > hora_fechamento) {

        println("O auditório não está disponível nesse horário.")
        println("Horário solicitado: $hora_inicio às $hora_fim horas.")
        println("Horário disponível para $dia_evento: $hora_abertura às $hora_fechamento horas.")

        return
    }

    println("O auditório está disponível!")

    println("Qual o nome da empresa?")
    val nome_empresa = readln()

    println()
    println(
        "Auditório reservado para $nome_empresa: " +
                "$dia_evento às $hora_inicio horas."
    )


    // =========================================================
    // PARTE C - EQUIPE DE GARÇONS
    // =========================================================

    println()
    println("===== EQUIPE DE GARÇONS =====")

    // Cada 12 convidados precisam de 1 garçom.
    // A fórmula abaixo arredonda para cima.
    val garcons_base = (n_convidados + 11) / 12

    // A cada duas horas, adiciona mais um garçom.
    val garcons_extras = duracao_evento / 2

    val total_garcons = garcons_base + garcons_extras

    val custo_garcom_hora = 10.50

    val custo_garcons =
        total_garcons * duracao_evento * custo_garcom_hora

    println("Garçons necessários: $total_garcons")
    println("Custo dos garçons: R$ %.2f".format(custo_garcons))


    // =========================================================
    // PARTE D - BUFFET
    // =========================================================

    println()
    println("===== BUFFET =====")

    // Quantidades por convidado
    val cafe_por_pessoa = 0.2
    val agua_por_pessoa = 0.5
    val salgados_por_pessoa = 7

    // Valores
    val valor_cafe_litro = 0.80
    val valor_agua_litro = 0.40
    val valor_cento_salgados = 34.00

    // Quantidades totais
    val total_cafe = cafe_por_pessoa * n_convidados
    val total_agua = agua_por_pessoa * n_convidados
    val total_salgados = salgados_por_pessoa * n_convidados

    // Custos
    val custo_cafe =
        total_cafe * valor_cafe_litro

    val custo_agua =
        total_agua * valor_agua_litro

    // R$ 34,00 corresponde a 100 salgados
    val custo_salgados =
        (total_salgados / 100.0) * valor_cento_salgados

    val custo_buffet =
        custo_cafe + custo_agua + custo_salgados

    println("Quantidade de café: %.2f litros".format(total_cafe))
    println("Quantidade de água: %.2f litros".format(total_agua))
    println("Quantidade de salgados: $total_salgados unidades")

    println("Custo do café: R$ %.2f".format(custo_cafe))
    println("Custo da água: R$ %.2f".format(custo_agua))
    println("Custo dos salgados: R$ %.2f".format(custo_salgados))
    println("Custo total do buffet: R$ %.2f".format(custo_buffet))


    // =========================================================
    // PARTE E - RELATÓRIO E DECISÃO
    // =========================================================

    val valor_total =
        custo_garcons + custo_buffet

    println()
    println("======================================")
    println("       RELATÓRIO DO EVENTO")
    println("======================================")

    println("Auditório: $auditorio")
    println("Empresa: $nome_empresa")
    println("Data: $dia_evento")
    println("Hora inicial: $hora_inicio horas")
    println("Hora final: $hora_fim horas")
    println("Duração: $duracao_evento horas")
    println("Quantidade de convidados: $n_convidados")
    println("Quantidade de garçons: $total_garcons")

    if (cadeiras_extras > 0) {
        println("Cadeiras adicionais: $cadeiras_extras")
    }

    println("Custo dos garçons: R$ %.2f".format(custo_garcons))
    println("Custo do buffet: R$ %.2f".format(custo_buffet))
    println("Valor total do evento: R$ %.2f".format(valor_total))

    println()
    println("Gostaria de efetuar a reserva? S/N")

    val escolha = readln().uppercase()

    when (escolha) {

        "S" -> {
            println()
            println("Reserva efetuada com sucesso.")
        }

        "N" -> {
            println()
            println("Reserva não efetuada.")
        }

        else -> {
            println()
            println("Opção inválida.")
        }
    }
}