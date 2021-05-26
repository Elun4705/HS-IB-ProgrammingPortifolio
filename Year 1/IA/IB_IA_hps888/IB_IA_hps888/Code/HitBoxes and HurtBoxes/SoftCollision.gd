extends Area2D

# The function of the 'SoftCollision' class is to not "fused" two based together
# and keep the seperate.

# In this function, areas is an arrays, if the array size is
# greater than zero it return true, vice versa false.
func is_colliding():
	var areas = get_overlapping_areas()
	return areas.size() > 0

# This function get the direction in which the bats are colligin and pushes the
# in the opposite direction.
func get_push_vector():
	var areas = get_overlapping_areas()
	var push_vector = Vector2.ZERO
	if is_colliding():
		var area = areas[0] # An array is being called to detect all collisions.
		# Will be filtered to just enemies so they can push each other
		# without colliding on the hurtboxes.
		push_vector = area.global_position.direction_to(global_position)
		push_vector = push_vector.normalized()
	return push_vector
