package com.example.nonameapp.ui.onboarding

import com.example.nonameapp.R

data class OnboardingData(
    val image: Int, val titleResource: Int,
    val descResource: Int,
)

val items = listOf<OnboardingData>(OnboardingData(
    R.drawable.burger_onboarding,
    R.string.part1_title_onboarding,
    R.string.part1_content_onboarding,
),
    OnboardingData(
        R.drawable.stew_onboarding,
        R.string.part2_title_onboarding,
        R.string.part2_content_onboarding,
    ),
    OnboardingData(
        R.drawable.meat_onboarding,
        R.string.part3_title_onboarding,
        R.string.part3_content_onboarding,
    )
)