fun abastecimento_carros() {

    println("Qual o valor do álcool no posto Wayne Oil?")
    val wayne_alcool = readln().toDouble()

    println ("Qual o valor da gasolina no posto Wayne Oil?")
    val wayne_gasolina = readln().toDouble()

    println("Qual o valor do álcool no posto Stark Petrol?")
    val stark_alcool = readln().toDouble()

    println ("Qual o valor da gasolina no posto Stark Petrol?")
    val stark_gasolina = readln().toDouble()

    val wayne_divi = wayne_alcool / wayne_gasolina

    val stark_divi = stark_alcool / stark_gasolina

    if (wayne_divi <= 0.7 && stark_divi <= 0.7) {
        if (wayne_alcool < stark_alcool) {
            println("$nomeUsuario, é mais barato abastecer com álcool no posto Wayne Oil")
        } else {
            println("$nomeUsuario, é mais barato abastecer com álcool no posto Stark Petrol")
        }
    } else if (wayne_divi <= 0.7){
        println("$nomeUsuario é mais barato abastecer com álcool no posto Wayne Oil")
    } else {
        if (stark_divi <= 0.7) {
            println ("É mais barato abastecer com álcool no posto Stark Petrol")
        } else {
            if (wayne_gasolina < stark_alcool) {
                println ("$nomeUsuario, é mais barato abastecer com gasolina no posto Wayne Oil")
            } else {
                println("$nomeUsuario, é mais barato abastecer com gasolina no posto Stark Petrol")
            }
        }
    }
    main()
}