package gr.maax.kpolybar.conditions

class ConditionBuilder {

    private val conditions = mutableListOf<String>()

    fun success(command: String) {
        conditions.add("$command > /dev/null")
    }

    fun gt(command: String, number: Int) {
        conditions.add("[ \$($command) -gt $number ]")
    }

    fun build(): String {
        val conditionsString = conditions
            .joinToString(" && ")
            .replace("\"", "\\")

        return  "\"$conditionsString || exit 1\""
    }

}