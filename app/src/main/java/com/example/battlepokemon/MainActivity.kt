

// Tipo agua --> 2xFuego, 1xElectrico, 0,5xPlanta, 0,5xAgua
// Tipo fuego --> 2xPlanta, 0,5xAgua, 1xElectrico, 0,5xFuego
// Tipo planta --> 2xAgua, 0,5xFuego, 0,5xPlanta, 1xElectrico
// Tipo electrico --> 1xFuego, 2xAgua, 0,5xPlanta, 0,5xElectrico

/** BATALLA POKÉMON
* Dificultad: MEDIA
*
* Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
* - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
* - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
* - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
* - El programa recibe los siguientes parámetros:
*  - Tipo del Pokémon atacante.
 - Tipo del Pokémon defensor.
  - Ataque: Entre 1 y 100.
  - Defensa: Entre 1 y 100.*/

package com.example.battlepokemon



import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pokemon1 = Pokemon("Picachu", Tipo.Electrico, 50, 50, 100)
        var pokemon2 = Pokemon("Charmander", Tipo.Fuego, 50, 60, 100)
        var pokemon3 = Pokemon("Bulbasaur", Tipo.Planta, 50, 50, 100)
        var pokemon4 = Pokemon("Squirtle", Tipo.Agua, 50, 50, 100)

        println("ESTO ES UNA BATALLA POKEMON")
        println("${pokemon1.nombre} vs ${pokemon2.nombre}")
        println("-----------------------------------------------")
        println(
            "Nombre: ${pokemon1.nombre}\n" +
                    "Tipo: ${pokemon1.tipo}\n" +
                    "Ataque: ${pokemon1.ataque}\n" +
                    "Defensa: ${pokemon1.defensa}\n" +
                    "Vida:${pokemon1.vida}"
        )
        println("--------------------VS--------------------------")
        println(
            "Nombre: ${pokemon2.nombre}\n" +
                    "Tipo: ${pokemon2.tipo}\n" +
                    "Ataque: ${pokemon2.ataque}\n" +
                    "Defensa: ${pokemon2.defensa}\n" +
                    "Vida:${pokemon2.vida}"
        )
        println("-----------------------------------------------")

        atacar(pokemon1, pokemon2)
    }

        fun atacar(pokemon1: Pokemon, pokemon2: Pokemon) {
            var primerturno: Pokemon
            var segundoturno: Pokemon
            if (pokemon1.ataque >= pokemon2.ataque) {
                primerturno = pokemon1
                segundoturno = pokemon2
            } else {
                primerturno = pokemon2
                segundoturno = pokemon1
            }

            //Ataque turno 1
            println("${primerturno.nombre} empieza la batalla")
            println("-----------------------------------------------")
            println("${primerturno.nombre} ataca a ${segundoturno.nombre}")
            var efectividad = 0.0

            when (primerturno.tipo) {
                Tipo.Agua -> {
                    if (segundoturno.tipo == Tipo.Fuego) {
                        efectividad = 2.0
                        println("${primerturno.nombre} es muy efectivo contra ${segundoturno.nombre} !!")
                    } else if (segundoturno.tipo == Tipo.Planta) {
                        efectividad = 1.0
                        println("${primerturno.nombre} es efectivo contra ${segundoturno.nombre}")
                    } else if (segundoturno.tipo == Tipo.Electrico) {
                        efectividad = 0.5
                        println("${primerturno.nombre} ...no es muy efectivo contra ${segundoturno.nombre}...")
                    }
                }
                Tipo.Fuego -> {
                    if (segundoturno.tipo == Tipo.Planta) {
                        efectividad = 2.0
                        println("${primerturno.nombre} es muy efectivo contra ${segundoturno.nombre}")
                    } else if (segundoturno.tipo == Tipo.Agua) {
                        efectividad = 1.0
                        println("${primerturno.nombre} es efectivo contra ${segundoturno.nombre}")
                    } else if (segundoturno.tipo == Tipo.Electrico) {
                        efectividad = 0.5
                        println("${primerturno.nombre} no es muy efectivo contra ${segundoturno.nombre}")
                    }
                }
                Tipo.Planta -> {
                    if (segundoturno.tipo == Tipo.Agua) {
                        efectividad = 2.0
                        println("${primerturno.nombre} es muy efectivo contra ${segundoturno.nombre}")
                    } else if (segundoturno.tipo == Tipo.Fuego) {
                        efectividad = 1.0
                        println("${primerturno.nombre} es efectivo contra ${segundoturno.nombre}")
                    } else if (segundoturno.tipo == Tipo.Electrico) {
                        efectividad = 0.0
                        println("${primerturno.nombre} no es muy efectivo contra ${segundoturno.nombre}")
                    }
                }
                Tipo.Electrico -> {
                    if (segundoturno.tipo == Tipo.Fuego) {
                        efectividad = 2.0
                        println("${primerturno.nombre} es muy efectivo contra ${segundoturno.nombre}")

                    } else if (segundoturno.tipo == Tipo.Agua) {
                        efectividad = 1.0
                        println("${primerturno.nombre} es efectivo contra ${segundoturno.nombre}")
                    } else if (segundoturno.tipo == Tipo.Planta) {
                        efectividad = 0.5
                        println("${primerturno.nombre} no es muy efectivo contra ${segundoturno.nombre}")
                    }
                }
            }
            var daño: Double = 50*(primerturno.ataque.toFloat()/segundoturno.defensa.toFloat())*efectividad
            println("El daño infringido por ${primerturno.nombre} es $daño")
            segundoturno.vida -= daño.toInt()
            println("${segundoturno.nombre} tiene ${segundoturno.vida} de vida")

            println("-----------------------------------------------")

            //Ataque turno 2
            println("Es el turno de ${segundoturno.nombre}")
            println("${segundoturno.nombre} ataca a ${primerturno.nombre}")

            when (segundoturno.tipo) {
                Tipo.Agua -> {
                    if (primerturno.tipo == Tipo.Fuego) {
                        efectividad = 2.0
                        println("${segundoturno.nombre} es muy efectivo contra ${primerturno.nombre} !!")
                    } else if (primerturno.tipo == Tipo.Planta) {
                        efectividad = 1.0
                        println("${segundoturno.nombre} es efectivo contra ${primerturno.nombre}")
                    } else if (primerturno.tipo == Tipo.Electrico) {
                        efectividad = 0.5
                        println("${segundoturno.nombre} ...no es muy efectivo contra ${primerturno.nombre}...")
                    }
                }
                Tipo.Fuego -> {
                    if (primerturno.tipo == Tipo.Planta) {
                        efectividad = 2.0
                        println("${segundoturno.nombre} es muy efectivo contra ${primerturno.nombre}")
                    } else if (primerturno.tipo == Tipo.Agua) {
                        efectividad = 1.0
                        println("${segundoturno.nombre} es efectivo contra ${primerturno.nombre}")
                    } else if (primerturno.tipo == Tipo.Electrico) {
                        efectividad = 0.5
                        println("${segundoturno.nombre} no es muy efectivo contra ${primerturno.nombre}")
                    }
                }
                Tipo.Planta -> {
                    if (primerturno.tipo == Tipo.Agua) {
                        efectividad = 2.0
                        println("${segundoturno.nombre} es muy efectivo contra ${primerturno.nombre}")
                    } else if (primerturno.tipo == Tipo.Fuego) {
                        efectividad = 1.0
                        println("${segundoturno.nombre} es efectivo contra ${primerturno.nombre}")
                    } else if (primerturno.tipo == Tipo.Electrico) {
                        efectividad = 0.5
                        println("${segundoturno.nombre} no es muy efectivo contra ${primerturno.nombre}")
                    }
                }
                Tipo.Electrico -> {
                    if (primerturno.tipo == Tipo.Fuego) {
                        efectividad = 2.0
                        println("${segundoturno.nombre} es muy efectivo contra ${primerturno.nombre}")

                    } else if (primerturno.tipo == Tipo.Agua) {
                        efectividad = 1.0
                        println("${segundoturno.nombre} es efectivo contra ${primerturno.nombre}")
                    } else if (primerturno.tipo == Tipo.Planta) {
                        efectividad = 0.5
                        println("${segundoturno.nombre} no es muy efectivo contra ${primerturno.nombre}")
                    }
                }
            }

            var daño2: Double = 50*(primerturno.ataque.toFloat()/segundoturno.defensa.toFloat())*efectividad
            println("El daño infringido por ${segundoturno.nombre} es $daño2")
            primerturno.vida -= daño2.toInt()
            println("${primerturno.nombre} tiene ${primerturno.vida} de vida")
        }

    }



