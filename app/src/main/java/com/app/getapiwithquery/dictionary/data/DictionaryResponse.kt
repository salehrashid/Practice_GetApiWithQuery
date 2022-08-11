package com.app.getapiwithquery.dictionary.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DefinitionsItem(
    val synonyms: List<String?>? = null,
    val antonyms: List<String?>? = null,
    val definition: String? = null,
    val example: String? = null
) : Parcelable

@Parcelize
data class DictionaryResponseItem(
    val phonetic: String? = null,
    val phonetics: List<PhoneticsItem?>? = null,
    val word: String? = null,
    val meanings: List<MeaningsItem?>? = null,
    val sourceUrls: List<String?>? = null
) : Parcelable

@Parcelize
data class PhoneticsItem(
    val sourceUrl: String? = null,
    val text: String? = null,
    val audio: String? = null
) : Parcelable

@Parcelize
data class MeaningsItem(
    val synonyms: List<String?>? = null,
    val partOfSpeech: String? = null,
    val antonyms: List<String?>? = null,
    val definitions: List<DefinitionsItem?>? = null
) : Parcelable
