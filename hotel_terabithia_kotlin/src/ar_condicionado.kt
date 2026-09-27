fun ar_condicionado() {
    println("MANUTENÇÃO DE AR CONDICIONADO - HOTEL SEREITEI!")

    println ("Qual o nome da sua empresa?")
    val nome_empresa = readln()

    println("Qual o valor por aparelho?")
    val valor_aparelhos = readln().toDouble()

    println("Qual a quantidade de aparelhos?")
    val quantidade_aparelhos = readln().toInt()

    println("Qual a porcentegem de desconto?")
    val porcentagem_desconto = readln().toDouble()

    println("Qual o número mínimo de aparelhos para conseguir o desconto?")
    val numero_min = readln().toInt()

    val valor_total = quantidade_aparelhos * valor_aparelhos
    val valor_desconto = valor_total * (porcentagem_desconto / 100)
    val valor_com_desconto = valor_total - valor_desconto

    if (quantidade_aparelhos >= numero_min) {
    println("O serviço de $nome_empresa custará R$ $valor_com_desconto reais")
    } else {
        println("O serviço de $nome_empresa custará, sem desconto, R$ $valor_total")
    }

    println("Deseja informar novos dados $nomeUsuario? S/N")

    val escolha = readln().uppercase()

    when (escolha) {
        "S" -> ar_condicionado()
        "N" -> main()

        else ->{
            println("Desculpe, mas não compreendi.")
        }
    }
}
