package com.ajijul.ny.news_feed.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {

    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("adx_keywords")
    @Expose
    var adxKeywords: String? = null
    @SerializedName("column")
    @Expose
    var column: Any? = null
    @SerializedName("section")
    @Expose
    var section: String? = null
    @SerializedName("byline")
    @Expose
    var byline: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("abstract")
    @Expose
    var abstract: String? = null
    @SerializedName("published_date")
    @Expose
    var publishedDate: String? = null
    @SerializedName("source")
    @Expose
    var source: String? = null
    @SerializedName("id")
    @Expose
    var id: Double? = null
    @SerializedName("asset_id")
    @Expose
    var assetId: Double? = null
    @SerializedName("views")
    @Expose
    var views: Double? = null
    @SerializedName("media")
    @Expose
    var media: List<Medium>? = null
    @SerializedName("uri")
    @Expose
    var uri: String? = null

}
