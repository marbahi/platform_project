package com.example.uas.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uas.R

// Definisikan font family
val PoppinsBold = FontFamily(Font(R.font.poppins_bold))
val PoppinsSemiBold = FontFamily(Font(R.font.poppins_semibold))
val PoppinsMedium = FontFamily(Font(R.font.poppins_medium))

// Custom typography
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = PoppinsSemiBold,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp // 24 dp (sp untuk teks)
    ),
    bodyMedium = TextStyle(
        fontFamily = PoppinsSemiBold,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = PoppinsMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )
)

val VeryBigTextStyle = TextStyle(
    fontFamily = PoppinsBold,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
)

val VeryMediumTextStyle = TextStyle(
    fontFamily = PoppinsSemiBold,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp
)

val VerySmallTextStyle = TextStyle(
    fontFamily = PoppinsMedium,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp
)