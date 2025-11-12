package com.intellij.plugins.nextflow.lang.psi

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.lang.Language
import com.intellij.plugins.nextflow.lang.NextflowLanguage

/**
 * Custom token types for the Nextflow support layered over Groovy.
 */
object NextflowTokenTypes {
    val LANGUAGE: Language = NextflowLanguage.INSTANCE

    @JvmField
    val NEXTFLOW_KEYWORD: IElementType = object : IElementType("NEXTFLOW_KEYWORD", LANGUAGE) {}

    @JvmField
    val KEYWORDS: Set<String> = setOf(
        "workflow",
        "process",
        "input",
        "output",
        "script"
    )

    @JvmField
    val KEYWORD_TOKEN_SET: TokenSet = TokenSet.create(NEXTFLOW_KEYWORD)
}