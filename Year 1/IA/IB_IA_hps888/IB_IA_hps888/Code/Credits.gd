extends Node2D

# Set the user free from the program once satisfied

func _input(event):
	if event.is_action_pressed("ui_cancel"):
		get_tree().quit()
