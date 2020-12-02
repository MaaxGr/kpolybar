package gr.maax.kpolybar

import kotlin.reflect.KProperty

class PolybarProperty<T>(
    private val propertyName: String,
    private val defaultValue: T,
    private val collector: Collector
) {

    private var value: T

    init {
        this.value = defaultValue
        this.collector.configMap[propertyName] = defaultValue.toString()
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return this.value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
        this.collector.configMap[propertyName] = value.toString()
    }

}