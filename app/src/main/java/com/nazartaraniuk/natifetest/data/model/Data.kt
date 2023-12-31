package com.nazartaraniuk.natifetest.data.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("analytics") val analytics: Analytics,
    @SerializedName("analytics_response_payload") val analyticsResponsePayload: String,
    @SerializedName("bitly_gif_url") val bitlyGifUrl: String,
    @SerializedName("bitly_url") val bitlyUrl: String,
    @SerializedName("content_url") val contentUrl: String,
    @SerializedName("embed_url") val embed_url: String,
    @SerializedName("id") val id: String,
    @SerializedName("images") val images: Images,
    @SerializedName("import_datetime") val importDatetime: String,
    @SerializedName("is_sticker") val is_sticker: Int,
    @SerializedName("rating") val rating: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("source") val source: String,
    @SerializedName("source_post_url") val sourcePostUrl: String,
    @SerializedName("source_tld") val sourceTld: String,
    @SerializedName("title") val title: String,
    @SerializedName("trending_datetime") val trendingDatetime: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String,
    @SerializedName("user") val user: User,
    @SerializedName("username") val username: String
)