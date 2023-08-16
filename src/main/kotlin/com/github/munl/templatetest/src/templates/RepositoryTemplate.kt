package com.github.munl.templatetest.src.templates

import org.jetbrains.kotlin.lombok.utils.capitalize

fun repositoryTemplate(
    packageName: String,
    repositoryName: String
) = """package $packageName

import org.koin.core.component.KoinComponent

class $repositoryName(): KoinComponent {

}
"""
