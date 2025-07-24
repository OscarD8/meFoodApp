import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mefood.R // Make sure your R import is correct

// 1. Define your Indie Flower font family
val IndieFlower = FontFamily(
    Font(R.font.indie_flower_regular, weight = FontWeight.Normal)
)

// 2. Define a highly readable sans-serif font family for body and general UI
// Roboto is a great choice as it's Android's default and highly optimized.
// If you don't have a custom font file for Roboto, you'd rely on the system's
// default sans-serif, which is often Roboto or a similar system font.
// For explicit control, you might import it as a font resource too.
val AppSansSerif = FontFamily(
    // Assuming you might import Roboto regular if you want explicit control,
    // otherwise the system default (often Roboto) will be used if you just say FontFamily.SansSerif
    // For this example, let's assume you've imported Roboto.
    Font(R.font.roboto_regular, weight = FontWeight.Normal),
    Font(R.font.roboto_medium, weight = FontWeight.Medium),
    Font(R.font.roboto_bold, weight = FontWeight.Bold)
)

// 3. Create your Typography object
val AppTypography = Typography(
    // Display Large: For very large, impactful titles (e.g., app title on splash screen)
    displayLarge = TextStyle(
        fontFamily = IndieFlower,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
    ),
    // Display Medium: For large section titles or prominent headings
    displayMedium = TextStyle(
        fontFamily = IndieFlower,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp,
    ),
    // Display Small: For smaller, but still distinct, headings
    displaySmall = TextStyle(
        fontFamily = IndieFlower,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp,
    ),

    // Headline Large: Main headings for screens/sections
    headlineLarge = TextStyle(
        fontFamily = IndieFlower,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
    ),
    // Headline Medium: Subheadings
    headlineMedium = TextStyle(
        fontFamily = IndieFlower,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
    ),
    // Headline Small: Smaller subheadings or important callouts
    headlineSmall = TextStyle(
        fontFamily = IndieFlower,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),

    // Title Large: For card titles, list item titles (prominent but not huge)
    titleLarge = TextStyle(
        fontFamily = AppSansSerif, // Use sans-serif for readability in lists/cards
        fontWeight = FontWeight.Medium, // Slightly bolder for titles
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
    ),
    // Title Medium: Smaller titles or important text within components
    titleMedium = TextStyle(
        fontFamily = AppSansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
    ),
    // Title Small: Very small titles or bolded labels
    titleSmall = TextStyle(
        fontFamily = AppSansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),

    // Body Large: Main body text, longer descriptions
    bodyLarge = TextStyle(
        fontFamily = AppSansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    // Body Medium: Standard body text, typical UI labels
    bodyMedium = TextStyle(
        fontFamily = AppSansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    // Body Small: Small helper text, captions
    bodySmall = TextStyle(
        fontFamily = AppSansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
    ),

    // Label Large: Buttons, large tags
    labelLarge = TextStyle(
        fontFamily = AppSansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    // Label Medium: Navigation items, small buttons
    labelMedium = TextStyle(
        fontFamily = AppSansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    // Label Small: Tiny labels, error messages
    labelSmall = TextStyle(
        fontFamily = AppSansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    )
)