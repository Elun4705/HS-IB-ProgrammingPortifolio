extends Node

# This class defines the stats of both the Bats, Talus/Boss, and the Player
# This is a singleton  that function like a global class. Sends out signals
# to change their health based on the damaga they take of just the utility of
# another class.

# This makes it possible so the number can be changed while debugging.
# Export variable allow me to change the health in the editor instead for code.

export(int) var max_health = 1 setget set_max_health
var health = max_health setget set_health

# First time I added signals manually, this creates signals for the node.
signal no_health
signal health_changed(value)
signal max_health_changed(value)

# The following function changes the max health, in addition, this automaticly
# sets the actual health of the character.

func set_max_health(value):
	max_health = value
	self.health = min(health, max_health)
	emit_signal("max_health_changed")

func set_health(value):
	health = value
	emit_signal("health_changed", health)
	if health <= 0:
		emit_signal("no_health")

# The _ready() function is called when the node, and all its children, enters 
# the active scene. - Not a constructor.

func _ready():
	self.health = max_health
