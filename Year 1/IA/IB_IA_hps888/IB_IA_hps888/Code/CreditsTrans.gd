extends Area2D

# The follwing class seeks out the body of 'Player' to take the character to the
# next area.

# warning-ignore:unused_argument
func _physics_process(delta):
	# Checks for bodies that are overlapping,
	# specifically the Player.
	var bodies = get_overlapping_bodies()
	for body in bodies:
		if body.get_name() == "Player":
# warning-ignore:return_value_discarded
			get_tree().change_scene("res://Credits.tscn")
