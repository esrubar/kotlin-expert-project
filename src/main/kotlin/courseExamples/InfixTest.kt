package courseExamples

data class Lunch(val name: String, val meal: String)

infix fun String.eats(meal: String) = Lunch(this, meal)

val lunch = Lunch("Tom", "Pizza")
val launch2 = "Tom" eats "Pizza"