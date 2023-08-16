package com.github.munl.templatetest.src.templates

import com.github.munl.templatetest.src.unCapitalizeFirstChar
import org.jetbrains.kotlin.lombok.utils.capitalize

fun composeViewTemplate(
    packageName: String,
    composeViewName: String,
    viewModelName: String,
) = """package $packageName

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ${composeViewName.unCapitalizeFirstChar()}(
    ${viewModelName.unCapitalizeFirstChar()}: ${viewModelName.capitalize()}
) {

}
"""
