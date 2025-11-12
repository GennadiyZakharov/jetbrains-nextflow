package com.intellij.plugins.nextflow.lang.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.plugins.nextflow.lang.psi.NextflowTokenTypes
import com.intellij.psi.tree.IElementType
import org.jetbrains.plugins.groovy.highlighter.GroovySyntaxHighlighter

/**
 * Syntax highlighter for Nextflow that reuses Groovy's highlighting and
 * additionally highlights Nextflow-specific keywords as KEYWORD.
 */
class NextflowSyntaxHighlighter : SyntaxHighlighterBase() {

    private val groovyDelegate = GroovySyntaxHighlighter()

    override fun getHighlightingLexer(): Lexer = NextflowHighlightingLexer()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        if (tokenType == NextflowTokenTypes.NEXTFLOW_KEYWORD) {
            return pack(DefaultLanguageHighlighterColors.KEYWORD)
        }
        // Fallback to Groovy highlighter attributes
        return groovyDelegate.getTokenHighlights(tokenType)
    }

}