package gr.maax.kpolybar.modules

import gr.maax.kpolybar.api.Module

class EmptyModule() : Module("empty") {

    private val type by collector.prop(
        propertyName = "type",
        defaultValue = "custom/text",
    )

    private val content by collector.prop(
        propertyName = "content",
        defaultValue = " ",
    )


}