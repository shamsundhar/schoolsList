package com.shyam.schoolslist.domain.model

data class SchoolListResponse(
    val help: String,
    val result: Result,
    val success: Boolean
)

data class Result(
    val _links: Links,
    val fields: List<Any>,
    val include_total: Boolean,
    val limit: Int,
    val records: List<Record>,
    val records_format: String,
    val resource_id: String,
    val total: Int,
    val total_estimation_threshold: Any,
    val total_was_estimated: Boolean
)

data class Links(
    val next: String,
    val start: String
)

data class Record(
    val Add1_City: String? = null,
    val Add1_Line1: String? = null,
    val Add1_Suburb: String? = null,
    val Add2_City: String? = null,
    val Add2_Line1: String? = null,
    val Add2_Postal_Code: Int? = null,
    val Add2_Suburb: String? = null,
    val Area_Unit: String? = null,
    val Asian: Int? = null,
    val Authority: String? = null,
    val CoEd_Status: String? = null,
    val Col_Id: Int? = null,
    val Col_Name: String? = null,
    val Contact1_Name: String? = null,
    val Decile: String? = null,
    val Definition: String? = null,
    val Education_Region: String? = null,
    val Email: String? = null,
    val European: Int? = null,
    val Fax: String? = null,
    val General_Electorate: String? = null,
    val International: Int? = null,
    val Isolation_Index: String? = null,
    val Latitude: Double? = null,
    val Local_Office_Name: String? = null,
    val Longitude: Double? = null,
    val MELAA: Int? = null,
    val Org_Name: String? = null,
    val Org_Type: String? = null,
    val Other: Int? = null,
    val Pacific: Int? = null,
    val Regional_Council: String? = null,
    val Roll_Date: String? = null,
    val School_Donations: String? = null,
    val School_Id: Int? = null,
    val Telephone: String? = null,
    val Territorial_Authority: String? = null,
    val Total: Int? = null,
    val URL: String? = null,
    val Urban_Area: String? = null,
    val Ward: String? = null,
    val _id: Int? = null
)
