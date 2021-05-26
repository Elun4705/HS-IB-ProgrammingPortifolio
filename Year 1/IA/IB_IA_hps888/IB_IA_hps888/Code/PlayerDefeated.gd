extends Node

# Gets the signal from the PlayerStats, so that when the player is
# defeated, the timer starts to switch to 'Credits.tscn'
# Moreover over assert acts as an exeption handler
# Checks for errors and if any are present is stop the function

onready var timer = $Timer

func _on_PlayerStats_no_health():
	timer.start(0.4)


func _on_Timer_timeout():
# warning-ignore:return_value_discarded
	get_tree().change_scene("res://Credits.tscn")
