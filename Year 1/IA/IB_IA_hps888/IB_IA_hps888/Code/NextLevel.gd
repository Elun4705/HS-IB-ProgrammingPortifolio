extends Area2D

# The follwing class seeks to look for the body of the 'Player' to move to the
# next area.

# warning-ignore:unused_argument
func _physics_process(delta):
	# This checks for body collisions, when in contact with the player scene
	# it change to the Forest scence.
	
	var bodies = get_overlapping_bodies()
	for body in bodies:
		if body.get_name() == "Player":
# warning-ignore:return_value_discarded
			get_tree().change_scene("res://Forest.tscn")
