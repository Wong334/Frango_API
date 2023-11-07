package com.example.frango.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()