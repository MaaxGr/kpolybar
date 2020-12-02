package gr.maax.kpolybar.api

import gr.maax.kpolybar.Collector
import gr.maax.kpolybar.DEPLOY_FILE
import gr.maax.kpolybar.PolybarProperty


fun polybar(name: String, configuration: Polybar.() -> Unit) {
    val polybar = Polybar(name)
    configuration(polybar)
    println(polybar.toString())

    DEPLOY_FILE.writeText(polybar.toString())
}

class Polybar(
    private val name: String
) {

    private val currentPropertyCollector = Collector()
    private var currentProperties = PolybarProperties(currentPropertyCollector)

    private val currentModules = ModuleConfig()

    fun properties(properties: PolybarProperties.() -> Unit) {
        properties(this.currentProperties)
    }

    fun modules(modules: ModuleConfig.() -> Unit) {
        modules(currentModules)
    }

    override fun toString(): String {
        val propertyString = currentPropertyCollector.configMap
            .map { (k, v) -> "$k = $v" }
            .joinToString(System.lineSeparator())

        val allModules = mutableListOf<Module>().apply {
            addAll(currentModules.leftArea.modules)
            addAll(currentModules.centerArea.modules)
            addAll(currentModules.rightArea.modules)
        }.distinctBy { it.name }

        return """
            |[bar/$name]
            |$propertyString
            |
            |modules-left = ${currentModules.leftArea.modules.map { it.name }.joinToString("  ")}
            |modules-center = ${currentModules.centerArea.modules.map { it.name }.joinToString("  ")}
            |modules-right = ${currentModules.rightArea.modules.map { it.name }.joinToString("  ")}
            |
            |${allModules.map { it.toConfigString() }.joinToString(System.lineSeparator() + System.lineSeparator())}
        """.trimMargin()
    }
}


class PolybarProperties(collector: Collector) {

    var width by PolybarProperty("width", "100%", collector)
    var height by PolybarProperty("height",24, collector)
    var clickareas by PolybarProperty("clickareas",45, collector)
    var trayPosition by PolybarProperty("tray-position","right", collector)
    var trayPadding by PolybarProperty("tray-padding", 0, collector)
    var trayOffsetX by PolybarProperty("tray-offset-x", 0, collector)
    var trayBackground by PolybarProperty("tray-background","#181818", collector)
    var trayTransparent by PolybarProperty("tray-transparent", false, collector)
    var background by PolybarProperty("background", "#181818", collector)
    var backgroundAlt by PolybarProperty("background-alt", "#555", collector)
    var foreground by PolybarProperty("foreground", "#cccccc", collector)
    var foregroundAlt by PolybarProperty("foreground-alt", "#555555", collector)
    var dpi by PolybarProperty("dpi", 190, collector)
    var monitor by PolybarProperty("monitor", "\${env:MONITOR:}", collector)
    var offsetX by PolybarProperty("offset-x", 0, collector)
    var offsetY by PolybarProperty("offset-y", 0, collector)
    var radius by PolybarProperty("radius", 0, collector)
    var borderSize by PolybarProperty("border-size", 0, collector)
    var borderColor by PolybarProperty("border-color", "#000000000", collector)
    var locale by PolybarProperty("locale", "en_US.UTF-8", collector)
    var bottom by PolybarProperty("bottom", true, collector)
    var font0 by PolybarProperty("font-0", "Caskaydia Cove Nerd Font:style=Mono:size=6;3", collector)
    var spacing by PolybarProperty("spacing", 1, collector)
    var underlineSize by PolybarProperty("underline-size", 2, collector)
    var paddingRight by PolybarProperty("padding-right", 0, collector)
    var paddingLeft by PolybarProperty("padding-left", 2, collector)
    var moduleMarginLeft by PolybarProperty("module-margin-left", 0, collector)
    var moduleMarginRight by PolybarProperty("module-margin-right", 0, collector)


}

class ModuleConfig {

    val leftArea = ModuleAreaConfig("left")
    val centerArea = ModuleAreaConfig("center")
    val rightArea = ModuleAreaConfig("right")

    fun left(modules: ModuleAreaConfig.() -> Unit) {
        modules(leftArea)
    }

    fun center (modules: ModuleAreaConfig.() -> Unit) {
        modules(centerArea)
    }

    fun right(modules: ModuleAreaConfig.() -> Unit) {
        modules(rightArea)
    }

}

class ModuleAreaConfig(private val area: String) {

    val modules = mutableListOf<Module>()

    fun getDeclarationString(): String {
        return "modules-$area"
    }

    operator fun Module.unaryPlus() {
        modules.add(this)
    }

}

abstract class Module(val name: String) {
    protected val collector = Collector()

    fun toConfigString(): String {
        return """
            |[module/$name]
            |${collector.configMap.map { (k, v) -> "$k = $v" }.joinToString(System.lineSeparator())}
        """.trimMargin()
    }

}