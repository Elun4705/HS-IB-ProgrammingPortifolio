extends AudioStreamPlayer

# The function of this class is to play the sound when the player takes a hit.

# The '_ready()' function is called when the node, and all its children, enters 
# the active scene. - Not a constructor.
func _ready():
	# warning-ignore:return_value_discarded
	connect("finished", self, "queue_free")
