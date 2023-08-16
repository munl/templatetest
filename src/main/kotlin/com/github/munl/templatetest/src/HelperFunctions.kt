package com.github.munl.templatetest.src

fun String.unCapitalizeFirstChar(): String {
    return this.replaceFirstChar { it.lowercase() }
}