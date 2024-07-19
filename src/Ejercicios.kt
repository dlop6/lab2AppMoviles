class Ejercicios {

//    Escriba una función calcularPromedio que tome una lista de números y devuelva su
//    promedio. Utilice la función de reducción para calcular la suma de los elementos.

    fun calcularPromedio(nums: List<Int>): Double {
        if (nums.isEmpty()) {
            throw IllegalArgumentException("La lista no puede estar vacía")
        }
        val suma = nums.reduce { acc, num -> acc + num }

        return suma.toDouble() / nums.size
    }

//    ● Cree una lista de enteros, luego use la función de filter para extraer números impares y
//    almacenarlos en una nueva lista.

    fun obtenerImpares(nums: List<Int>) {
        val impares = nums.filter { it % 2 != 0 }
        println(impares)

    }
//    ● Escriba una función compacta isPalindrome que tome una cadena como entrada y
//    devuelva verdadero si es un palíndromo (lee lo mismo hacia atrás que hacia adelante), y
//    falso de lo contrario.

    fun isPalindrome(palabra: String): Boolean = palabra == palabra.reversed()


//    ● Defina una función performOperation que tome dos enteros y una lambda como
//    parámetros. La lambda debe representar una operación matemática (por ejemplo, suma,
//    resta). La función debe devolver el resultado de la operación en los dos enteros.

    fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }


//
//    ● Defina dos clases

    fun personStudent(){
        data class Person(val name: String, val age: Int, val gender: String)

        data class Student(val name: String, val age: Int, val gender: String, val
        studentId: String)

        val persons = listOf( Person("Alice", 30, "F"),  Person("Bob", 25, "M"),
            Person("Charlie", 35, "M")
        )

        val students = persons.mapIndexed{index, person ->
        Student(name=person.name, age=person.age, gender=person.gender, studentId=(index+1).toString())
        }

        val texto = students.map{"El estudiante ${it.name} tiene ${it.age} años"}
        texto.forEach{println(it)}
    }

    fun agregarSaludo() {
        val nombres = listOf("Alicia", "Bruno", "Carlos", "Diana")
        val saludos = nombres.map { nombre -> "¡Hola, $nombre!" }

        saludos.forEach { println(it) }
    }


//



}