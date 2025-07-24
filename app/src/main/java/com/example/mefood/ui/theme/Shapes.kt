import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

// This is the standard Material Design 3 Shapes object
val AppMaterialShapes = Shapes(
    small = RoundedCornerShape(4.dp),    // Typically for small components like chips, buttons
    medium = RoundedCornerShape(8.dp),   // For cards, larger buttons, dialogs
    large = RoundedCornerShape(16.dp)    // For larger surfaces or specific containers
)

// You can still define custom/extra shapes outside of the main M3 'Shapes' class
// For instance, your FullCircle doesn't directly map to small/medium/large categories
val FullCircleShape = CircleShape