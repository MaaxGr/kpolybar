package gr.maax.kpolybar.modules

import gr.maax.kpolybar.api.Module

class BspwmModule(
) : Module("bspwm") {

    private val type by collector.prop(
        propertyName = "type",
        defaultValue = "internal/bspwm",
    )

    private val pinWorkspaces by collector.prop(
        propertyName = "pin-workspaces",
        defaultValue = true,
    )

    private val inlineMode by collector.prop(
        propertyName = "inline-mode",
        defaultValue = false,
    )

    private val enableClick by collector.prop(
        propertyName = "enable-click",
        defaultValue = true,
    )

    private val enableScroll by collector.prop(
        propertyName = "enable-scroll",
        defaultValue = true,
    )

    private val labelFocused by collector.prop(
        propertyName = "label-focused",
        defaultValue = "\"  \"",
    )

    private val labelEmpty by collector.prop(
        propertyName = "label-empty",
        defaultValue = "\"  \"",
    )

    private val labelOccupied by collector.prop(
        propertyName = "label-occupied",
        defaultValue = "\"  \"",
    )

    private val labelUrgent by collector.prop(
        propertyName = "label-urgent",
        defaultValue = "\"  \"",
    )

    private val labelUrgenForeground by collector.prop(
        propertyName = "label-urgen-foreground",
        defaultValue = "#ffb600",
    )

}