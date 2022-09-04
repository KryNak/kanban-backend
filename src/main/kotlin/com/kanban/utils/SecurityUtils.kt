package com.kanban.utils

import org.apache.logging.log4j.util.Strings
import org.springframework.http.HttpStatus
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.server.ResponseStatusException

object SecurityUtils {

    fun getUserId(): String {

        val authorization = SecurityContextHolder.getContext()?.authentication?.name ?: throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
        if(Strings.isBlank(authorization) && !authorization.contains("auth0|", true)) throw ResponseStatusException(HttpStatus.UNAUTHORIZED)

        return authorization.replaceFirst("auth0|", "", true)

    }

}
