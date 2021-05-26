extends Node2D

# This class is being inheriterd by the bat class as to detect the player and
# get thier position relative to the bat.

# This makes it possible so the number can be changed while debugging
# Export variable allow me to change the health in the editor instead for code

export(int) var wander_range = 32

onready var start_position = global_position
onready var target_position = global_position

onready var timer = $Timer

# The _ready() function is called when the node, and all its children, enters 
# the active scene. - Not a constructor
func _ready():
	update_target_position()

# Gets the postion of the target for it store and return to
func update_target_position():
	var target_vector = Vector2(rand_range(-wander_range, wander_range), rand_range(-wander_range, wander_range))
	target_position = start_position + target_vector

# This functions to return to their last know direction after a set
# period of time. This is further used in 'Bat.gd'

func get_time_left():
	return timer.time_left

# Sets the duration in which the bat is allowed to wander
func start_wander_timer(duration):
	timer.start(duration)

func _on_Timer_timeout():
	update_target_position()
