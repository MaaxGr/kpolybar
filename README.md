# kpolybar

Polybar config generator written with kotlin lang.

## Advantages

* typesafe module configuration
* clear separation of left, center and right modules through dsl
* only modules that are currently used will be transpiled into config file
* option for conditional modules (multiple conditions are possible)

## Getting started
* Clone repository and import gradle project into Intellij
* Change `DEPLOY_FILE` in `Main.kt` to your pc specific polybar path
* Change `modules/` to your needs
* Run `main()` function in `Main.kt` => your polybar config should be updated 


## How the dsl looks like

```kotlin
val DEPLOY_FILE = File("/home/max/.config/polybar", "config")
val SEPERATOR = "%{F#41535b}| "

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
        suffix = SEPERATOR
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
```
