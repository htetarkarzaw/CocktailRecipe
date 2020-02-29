package com.htetarkarzaw.cocktailrecipe.networks

class ApiResponse<T> (
    var data: T? = null,
    var error: Throwable? = null
)
