/*
 * Copyright (c) ThinkResearch Inc.
 * MIT license. See LICENSE file in root directory.
 */

package com.thinkresearch.chatbot

import android.content.Context
import com.thinkresearch.chatbot.channel.ChannelHandler
/*
ThinkResearch Chatbot SDK
 */
class ChatBotSDK {
    private var handler: ChannelHandler? = null
    private var _appId: String? = null
    private var _baseUrl: String? = null
    private var _lang: String = "en"

    fun initialize(
        appId: String,
        baseUrl: String,
        lang: String = "en",
        context: Context,
    ) { handler = ChannelHandler(context,appId,baseUrl, lang)
        _appId = appId
        _baseUrl = baseUrl
        _lang = lang
        }

    private val isInitialized: Boolean
        get() = handler != null && _appId!=null && _baseUrl!= null

    fun start(context: Context) {
        throwIfNotInitialized()
            handler?.startChatBot(context)
        }

    private fun throwIfNotInitialized() {
        if (!isInitialized) {
            throw IllegalStateException("Please ensure that the ChatBot SDK is properly initialized by calling ChatBotSDK.initialize().")
        }
    }
}