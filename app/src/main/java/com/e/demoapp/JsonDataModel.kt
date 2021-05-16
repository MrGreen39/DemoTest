package com.e.demoapp


import com.google.gson.annotations.SerializedName

data class JsonDataModel(
    @SerializedName("history")
    val history: List<History?>?
) {
    data class History(
        @SerializedName("grandfathers")
        val grandfathers: List<Grandfather?>?,
        @SerializedName("name")
        val name: String?
    ) {
        data class Grandfather(
            @SerializedName("gFName")
            val gFName: String?,
            @SerializedName("grandfathersKid")
            val grandfathersKid: List<GrandfathersKid?>?
        ) {
            data class GrandfathersKid(
                @SerializedName("gFKName")
                val gFKName: String?,
                @SerializedName("kid")
                val kid: List<Kid?>?
            ) {
                data class Kid(
                    @SerializedName("friends")
                    val friends: List<Friend?>?,
                    @SerializedName("name")
                    val name: String?
                ) {
                    data class Friend(
                        @SerializedName("name")
                        val name: String?
                    )
                }
            }
        }
    }
}