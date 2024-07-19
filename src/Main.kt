import java.util.Scanner

fun main() {
    val ejercicios = Ejercicios()
    val scanner = Scanner(System.`in`)
    var opcion: Int = -1  // Inicializar con un valor que garantice que el bucle se ejecute

    do {
        println("\n--- Menú ---")
        println("1. Calcular Promedio")
        println("2. Obtener Números Impares")
        println("3. Verificar Palíndromo")
        println("4. Agregar Saludo")
        println("5. Realizar Operación Matemática")
        println("6. Person to Student")
        println("0. Salir")
        print("Seleccione una opción: ")

        // Manejo de posibles errores en la lectura de la opción
        opcion = try {
            scanner.nextInt()
        } catch (e: Exception) {
            scanner.nextLine() // Limpiar el buffer del scanner
            println("Entrada inválida. Por favor ingrese un número.")
            continue
        }

        // Limpiar el buffer del scanner para leer la siguiente línea correctamente
        scanner.nextLine()

        when (opcion) {
            1 -> {
                print("Ingrese los números separados por espacio: ")
                val nums = scanner.nextLine().split(" ").mapNotNull { it.toIntOrNull() }
                if (nums.isNotEmpty()) {
                    println("Promedio: ${ejercicios.calcularPromedio(nums)}")
                } else {
                    println("No se ingresaron números válidos.")
                }
            }
            2 -> {
                print("Ingrese los números separados por espacio: ")
                val nums = scanner.nextLine().split(" ").mapNotNull { it.toIntOrNull() }
                println("Números impares: ${ejercicios.obtenerImpares(nums)}")
            }
            3 -> {
                print("Ingrese una palabra: ")
                val palabra = scanner.nextLine()
                println("Es palíndromo: ${ejercicios.isPalindrome(palabra)}")
            }
            4 -> {
                ejercicios.agregarSaludo()
            }
            5 -> {
                print("Ingrese el primer número: ")
                val a = try {
                    scanner.nextInt()
                } catch (e: Exception) {
                    scanner.nextLine() // Limpiar el buffer del scanner
                    println("Entrada inválida. Se utilizará 0.")
                    0
                }
                print("Ingrese el segundo número: ")
                val b = try {
                    scanner.nextInt()
                } catch (e: Exception) {
                    scanner.nextLine() // Limpiar el buffer del scanner
                    println("Entrada inválida. Se utilizará 0.")
                    0
                }
                scanner.nextLine() // Limpiar el buffer del scanner
                print("Seleccione la operación (suma/resta): ")
                val operacion = scanner.nextLine()
                val resultado = when (operacion) {
                    "suma" -> ejercicios.performOperation(a, b) { x, y -> x + y }
                    "resta" -> ejercicios.performOperation(a, b) { x, y -> x - y }
                    else -> {
                        println("Operación no válida")
                        continue
                    }
                }
                println("Resultado: $resultado")
            }
            6 -> {
                ejercicios.personStudent()
            }
            0 -> {
                println("Saliendo...")
            }
            else -> {
                println("Opción no válida")
            }
        }
    } while (opcion != 0)

    scanner.close()
}
