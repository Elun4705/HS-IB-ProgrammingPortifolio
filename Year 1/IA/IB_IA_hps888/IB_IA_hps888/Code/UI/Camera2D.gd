extends Camera2D

# The following class gives the client a camara free to follow the player.
# This takes the limits of the view of so they may see whats up ahead.

onready var topLeft = $Limits/TopLeft
onready var bottomRight = $Limits/BottomRight

# The '_ready()' function is called when the node, and all its children, enters 
# the active scene. - Not a constructor.

# This activates the position for the boundaires of the camara from the start.
func _ready():
	limit_top = topLeft.position.y
	limit_left = topLeft.position.x
	limit_bottom = bottomRight.position.y
	limit_right = bottomRight.position.x
