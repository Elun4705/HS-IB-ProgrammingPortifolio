extends Node2D

# The function of this class is to give the client enough time to understand
# the gimmick of the game. After so, the loading screen taken of for the client
# to explore the program.

onready var timer = $Timer

# The '_ready()' function is called when the node, and all its children, enters 
# the active scene. - Not a constructor.

# Called when the node enters the scene tree for the first time.
func _ready():
		timer.start(10)

# Once the time is up is switches to the tutorial.
func _on_Timer_timeout():
# warning-ignore:return_value_discarded
	get_tree().change_scene("res://World.tscn")
