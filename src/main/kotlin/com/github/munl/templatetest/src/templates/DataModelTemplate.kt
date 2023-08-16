package com.github.munl.templatetest.src.templates

import org.jetbrains.kotlin.lombok.utils.capitalize

fun dataModelTemplate(
    packageName: String,
    dataModelName: String,
) = """package $packageName

data class ${dataModelName}(
    val name: String
)
"""