package com.intellij.plugins.nextflow.lang.highlight

import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerBase
import com.intellij.plugins.nextflow.lang.psi.NextflowTokenTypes
import com.intellij.psi.tree.IElementType
import org.jetbrains.plugins.groovy.lang.lexer.GroovyLexer
import org.jetbrains.plugins.groovy.lang.lexer.GroovyTokenTypes

/**
 * A lightweight highlighting lexer that delegates to Groovy's lexer and
 * remaps identifiers matching Nextflow-specific keywords to a custom token.
 */
class NextflowHighlightingLexer : LexerBase() {
    private val delegate: Lexer = GroovyLexer()

    private var buffer: CharSequence = ""
    private var startOffset: Int = 0
    private var endOffset: Int = 0
    private var state: Int = 0

    private var tokenStart: Int = 0
    private var tokenEnd: Int = 0
    private var tokenType: IElementType? = null

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.state = initialState
        delegate.start(buffer, startOffset, endOffset, initialState)
        advanceInternal()
    }

    override fun getState(): Int = state

    override fun getTokenType(): IElementType? = tokenType

    override fun getTokenStart(): Int = tokenStart

    override fun getTokenEnd(): Int = tokenEnd

    override fun getBufferSequence(): CharSequence = buffer

    override fun getBufferEnd(): Int = endOffset

    override fun advance() {
        advanceInternal()
    }

    private fun advanceInternal() {
        if (delegate.tokenType == null) {
            tokenType = null
            return
        }
        tokenStart = delegate.tokenStart
        tokenEnd = delegate.tokenEnd
        state = delegate.state

        val dt = delegate.tokenType
        tokenType = if (dt == GroovyTokenTypes.mIDENT) {
            val text = buffer.subSequence(tokenStart, tokenEnd).toString()
            if (NextflowTokenTypes.KEYWORDS.contains(text)) NextflowTokenTypes.NEXTFLOW_KEYWORD else dt
        } else dt

        delegate.advance()
    }
}