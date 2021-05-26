extends Control

# The function of this class is to display the amount of hits the 'Player' body
# can take before starting the over.

var hearts = 4 setget set_hearts
var max_hearts = 4 setget set_max_hearts

# The onready allows it so that the vars can be used outside 
# of stats and use elsewhere.
onready var heartUIFull = $HeartUIFull
onready var heartUIEmpty = $HeartUIEmpty

func set_hearts(value):
	hearts = clamp(value, 0, max_hearts)
	if heartUIFull != null:
		heartUIFull.rect_size.x = hearts * 15
	

func set_max_hearts(value):
	max_hearts = max(value, 1)
	self.hearts = min(hearts, max_hearts)
	if heartUIEmpty != null:
		heartUIEmpty.rect_size.x = max_hearts * 15

# The '_ready()' function is called when the node, and all its children, enters 
# the active scene. - Not a constructor.

# Starts the hearts in whatever value they've been set.
# Connects to it's self.
func _ready():
	self.max_hearts = PlayerStats.max_health
	self.hearts = PlayerStats.health
	# warning-ignore:return_value_discarded
	PlayerStats.connect("health_changed", self, "set_hearts")
	# warning-ignore:return_value_discarded
	PlayerStats.connect("max_health_changed", self, "set_max_hearts")
