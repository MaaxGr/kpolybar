package gr.maax.kpolybar

import gr.maax.kpolybar.api.ModuleAreaConfig
import gr.maax.kpolybar.api.polybar
import gr.maax.kpolybar.conditions.ConditionBuilder
import gr.maax.kpolybar.modules.*
import java.io.File

val DEPLOY_FILE = File("/home/max/.config/polybar", "config")
val SEPARATOR = "%{F#41535b}| "

fun main() {
    polybar("top") {
        modules {
            left {
                +BspwmModule()
            }
            right {
                conditionalModules()
                permanentModules()
            }
        }
    }
}

fun ModuleAreaConfig.conditionalModules() {
    val pacmanModuleVisible = ConditionBuilder().apply {
        success("ping -q -w 2 -c 1 google.de")
        gt("checkupdates | wc -l", 100)
    }

    +PacmanModule(
        showIf = pacmanModuleVisible,
        suffix = SEPARATOR
    )
}

fun ModuleAreaConfig.permanentModules() {
    +NetworkModule()
    +SeparatorModule()
    +BatteryModule()
    +SeparatorModule()
    +ClockModule(format = "+%a %e %b %H:%M")
    +SeparatorModule()
}