package com.intellij.plugins.nextflow.lang

import com.intellij.lang.Language

/**
 * Nextflow language definition.
 * We intentionally reuse Groovy's highlighter via a SyntaxHighlighterFactory,
 * but keep a dedicated language to allow separate file type and future features.
 */
class NextflowLanguage private constructor() : Language("Nextflow") {
    companion object {
        @JvmField
        val INSTANCE: NextflowLanguage = NextflowLanguage()
    }
}