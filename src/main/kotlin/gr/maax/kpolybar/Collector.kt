package gr.maax.kpolybar

class Collector {

    val configMap = mutableMapOf<String, String>()

    fun <T> prop(propertyName: String, defaultValue: T): PolybarProperty<T> {
        return PolybarProperty(propertyName, defaultValue, this)
    }

}