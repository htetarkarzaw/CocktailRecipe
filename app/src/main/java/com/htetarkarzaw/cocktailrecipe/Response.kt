package com.example.myapplication

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import retrofit2.http.Field

@Root(name = "Response")
class Response(

    @field:Element(name = "ResponseCode", required = false)
    @param:Element(name = "ResponseCode", required = false)
    val responseCode: Long? = null,

    @field:Element(name = "ResponseStatus", required = false)
    @param:Element(name = "ResponseStatus", required = false)
    val responseStatus: String? = null,

    @field:Element(name = "ResponseMessage", required = false)
    @param:Element(name = "ResponseMessage", required = false)
    val responseMessage: String? = null,

    @field:Element(name = "ResponseData", required = false)
    @param:Element(name = "ResponseData", required = false)
    val responseData: String? = null
)