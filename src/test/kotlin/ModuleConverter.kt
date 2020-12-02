import gr.maax.kpolybar.utils.times
import org.junit.jupiter.api.Test

class ModuleConverter {

    val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()
    val dashRegex = "-[a-zA-Z]".toRegex()

    @Test
    fun test() {
        val x = "\${xxx}"
        val y = """

        """.trimIndent()

        var convertText = """
            [module/volume1]
            type = internal/volume
            ;speaker-mixer = Speaker
            ;headphone-mixer = Headphone
            ;headphone-id = 9

            format-volume = <ramp-volume>  <label-volume>
            label-muted =   muted
            label-muted-foreground = #66

            ramp-volume-0 = 
            ramp-volume-1 = 
            ramp-volume-2 = 
            ramp-volume-3 = 
        """.trimIndent()

        convertText
            .split(System.lineSeparator())
            .filter { !it.startsWith("[") }
            .filter { !it.startsWith(";") }
            .filter { it.trim().isNotEmpty() }
            .joinToString(System.lineSeparator() * 2) { line ->

                var name = ""
                var value = ""
                try {
                    val (a, b) = line.split("=").map { it.trim() }
                    name = a
                    value = b
                } catch (ex: Exception) {
                    println("LINE: $line")
                    ex.printStackTrace()
                }

                val variableName = name.snakeToLowerCamelCase()

                val completeValue = value.toIntOrNull()
                    ?: value.let {
                        if (it == "true" || it == "false") {
                            it.toBoolean()
                        } else {
                            "\"${it.replace("\"", "\\\"")}\""
                        }
                    }

                """
                    private val $variableName by collector.prop(
                        propertyName = "$name",
                        defaultValue = $completeValue,
                    )
                """.trimIndent()
            }
            .also { println(it) }

    }

    fun String.snakeToLowerCamelCase(): String {
        return dashRegex.replace(this) {
            it.value.replace("-","")
                .toUpperCase()
        }
    }

}